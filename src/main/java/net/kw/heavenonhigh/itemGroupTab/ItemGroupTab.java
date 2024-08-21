package net.kw.heavenonhigh.itemGroupTab;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kw.heavenonhigh.HeavenOnHigh;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ItemGroupTab {
//    public ItemGroupTab(List<ItemStack> items, String id, String groupName, int iconPosition) {
//        registerItemGroupTab(items, id, groupName, iconPosition);
//    }

    public RegistryKey<ItemGroup> itemGroup1_key;

    public ItemGroupTab(String id, String groupName) {
        registerItemGroupTab(id, groupName);
    }



//    public void registerItemGroupTab(List<ItemStack> items, String id, String groupName, int iconPosition) {
//        ItemGroup itemGroup1 = Registry.register(
//                Registries.ITEM_GROUP,
//                Identifier.of(HeavenOnHigh.MOD_ID, id),
//                FabricItemGroup
//                        .builder()
//                        .icon(() -> items.get(iconPosition))
//                        .entries(((displayContext, entries) -> {
//                            for (ItemStack item : items) {
//                                entries.add(item);
//                            }
//                        }))
//                        .displayName(Text.translatable(groupName))
//                        .build()
//        );
//    }



    public void registerItemGroupTab(String id, String groupName) {
        itemGroup1_key = RegistryKey.of(
                Registries.ITEM_GROUP.getKey(),
                Identifier.of(
                        HeavenOnHigh.MOD_ID,
                        id
                )
        );


        ItemGroup itemGroup1 = FabricItemGroup
                .builder()
                .displayName(Text.translatable(groupName))
                .build();


        Registry.register(Registries.ITEM_GROUP, itemGroup1_key, itemGroup1);
    }
}