package com.crescentine.trajanstanks.integration.jei;

import com.crescentine.trajanstanks.TankMod;
import com.crescentine.trajanstanks.item.TankModItems;
import com.crescentine.trajanstanks.recipe.TankCrafterRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@SuppressWarnings("deprecation")
public class TankCrafterRecipeCategory implements IRecipeCategory<TankCrafterRecipe> {
    public static final RecipeType<TankCrafterRecipe> RECIPE_TYPE = RecipeType.create(TankMod.MOD_ID, "crafter", TankCrafterRecipe.class);
    public final static ResourceLocation UID = new ResourceLocation(TankMod.MOD_ID, ".crafter");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(TankMod.MOD_ID, "textures/gui/crafter.png");

    private final IDrawable background;
    private final IDrawable icon;

    public TankCrafterRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(TankModItems.CRAFTER_BLOCK.get()));
    }
    @Deprecated
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
        return TankModItems.CRAFTER_BLOCK.get().getName();
    }

    @Override
    public RecipeType<TankCrafterRecipe> getRecipeType() {
        return RECIPE_TYPE;
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
    public void setRecipe(IRecipeLayoutBuilder builder, TankCrafterRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 17)
                .addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 26, 35)
                .addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 35)
                .addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 62, 35)
                .addIngredients(recipe.getIngredients().get(3));
        builder.addSlot(RecipeIngredientRole.INPUT, 26, 53)
                .addIngredients(recipe.getIngredients().get(4));
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 53)
                .addIngredients(recipe.getIngredients().get(5));
        builder.addSlot(RecipeIngredientRole.INPUT, 62, 53)
                .addIngredients(recipe.getIngredients().get(6));
        builder.addSlot(RecipeIngredientRole.INPUT, 98, 53)
                .addIngredients(recipe.getIngredients().get(7));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 134, 35)
                .addItemStack(recipe.getResultItem());
    }

}
