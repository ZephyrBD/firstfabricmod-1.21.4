package zbd.firstfabricmod.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import zbd.firstfabricmod.mixin.ToolMaterialMixin;
import zbd.firstfabricmod.tags.ModItemTags;

public class ModToolMaterial {
    static ToolMaterial GALLIUM = ToolMaterialMixin.createCustomToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            1000,
            7.0F,
            2.0F,
            14,
            ModItemTags.GALLIUM_TAG
    );
}
