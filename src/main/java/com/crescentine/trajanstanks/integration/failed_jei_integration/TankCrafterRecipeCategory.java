package com.crescentine.trajanstanks.integration.failed_jei_integration;

/* @SuppressWarnings("depreciation") */
public class TankCrafterRecipeCategory /* implements IRecipeCategory<TankCrafterRecipe> */ {
 /*   public static final RecipeType<TankCrafterRecipe> RECIPE_TYPE = RecipeType.create(TankMod.MOD_ID, "crafter", TankCrafterRecipe.class);
    public final static ResourceLocation UID = new ResourceLocation(TankMod.MOD_ID, "crafter");

    private final IDrawable background;
    private final IDrawable icon;

    public TankCrafterRecipeCategory(IGuiHelper helper) {
        background = helper.createDrawable(new ResourceLocation(TankMod.MOD_ID, "textures/gui/crafter.png"), 0, 0, 176, 165);
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(TankModItems.CRAFTER_BLOCK.get()));
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
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, TankCrafterRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 17)
                .addIngredients(recipe.recipeItems.get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 26, 35)
                .addIngredients(recipe.recipeItems.get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 35)
                .addIngredients(recipe.recipeItems.get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 62, 35)
                .addIngredients(recipe.recipeItems.get(3));
        builder.addSlot(RecipeIngredientRole.INPUT, 26, 53)
                .addIngredients(recipe.recipeItems.get(4));
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 53)
                .addIngredients(recipe.recipeItems.get(5));
        builder.addSlot(RecipeIngredientRole.INPUT, 62, 53)
                .addIngredients(recipe.recipeItems.get(6));
        builder.addSlot(RecipeIngredientRole.INPUT, 98, 53)
                .addIngredients(recipe.recipeItems.get(7));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 134, 35)
                .addItemStack(recipe.getResultItem());
    } */
}