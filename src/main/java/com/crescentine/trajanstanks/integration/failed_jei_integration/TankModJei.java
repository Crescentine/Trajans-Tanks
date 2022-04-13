package com.crescentine.trajanstanks.integration.failed_jei_integration;

// @JeiPlugin
public class TankModJei /* implements IModPlugin */ {
    /* @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(TankMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(
                new TankCrafterRecipeCategory(guiHelper)
        );
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        if (Minecraft.getInstance().getConnection() == null) {
            return;
        }
        RecipeManager recipeManager = Minecraft.getInstance().getConnection().getRecipeManager();
        registration.addRecipes(TankCrafterRecipeCategory.RECIPE_TYPE, compileCrafterRecipes(recipeManager));
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(CrafterScreen.class, 73, 54, 39, 23, TankCrafterRecipeCategory.UID);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(CrafterContainer.class,TankCrafterRecipeCategory.UID, 0, 8, 9, 36);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(TankModItems.CRAFTER_BLOCK.get()), TankCrafterRecipeCategory.UID);
    }

    private ArrayList<TankCrafterRecipe> compileCrafterRecipes(RecipeManager recipeManager) {
        ArrayList<TankCrafterRecipe> crafterRecipes = new ArrayList<>();
        for (TankCrafterRecipe recipe : recipeManager.getAllRecipesFor(ModRecipes.CRAFTER_RECIPE_TYPE)) {
            crafterRecipes.add(recipe);
        }
        return crafterRecipes;
    } */

}