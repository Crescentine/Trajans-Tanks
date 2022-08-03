package com.crescentine.trajanstanks.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.BlockSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.core.Direction;

import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.common.ForgeSpawnEggItem;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class TankSpawnEgg extends ForgeSpawnEggItem {
    public String toolTip;
    public boolean standard;
    public boolean armorPiercing;
    public boolean heatShell;
    public boolean heShell;
    public boolean apcrShell;
    public TankSpawnEgg(Supplier<? extends EntityType<? extends Mob>> typeIn, int primaryColorIn, int secondaryColorIn, boolean standard, boolean armorPiercing, boolean heatShell,
                        boolean heShell, boolean apcrShell, Properties builder) {
        super(typeIn, primaryColorIn, secondaryColorIn,  builder);
        this.standard = standard;
        this.armorPiercing = armorPiercing;
        this.heatShell = heatShell;
        this.heShell = heShell;
        this.apcrShell = apcrShell;
        DispenserBlock.registerBehavior(
                this,
                new DefaultDispenseItemBehavior() {
                    public ItemStack execute(BlockSource source, ItemStack stack) {
                        Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
                        EntityType<?> entitytype = ((SpawnEggItem)stack.getItem()).getType(stack.getTag());
                        entitytype.spawn(source.getLevel(), stack, null, source.getPos().relative(direction, 0), MobSpawnType.DISPENSER, direction != Direction.UP, false);
                        stack.shrink(1);
                        return stack;
                    }
                });
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.literal("Ammo:").withStyle(ChatFormatting.AQUA));
        if (standard) {
            pTooltipComponents.add(Component.literal("Standard Shell"));
        }
        if (armorPiercing) {
            pTooltipComponents.add(Component.literal("Armor Piercing Shell"));
        }
        if (heatShell) {
            pTooltipComponents.add(Component.literal("HEAT Shell"));
        }
        if (heShell) {
            pTooltipComponents.add(Component.literal("High Explosive Shell"));
        }
        if (apcrShell) {
            pTooltipComponents.add(Component.literal("APCR Shell"));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
