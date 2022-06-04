package net.fabricmc.ctf;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.HoneyBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookedTropicalFishMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Cooked Tropical Fish");

	public static final Item COOKED_TROPICAL_FISH = new Item(
			new FabricItemSettings().group(ItemGroup.FOOD).food(
					new FoodComponent.Builder().hunger(5).saturationModifier(0.6F).build()));

	public static final Item ROASTED_SWEET_BERRIES = new Item(
			new FabricItemSettings().group(ItemGroup.FOOD).food(
					new FoodComponent.Builder().hunger(3).saturationModifier(0.4F).build()));

	public static final Item SWEET_BERRY_JAM = new DrinkItem(
			new FabricItemSettings().group(ItemGroup.FOOD).recipeRemainder(Items.GLASS_BOTTLE).food(
					new FoodComponent.Builder().hunger(3).saturationModifier(1F).build()).maxCount(16));

	public static final Item TOAST = new Item(
			new FabricItemSettings().group(ItemGroup.FOOD).food(
					new FoodComponent.Builder().hunger(5).saturationModifier(0.6F).build()));

	public static final Item HALF_SWEET_BERRY_TOAST = new Item(
			new FabricItemSettings().group(ItemGroup.FOOD).food(
					new FoodComponent.Builder().snack().hunger(6).saturationModifier(1.4F).build()).maxCount(1));

	public static final Item SWEET_BERRY_TOAST = new ToastItem(
			new FabricItemSettings().group(ItemGroup.FOOD).food(
					new FoodComponent.Builder().snack().hunger(6).saturationModifier(1.4F).build()).maxCount(1),
			HALF_SWEET_BERRY_TOAST);

	public static final Item ROASTED_GLOW_BERRIES = new Item(
			new FabricItemSettings().group(ItemGroup.FOOD).food(
					new FoodComponent.Builder().hunger(3).saturationModifier(0.4F).build()));

	public static final Item GLOW_BERRY_JAM = new DrinkItem(
			new FabricItemSettings().group(ItemGroup.FOOD).recipeRemainder(Items.GLASS_BOTTLE).food(
					new FoodComponent.Builder().hunger(3).saturationModifier(1F).build()).maxCount(16));

	public static final Item HALF_GLOW_BERRY_TOAST = new Item(
			new FabricItemSettings().group(ItemGroup.FOOD).food(
					new FoodComponent.Builder().snack().hunger(6).saturationModifier(1.4F).build()).maxCount(1));

	public static final Item GLOW_BERRY_TOAST = new ToastItem(
			new FabricItemSettings().group(ItemGroup.FOOD).food(
					new FoodComponent.Builder().snack().hunger(6).saturationModifier(1.4F).build()).maxCount(1),
			HALF_GLOW_BERRY_TOAST);

	public static final Item APPLE_SAUCE = new DrinkItem(
			new FabricItemSettings().group(ItemGroup.FOOD).food(
					new FoodComponent.Builder().hunger(3).saturationModifier(1F).build()).maxCount(16));

	public static final Item BAKED_APPLE = new Item(
			new FabricItemSettings().group(ItemGroup.FOOD).food(
					new FoodComponent.Builder().hunger(5).saturationModifier(0.6F).build()));
	public static final Item APPLE_PIE = new Item(
			new FabricItemSettings().group(ItemGroup.FOOD).food(
					new FoodComponent.Builder().hunger(8).saturationModifier(0.6F).build()));

	public static final Block GLOW_BERRY_BLOCK = new JamBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT, MapColor.ORANGE).velocityMultiplier(0.4f)
					.jumpVelocityMultiplier(0.5f).nonOpaque().sounds(BlockSoundGroup.HONEY).luminance(state -> 15));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Warning!!!! Warning!!!! Cum Mode Initialized!!!!!!!!");
		Registry.register(Registry.ITEM, new Identifier("ctf", "cooked_tropical_fish"), COOKED_TROPICAL_FISH);

		Registry.register(Registry.ITEM, new Identifier("ctf", "roasted_sweet_berries"), ROASTED_SWEET_BERRIES);
		Registry.register(Registry.ITEM, new Identifier("ctf", "sweet_berry_jam"), SWEET_BERRY_JAM);
		Registry.register(Registry.ITEM, new Identifier("ctf", "toast"), TOAST);
		Registry.register(Registry.ITEM, new Identifier("ctf", "sweet_berry_toast"), SWEET_BERRY_TOAST);
		Registry.register(Registry.ITEM, new Identifier("ctf", "half_sweet_berry_toast"), HALF_SWEET_BERRY_TOAST);

		Registry.register(Registry.ITEM, new Identifier("ctf", "roasted_glow_berries"), ROASTED_GLOW_BERRIES);
		Registry.register(Registry.ITEM, new Identifier("ctf", "glow_berry_jam"), GLOW_BERRY_JAM);
		Registry.register(Registry.ITEM, new Identifier("ctf", "glow_berry_toast"), GLOW_BERRY_TOAST);
		Registry.register(Registry.ITEM, new Identifier("ctf", "half_glow_berry_toast"), HALF_GLOW_BERRY_TOAST);

		Registry.register(Registry.ITEM, new Identifier("ctf", "baked_apple"), BAKED_APPLE);
		Registry.register(Registry.ITEM, new Identifier("ctf", "apple_sauce"), APPLE_SAUCE);
		Registry.register(Registry.ITEM, new Identifier("ctf", "apple_pie"), APPLE_PIE);

		Registry.register(Registry.BLOCK, new Identifier("ctf", "glow_berry_block"), GLOW_BERRY_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("ctf", "glow_berry_block"), new BlockItem(GLOW_BERRY_BLOCK, new FabricItemSettings().group(ItemGroup.REDSTONE)));
		BlockRenderLayerMap.INSTANCE.putBlock(GLOW_BERRY_BLOCK, RenderLayer.getTranslucent());
	}
}
