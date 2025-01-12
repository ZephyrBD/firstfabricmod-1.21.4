package zbd.firstfabricmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.tag.TagProvider;
import net.minecraft.data.tag.vanilla.VanillaBlockTagProvider;
import net.minecraft.data.tag.vanilla.VanillaItemTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Util;
import org.jetbrains.annotations.Nullable;
import zbd.firstfabricmod.datagen.*;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

public class FirstFabricModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		FabricTagProvider.BlockTagProvider blockTagsProvider = pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider((output, completableFuture) -> new ModItemTagsProvider(output, completableFuture, blockTagsProvider));
		pack.addProvider(ModENUSLanProvider::new);
		pack.addProvider(ModModelsProvider::new);
		pack.addProvider(ModRecipesProvider::new);
		pack.addProvider(ModLootTableProvider::new);
	}
}
