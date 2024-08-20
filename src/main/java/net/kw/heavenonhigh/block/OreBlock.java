package net.kw.heavenonhigh.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kw.heavenonhigh.HeavenOnHigh;
import net.kw.heavenonhigh.ModItem;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class OreBlock implements ModItem {
    public final Block registration;

    public OreBlock(String id, Block blockSettings, BlockItem blockItemSettings, RegistryKey<ItemGroup> itemGroupTab) {
        this.registration = registerBlock(id, blockSettings);
        Item itemRegistered = registerBlockItem(id, blockItemSettings);

        initialize(registration, itemGroupTab);

    }


    public Block registerBlock(String id, Block settings) {
        Identifier idConverted = Identifier.of(HeavenOnHigh.MOD_ID, id);
        Block registration = Registry.register(Registries.BLOCK, idConverted, settings);

        return registration;
    }


    public Item registerBlockItem(String id, BlockItem blockItemSettings) {
        Identifier idConverted = Identifier.of(HeavenOnHigh.MOD_ID, id);
        Item blockItemRegistered = Registry.register(Registries.ITEM, idConverted, blockItemSettings);

        return blockItemRegistered;
    }


    public void initialize(Block registration, RegistryKey<ItemGroup> itemGroupTab) {
        ItemGroupEvents.
                modifyEntriesEvent(itemGroupTab)
                .register(entries -> entries.add(registration));
    }

    @Override
    public ItemStack getItemStack() {
        return new ItemStack(this.registration);
    }
}