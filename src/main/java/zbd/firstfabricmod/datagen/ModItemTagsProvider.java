package zbd.firstfabricmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;
import zbd.firstfabricmod.item.ModItems;
import zbd.firstfabricmod.tags.ModItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagProvider.ItemTagProvider{
    public ModItemTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture, @Nullable BlockTagProvider blockTagProvider) {
        super(output, completableFuture, blockTagProvider);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModItemTags.GALLIUM_TAG).add(ModItems.GALLIUM_INGOT);

        getOrCreateTagBuilder(ItemTags.SWORDS).add(ModItems.GALLIUM_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(ModItems.GALLIUM_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES).add(ModItems.GALLIUM_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS).add(ModItems.GALLIUM_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES).add(ModItems.GALLIUM_HOE);

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR).add(ModItems.GALLIUM_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR).add(ModItems.GALLIUM_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR).add(ModItems.GALLIUM_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR).add(ModItems.GALLIUM_BOOTS);
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR).add(ModItems.GALLIUM_HELMET, ModItems.GALLIUM_CHESTPLATE, ModItems.GALLIUM_LEGGINGS, ModItems.GALLIUM_BOOTS);

        getOrCreateTagBuilder(ModItemTags.IRON_TAG)
                .add(Items.IRON_INGOT)
                .add(ModItems.GALLIUM_INGOT);
    }
}
