package net.kw.heavenonhigh;

import net.fabricmc.api.ModInitializer;
import net.kw.heavenonhigh.block.OreBlock;
import net.kw.heavenonhigh.item.Ore;
import net.kw.heavenonhigh.itemGroupTab.ItemGroupTab;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;

import java.util.ArrayList;
import java.util.List;


public class HeavenOnHigh implements ModInitializer {
    public static final String MOD_ID = "heavenonhigh";
	//public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);














	public void onInitialize() {
		ItemGroupTab group1 = new ItemGroupTab("pink_garnet_items_group", "itemgroup.heavenonhigh.pink_garnet_items_group");
		RegistryKey<ItemGroup> itemGroup1_key = group1.getRegistration();
		List<RegistryKey<ItemGroup>> itemGroups = new ArrayList<>();
		itemGroups.add(itemGroup1_key);
		itemGroups.add(ItemGroups.INGREDIENTS);


		Ore pinkGarnet = new Ore(
				"pink_garnet",
				new Item(new Item.Settings()),
				itemGroups);

		Ore rawPinkGarnet = new Ore(
				"raw_pink_garnet",
				new Item(new Item.Settings()),
				itemGroups);


//		Block block1Settings = new Block(AbstractBlock.Settings
//				.create()
//				.strength(4f)
//				.requiresTool()
//				.sounds(BlockSoundGroup.AMETHYST_BLOCK));
//		OreBlock pinkGarnetBlock = new OreBlock(
//				"pink_garnet_block",
//				block1Settings,
//				new BlockItem(block1Settings, new Item.Settings()),
//				ItemGroups.BUILDING_BLOCKS
//		);
//
//
//		Block block2Settings = new Block(AbstractBlock.Settings
//				.create()
//				.strength(4f)
//				.requiresTool()
//				.sounds(BlockSoundGroup.AMETHYST_BLOCK));
//		OreBlock rawPinkGarnetBlock = new OreBlock(
//				"raw_pink_garnet_block",
//				block2Settings,
//				new BlockItem(block2Settings, new Item.Settings()),
//				ItemGroups.BUILDING_BLOCKS
//		);
	}
}