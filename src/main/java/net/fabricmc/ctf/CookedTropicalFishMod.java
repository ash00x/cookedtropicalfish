package net.fabricmc.ctf;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookedTropicalFishMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	public static final Item COOKED_TROPICAL_FISH = new Item(
		new FabricItemSettings().group(ItemGroup.FOOD).food(
			new FoodComponent.Builder().hunger(5).saturationModifier(0.6F).build()
			)
		);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Nice cock.");
		Registry.register(Registry.ITEM, new Identifier("ctf", "cooked_tropical_fish"), COOKED_TROPICAL_FISH);
	}
}
