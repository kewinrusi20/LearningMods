package net.kw.heavenonhigh.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.kw.heavenonhigh.HeavenOnHigh;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.List;

public class Ore {
    public final Item registration;

    public Ore(String id, Item settings, List<RegistryKey<ItemGroup>> groups) {
        this.registration = registerItem(id, settings);
        registry(this.registration);
        initialize(this.registration, groups);
    }


    public Item registerItem(String id, Item settings) {
        Identifier idConverted = Identifier.of(HeavenOnHigh.MOD_ID, id);
        Item registration = Registry.register(Registries.ITEM, idConverted, settings);

        return registration;
    }


    public void registry(Item settings) {
        FuelRegistry.INSTANCE.add(settings, 30 * 20);
        CompostingChanceRegistry.INSTANCE.add(settings, 0.3f);
    }


    public void initialize(Item registration, List<RegistryKey<ItemGroup>> groups) {
        // Add Item to a Section

        for (RegistryKey<ItemGroup> group : groups) {
            ItemGroupEvents
                    .modifyEntriesEvent(group)
                    .register((entries) -> entries.add(registration));
        }
    }



}