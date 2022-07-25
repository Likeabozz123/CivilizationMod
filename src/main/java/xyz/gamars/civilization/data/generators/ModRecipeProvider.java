package xyz.gamars.civilization.data.generators;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    // CRAFTING RECIPES
    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        buildSmeltingRecipes(consumer);

    }

    // SMELTING RECIPES
    public void buildSmeltingRecipes (Consumer<FinishedRecipe> consumer) {

    }

    public static void inputOutput(ItemLike input, ItemLike output, float experience, int cookingTime, String recipeID, Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(
                        input),
                        output,
                        experience,
                        cookingTime)
                .unlockedBy("has_chunk", has(input))
                .save(consumer, recipeID);
    }

    public static void singleFormat(ItemLike input, ItemLike output, String recipeID, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(output)
                .requires(input)
                .unlockedBy("has_ingot", has(input))
                .save(consumer);
    }

    public static void singleFormat(ItemLike input, ItemLike output, int outputAmount, String recipeID, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(output, outputAmount)
                .requires(input)
                .unlockedBy("has_ingot", has(input))
                .save(consumer, recipeID);
    }

    public static void stickFormat(ItemLike input, ItemLike output, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(output)
                .define('#', input)
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_ingot", has(input))
                .save(consumer);
    }

    public static void pickaxeFormat(ItemLike material, ItemLike stick, ItemLike output, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(output)
                .define('#', material)
                .define('/', stick)
                .pattern("###")
                .pattern(" / ")
                .pattern(" / ")
                .unlockedBy("has_ingot", has(material))
                .save(consumer);
    }

    public static void axeFormat(ItemLike material, ItemLike stick, ItemLike output, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(output)
                .define('#', material)
                .define('/', stick)
                .pattern("## ")
                .pattern("#/ ")
                .pattern(" / ")
                .unlockedBy("has_ingot", has(material))
                .save(consumer);
    }

    public static void shovelFormat(ItemLike material, ItemLike stick, ItemLike output, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(output)
                .define('#', material)
                .define('/', stick)
                .pattern(" # ")
                .pattern(" / ")
                .pattern(" / ")
                .unlockedBy("has_ingot", has(material))
                .save(consumer);
    }

    public static void swordFormat(ItemLike material, ItemLike stick, ItemLike output, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(output)
                .define('#', material)
                .define('/', stick)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" / ")
                .unlockedBy("has_ingot", has(material))
                .save(consumer);
    }

    public static void hoeFormat(ItemLike material, ItemLike stick, ItemLike output,  Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(output)
                .define('#', material)
                .define('/', stick)
                .pattern("## ")
                .pattern(" / ")
                .pattern(" / ")
                .unlockedBy("has_ingot", has(material))
                .save(consumer);
    }

    public static void helmetFormat(ItemLike material, ItemLike output, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(output)
                .define('#', material)
                .pattern("###")
                .pattern("# #")
                .pattern("   ")
                .unlockedBy("has_ingot", has(material))
                .save(consumer);
    }

    public static void chestplateFormat(ItemLike material, ItemLike output, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(output)
                .define('#', material)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_ingot", has(material))
                .save(consumer);
    }

    public static void leggingsFormat(ItemLike material, ItemLike output, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(output)
                .define('#', material)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_ingot", has(material))
                .save(consumer);
    }

    public static void bootsFormat(ItemLike material, ItemLike output, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(output)
                .define('#', material)
                .pattern("# #")
                .pattern("# #")
                .pattern("   ")
                .unlockedBy("has_ingot", has(material))
                .save(consumer);
    }

    public static void ringFormat(ItemLike material, ItemLike output, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(output)
                .define('#', material)
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_ingot", has(material))
                .save(consumer);
    }

    public static void ringWithCenterFormat(ItemLike material, ItemLike material2, ItemLike output, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(output)
                .define('#', material)
                .define('/', material2)
                .pattern("###")
                .pattern("#/#")
                .pattern("###")
                .unlockedBy("has_ingot", has(material))
                .save(consumer);
    }

    public static void threeByThreeFormat(ItemLike material, ItemLike output, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(output)
                .define('#', material)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_ingot", has(material))
                .save(consumer);
    }



    @Override
    public String getName() {
        return "Civilization : Recipes";
    }
}
