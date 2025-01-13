package zbd.firstfabricmod.blocks;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;

import java.util.Map;
import java.util.stream.Stream;

public class ModBlockFamilies {
    private static final Map<Block, BlockFamily> BASE_BLOCKS_TO_FAMILIES = Maps.newHashMap();

    public static final BlockFamily GA = register(ModBlocks.GA_BLOCK)
            .stairs(ModBlocks.GA_STAIRS)
            .slab(ModBlocks.GA_BLOCK_SLAB)
            .button(ModBlocks.GA_BUTTON)
            .pressurePlate(ModBlocks.GA_PRESSURE_PLATE)
            .fence(ModBlocks.GA_FENCE)
            .fenceGate(ModBlocks.GA_FENCE_GATE)
            .wall(ModBlocks.GA_WALL)
            .door(ModBlocks.GA_DOOR)
            .trapdoor(ModBlocks.GA_TRAPDOOR)
            .unlockCriterionName("has_ga_ingot")
            .build();

    public static BlockFamily.Builder register(Block baseBlock) {
        BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
        BlockFamily blockFamily = BASE_BLOCKS_TO_FAMILIES.put(baseBlock, builder.build());
        if (blockFamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + Registries.BLOCK.getId(baseBlock));
        } else {
            return builder;
        }
    }
    public static Stream<BlockFamily> getFamilies() {
        return BASE_BLOCKS_TO_FAMILIES.values().stream();
    }
}
