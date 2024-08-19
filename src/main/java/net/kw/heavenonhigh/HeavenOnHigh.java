package net.kw.heavenonhigh;

import net.fabricmc.api.ModInitializer;
import net.kw.heavenonhigh.block.OreBlock;
import net.kw.heavenonhigh.item.Ore;
import net.kw.heavenonhigh.itemGroupTab.ItemGroupTab;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.sound.BlockSoundGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class HeavenOnHigh implements ModInitializer {
    public static final String MOD_ID = "heavenonhigh";
	//public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public List<Ore> ores = new ArrayList<>();
	public List<OreBlock> oreBlocks = new ArrayList<>();

	public void onInitialize() {
		Ore pinkGarnet = new Ore(
				"pink_garnet",
				new Item(new Item.Settings()),
				ItemGroups.INGREDIENTS);

		Ore rawPinkGarnet = new Ore(
				"raw_pink_garnet",
				new Item(new Item.Settings()),
				ItemGroups.INGREDIENTS);


		Block block1Settings = new Block(AbstractBlock.Settings
				.create()
				.strength(4f)
				.requiresTool()
				.sounds(BlockSoundGroup.AMETHYST_BLOCK));
		OreBlock pinkGarnetBlock = new OreBlock(
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
		OreBlock rawPinkGarnetBlock = new OreBlock(
				"raw_pink_garnet_block",
				block2Settings,
				new BlockItem(block2Settings, new Item.Settings()),
				ItemGroups.BUILDING_BLOCKS
		);


		ores.add(pinkGarnet);
		ores.add(rawPinkGarnet);

		oreBlocks.add(pinkGarnetBlock);
		oreBlocks.add(rawPinkGarnetBlock);


		new ItemGroupTab<>(ores, "itemgroup.heavenonhigh.pink_garnet_items_group");
		new ItemGroupTab<>(oreBlocks, "itemgroup.heavenonhigh.pink_garnet_blocks_group");
	}
}