package zbd.firstfabricmod;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zbd.firstfabricmod.blocks.ModBlocks;
import zbd.firstfabricmod.item.ModItemGroups;
import zbd.firstfabricmod.item.ModItems;
import zbd.firstfabricmod.tags.ModBlockTags;
import zbd.firstfabricmod.tags.ModItemTags;

public class FirstFabricMod implements ModInitializer {
	public static final String MOD_ID = "firstfabricmod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItems.initialize();
		ModItemGroups.initialize();
		ModBlocks.initialize();
		ModBlockTags.init();
		ModItemTags.init();
		LOGGER.info("First Fabric Mod has been initialized. By:ZephyrBD");
	}

}