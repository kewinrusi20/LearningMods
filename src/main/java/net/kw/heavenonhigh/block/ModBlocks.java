package net.kw.heavenonhigh.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kw.heavenonhigh.HeavenOnHigh;
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


public class ModBlocks {
//    public ModBlocks() {
//        String id = "pink_garnet_block";
//        Block blockSettings = new Block(AbstractBlock.Settings
//                .create()
//                .strength(4f)
//                .requiresTool()
//                .sounds(BlockSoundGroup.AMETHYST_BLOCK));
//        BlockItem blockItemSettings = new BlockItem(blockSettings, new Item.Settings());
//
//        Block blockRegistered = registerBlock(id, blockSettings);
//        Item itemRegistered = registerItem(id, blockItemSettings);
//
//        initialize(blockRegistered, ItemGroups.BUILDING_BLOCKS);
//    }

    public ModBlocks(String id, Block blockSettings, BlockItem blockItemSettings, RegistryKey<ItemGroup> groupTab) {
        Block blockRegistered = registerBlock(id, blockSettings);
        Item itemRegistered = registerItem(id, blockItemSettings);

        initialize(blockRegistered, groupTab);

    }


    public Item registerItem(String id, BlockItem blockItemSettings) {
        Identifier idConverted = Identifier.of(HeavenOnHigh.MOD_ID, id);
        Item blockItemRegistered = Registry.register(Registries.ITEM, idConverted, blockItemSettings);

        return blockItemRegistered;
    }


    public Block registerBlock(String id, Block settings) {
        Identifier idConverted = Identifier.of(HeavenOnHigh.MOD_ID, id);
        Block blockRegistered = Registry.register(Registries.BLOCK, idConverted, settings);

        return blockRegistered;
    }


    public void initialize(Block blockRegistered, RegistryKey<ItemGroup> groupTab) {
        ItemGroupEvents.
                modifyEntriesEvent(groupTab)
                .register(entries -> entries.add(blockRegistered));
    }
}