package net.kw.heavenonhigh.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.kw.heavenonhigh.HeavenOnHigh;
import net.kw.heavenonhigh.ModItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class Ore implements ModItem {
    private final Item itemRegistered;

    public Ore(String id, Item settings, RegistryKey<ItemGroup> itemGroupTab) {
        this.itemRegistered = registerItem(id, settings);
        registry(this.itemRegistered);
        initialize(this.itemRegistered, itemGroupTab);
    }


    public Item registerItem(String id, Item settings) {
        Identifier idConverted = Identifier.of(HeavenOnHigh.MOD_ID, id);
        Item itemRegistered = Registry.register(Registries.ITEM, idConverted, settings);

        return itemRegistered;
    }


    public void registry(Item settings) {
        FuelRegistry.INSTANCE.add(settings, 30 * 20);
        CompostingChanceRegistry.INSTANCE.add(settings, 0.3f);
    }


    public void initialize(Item itemRegistered, RegistryKey<ItemGroup> itemGroupTab) {
        // Add Item to a Section
        ItemGroupEvents
                .modifyEntriesEvent(itemGroupTab)
                .register((entries) -> entries.add(itemRegistered));
    }

    @Override
    public ItemStack getItemStack() {
        return new ItemStack(this.itemRegistered);
    }
}