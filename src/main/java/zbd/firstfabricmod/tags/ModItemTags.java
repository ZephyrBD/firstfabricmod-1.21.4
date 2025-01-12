package zbd.firstfabricmod.tags;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import zbd.firstfabricmod.FirstFabricMod;

public class ModItemTags {
    public static final TagKey<Item> IRON_TAG = of("iron_tag");
    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(FirstFabricMod.MOD_ID,id));
    }
    public static void init() {
    }
}
