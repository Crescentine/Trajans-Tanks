package com.crescentine.trajanstanks;


import com.crescentine.trajanstanks.config.TankModConfig;
import com.crescentine.trajanstanks.entity.*;
import com.crescentine.trajanstanks.entity.artillery.ArtilleryEntityRenderer;
import com.crescentine.trajanstanks.entity.shell.ArtilleryShell;
import com.crescentine.trajanstanks.entity.shell.ShellEntity;
import com.crescentine.trajanstanks.entity.tanks.cruisermk1.CruiserMk1Renderer;
import com.crescentine.trajanstanks.entity.tanks.m4sherman.M4ShermanRenderer;
import com.crescentine.trajanstanks.entity.tanks.tiger.TigerTankRenderer;
import com.crescentine.trajanstanks.entity.tanks.panzer2.Panzer2Renderer;
import com.crescentine.trajanstanks.entity.tanks.t34.T34Renderer;
import com.crescentine.trajanstanks.item.TankModItems;
import com.crescentine.trajanstanks.packet.*;
import net.minecraft.client.renderer.entity.EntityRenderers;
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
        NETWORK_INSTANCE.registerMessage(0, TankPacket.class,
                TankPacket::writePacketData,
                TankPacket::new,
                (packet, ctx) -> {
                    ctx.get().setPacketHandled(true);
                    packet.handle(packet, null);
                }
        );
        NETWORK_INSTANCE.registerMessage(1, ArtilleryPacket.class,
                ArtilleryPacket::writePacketData,
                ArtilleryPacket::new,
                (packet, ctx) -> {
                    ctx.get().setPacketHandled(true);
                    packet.handle(packet, null);
                }
        );

        GeckoLib.initialize();
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::onClientSetup);
        eventBus.addListener(this::commonSetup);
        TankModItems.ITEMS.register(eventBus);
        TankModItems.BLOCKS.register(eventBus);
        TankModEntityTypes.ENTITY_TYPES.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
        TankModNetwork.init();

    }


    public void commonSetup(final FMLCommonSetupEvent event) {
        TankModNetwork.init();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @OnlyIn(Dist.CLIENT)
        @SubscribeEvent
        public static void registerRenderers(final FMLClientSetupEvent event) {
            EntityRenderers.register(TankModEntityTypes.ARTILLERY_ENTITY_TYPE.get(), ArtilleryEntityRenderer::new);
            EntityRenderers.register(TankModEntityTypes.PANZER_TWO_ENTITY_TYPE.get(), Panzer2Renderer::new);
            EntityRenderers.register(TankModEntityTypes.SHELL.get(), ThrownItemRenderer<ShellEntity>::new);
            EntityRenderers.register(TankModEntityTypes.ARTILLERY_SHELL.get(), ThrownItemRenderer<ArtilleryShell>::new);
            EntityRenderers.register(TankModEntityTypes.TIGER_ENTITY_TYPE.get(), TigerTankRenderer::new);
            EntityRenderers.register(TankModEntityTypes.T34_ENTITY_TYPE.get(), T34Renderer::new);
            EntityRenderers.register(TankModEntityTypes.CRUISERMK1_ENTITY_TYPE.get(), CruiserMk1Renderer::new);
            EntityRenderers.register(TankModEntityTypes.M4SHERMAN_ENTITY_TYPE.get(), M4ShermanRenderer::new);
        }
    }
    private void onClientSetup(FMLClientSetupEvent event) {
        ClientEventHandler.setup();
    }
}
