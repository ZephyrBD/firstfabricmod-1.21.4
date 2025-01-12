package zbd.firstfabricmod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.data.family.BlockFamily;
import zbd.firstfabricmod.blocks.ModBlockFamilies;
import zbd.firstfabricmod.blocks.ModBlocks;
import zbd.firstfabricmod.item.ModItems;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        ModBlockFamilies.getFamilies()
                        .filter(BlockFamily::shouldGenerateModels)
                        .forEach(blockFamily -> blockStateModelGenerator.registerCubeAllModelTexturePool(blockFamily.getBaseBlock())
                        .family(blockFamily));
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GA_ORE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_GA_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_GA_ORE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIAMOND_FURNACE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.INGOT_GA, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_GA, Models.GENERATED);
        itemModelGenerator.register(ModItems.APEX, Models.GENERATED);
        itemModelGenerator.register(ModItems.INTESTINES, Models.GENERATED);
        itemModelGenerator.register(ModItems.NINE_TURN_INTESTINES, Models.GENERATED);
        itemModelGenerator.register(ModItems.PROSPECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_NINE_TURN_INTESTINES, Models.GENERATED);
        itemModelGenerator.registerWithInHandModel(ModItems.PLATE);

        itemModelGenerator.registerWithInHandModel(ModItems.GA_SWORD);
        itemModelGenerator.register(ModItems.GA_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GA_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GA_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GA_SHOVEL, Models.HANDHELD);
    }
}
