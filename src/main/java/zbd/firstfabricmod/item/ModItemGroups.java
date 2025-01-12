package zbd.firstfabricmod.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import zbd.firstfabricmod.FirstFabricMod;
import zbd.firstfabricmod.blocks.ModBlocks;

import static com.mojang.text2speech.Narrator.LOGGER;

public class ModItemGroups {
    public static final ItemGroup FIRSTFABRICMOD_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(FirstFabricMod.MOD_ID),
            ItemGroup.create(null,-1)
                    .displayName(Text.translatable("itemGroup.firstfabricmod.firstfabricmod_group"))
                    .icon(() -> new ItemStack(ModItems.APEX))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.APEX);

                        entries.add(ModItems.INTESTINES);
                        entries.add(ModItems.NINE_TURN_INTESTINES);
                        entries.add(ModItems.COOKED_NINE_TURN_INTESTINES);

                        entries.add(ModItems.PROSPECTOR);
                        entries.add(ModBlocks.DIAMOND_FURNACE);

                        entries.add(ModBlocks.GA_ORE_BLOCK);
                        entries.add(ModBlocks.DEEPSLATE_GA_ORE_BLOCK);
                        entries.add(ModItems.RAW_GA);
                        entries.add(ModBlocks.RAW_GA_BLOCK);
                        entries.add(ModBlocks.GA_BLOCK);
                        entries.add(ModItems.INGOT_GA);
                        entries.add(ModBlocks.GA_STAIRS);
                        entries.add(ModBlocks.GA_BLOCK_SLAB);
                        entries.add(ModBlocks.GA_BUTTON);
                        entries.add(ModBlocks.GA_PRESSURE_PLATE);
                        entries.add(ModBlocks.GA_FENCE);
                        entries.add(ModBlocks.GA_FENCE_GATE);
                        entries.add(ModBlocks.GA_WALL);
                        entries.add(ModBlocks.GA_DOOR);
                        entries.add(ModBlocks.GA_TRAPDOOR);

                        entries.add(ModItems.GA_SWORD);
                        entries.add(ModItems.GA_PICKAXE);
                        entries.add(ModItems.GA_AXE);
                        entries.add(ModItems.GA_HOE);
                        entries.add(ModItems.GA_SHOVEL);
                    }).build());
    public static void initialize()
    {
        LOGGER.info("Loading " + FirstFabricMod.MOD_ID + "'s Mod Items Groups...");
    }
}
