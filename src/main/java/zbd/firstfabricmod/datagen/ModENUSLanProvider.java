package zbd.firstfabricmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import zbd.firstfabricmod.blocks.ModBlocks;
import zbd.firstfabricmod.item.ModItems;
import zbd.firstfabricmod.tags.ModBlockTags;
import zbd.firstfabricmod.tags.ModItemTags;

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

        translationBuilder.add(ModItems.RAW_GA, "Raw Gallium");
        translationBuilder.add(ModItems.INGOT_GA, "Gallium Ingot");
        translationBuilder.add(ModBlocks.GA_ORE_BLOCK, "Gallium Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_GA_ORE_BLOCK, "Deepslate Gallium Ore");
        translationBuilder.add(ModBlocks.RAW_GA_BLOCK, "Block of Raw Gallium");
        translationBuilder.add(ModBlocks.GA_BLOCK, "Block of Gallium");
        translationBuilder.add(ModBlocks.GA_STAIRS, "Gallium Stairs");
        translationBuilder.add(ModBlocks.GA_BLOCK_SLAB, "Gallium Slab");
        translationBuilder.add(ModBlocks.GA_BUTTON, "Gallium Button");
        translationBuilder.add(ModBlocks.GA_PRESSURE_PLATE, "Gallium Pressure Plate");
        translationBuilder.add(ModBlocks.GA_FENCE, "Gallium Fence");
        translationBuilder.add(ModBlocks.GA_FENCE_GATE, "Gallium Fence Gate");
        translationBuilder.add(ModBlocks.GA_WALL, "Gallium Wall");
        translationBuilder.add(ModBlocks.GA_DOOR, "Gallium Door");
        translationBuilder.add(ModBlocks.GA_TRAPDOOR, "Gallium Trapdoor");

        translationBuilder.add("item.firstfabricmod.prospector.shift_tooltip","A tool to ores.");
        translationBuilder.add("item.firstfabricmod.prospector.tooltip","Hold \u00A76SHIFT\u00A7r for more information.");
    }
}
