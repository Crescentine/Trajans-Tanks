package com.crescentine.trajanstanks.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class TankModConfig {
    public static final ForgeConfigSpec.Builder BUILDER  = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> fuelSystemEnabled;
    public static final ForgeConfigSpec.ConfigValue<Double> coalFuelAmount;
    public static final ForgeConfigSpec.ConfigValue<Double> lavaFuelAmount;

    public static final ForgeConfigSpec.ConfigValue<Double> panzer2_health;
    public static final ForgeConfigSpec.ConfigValue<Double> panzer2_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> panzer2_shot_cooldown;
    public static final ForgeConfigSpec.ConfigValue<Double> panzer2_heal_amount;
    public static final ForgeConfigSpec.ConfigValue<Double> panzer_2_maxfuel;

    public static final ForgeConfigSpec.ConfigValue<Double> t34_health;
    public static final ForgeConfigSpec.ConfigValue<Double> t34_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> t34_shot_cooldown;
    public static final ForgeConfigSpec.ConfigValue<Double> t34_heal_amount;
    public static final ForgeConfigSpec.ConfigValue<Double> t34_maxfuel;


    public static final ForgeConfigSpec.ConfigValue<Double> tiger_health;
    public static final ForgeConfigSpec.ConfigValue<Double> tiger_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> tiger_shot_cooldown;
    public static final ForgeConfigSpec.ConfigValue<Double> tiger_heal_amount;
    public static final ForgeConfigSpec.ConfigValue<Double> tiger_maxfuel;

    public static final ForgeConfigSpec.ConfigValue<Double> cruisermk1_health;
    public static final ForgeConfigSpec.ConfigValue<Double> cruisermk1_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> cruisermk1_shot_cooldown;
    public static final ForgeConfigSpec.ConfigValue<Double> cruisermk1_heal_amount;
    public static final ForgeConfigSpec.ConfigValue<Double> cruisermk1_maxfuel;

    public static final ForgeConfigSpec.ConfigValue<Double> m4sherman_health;
    public static final ForgeConfigSpec.ConfigValue<Double> m4sherman_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> m4sherman_shot_cooldown;
    public static final ForgeConfigSpec.ConfigValue<Double> m4sherman_heal_amount;
    public static final ForgeConfigSpec.ConfigValue<Double> m4sherman_maxfuel;

    public static final ForgeConfigSpec.ConfigValue<Double> archer_health;
    public static final ForgeConfigSpec.ConfigValue<Double> archer_speed;
    public static final ForgeConfigSpec.ConfigValue<Integer> archer_shot_cooldown;
    public static final ForgeConfigSpec.ConfigValue<Double> archer_heal_amount;
    public static final ForgeConfigSpec.ConfigValue<Double> archer_maxfuel;

    public static final ForgeConfigSpec.ConfigValue<Double> mounted_gun_health;
    public static final ForgeConfigSpec.ConfigValue<Integer> mounted_gun_shot_cooldown;


    public static final ForgeConfigSpec.ConfigValue<Double> shell_damage;
    public static final ForgeConfigSpec.ConfigValue<Boolean> shell_makes_fire;
    public static final ForgeConfigSpec.ConfigValue<Integer> shell_explosion_radius;
    public static final ForgeConfigSpec.ConfigValue<Double> anti_tank_shell_damage;
    public static final ForgeConfigSpec.ConfigValue<Boolean> at_shell_makes_fire;
    public static final ForgeConfigSpec.ConfigValue<Integer> anti_tank_shell_explosion_radius;
    public static final ForgeConfigSpec.ConfigValue<Double> anti_tank_shell_damage_to_tank;

    public static final ForgeConfigSpec.ConfigValue<Double> standardShellDamage;
    public static final ForgeConfigSpec.ConfigValue<Integer> standardShellExplosionRadius;

    public static final ForgeConfigSpec.ConfigValue<Double> armorPiercingShellDamage;
    public static final ForgeConfigSpec.ConfigValue<Double> armorPiercingShellDamageToArmoredVehicles;
    public static final ForgeConfigSpec.ConfigValue<Integer> armorPiercingExplosionRadius;

    public static final ForgeConfigSpec.ConfigValue<Double> highExplosiveShellDamage;
    public static final ForgeConfigSpec.ConfigValue<Integer> highExplosiveShellExplosionRadius;

    public static final ForgeConfigSpec.ConfigValue<Double> heatShellDamage;
    public static final ForgeConfigSpec.ConfigValue<Integer> heatShellExplosionRadius;

    public static final ForgeConfigSpec.ConfigValue<Double> APCRShellDamage;
    public static final ForgeConfigSpec.ConfigValue<Integer> APCRShellExplosionRadius;


    static {
        BUILDER.push("Trajan's Tanks Config");
        BUILDER.comment("Config File for Trajan's Tank Mod");
        BUILDER.pop();

        BUILDER.push("General");
        fuelSystemEnabled = BUILDER.define("Set to false to disable tanks requiring fuel", true);
        coalFuelAmount = BUILDER.define("How Much Fuel Coal and Charcoal Gives (seconds)", 6.0);
        lavaFuelAmount = BUILDER.define("How Much Fuel Lava Gives (seconds)", 60.0);
        BUILDER.pop();

        BUILDER.push("Panzer 2 Stats");
        panzer2_health = BUILDER.define("Panzer 2 Health (0-250)" , 80.0);
        panzer2_speed = BUILDER.define("Panzer 2 Speed" , 0.17);
        panzer2_shot_cooldown = BUILDER.define("Panzer 2 Shot Cooldown (1 = 1/20 second)", 60);
        panzer2_heal_amount = BUILDER.define("Panzer 2 Healing Amount (on right click)", 10.0);
        panzer_2_maxfuel = BUILDER.define("Panzer 2 Max Fuel (seconds)", 600.0);
        BUILDER.pop();

        BUILDER.push("Tiger Stats");
        tiger_health = BUILDER.define("Tiger Health (0-250)" , 110.0);
        tiger_speed = BUILDER.define("Tiger Speed" , 0.12);
        tiger_shot_cooldown = BUILDER.define("Tiger Shoot Cooldown (1 = 1/20 second", 80);
        tiger_heal_amount = BUILDER.define("Tiger Healing Amount (on right click)", 10.0);
        tiger_maxfuel = BUILDER.define("Tiger Max Fuel (seconds)", 600.0);
        BUILDER.pop();

        BUILDER.push("T-34 Stats");
        t34_health = BUILDER.define("T-34 Health (0-250)" , 95.0);
        t34_speed = BUILDER.define("T-34 Speed" , 0.14);
        t34_shot_cooldown = BUILDER.define("T-34 Shoot Cooldown (1 = 1/20 second", 70);
        t34_heal_amount = BUILDER.define("T-34 Healing Amount (on right click)", 10.0);
        t34_maxfuel = BUILDER.define("T-34 Max Fuel (seconds)", 600.0);
        BUILDER.pop();

        BUILDER.push("Cruiser MK1 Stats");
        cruisermk1_health = BUILDER.define("Cruiser MK1 Health (0-250)" , 80.0);
        cruisermk1_speed = BUILDER.define("Cruiser MK1 Speed" , 0.17);
        cruisermk1_shot_cooldown = BUILDER.define("Cruiser MK1 Shoot Cooldown (1 = 1/20 second", 60);
        cruisermk1_heal_amount = BUILDER.define("Cruiser MK1 Healing Amount (on right click)", 10.0);
        cruisermk1_maxfuel = BUILDER.define("Cruiser MK1 Max Fuel (seconds)", 600.0);
        BUILDER.pop();

        BUILDER.push("M4 Sherman Stats");
        m4sherman_health = BUILDER.define("M4 Sherman Health (0-250)" , 95.0);
        m4sherman_speed = BUILDER.define("M4 Sherman Speed" , 0.14);
        m4sherman_shot_cooldown = BUILDER.define("M4 Sherman Shoot Cooldown (1 = 1/20 second", 70);
        m4sherman_heal_amount = BUILDER.define("M4 Sherman Healing Amount (on right click)", 10.0);
        m4sherman_maxfuel = BUILDER.define("M4 Sherman Max Fuel (seconds)", 600.0);
        BUILDER.pop();

        BUILDER.push("Archer Stats");
        archer_health = BUILDER.define("Archer Health (0-250)" , 110.0);
        archer_speed = BUILDER.define("Archer Speed" , 0.14);
        archer_shot_cooldown = BUILDER.define("Archer Shoot Cooldown (1 = 1/20 second", 80);
        archer_heal_amount = BUILDER.define("Archer Healing Amount (on right click)", 10.0);
        archer_maxfuel = BUILDER.define("Archer Max Fuel (seconds)", 600.0);
        BUILDER.pop();

        BUILDER.push("Anti-Tank Stats");
        mounted_gun_health = BUILDER.define("Artillery Health", 30.0);
        mounted_gun_shot_cooldown = BUILDER.define("Artillery Shot Cooldown (1 = 1/20 second)", 75);
        BUILDER.pop();

        BUILDER.push("Tank Shell Damages");
        shell_damage = BUILDER.define("Shell Damage", 60.0);
        shell_makes_fire = BUILDER.define("Tank Shell Creates Fire on Explosion", true);
        shell_explosion_radius = BUILDER.define("Shell Explosion Radius (Whole Number)", 3);
        anti_tank_shell_damage = BUILDER.define("Anti Tank Shell Damage", 10.0);
        at_shell_makes_fire = BUILDER.define("Anti-Tank Tank Shell Creates Fire on Explosion", true);
        anti_tank_shell_explosion_radius = BUILDER.define("Anti-Tank Shell Explosion Radius (Whole Number)", 3);
        anti_tank_shell_damage_to_tank = BUILDER.define("Anti Tank Damage to Tank", 20.0);
        BUILDER.pop();

        BUILDER.push("Standard Shell Stats");
        standardShellDamage = BUILDER.define("Standard Shell Damage", 60.0);
        standardShellExplosionRadius = BUILDER.define("Standard Shell Explosion Radius", 3);
        BUILDER.pop();

        BUILDER.push("Armor Piercing Shell Stats");
        armorPiercingShellDamage = BUILDER.define("Armor Piercing Shell Damage (to players)", 60.0);
        armorPiercingExplosionRadius = BUILDER.define("Armor Piercing Shell Explosion Radius", 3);
        armorPiercingShellDamageToArmoredVehicles = BUILDER.define("Armor Piercing Shell Damage (to armored vehicles)", 80.0);
        BUILDER.pop();

        BUILDER.push("High Explosive Shell Stats");
        highExplosiveShellDamage = BUILDER.define("High Explosive Shell Damage", 60.0);
        highExplosiveShellExplosionRadius = BUILDER.define("High Explosive Shell Explosion Radius", 4);
        BUILDER.pop();

        BUILDER.push("HEAT Shell Stats");
        heatShellDamage = BUILDER.define("HEAT Shell Damage", 80.0);
        heatShellExplosionRadius = BUILDER.define("HEAT Shell Explosion Radius", 2);
        BUILDER.pop();

        BUILDER.push("APCR Shell Stats");
        APCRShellDamage = BUILDER.define("APCR Shell Damage", 90.0);
        APCRShellExplosionRadius = BUILDER.define("ACPR Shell Explosion Radius", 0);
        BUILDER.pop();
        SPEC = BUILDER.build();

    }
}
