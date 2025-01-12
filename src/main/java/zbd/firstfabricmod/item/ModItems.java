package zbd.firstfabricmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import zbd.firstfabricmod.FirstFabricMod;
import zbd.firstfabricmod.item.custom.Prospector;

import java.util.function.Function;
import static com.mojang.text2speech.Narrator.LOGGER;
import static net.minecraft.item.Items.BOWL;

public class ModItems {
    public static final Item APEX = register("apex_legends", Item::new, new Item.Settings());
    public static final Item RAW_GA= register("raw_ga", Item::new, new Item.Settings());
    public static final Item INGOT_GA = register("ingot_ga", Item::new, new Item.Settings());
    public static final Item INTESTINES = register("intestines", Item::new, new Item.Settings()
            .food(ModFoodComponents.INTESTINES, ModFoodConsumableComponents.INTESTINES));
    public static final Item NINE_TURN_INTESTINES = register("nine_turn_intestines", Item::new, new Item.Settings()
            .maxCount(1)
            .food(ModFoodComponents.NINE_TURN_INTESTINES)
            .useRemainder(BOWL));
    public static final Item COOKED_NINE_TURN_INTESTINES = register("cooked_nine_turn_intestines", Item::new, new Item.Settings()
            .maxCount(1)
            .food(ModFoodComponents.COOKED_NINE_TURN_INTESTINES, ModFoodConsumableComponents.COOKED_NINE_TURN_INTESTINES)
            .useRemainder(BOWL));
    public static final Item PROSPECTOR = register("prospector", Prospector::new, new Item.Settings().maxDamage(127));
    public static final Item PLATE = register("plate", Item::new, new Item.Settings());


    public static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {//注册item
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(FirstFabricMod.MOD_ID, name));
        return Items.register(registryKey, factory, settings);
    }
    //RegistryEntryLookup<Item> registryLookup
    private static void addToINGREDIENTSGroups(FabricItemGroupEntries fabricItemGroupEntries) {
        //添加到FabricGroups
        fabricItemGroupEntries.add(APEX);
    }
    private static void addToFOOD_AND_DRINKGroups(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.add(INTESTINES);
        fabricItemGroupEntries.add(NINE_TURN_INTESTINES);
        fabricItemGroupEntries.add(COOKED_NINE_TURN_INTESTINES);
    }
    private static void registerComposting() {
        //注册堆肥桶材料
        CompostingChanceRegistry.INSTANCE.add(APEX, 0.5F);
    }
    private static void registerFuels() {
        //注册为燃料
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            // 可以一次在这个 lambda 中添加多个物品。
            builder.add(APEX, 2100);
        });
    }
    public static void initialize() {
        registerFuels();
        registerComposting();
        //添加到原材料物品栏
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addToINGREDIENTSGroups);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addToFOOD_AND_DRINKGroups);
        LOGGER.info("Loading " + FirstFabricMod.MOD_ID + "'s items...");
    }
}
