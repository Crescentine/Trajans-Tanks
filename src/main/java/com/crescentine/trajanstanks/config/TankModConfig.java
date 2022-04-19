package com.crescentine.trajanstanks.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class TankModConfig {
    public static final ForgeConfigSpec.Builder BUILDER  = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.ConfigValue<Double> panzer2_health;
    public static final ForgeConfigSpec.ConfigValue<Double> panzer2_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> panzer2_shot_cooldown;

    public static final ForgeConfigSpec.ConfigValue<Double> t34_health;
    public static final ForgeConfigSpec.ConfigValue<Double> t34_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> t34_shot_cooldown;

    public static final ForgeConfigSpec.ConfigValue<Double> tiger_health;
    public static final ForgeConfigSpec.ConfigValue<Double> tiger_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> tiger_shot_cooldown;

    public static final ForgeConfigSpec.ConfigValue<Double> cruisermk1_health;
    public static final ForgeConfigSpec.ConfigValue<Double> cruisermk1_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> cruisermk1_shot_cooldown;

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

        BUILDER.push("Panzer 2 Stats");
        panzer2_health = BUILDER.define("Panzer 2 Health (0-250)" , 80.0);
        panzer2_speed = BUILDER.define("Panzer 2 Speed" , 0.17);
        panzer2_shot_cooldown = BUILDER.define("Panzer 2 Shot Cooldown (1 = 1/20 second)", 60);
        BUILDER.pop();

        BUILDER.push("Tiger Stats");
        tiger_health = BUILDER.define("Tiger Health (0-250)" , 110.0);
        tiger_speed = BUILDER.define("Tiger Speed" , 0.12);
        tiger_shot_cooldown = BUILDER.define("Tiger Shoot Cooldown (1 = 1/20 second", 80);
        BUILDER.pop();

        BUILDER.push("T-34 Stats");
        t34_health = BUILDER.define("T-34 Health (0-250)" , 95.0);
        t34_speed = BUILDER.define("T-34 Speed" , 0.14);
        t34_shot_cooldown = BUILDER.define("T-34 Shoot Cooldown (1 = 1/20 second", 70);
        BUILDER.pop();

        BUILDER.push("Cruiser MK1 Stats");
        cruisermk1_health = BUILDER.define("Cruiser MK1 Health (0-250)" , 80.0);
        cruisermk1_speed = BUILDER.define("Cruiser MK1 Speed" , 0.17);
        cruisermk1_shot_cooldown = BUILDER.define("Cruiser MK1 Shoot Cooldown (1 = 1/20 second", 60);
        BUILDER.pop();

        BUILDER.push("Anti-Tank Stats");
        mounted_gun_health = BUILDER.define("Artillery Health", 30.0);
        mounted_gun_shot_cooldown = BUILDER.define("Artillery Shot Cooldown (1 = 1/20 second)", 75);
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
