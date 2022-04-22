package com.crescentine.trajanstanks.recipe;

import com.crescentine.trajanstanks.TankMod;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class EngineFabricatorRecipe implements Recipe<SimpleContainer> {
    ResourceLocation TYPE_ID = new ResourceLocation(TankMod.MOD_ID, "engine_fabricator");
    private final ResourceLocation id;
    private final ItemStack output;
    public final NonNullList<Ingredient> recipeItems;

    public EngineFabricatorRecipe(ResourceLocation id, ItemStack output,
                             NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.TYPE_ID = TYPE_ID;
        this.recipeItems = recipeItems;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public boolean matches(SimpleContainer inventory, Level world) {
        if (recipeItems.get(0).test(inventory.getItem(0))) {
            if (recipeItems.get(1).test(inventory.getItem(1))) {
                if (recipeItems.get(2).test(inventory.getItem(2))) {
                    if (recipeItems.get(3).test(inventory.getItem(3))) {
                        if (recipeItems.get(4).test(inventory.getItem(4))) {
                            if (recipeItems.get(5).test(inventory.getItem(5))) {
                                if (recipeItems.get(6).test(inventory.getItem(6))) {
                                    if (recipeItems.get(7).test(inventory.getItem(7))) {
                                    return recipeItems.get(8).test(inventory.getItem(8));
                                }}}}}}}}
        return false;
    }


    @Override
    public ItemStack assemble(SimpleContainer p_44001_) {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<EngineFabricatorRecipe> {
        public Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "engine_fabricator";
    }

    public static class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<EngineFabricatorRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "engine_fabricator";
        public Serializer() {
            setRegistryName(TankMod.MOD_ID, "engine_fabricator");
        }
        @Override
        public EngineFabricatorRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(9, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new EngineFabricatorRecipe(id, output, inputs);
        }

        @Override
        public EngineFabricatorRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();
            return new EngineFabricatorRecipe(id, output,
                    inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, EngineFabricatorRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(), false);
        }
    }
}