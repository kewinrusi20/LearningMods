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
    // Item 1
    public static String pinkGarnet_id = "pink_garnet";
    public static Item PINK_GARNET = registerItem(
            pinkGarnet_id,
            new Item(new Item.Settings())
    );

    // Item 2
    public static String rawPinkGarnet_id = "raw_pink_garnet";
    public static Item RAW_PINK_GARNET = registerItem(
            rawPinkGarnet_id,
            new Item(new Item.Settings())
    );

    // Item 3
    //public static final Item HEALING_ITEM = new HealingItem(new Item.Settings().maxCount(1));
    public static Item HEALING_ITEM = registerItem(
            "healing_item",
            new HealingItem(new Item.Settings()
                    .maxCount(1))
    );

    // Item 4
    public static String pinkGarnetNugget_id = "pink_garnet_nugget";
    public static Item PING_GARNET_NUGGET = registerItem(
            pinkGarnetNugget_id,
            new Item(new Item.Settings())
    );

    public static void mainModItems() {
        // Item 1
		List<RegistryKey<ItemGroup>> pinkGarnet_groupTab = new ArrayList<>();
        pinkGarnet_groupTab.add(ItemGroups.INGREDIENTS);
        pinkGarnet_groupTab.add(ModItemGroups.CUSTOM_ITEM_GROUP_1);
        registerToGroup(PINK_GARNET, pinkGarnet_groupTab);


        // Item 2
        List<RegistryKey<ItemGroup>> rawPinkGarnet_groupTab = new ArrayList<>();
		rawPinkGarnet_groupTab.add(ItemGroups.INGREDIENTS);
        rawPinkGarnet_groupTab.add(ModItemGroups.CUSTOM_ITEM_GROUP_1);
        registerToGroup(RAW_PINK_GARNET, rawPinkGarnet_groupTab);


        // Item 3
        List<RegistryKey<ItemGroup>> healingItem_groupTab = new ArrayList<>();
        healingItem_groupTab.add(ItemGroups.INGREDIENTS);
        healingItem_groupTab.add(ModItemGroups.CUSTOM_ITEM_GROUP_1);
        registerToGroup(HEALING_ITEM, healingItem_groupTab);

        // Item 4
        List<RegistryKey<ItemGroup>> pinkGarnetNugget_groupTab = new ArrayList<>();
        pinkGarnetNugget_groupTab.add(ItemGroups.INGREDIENTS);
        pinkGarnetNugget_groupTab.add(ModItemGroups.CUSTOM_ITEM_GROUP_1);
        registerToGroup(PING_GARNET_NUGGET, pinkGarnetNugget_groupTab);

    }



    public static Item registerItem(String id, Item item) {
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
