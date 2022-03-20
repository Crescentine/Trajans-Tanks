package com.crescentine.trajanstanks;

import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.*;
import com.crescentine.trajanstanks.entity.artillery.ArtilleryEntityRenderer;
import com.crescentine.trajanstanks.entity.shell.ArtilleryShell;
import com.crescentine.trajanstanks.entity.shell.ShellEntity;
import com.crescentine.trajanstanks.entity.tank.heavy_tank.HeavyTankRenderer;
import com.crescentine.trajanstanks.entity.tank.light_tank.TankEntityRenderer;
import com.crescentine.trajanstanks.item.TankModItems;
import com.crescentine.trajanstanks.packet.ArtilleryInputMessage;
import com.crescentine.trajanstanks.packet.HeavyInputMessage;
import com.crescentine.trajanstanks.packet.TankInputMessage;
import com.crescentine.trajanstanks.packet.TankNetwork;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("trajanstanks")
public class TankMod {
    public static final SimpleChannel NETWORK_INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation("trajanstanks", "main"),
            () -> "1",
            "1"::equals,
            "1"::equals
    );
    public static final String MOD_ID = "trajanstanks";
    private static final Logger LOGGER = LogManager.getLogger();
    public TankMod() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TankModConfig.SPEC, "trajanstanks-config.toml");
        NETWORK_INSTANCE.registerMessage(0, TankInputMessage.class,
                TankInputMessage::writePacketData,
                TankInputMessage::new,
                (packet, ctx) -> {
                    ctx.get().setPacketHandled(true);
                    packet.handle(packet, null);
                }
        );
        NETWORK_INSTANCE.registerMessage(1, ArtilleryInputMessage.class,
                ArtilleryInputMessage::writePacketData,
                ArtilleryInputMessage::new,
                (packet, ctx) -> {
                    ctx.get().setPacketHandled(true);
                    packet.handle(packet, null);
                }
        );
        NETWORK_INSTANCE.registerMessage(2, HeavyInputMessage.class,
                HeavyInputMessage::writePacketData,
                HeavyInputMessage::new,
                (packet, ctx) -> {
                    ctx.get().setPacketHandled(true);
                    packet.handle(packet, null);
                }
        );
                    GeckoLib.initialize();

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::commonSetup);
        TankModItems.ITEMS.register(eventBus);
        TankModEntityTypes.ENTITY_TYPES.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
        TankNetwork.init();
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
        TankNetwork.init();
    }
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @OnlyIn(Dist.CLIENT)
        @SubscribeEvent
        public static void registerRenderers(final FMLClientSetupEvent event) {
            Minecraft minecraftClient = Minecraft.getInstance();
            EntityRenderers.register(TankModEntityTypes.ARTILLERY_ENTITY_TYPE.get(), ArtilleryEntityRenderer::new);
            EntityRenderers.register(TankModEntityTypes.TANK_ENTITY_TYPE.get(), TankEntityRenderer::new);
            EntityRenderers.register(TankModEntityTypes.SHELL.get(), ThrownItemRenderer<ShellEntity>::new);
            EntityRenderers.register(TankModEntityTypes.ARTILLERY_SHELL.get(), ThrownItemRenderer<ArtilleryShell>::new);
            EntityRenderers.register(TankModEntityTypes.HEAVY_TANK_ENTITY_TYPE.get(), HeavyTankRenderer::new);

        }
    }
}
