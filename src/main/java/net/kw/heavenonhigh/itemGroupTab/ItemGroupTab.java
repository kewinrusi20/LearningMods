package net.kw.heavenonhigh.itemGroupTab;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kw.heavenonhigh.HeavenOnHigh;
import net.kw.heavenonhigh.ModItem;
import net.kw.heavenonhigh.item.Ore;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ItemGroupTab<T extends ModItem> {
    ItemGroup itemGroupTab;

    public ItemGroupTab(List<T> items, String groupName) {
        this.itemGroupTab = Registry.register(
                Registries.ITEM_GROUP,
                Identifier.of(HeavenOnHigh.MOD_ID, "pink_garnet_items_group"),
                FabricItemGroup
                        .builder()
                        .icon(() -> items.get(0).getItemStack())
                        .displayName(Text.translatable(groupName))
                        .entries(((displayContext, entries) -> {
                            for (T item : items) {
                                entries.add(item.getItemStack());
                            }
                        }))
                        .build()
        );
    }

    public void addElements() {




    }
}