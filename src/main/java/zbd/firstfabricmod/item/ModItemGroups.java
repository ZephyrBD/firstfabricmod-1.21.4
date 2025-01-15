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

                        entries.add(ModBlocks.GALLIUM_ORE_BLOCK);
                        entries.add(ModBlocks.DEEPSLATE_GALLIUM_ORE_BLOCK);
                        entries.add(ModItems.RAW_GALLIUM);
                        entries.add(ModBlocks.RAW_GALLIUM_BLOCK);
                        entries.add(ModBlocks.GALLIUM_BLOCK);
                        entries.add(ModItems.GALLIUM_INGOT);
                        entries.add(ModBlocks.GALLIUM_STAIRS);
                        entries.add(ModBlocks.GALLIUM_BLOCK_SLAB);
                        entries.add(ModBlocks.GALLIUM_BUTTON);
                        entries.add(ModBlocks.GALLIUM_PRESSURE_PLATE);
                        entries.add(ModBlocks.GALLIUM_FENCE);
                        entries.add(ModBlocks.GALLIUM_FENCE_GATE);
                        entries.add(ModBlocks.GALLIUM_WALL);
                        entries.add(ModBlocks.GALLIUM_DOOR);
                        entries.add(ModBlocks.GALLIUM_TRAPDOOR);

                        entries.add(ModItems.GALLIUM_SWORD);
                        entries.add(ModItems.GALLIUM_PICKAXE);
                        entries.add(ModItems.GALLIUM_AXE);
                        entries.add(ModItems.GALLIUM_HOE);
                        entries.add(ModItems.GALLIUM_SHOVEL);

                        entries.add(ModItems.GALLIUM_HELMET);
                        entries.add(ModItems.GALLIUM_CHESTPLATE);
                        entries.add(ModItems.GALLIUM_LEGGINGS);
                        entries.add(ModItems.GALLIUM_BOOTS);

                        entries.add(ModItems.STRAWBERRY);
                    }).build());
    public static void initialize()
    {
        LOGGER.info("Loading " + FirstFabricMod.MOD_ID + "'s Mod Items Groups...");
    }
}
