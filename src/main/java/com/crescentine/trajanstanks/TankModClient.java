package com.crescentine.trajanstanks;

import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class TankModClient {
    private static final String CATEGORY = "key.categories." + TankMod.MOD_ID;
    public static final KeyMapping STARTMOVING = new KeyMapping(TankMod.MOD_ID + ".key.tankmod.startmovinng", GLFW.GLFW_KEY_W, CATEGORY);
    public static final KeyMapping shootkey = new KeyMapping(TankMod.MOD_ID + ".key.tankmod.shootkey", GLFW.GLFW_KEY_G, CATEGORY);

}
