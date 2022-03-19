package com.crescentine.trajanstanks.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class TankModConfig {
    public static final ForgeConfigSpec.Builder BUILDER  = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.ConfigValue<Double> light_tank_health;
    public static final ForgeConfigSpec.ConfigValue<Double> light_tank_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> light_tank_shot_cooldown;


    public static final ForgeConfigSpec.ConfigValue<Double> heavy_tank_health;
    public static final ForgeConfigSpec.ConfigValue<Double> heavy_tank_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> heavy_tank_shot_cooldown;

    public static final ForgeConfigSpec.ConfigValue<Double> mounted_gun_health;
    public static final ForgeConfigSpec.ConfigValue<Integer> mounted_gun_shot_cooldown;


    public static final ForgeConfigSpec.ConfigValue<Double> shell_damage;
    public static final ForgeConfigSpec.ConfigValue<Integer> shell_explosion_radius;
    public static final ForgeConfigSpec.ConfigValue<Double> anti_tank_shell_damage;
    public static final ForgeConfigSpec.ConfigValue<Integer> anti_tank_shell_explosion_radius;
    public static final ForgeConfigSpec.ConfigValue<Double> anti_tank_shell_damage_to_tank;



    static {
        BUILDER.push("Trajan's Tanks Config");
        BUILDER.comment("Config File for Trajan's Tank Mod");
        BUILDER.pop();

        BUILDER.push("Light Tank Stats");
        light_tank_health = BUILDER.define("Light Tank Health (0-250)" , 80.0);
        light_tank_speed = BUILDER.define("Light Tank Speed" , 0.6);
        light_tank_shot_cooldown = BUILDER.define("Light Tank Shot Cooldown (1 = 1/20 second)", 75);
        BUILDER.pop();

        BUILDER.push("Anti-Tank Stats");
        mounted_gun_health = BUILDER.define("Artillery Health", 30.0);
        mounted_gun_shot_cooldown = BUILDER.define("Artillery Shot Cooldown (1 = 1/20 second)", 75);
        BUILDER.pop();

        BUILDER.push("Heavy Tank Stats");
        heavy_tank_health = BUILDER.define("Heavy Tank Health (0-250)" , 110.0);
        heavy_tank_speed = BUILDER.define("Heavy Tank Speed" , 0.44);
        heavy_tank_shot_cooldown = BUILDER.define("Heavy Tank Shoot Cooldown (1 = 1/20 second", 75);
        BUILDER.pop();

        BUILDER.push("Tank Shell Damages");
        shell_damage = BUILDER.define("Shell Damage", 60.0);
        shell_explosion_radius = BUILDER.define("Shell Explosion Radius (Whole Number)", 3);
        anti_tank_shell_damage = BUILDER.define("Anti Tank Shell Damage", 10.0);
        anti_tank_shell_explosion_radius = BUILDER.define("Anti-Tank Shell Explosion Radius (Whole Number)", 3);
        anti_tank_shell_damage_to_tank = BUILDER.define("Anti Tank Damage to Tank", 20.0);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
