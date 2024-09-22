package net.kw.heavenonhigh.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kw.heavenonhigh.HeavenOnHigh;
import net.kw.heavenonhigh.itemGroup.ModItemGroups;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static Item PINK_GARNET;
    public static Item RAW_PINK_GARNET;


    public static void mainModItems() {
        // Item 1
        PINK_GARNET = initializeItem(
                "pink_garnet",
                new Item(new Item.Settings())
        );
		List<RegistryKey<ItemGroup>> pinkGarnet_groupTab = new ArrayList<>();
        pinkGarnet_groupTab.add(ItemGroups.INGREDIENTS);
        pinkGarnet_groupTab.add(ModItemGroups.CUSTOM_ITEM_GROUP_1);
        registerToGroup(PINK_GARNET, pinkGarnet_groupTab);


        // Item 2
        RAW_PINK_GARNET = initializeItem(
                "raw_pink_garnet",
                new Item(new Item.Settings())
        );
		List<RegistryKey<ItemGroup>> rawPinkGarnet_groupTab = new ArrayList<>();
		rawPinkGarnet_groupTab.add(ItemGroups.INGREDIENTS);
        rawPinkGarnet_groupTab.add(ModItemGroups.CUSTOM_ITEM_GROUP_1);
        registerToGroup(RAW_PINK_GARNET, rawPinkGarnet_groupTab);
    }



    public static Item initializeItem(String id, Item item) {
        Identifier idConverted = Identifier.of(HeavenOnHigh.MOD_ID, id);
        Item initializedItem = Registry.register(Registries.ITEM, idConverted, item);

        return initializedItem;
    }

//    public void registry(Item settings) {
//        FuelRegistry.INSTANCE.add(settings, 30 * 20);
//        CompostingChanceRegistry.INSTANCE.add(settings, 0.3f);
//    }

    public static void registerToGroup(Item registration, List<RegistryKey<ItemGroup>> groups) {
        // Add Item to a Section
        for (RegistryKey<ItemGroup> group : groups) {
            ItemGroupEvents
                    .modifyEntriesEvent(group)
                    .register((entries) -> entries.add(registration));
        }
    }

}
