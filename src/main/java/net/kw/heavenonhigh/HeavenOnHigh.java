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

	// Create a custom group tab
	String group1ID = "pink_garnet_items_group";
	String group1Name = "itemgroup.heavenonhigh.pink_garnet_items_group";
	RegistryKey<ItemGroup> group1Key;

	// Create a custom block
	String block1ID = "pink_garnet_block";
	Block block1Settings = new Block(AbstractBlock.Settings
			.create()
			.strength(4f)
			.requiresTool()
			.sounds(BlockSoundGroup.AMETHYST_BLOCK));
	List<RegistryKey<ItemGroup>> blockGroups = new ArrayList<>(){{
		add(group1Key);
		add(ItemGroups.INGREDIENTS);
		add(ItemGroups.BUILDING_BLOCKS);
	}};



//	String block2ID = "raw_pink_garnet_block";
//	Block block2Settings = new Block(AbstractBlock.Settings
//				.create()
//				.strength(4f)
//				.requiresTool()
//				.sounds(BlockSoundGroup.AMETHYST_BLOCK));


	public void onInitialize() {
		// set Group
		group1Key = setGroup(this.group1ID, this.group1Name);


		// Set Item
		setBlock(this.block1ID , this.block1Settings, this.blockGroups);


//		this.pinkGarnet = new Ore(
//				"pink_garnet",
//				new Item(new Item.Settings()),
//				itemGroups);
//
//		Ore rawPinkGarnet = new Ore(
//				"raw_pink_garnet",
//				new Item(new Item.Settings()),
//				itemGroups);
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


	public RegistryKey<ItemGroup> setGroup(String groupID, String groupName) {
		ItemGroupTab group = new ItemGroupTab(groupID , groupName);
		return group.getRegistration(); // get group key
	}



	public void setBlock(String itemName, Block blockSettings, List<RegistryKey<ItemGroup>> blockGroups) {
		OreBlock pinkGarnetBlock = new OreBlock(
				"pink_garnet_block",
				blockSettings,
				new BlockItem(blockSettings, new Item.Settings())
		);


//		List<RegistryKey<ItemGroup>> blockGroups = new ArrayList<>();
//		blockGroups.add(group1Key);
//		blockGroups.add(ItemGroups.INGREDIENTS);
//		blockGroups.add(ItemGroups.BUILDING_BLOCKS);


		Block pinkGarnetBlock_registration = pinkGarnetBlock.getRegistration();
		pinkGarnetBlock.initialize(pinkGarnetBlock_registration, blockGroups);
	}
}