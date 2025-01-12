package zbd.firstfabricmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.block.Blocks;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.util.Identifier;
import zbd.firstfabricmod.FirstFabricMod;
import zbd.firstfabricmod.blocks.ModBlocks;
import zbd.firstfabricmod.item.ModItems;
import zbd.firstfabricmod.tags.ModItemTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;



public class ModRecipesProvider extends FabricRecipeProvider
{
    private static final List<ItemConvertible> GA_FURNACE = List.of(ModItems.RAW_GA);
    public ModRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }
    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter)
    {
        return new RecipeGenerator(wrapperLookup, recipeExporter)
        {

            @Override
            public void generate()
            {
                //可逆配方
                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.INGOT_GA, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GA_BLOCK);
                //熔炉
                offerSmelting(GA_FURNACE, RecipeCategory.MISC, ModItems.INGOT_GA, 0.7f, 200, "ga_furnace");
                offerSmelting(List.of(ModItems.NINE_TURN_INTESTINES), RecipeCategory.FOOD, ModItems.COOKED_NINE_TURN_INTESTINES, 0.7f, 200, "cooked_intestines_furnace");
                //高炉
                offerBlasting(GA_FURNACE, RecipeCategory.MISC, ModItems.INGOT_GA, 0.7f, 100, "ga_blast_furnace");
                //篝火
                offerFoodCookingRecipe("campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new,
                        600, ModItems.RAW_GA, ModItems.INGOT_GA, 0.35f);
                offerFoodCookingRecipe("campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new,
                        600, ModItems.NINE_TURN_INTESTINES, ModItems.COOKED_NINE_TURN_INTESTINES, 0.35f);
                //烟熏炉
                offerFoodCookingRecipe("smoking", RecipeSerializer.SMOKING, SmokingRecipe::new,
                        600, ModItems.RAW_GA, ModItems.INGOT_GA, 0.35f);
                offerFoodCookingRecipe("smoking", RecipeSerializer.SMOKING, SmokingRecipe::new,
                        100, ModItems.NINE_TURN_INTESTINES, ModItems.COOKED_NINE_TURN_INTESTINES, 0.7f);
                //有序配方
                createShaped(RecipeCategory.MISC, ModItems.APEX)
                        .pattern("XXX")
                        .input('X', ModItemTags.IRON_TAG)
                        .criterion("has_apex",conditionsFromTag(ModItemTags.IRON_TAG))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, getRecipeIdentifier(Identifier.of(FirstFabricMod.MOD_ID, "apex"))));
                createShaped(RecipeCategory.MISC, ModItems.NINE_TURN_INTESTINES)
                        .pattern(" Y ")
                        .pattern("#X#")
                        .pattern(" M ")
                        .input('Y',Items.GOLDEN_APPLE)
                        .input('#',Items.GOLDEN_CARROT)
                        .input('X',ModItems.INTESTINES)
                        .input('M',Items.BOWL)
                        .criterion("has_intestines",conditionsFromItem(ModItems.INTESTINES))
                        .criterion("has_golden_carrot",conditionsFromItem(Items.GOLDEN_CARROT))
                        .criterion("has_golden_apple",conditionsFromItem(Items.GOLDEN_APPLE))
                        .criterion("has_bowl",conditionsFromItem(Items.BOWL))
                        .offerTo(exporter,RegistryKey.of(RegistryKeys.RECIPE, getRecipeIdentifier(Identifier.of(FirstFabricMod.MOD_ID, "nine_turn_intestines"))));
                createShaped(RecipeCategory.MISC, ModItems.PROSPECTOR)
                        .pattern("YYY")
                        .pattern("#X#")
                        .pattern("MMM")
                        .input('Y',ModItems.INGOT_GA)
                        .input('#',Items.REDSTONE)
                        .input('X',ConventionalItemTags.GLASS_BLOCKS)
                        .input('M',Blocks.IRON_BLOCK)
                        .criterion("has_ingot_ga",conditionsFromItem(ModItems.INGOT_GA))
                        .offerTo(exporter,RegistryKey.of(RegistryKeys.RECIPE, getRecipeIdentifier(Identifier.of(FirstFabricMod.MOD_ID, "prospector"))));
                //无序配方
                createShapeless(RecipeCategory.MISC, Items.FLINT_AND_STEEL,1)
                        .input(ModItems.INGOT_GA)
                        .input(Items.IRON_INGOT)
                        .criterion("has_flint_steel",conditionsFromItem(ModItems.INGOT_GA))
                        .criterion("has_flint_steel",conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(exporter,RegistryKey.of(RegistryKeys.RECIPE, getRecipeIdentifier(Identifier.of(FirstFabricMod.MOD_ID, "other_flint_and_steel"))));
            }
        };
    }

    @Override
    public String getName()
    {
        return FirstFabricMod.MOD_ID;
    }
}

