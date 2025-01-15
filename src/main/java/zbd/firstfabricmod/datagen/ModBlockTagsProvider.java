package zbd.firstfabricmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import zbd.firstfabricmod.blocks.ModBlocks;
import zbd.firstfabricmod.tags.ModBlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagProvider.BlockTagProvider{

    public ModBlockTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.DIAMOND_FURNACE)
                .add(ModBlocks.GALLIUM_ORE_BLOCK)
                .add(ModBlocks.DEEPSLATE_GALLIUM_ORE_BLOCK)
                .add(ModBlocks.RAW_GALLIUM_BLOCK)
                .add(ModBlocks.GALLIUM_BLOCK)
                .add(ModBlocks.GALLIUM_DOOR)
                .add(ModBlocks.GALLIUM_TRAPDOOR)
                .add(ModBlocks.GALLIUM_FENCE)
                .add(ModBlocks.GALLIUM_BLOCK_SLAB)
                .add(ModBlocks.GALLIUM_PRESSURE_PLATE)
                .add(ModBlocks.GALLIUM_STAIRS);
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.DIAMOND_FURNACE);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GALLIUM_ORE_BLOCK)
                .add(ModBlocks.DEEPSLATE_GALLIUM_ORE_BLOCK)
                .add(ModBlocks.RAW_GALLIUM_BLOCK)
                .add(ModBlocks.GALLIUM_BLOCK);
        getOrCreateTagBuilder(ModBlockTags.ORE_LIST)
                .add(ModBlocks.RAW_GALLIUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_GALLIUM_ORE_BLOCK);
        getOrCreateTagBuilder(ConventionalBlockTags.ORES)
                .forceAddTag(ModBlockTags.ORE_LIST);
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.GALLIUM_BLOCK);
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.GALLIUM_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.GALLIUM_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.GALLIUM_WALL);
        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(ModBlocks.GALLIUM_BUTTON);
//        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
//                .add(ModBlocks.GALLIUM_FENCE);
    }
}
