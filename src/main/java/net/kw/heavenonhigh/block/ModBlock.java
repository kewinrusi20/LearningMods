package net.kw.heavenonhigh.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kw.heavenonhigh.HeavenOnHigh;
import net.kw.heavenonhigh.itemGroup.ModItemGroups;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.ArrayList;
import java.util.List;

public class ModBlock {
    // Block 1
    static String pinkGarnetBlockID = "pink_garnet_block";
    public static Block PINK_GARNEET_BLOCK;
    public static Item PINK_GARNEET_BLOCK_ITEM;

    // Block 2
    static String rawPinkGarnetBlockID = "raw_pink_garnet_block";
    public static Block RAW_PINK_GARNEET_BLOCK;
    public static Item RAW_PINK_GARNEET_BLOCK_ITEM;

    // Block 3
    static String pinkGarnetOreID = "pink_garnet_ore";
    public static Block PINK_GARNET_ORE;
    public static Item PINK_GARNET_ORE_ITEM;

    // Block 4
    static String pinkGarnetDeepslateOreID = "pink_garnet_deepslate_ore";
    public static Block PINK_GARNET_DEEPSLATE_ORE;
    public static Item PINK_GARNET_DEEPSLATE_ORE_ITEM;


    public static void mainModBlocks() {
        // -----------------------------------------------------------------
        // Block 1
        PINK_GARNEET_BLOCK = registerBlock(
                pinkGarnetBlockID,
                new Block(AbstractBlock.Settings
                        .create()
                        .strength(4f)
                        .requiresTool()
                        .sounds(BlockSoundGroup.AMETHYST_BLOCK))
        );

        PINK_GARNEET_BLOCK_ITEM = registerBlockItem(
                pinkGarnetBlockID,
                new BlockItem(PINK_GARNEET_BLOCK, new Item.Settings())
        );

        List<RegistryKey<ItemGroup>> pinkGarnetBlock_groupTab = new ArrayList<>();
        pinkGarnetBlock_groupTab.add(ItemGroups.BUILDING_BLOCKS);
        pinkGarnetBlock_groupTab.add(ModItemGroups.CUSTOM_ITEM_GROUP_1);
        registerToGroup(PINK_GARNEET_BLOCK, pinkGarnetBlock_groupTab);


        // -----------------------------------------------------------------
        // Block 2
        RAW_PINK_GARNEET_BLOCK = registerBlock(
                rawPinkGarnetBlockID,
                new Block(AbstractBlock.Settings
                        .create()
                        .strength(4f)
                        .requiresTool()
                        .sounds(BlockSoundGroup.AMETHYST_BLOCK))
        );

        RAW_PINK_GARNEET_BLOCK_ITEM = registerBlockItem(
                rawPinkGarnetBlockID,
                new BlockItem(RAW_PINK_GARNEET_BLOCK, new Item.Settings())
        );

        List<RegistryKey<ItemGroup>> rawPinkGarnetBlock_groupTab = new ArrayList<>();
        rawPinkGarnetBlock_groupTab.add(ItemGroups.BUILDING_BLOCKS);
        rawPinkGarnetBlock_groupTab.add(ModItemGroups.CUSTOM_ITEM_GROUP_1);
        registerToGroup(RAW_PINK_GARNEET_BLOCK, rawPinkGarnetBlock_groupTab);


        // -----------------------------------------------------------------
        // Block 3
        PINK_GARNET_ORE = registerBlock(
                pinkGarnetOreID,
                new ExperienceDroppingBlock(
                        UniformIntProvider.create(2, 5),
                        AbstractBlock.Settings
                                .create()
                                .strength(3f)
                                .requiresTool()
                )
        );

        PINK_GARNET_ORE_ITEM = registerBlockItem(
                pinkGarnetOreID,
                new BlockItem(PINK_GARNET_ORE, new Item.Settings())
        );

        List<RegistryKey<ItemGroup>> pinkGarnetOreBlock_groupTab = new ArrayList<>();
        pinkGarnetOreBlock_groupTab.add(ItemGroups.BUILDING_BLOCKS);
        pinkGarnetOreBlock_groupTab.add(ModItemGroups.CUSTOM_ITEM_GROUP_1);
        registerToGroup(PINK_GARNET_ORE, pinkGarnetOreBlock_groupTab);


        // -----------------------------------------------------------------
        // Block 4
        PINK_GARNET_DEEPSLATE_ORE = registerBlock(
                pinkGarnetDeepslateOreID,
                new ExperienceDroppingBlock(
                        UniformIntProvider.create(2, 5),
                        AbstractBlock.Settings
                                .create()
                                .strength(3f)
                                .requiresTool()
                                .sounds(BlockSoundGroup.DEEPSLATE)
                )
        );

        PINK_GARNET_DEEPSLATE_ORE_ITEM = registerBlockItem(
                pinkGarnetDeepslateOreID,
                new BlockItem(PINK_GARNET_DEEPSLATE_ORE, new Item.Settings())
        );

        List<RegistryKey<ItemGroup>> pinkGarnetDeepslateOreBlock_groupTab = new ArrayList<>();
        pinkGarnetDeepslateOreBlock_groupTab.add(ItemGroups.BUILDING_BLOCKS);
        pinkGarnetDeepslateOreBlock_groupTab.add(ModItemGroups.CUSTOM_ITEM_GROUP_1);
        registerToGroup(PINK_GARNET_DEEPSLATE_ORE, pinkGarnetDeepslateOreBlock_groupTab);
    }



    public static Block registerBlock(String id, Block block) {
        Identifier idConverted = Identifier.of(HeavenOnHigh.MOD_ID, id);
        Block initialization = Registry.register(Registries.BLOCK, idConverted, block);

        return initialization;
    }

    public static Item registerBlockItem(String id, BlockItem blockItem) {
        Identifier idConverted = Identifier.of(HeavenOnHigh.MOD_ID, id);
        Item initialization = Registry.register(Registries.ITEM, idConverted, blockItem);

        return initialization;
    }


    public static void registerToGroup(Block registration, List<RegistryKey<ItemGroup>> groups) {
        // Add Item inside a group tab
        for (RegistryKey<ItemGroup> group : groups) {
            ItemGroupEvents
                    .modifyEntriesEvent(group)
                    .register((entries) -> entries.add(registration));
        }
    }
}
