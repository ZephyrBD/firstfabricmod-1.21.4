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
                .add(ModBlocks.GA_ORE_BLOCK)
                .add(ModBlocks.DEEPSLATE_GA_ORE_BLOCK)
                .add(ModBlocks.RAW_GA_BLOCK)
                .add(ModBlocks.GA_BLOCK)
                .add(ModBlocks.GA_DOOR)
                .add(ModBlocks.GA_TRAPDOOR)
                .add(ModBlocks.GA_FENCE)
                .add(ModBlocks.GA_BLOCK_SLAB)
                .add(ModBlocks.GA_PRESSURE_PLATE)
                .add(ModBlocks.GA_STAIRS);
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.DIAMOND_FURNACE);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GA_ORE_BLOCK)
                .add(ModBlocks.DEEPSLATE_GA_ORE_BLOCK)
                .add(ModBlocks.RAW_GA_BLOCK)
                .add(ModBlocks.GA_BLOCK);
        getOrCreateTagBuilder(ModBlockTags.ORE_LIST)
                .add(ModBlocks.RAW_GA_BLOCK)
                .add(ModBlocks.DEEPSLATE_GA_ORE_BLOCK);
        getOrCreateTagBuilder(ConventionalBlockTags.ORES)
                .forceAddTag(ModBlockTags.ORE_LIST);
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.GA_BLOCK);
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.GA_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.GA_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.GA_WALL);
        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(ModBlocks.GA_BUTTON);
//        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
//                .add(ModBlocks.GA_FENCE);
    }
}
