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
    RegistryKey<ItemGroup> groupKey;


    public ItemGroupTab(String id, String groupName) {
        this.groupKey = registerItemGroupTab(id, groupName);
    }



    public RegistryKey<ItemGroup> registerItemGroupTab(String id, String groupName) {
        Identifier icConverted = Identifier.of(HeavenOnHigh.MOD_ID, id);
        RegistryKey<ItemGroup> groupKey = RegistryKey.of(Registries.ITEM_GROUP.getKey(), icConverted);

        ItemGroup settings = FabricItemGroup
                .builder()
                .displayName(Text.translatable(groupName))
                .build();

        Registry.register(Registries.ITEM_GROUP, groupKey, settings);

        return groupKey;
    }



    public RegistryKey<ItemGroup> getRegistration() {
        return this.groupKey;
    }
}