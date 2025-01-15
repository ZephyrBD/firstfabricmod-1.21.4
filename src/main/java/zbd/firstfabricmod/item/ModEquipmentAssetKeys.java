package zbd.firstfabricmod.item;

import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import zbd.firstfabricmod.FirstFabricMod;
import static net.minecraft.item.equipment.EquipmentAssetKeys.REGISTRY_KEY;

public interface ModEquipmentAssetKeys {
    RegistryKey<EquipmentAsset> GALLIUM = register("gallium");
    static RegistryKey<EquipmentAsset> register(String name) {
        return RegistryKey.of(REGISTRY_KEY, Identifier.of(FirstFabricMod.MOD_ID,name));
    }
}
