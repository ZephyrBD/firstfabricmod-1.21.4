package zbd.firstfabricmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import zbd.firstfabricmod.blocks.ModBlocks;
import zbd.firstfabricmod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModENUSLanProvider extends FabricLanguageProvider {
    public ModENUSLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("itemGroup.firstfabricmod.firstfabricmod_group", "First Fabric Mod");

        translationBuilder.add(ModItems.PLATE, "Plate");
        translationBuilder.add(ModItems.INTESTINES, "Intestines");
        translationBuilder.add(ModItems.NINE_TURN_INTESTINES, "9 Turn Intestines");
        translationBuilder.add(ModItems.COOKED_NINE_TURN_INTESTINES, "Cooked 9 Turn Intestines");

        translationBuilder.add(ModItems.PROSPECTOR, "Prospector");
        translationBuilder.add(ModBlocks.DIAMOND_FURNACE, "Diamond Furnace");
        translationBuilder.add(ModItems.APEX, "Apex Legends");

        translationBuilder.add(ModItems.RAW_GALLIUM, "Raw Gallium");
        translationBuilder.add(ModItems.GALLIUM_INGOT, "Gallium Ingot");
        translationBuilder.add(ModBlocks.GALLIUM_ORE_BLOCK, "Gallium Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_GALLIUM_ORE_BLOCK, "Deepslate Gallium Ore");
        translationBuilder.add(ModBlocks.RAW_GALLIUM_BLOCK, "Block of Raw Gallium");
        translationBuilder.add(ModBlocks.GALLIUM_BLOCK, "Block of Gallium");
        translationBuilder.add(ModBlocks.GALLIUM_STAIRS, "Gallium Stairs");
        translationBuilder.add(ModBlocks.GALLIUM_BLOCK_SLAB, "Gallium Slab");
        translationBuilder.add(ModBlocks.GALLIUM_BUTTON, "Gallium Button");
        translationBuilder.add(ModBlocks.GALLIUM_PRESSURE_PLATE, "Gallium Pressure Plate");
        translationBuilder.add(ModBlocks.GALLIUM_FENCE, "Gallium Fence");
        translationBuilder.add(ModBlocks.GALLIUM_FENCE_GATE, "Gallium Fence Gate");
        translationBuilder.add(ModBlocks.GALLIUM_WALL, "Gallium Wall");
        translationBuilder.add(ModBlocks.GALLIUM_DOOR, "Gallium Door");
        translationBuilder.add(ModBlocks.GALLIUM_TRAPDOOR, "Gallium Trapdoor");

        translationBuilder.add(ModItems.GALLIUM_SWORD, "Gallium Sword");
        translationBuilder.add(ModItems.GALLIUM_AXE, "Gallium Axe");
        translationBuilder.add(ModItems.GALLIUM_HOE, "Gallium Hoe");
        translationBuilder.add(ModItems.GALLIUM_PICKAXE, "Gallium Pickaxe");
        translationBuilder.add(ModItems.GALLIUM_SHOVEL, "Gallium Shovel");

        translationBuilder.add(ModItems.GALLIUM_HELMET, "Gallium Helmet");
        translationBuilder.add(ModItems.GALLIUM_CHESTPLATE, "Gallium Chestplate");
        translationBuilder.add(ModItems.GALLIUM_LEGGINGS, "Gallium Leggings");
        translationBuilder.add(ModItems.GALLIUM_BOOTS, "Gallium Boots");

        translationBuilder.add(ModBlocks.STRAWBERRY_CROP, "Strawberry");
        translationBuilder.add(ModItems.STRAWBERRY, "Strawberry");

        translationBuilder.add("item.firstfabricmod.prospector.shift_tooltip","A tool to ores.");
        translationBuilder.add("item.firstfabricmod.prospector.tooltip","Hold \u00A76SHIFT\u00A7r for more information.");
    }
}
