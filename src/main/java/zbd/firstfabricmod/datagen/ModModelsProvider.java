package zbd.firstfabricmod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.state.property.Properties;
import zbd.firstfabricmod.blocks.ModBlockFamilies;
import zbd.firstfabricmod.blocks.ModBlocks;
import zbd.firstfabricmod.item.ModEquipmentAssetKeys;
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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GALLIUM_ORE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_GALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_GALLIUM_ORE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIAMOND_FURNACE);
        blockStateModelGenerator.registerCrop(ModBlocks.STRAWBERRY_CROP, Properties.AGE_5,0,1,2,3,4,5);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.GALLIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_GALLIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.APEX, Models.GENERATED);
        itemModelGenerator.register(ModItems.INTESTINES, Models.GENERATED);
        itemModelGenerator.register(ModItems.NINE_TURN_INTESTINES, Models.GENERATED);
        itemModelGenerator.register(ModItems.PROSPECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_NINE_TURN_INTESTINES, Models.GENERATED);
        itemModelGenerator.registerWithInHandModel(ModItems.PLATE);

        itemModelGenerator.registerWithInHandModel(ModItems.GALLIUM_SWORD);
        itemModelGenerator.register(ModItems.GALLIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GALLIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GALLIUM_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GALLIUM_SHOVEL, Models.HANDHELD);

        itemModelGenerator.registerArmor(ModItems.GALLIUM_HELMET, ModEquipmentAssetKeys.GALLIUM, "helmet", false);
        itemModelGenerator.registerArmor(ModItems.GALLIUM_CHESTPLATE, ModEquipmentAssetKeys.GALLIUM, "chestplate", false);
        itemModelGenerator.registerArmor(ModItems.GALLIUM_LEGGINGS, ModEquipmentAssetKeys.GALLIUM, "leggings", false);
        itemModelGenerator.registerArmor(ModItems.GALLIUM_BOOTS, ModEquipmentAssetKeys.GALLIUM, "boots", false);
    }
}
