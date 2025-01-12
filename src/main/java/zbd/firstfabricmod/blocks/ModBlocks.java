package zbd.firstfabricmod.blocks;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import zbd.firstfabricmod.FirstFabricMod;

import java.util.function.Function;

import static com.mojang.text2speech.Narrator.LOGGER;
import static net.minecraft.block.Blocks.createButtonSettings;

public class ModBlocks {
    public static final Block DIAMOND_FURNACE = register("diamond_furnace", Block::new, Block.Settings.create().strength(4.0f).requiresTool());
    public static final Block GA_ORE_BLOCK = register("ga_ore_block", Block::new, Block.Settings.create().strength(4.0f).requiresTool());
    public static final Block DEEPSLATE_GA_ORE_BLOCK = register("deepslate_ga_ore_block", Block::new, Block.Settings.create().strength(4.0f).requiresTool());
    public static final Block RAW_GA_BLOCK = register("raw_ga_block", Block::new, Block.Settings.create().strength(4.0f).requiresTool());
    public static final Block GA_BLOCK = register("ga_block", Block::new, Block.Settings.create().strength(4.0f).requiresTool());
    public static final Block GA_STAIRS = registerOldStairsBlock("ga_stairs", GA_BLOCK);
    public static final Block GA_BLOCK_SLAB = register("ga_block_slab", SlabBlock::new, AbstractBlock.Settings.copy(GA_BLOCK));

    public static final Block GA_BUTTON = register("ga_button",
            settings -> new ButtonBlock(BlockSetType.OAK, 30, settings),
            createButtonSettings());

    public static final Block GA_PRESSURE_PLATE = register("ga_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.copy(GA_BLOCK));

    public static final Block GA_FENCE = register("ga_fence", FenceBlock::new, AbstractBlock.Settings.copy(GA_BLOCK));
    public static final Block GA_FENCE_GATE = register("ga_fence_gate",
            settings -> new FenceGateBlock(WoodType.OAK, settings),
            AbstractBlock.Settings.copy(GA_BLOCK));

    public static final Block GA_WALL = register("ga_wall", WallBlock::new, AbstractBlock.Settings.copy(GA_BLOCK));
    public static final Block GA_DOOR = register("ga_door",
            settings -> new DoorBlock(BlockSetType.IRON, settings),
            AbstractBlock.Settings.copy(GA_BLOCK)
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.DESTROY));
    public static final Block GA_TRAPDOOR = register("ga_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.copy(GA_BLOCK)
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.DESTROY));

    private static Block registerOldStairsBlock(String id, Block base) {
        return register(id, settings -> new StairsBlock(base.getDefaultState(), settings), AbstractBlock.Settings.copyShallow(base));
    }
    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(FirstFabricMod.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        return block;
    }
    public static void initialize()
    {
        LOGGER.info("Loading " + FirstFabricMod.MOD_ID + "'s Blocks...");
    }
}
