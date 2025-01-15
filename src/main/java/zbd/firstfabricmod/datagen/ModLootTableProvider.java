package zbd.firstfabricmod.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import zbd.firstfabricmod.blocks.ModBlocks;
import zbd.firstfabricmod.blocks.custom.StrawberryCropBlock;
import zbd.firstfabricmod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }
    public LootTable.Builder copperOreLikeDrops(Block drop,Item dropItem) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop,
                this
                .applyExplosionDecay(drop, ItemEntry.builder(dropItem))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 5.0F)))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE))));
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        addDrop(ModBlocks.DIAMOND_FURNACE);
        addDrop(ModBlocks.GALLIUM_BLOCK);
        addDrop(ModBlocks.RAW_GALLIUM_BLOCK);
        addDrop(ModBlocks.GALLIUM_STAIRS);
        addDrop(ModBlocks.GALLIUM_BLOCK_SLAB);
        addDrop(ModBlocks.GALLIUM_BUTTON);
        addDrop(ModBlocks.GALLIUM_PRESSURE_PLATE);
        addDrop(ModBlocks.GALLIUM_FENCE);
        addDrop(ModBlocks.GALLIUM_FENCE_GATE);
        addDrop(ModBlocks.GALLIUM_WALL);
        addDrop(ModBlocks.GALLIUM_DOOR);
        addDrop(ModBlocks.GALLIUM_TRAPDOOR);
        addDrop(ModBlocks.DEEPSLATE_GALLIUM_ORE_BLOCK,copperOreLikeDrops(ModBlocks.DEEPSLATE_GALLIUM_ORE_BLOCK, ModItems.RAW_GALLIUM));
        addDrop(ModBlocks.GALLIUM_ORE_BLOCK,copperOreLikeDrops(ModBlocks.GALLIUM_ORE_BLOCK, ModItems.RAW_GALLIUM));

        LootCondition.Builder builder1 = BlockStatePropertyLootCondition.builder(ModBlocks.STRAWBERRY_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(StrawberryCropBlock.AGE, 5));
        this.addDrop(
                ModBlocks.STRAWBERRY_CROP,
                this.applyExplosionDecay(
                        ModBlocks.STRAWBERRY_CROP,
                        LootTable.builder()
                                .pool(LootPool.builder().with(ItemEntry.builder(ModItems.STRAWBERRY)))
                                .pool(
                                        LootPool.builder()
                                                .conditionally(builder1)
                                                .with(ItemEntry.builder(ModItems.STRAWBERRY).apply(ApplyBonusLootFunction.binomialWithBonusCount(impl.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 3)))
                                )
                )
        );
    }
}
