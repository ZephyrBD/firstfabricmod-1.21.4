package zbd.firstfabricmod.mixin;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ToolMaterial.class)
public interface ToolMaterialMixin {
    @Invoker("<init>")
    static ToolMaterial createCustomToolMaterial(
            TagKey<Block> incorrectBlocksForDrops,
            int durability,
            float speed,
            float attackDamageBonus,
            int enchantmentValue,
            TagKey<Item> repairItems
    ) {
        throw new AssertionError();
    }
}