package com.crescentine.trajanstanks;

import com.crescentine.trajanstanks.blockentity.TankModBlockEntities;
import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.container.TankModContainers;
import com.crescentine.trajanstanks.entity.*;
import com.crescentine.trajanstanks.entity.artillery.ArtilleryEntityRenderer;
import com.crescentine.trajanstanks.entity.shell.ArtilleryShell;
import com.crescentine.trajanstanks.entity.shell.ShellEntity;
import com.crescentine.trajanstanks.entity.tank.heavy_tank.HeavyTankRenderer;
import com.crescentine.trajanstanks.entity.tank.light_tank.TankEntityRenderer;
import com.crescentine.trajanstanks.entity.tank.medium_tank.MediumTankRenderer;
import com.crescentine.trajanstanks.item.TankModItems;
import com.crescentine.trajanstanks.packet.ArtilleryInputMessage;
import com.crescentine.trajanstanks.packet.HeavyInputMessage;
import com.crescentine.trajanstanks.packet.TankInputMessage;
import com.crescentine.trajanstanks.packet.TankNetwork;

import com.crescentine.trajanstanks.recipe.ModRecipes;
import com.crescentine.trajanstanks.screen.CrafterScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

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
        TankModItems.BLOCKS.register(eventBus);
        eventBus.addListener(this::doClientStuff);
        TankModEntityTypes.ENTITY_TYPES.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
      //  ModRecipeTypes.register(eventBus);
        TankNetwork.init();
        TankModContainers.register(eventBus);
        TankModBlockEntities.register(eventBus);
        ModRecipes.init();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        MenuScreens.register(TankModContainers.CRAFTER_CONTAINER.get(), CrafterScreen::new);
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
            EntityRenderers.register(TankModEntityTypes.MEDIUM_TANK_ENTITY_TYPE.get(), MediumTankRenderer::new);

        }
    }
}
