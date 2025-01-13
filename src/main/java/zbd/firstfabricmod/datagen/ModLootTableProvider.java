package zbd.firstfabricmod.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import zbd.firstfabricmod.blocks.ModBlocks;
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
        addDrop(ModBlocks.DIAMOND_FURNACE);
        addDrop(ModBlocks.GA_BLOCK);
        addDrop(ModBlocks.RAW_GA_BLOCK);
        addDrop(ModBlocks.GA_STAIRS);
        addDrop(ModBlocks.GA_BLOCK_SLAB);
        addDrop(ModBlocks.GA_BUTTON);
        addDrop(ModBlocks.GA_PRESSURE_PLATE);
        addDrop(ModBlocks.GA_FENCE);
        addDrop(ModBlocks.GA_FENCE_GATE);
        addDrop(ModBlocks.GA_WALL);
        addDrop(ModBlocks.GA_DOOR);
        addDrop(ModBlocks.GA_TRAPDOOR);
        addDrop(ModBlocks.DEEPSLATE_GA_ORE_BLOCK,copperOreLikeDrops(ModBlocks.DEEPSLATE_GA_ORE_BLOCK, ModItems.RAW_GA));
        addDrop(ModBlocks.GA_ORE_BLOCK,copperOreLikeDrops(ModBlocks.GA_ORE_BLOCK, ModItems.RAW_GA));
    }
}
