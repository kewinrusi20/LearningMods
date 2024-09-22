package net.kw.heavenonhigh.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kw.heavenonhigh.HeavenOnHigh;
import net.kw.heavenonhigh.itemGroup.ModItemGroups;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModBlock {
    // Block 1
    public static final Block PINK_GARNEET_BLOCK = initializeBlock(
            "pink_garnet_block",
            new Block(AbstractBlock.Settings
                    .create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK))
    );
    public static final Item PINK_GARNEET_BLOCK_ITEM = initializeBlockItem(
           "pink_garnet_block",
           new BlockItem(PINK_GARNEET_BLOCK, new Item.Settings())
    );


    // Block 2
    public static Block RAW_PINK_GARNEET_BLOCK;
    public static Item RAW_PINK_GARNEET_BLOCK_ITEM;



    public static void mainModBlocks() {
        // Block 1

        List<RegistryKey<ItemGroup>> pinkGarnetBlock_groupTab = new ArrayList<>();
        pinkGarnetBlock_groupTab.add(ItemGroups.BUILDING_BLOCKS);
        pinkGarnetBlock_groupTab.add(ModItemGroups.CUSTOM_ITEM_GROUP_1);
        registerToGroup(PINK_GARNEET_BLOCK, pinkGarnetBlock_groupTab);

        // Block 2
        RAW_PINK_GARNEET_BLOCK = initializeBlock(
                "raw_pink_garnet_block",
                new Block(AbstractBlock.Settings
                        .create()
                        .strength(4f)
                        .requiresTool()
                        .sounds(BlockSoundGroup.AMETHYST_BLOCK))
        );
        RAW_PINK_GARNEET_BLOCK_ITEM = initializeBlockItem(
                "raw_pink_garnet_block",
                new BlockItem(RAW_PINK_GARNEET_BLOCK, new Item.Settings())
        );
        List<RegistryKey<ItemGroup>> rawPinkGarnetBlock_groupTab = new ArrayList<>();
        rawPinkGarnetBlock_groupTab.add(ItemGroups.BUILDING_BLOCKS);
        rawPinkGarnetBlock_groupTab.add(ModItemGroups.CUSTOM_ITEM_GROUP_1);
        registerToGroup(RAW_PINK_GARNEET_BLOCK, rawPinkGarnetBlock_groupTab);
    }



    public static Block initializeBlock(String id, Block block) {
        Identifier idConverted = Identifier.of(HeavenOnHigh.MOD_ID, id);
        Block initialization = Registry.register(Registries.BLOCK, idConverted, block);

        return initialization;
    }

    public static Item initializeBlockItem(String id, BlockItem blockItem) {
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
