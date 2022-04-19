package com.crescentine.trajanstanks.integration.jei_compat;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.item.TankModItems;
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

public class TankCrafterRecipeCategory implements IRecipeCategory<TankCrafterRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(TankMod.MOD_ID, "crafter");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(TankMod.MOD_ID, "textures/gui/jei_crafter.png");

    private final IDrawable background;
    private final IDrawable icon;

    public TankCrafterRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 125, 53);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(TankModItems.CRAFTER_BLOCK.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends TankCrafterRecipe> getRecipeClass() {
        return TankCrafterRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TextComponent("Tank Crafter");
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
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull TankCrafterRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 19, 1).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 19).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 19, 19).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 37, 19).addIngredients(recipe.getIngredients().get(3));
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 37).addIngredients(recipe.getIngredients().get(4));
        builder.addSlot(RecipeIngredientRole.INPUT, 19, 37).addIngredients(recipe.getIngredients().get(5));
        builder.addSlot(RecipeIngredientRole.INPUT, 37, 37).addIngredients(recipe.getIngredients().get(6));
        builder.addSlot(RecipeIngredientRole.INPUT, 73, 37).addIngredients(recipe.getIngredients().get(7));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 109, 19).addItemStack(recipe.getResultItem());
    }
}