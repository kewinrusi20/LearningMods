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
    RegistryKey<ItemGroup> registration;


    public ItemGroupTab(String id, String groupName) {
        this.registration = registerItemGroupTab(id, groupName);
    }



    public RegistryKey<ItemGroup> registerItemGroupTab(String id, String groupName) {
        RegistryKey<ItemGroup> registration = RegistryKey.of(
                Registries.ITEM_GROUP.getKey(),
                Identifier.of(
                        HeavenOnHigh.MOD_ID,
                        id
                )
        );

        ItemGroup settings = FabricItemGroup
                .builder()
                .displayName(Text.translatable(groupName))
                .build();

        Registry.register(Registries.ITEM_GROUP, registration, settings);

        return registration;
    }



    public RegistryKey<ItemGroup> getRegistration() {
        return this.registration;
    }
}