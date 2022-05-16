package com.crescentine.trajanstanks;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import org.lwjgl.glfw.GLFW;

public class TankModClient {
    public static KeyMapping startMoving;
    public static KeyMapping shootKey;

    private TankModClient() {
    }
    public static void init() {
        startMoving = registerKey("tankMovement", KeyMapping.CATEGORY_GAMEPLAY, GLFW.GLFW_KEY_W);
         shootKey = registerKey("shootKey", KeyMapping.CATEGORY_GAMEPLAY, GLFW.GLFW_KEY_G);
    }
    private static KeyMapping registerKey(String name, String category, int keycode) {
        final var key = new KeyMapping("key." + TankMod.MOD_ID + "." + name, keycode, category);
        ClientRegistry.registerKeyBinding(key);
        return key;
    }
}
