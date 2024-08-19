package net.kw.heavenonhigh;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.kw.heavenonhigh.block.ModBlocks;
import net.kw.heavenonhigh.item.Ore;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.sound.BlockSoundGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeavenOnHigh implements ModInitializer {
    public static final String MOD_ID = "heavenonhigh";
	public static final Logger LOGGER = LoggerFactory.getLogger("heavenonhigh");

	@Override
	public void onInitialize() {
		Ore item1 = new Ore(
				"pink_garnet",
				new Item(new Item.Settings()),
				ItemGroups.INGREDIENTS);

		Ore item2 = new Ore(
				"raw_pink_garnet",
				new Item(new Item.Settings()),
				ItemGroups.INGREDIENTS);

		Block block1Settings = new Block(AbstractBlock.Settings
				.create()
				.strength(4f)
				.requiresTool()
				.sounds(BlockSoundGroup.AMETHYST_BLOCK));
		ModBlocks block1 = new ModBlocks(
				"pink_garnet_block",
				block1Settings,
				new BlockItem(block1Settings, new Item.Settings()),
				ItemGroups.BUILDING_BLOCKS
		);

		Block block2Settings = new Block(AbstractBlock.Settings
				.create()
				.strength(4f)
				.requiresTool()
				.sounds(BlockSoundGroup.AMETHYST_BLOCK));
		ModBlocks block2 = new ModBlocks(
				"raw_pink_garnet_block",
				block2Settings,
				new BlockItem(block2Settings, new Item.Settings()),
				ItemGroups.BUILDING_BLOCKS
		);

	}
}