package zbd.firstfabricmod.blocks;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;

import java.util.Map;
import java.util.stream.Stream;

public class ModBlockFamilies {
    private static final Map<Block, BlockFamily> BASE_BLOCKS_TO_FAMILIES = Maps.newHashMap();

    public static final BlockFamily GA = register(ModBlocks.GALLIUM_BLOCK)
            .stairs(ModBlocks.GALLIUM_STAIRS)
            .slab(ModBlocks.GALLIUM_BLOCK_SLAB)
            .button(ModBlocks.GALLIUM_BUTTON)
            .pressurePlate(ModBlocks.GALLIUM_PRESSURE_PLATE)
            .fence(ModBlocks.GALLIUM_FENCE)
            .fenceGate(ModBlocks.GALLIUM_FENCE_GATE)
            .wall(ModBlocks.GALLIUM_WALL)
            .door(ModBlocks.GALLIUM_DOOR)
            .trapdoor(ModBlocks.GALLIUM_TRAPDOOR)
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
