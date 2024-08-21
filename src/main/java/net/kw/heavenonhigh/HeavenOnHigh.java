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
import java.util.Arrays;
import java.util.List;


public class HeavenOnHigh implements ModInitializer {
    public static final String MOD_ID = "heavenonhigh";
	//public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	public void onInitialize() {
		// set Group -------------------------------------------
		String group1ID = "pink_garnet_items_group";
		String group1Name = "itemgroup.heavenonhigh.pink_garnet_items_group";
		RegistryKey<ItemGroup> group1Key;
		group1Key = setGroup(group1ID, group1Name);



		// Set Item 1 -------------------------------------------
		String item1ID = "pink_garnet";
		List<RegistryKey<ItemGroup>> item1Groups = new ArrayList<>();
		item1Groups.add(group1Key);
		item1Groups.add(ItemGroups.INGREDIENTS);
		registerItems(item1ID, item1Groups);



		// Set Item 2 -------------------------------------------
		// Create ID for the Item
		String item2ID = "raw_pink_garnet";
		List<RegistryKey<ItemGroup>> item2Groups = new ArrayList<>();
		item2Groups.add(group1Key);
		item2Groups.add(ItemGroups.INGREDIENTS);
		registerItems(item2ID, item2Groups);



		// Set Item 3 -------------------------------------------
		// Create ID for the Block
		String block3ID = "pink_garnet_block";
		// Design the Properties of the Block
		Block block3Settings = new Block(AbstractBlock.Settings
				.create()
				.strength(4f)
				.requiresTool()
				.sounds(BlockSoundGroup.AMETHYST_BLOCK));
		// Set Item Group Tab for the Item
		List<RegistryKey<ItemGroup>> block3Groups = new ArrayList<>();
		block3Groups.add(group1Key);
		block3Groups.add(ItemGroups.BUILDING_BLOCKS);
		registerBlock(block3ID , block3Settings, block3Groups);



		// Set Item 4 -------------------------------------------
		// Create ID for the Block
		String block4ID = "raw_pink_garnet_block";
		// Design the Properties of the Block
		Block block4Settings = new Block(AbstractBlock.Settings
				.create()
				.strength(4f)
				.requiresTool()
				.sounds(BlockSoundGroup.AMETHYST_BLOCK));
		// Set Item Group Tab for the Item
		List<RegistryKey<ItemGroup>> block4Groups = new ArrayList<>();
		block4Groups.add(group1Key);
		block4Groups.add(ItemGroups.BUILDING_BLOCKS);
		registerBlock(block4ID , block4Settings, block4Groups);
	}



	public RegistryKey<ItemGroup> setGroup(String groupID, String groupName) {
		ItemGroupTab group = new ItemGroupTab(groupID , groupName);
		return group.getRegistration(); // get group key
	}



	public void registerItems(String id, List<RegistryKey<ItemGroup>> groups) {
		Ore pinkGarnetBlock = new Ore(
				id,
				new Item(new Item.Settings()),
				groups
		);

		Item pinkGarnetBlock_registration = pinkGarnetBlock.getRegistration();
		pinkGarnetBlock.initialize(pinkGarnetBlock_registration, groups);
	}



	public void registerBlock(String id, Block blockSettings, List<RegistryKey<ItemGroup>> groups) {
		OreBlock pinkGarnetBlock = new OreBlock(
				id,
				blockSettings,
				new BlockItem(blockSettings, new Item.Settings()),
				groups
		);

		Block pinkGarnetBlock_registration = pinkGarnetBlock.getRegistration();
		pinkGarnetBlock.initialize(pinkGarnetBlock_registration, groups);
	}
}