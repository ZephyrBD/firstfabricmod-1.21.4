package zbd.firstfabricmod.blocks;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import zbd.firstfabricmod.FirstFabricMod;
import zbd.firstfabricmod.blocks.custom.StrawberryCropBlock;

import java.util.function.Function;

import static com.mojang.text2speech.Narrator.LOGGER;
import static net.minecraft.block.Blocks.createButtonSettings;

public class ModBlocks {
    public static final Block DIAMOND_FURNACE = register("diamond_furnace", Block::new, Block.Settings.create().strength(4.0f).requiresTool());
    public static final Block GALLIUM_ORE_BLOCK = register("gallium_ore_block", Block::new, Block.Settings.create().strength(4.0f).requiresTool());
    public static final Block DEEPSLATE_GALLIUM_ORE_BLOCK = register("deepslate_gallium_ore_block", Block::new, Block.Settings.create().strength(4.0f).requiresTool());
    public static final Block RAW_GALLIUM_BLOCK = register("raw_gallium_block", Block::new, Block.Settings.create().strength(4.0f).requiresTool());
    public static final Block GALLIUM_BLOCK = register("gallium_block", Block::new, Block.Settings.create().strength(4.0f).requiresTool());
    public static final Block GALLIUM_STAIRS = registerOldStairsBlock("gallium_stairs", GALLIUM_BLOCK);
    public static final Block GALLIUM_BLOCK_SLAB = register("gallium_block_slab", SlabBlock::new, AbstractBlock.Settings.copy(GALLIUM_BLOCK));

    public static final Block GALLIUM_BUTTON = register("gallium_button",
            settings -> new ButtonBlock(BlockSetType.OAK, 30, settings),
            createButtonSettings());

    public static final Block GALLIUM_PRESSURE_PLATE = register("gallium_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.copy(GALLIUM_BLOCK));

    public static final Block GALLIUM_FENCE = register("gallium_fence", FenceBlock::new, AbstractBlock.Settings.copy(GALLIUM_BLOCK));
    public static final Block GALLIUM_FENCE_GATE = register("gallium_fence_gate",
            settings -> new FenceGateBlock(WoodType.OAK, settings),
            AbstractBlock.Settings.copy(GALLIUM_BLOCK));

    public static final Block GALLIUM_WALL = register("gallium_wall", WallBlock::new, AbstractBlock.Settings.copy(GALLIUM_BLOCK));
    public static final Block GALLIUM_DOOR = register("gallium_door",
            settings -> new DoorBlock(BlockSetType.IRON, settings),
            AbstractBlock.Settings.copy(GALLIUM_BLOCK)
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.DESTROY));
    public static final Block GALLIUM_TRAPDOOR = register("gallium_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.copy(GALLIUM_BLOCK)
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.DESTROY));

    public static final Block STRAWBERRY_CROP = Registry.register(Registries.BLOCK,
            Identifier.of(FirstFabricMod.MOD_ID, "strawberry_crop"),
            new StrawberryCropBlock(AbstractBlock.Settings.copy(Blocks.CARROTS).registryKey(ModregistryKey("strawberry_crop"))));

    private static Block registerOldStairsBlock(String id, Block base) {
        return register(id, settings -> new StairsBlock(base.getDefaultState(), settings), AbstractBlock.Settings.copyShallow(base));
    }
    private static Block register(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Block block = Blocks.register(ModregistryKey(name), factory, settings);
        Items.register(block);
        return block;
    }
    private static RegistryKey<Block> ModregistryKey(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(FirstFabricMod.MOD_ID, name));
    }

    public static void initialize()
    {
        LOGGER.info("Loading " + FirstFabricMod.MOD_ID + "'s Blocks...");
    }
}
