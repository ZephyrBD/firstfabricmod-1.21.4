package zbd.firstfabricmod.item;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;
import zbd.firstfabricmod.tags.ModItemTags;
import java.util.EnumMap;

public interface ModArmorMaterials {
    ArmorMaterial GALLIUM = new ArmorMaterial(20, Util.make(new EnumMap(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 3);
        map.put(EquipmentType.LEGGINGS, 6);
        map.put(EquipmentType.CHESTPLATE, 8);
        map.put(EquipmentType.HELMET, 3);
        map.put(EquipmentType.BODY, 11);
    }), 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F, 0.0F, ModItemTags.GALLIUM_TAG, ModEquipmentAssetKeys.GALLIUM);
}
