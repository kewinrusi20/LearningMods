package net.kw.heavenonhigh.itemGroup;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kw.heavenonhigh.HeavenOnHigh;
import net.kw.heavenonhigh.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public final static RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_1 = initializeGroupTab(
            "pink_garnet_items_group", 
            "itemgroup.heavenonhigh.pink_garnet_items_group",
            ModItems.PINK_GARNET
    );

    public final static RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_2 = initializeGroupTab(
            "spells_group",
            "itemgroup.heavenonhigh.spells_group",
            ModItems.HEALING_ITEM
    );


    public static RegistryKey<ItemGroup> initializeGroupTab(String id, String groupName, Item icon) {
        Identifier idConverted = Identifier.of(HeavenOnHigh.MOD_ID, id);
        RegistryKey<ItemGroup> itemGroupKey = RegistryKey.of(Registries.ITEM_GROUP.getKey(), idConverted);

        ItemGroup settings = FabricItemGroup
                .builder()
                .icon(() -> new ItemStack(icon))
                .displayName(Text.translatable(groupName))
                .build();

        Registry.register(Registries.ITEM_GROUP, itemGroupKey, settings);

        return itemGroupKey;
    }

}
