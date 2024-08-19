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
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;

import java.util.ArrayList;
import java.util.List;


public class HeavenOnHigh implements ModInitializer {
    public static final String MOD_ID = "heavenonhigh";
	//public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



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


		List<ItemStack> li = new ArrayList<>();
		li.add(new ItemStack(pinkGarnet.registration));
		li.add(new ItemStack(rawPinkGarnet.registration));
		li.add(new ItemStack(pinkGarnetBlock.registration));
		li.add(new ItemStack(rawPinkGarnetBlock.registration));

		ItemGroupTab group1 = new ItemGroupTab(li, "itemgroup.heavenonhigh.pink_garnet_items_group", "0");
		ItemGroupTab group2 = new ItemGroupTab(li, "itemgroup.heavenonhigh.pink_garnet_blocks_group", "2");
	}
}