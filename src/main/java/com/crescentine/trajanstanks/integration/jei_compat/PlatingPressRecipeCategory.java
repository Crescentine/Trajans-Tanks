package com.crescentine.trajanstanks.integration.jei_compat;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.item.TankModItems;
import com.crescentine.trajanstanks.recipe.PlatingPressRecipe;
import com.crescentine.trajanstanks.recipe.TankCrafterRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class PlatingPressRecipeCategory implements IRecipeCategory<PlatingPressRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(TankMod.MOD_ID, "plating_press");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(TankMod.MOD_ID, "textures/gui/jei_plating_press.png");

    private final IDrawable background;
    private final IDrawable icon;

    public PlatingPressRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 95, 40);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(TankModItems.PLATE_PRESS_BLOCK.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends PlatingPressRecipe> getRecipeClass() {
        return PlatingPressRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TextComponent("Plating Press");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull PlatingPressRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 3, 3).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 21, 3).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 3, 21).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 21, 21).addIngredients(recipe.getIngredients().get(3));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 77, 10).addItemStack(recipe.getResultItem());
    }
}