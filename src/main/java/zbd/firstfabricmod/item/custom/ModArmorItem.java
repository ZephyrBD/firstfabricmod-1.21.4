package zbd.firstfabricmod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.world.World;
import zbd.firstfabricmod.item.ModItems;

import java.util.List;

public class ModArmorItem extends ArmorItem {
    public ModArmorItem(ArmorMaterial material, EquipmentType type, Settings settings) {
        super(material, type, settings);
    }

    private static final List<StatusEffectInstance> LIST = List.of(
            new StatusEffectInstance(StatusEffects.SPEED, 1000, 2),
            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 2400, 0));


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient() && entity instanceof PlayerEntity player && hasFullSuitOfArmor(player)) {
            evaluateArmorEffects(player);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        if(hasCorrectArmorSet(player)) {
            for (StatusEffectInstance effectInstance : LIST) {
                addStatusEffectForMaterial(player, effectInstance);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, StatusEffectInstance effect) {
        boolean hasPlayerEffect = player.hasStatusEffect(effect.getEffectType());
        if(!hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(effect));
        }
    }

    private boolean hasCorrectArmorSet(PlayerEntity player) {
        Item helmet = player.getInventory().getArmorStack(3).getItem();
        Item chestplate = player.getInventory().getArmorStack(2).getItem();
        Item legging = player.getInventory().getArmorStack(1).getItem();
        Item boots = player.getInventory().getArmorStack(0).getItem();

        return helmet == ModItems.GALLIUM_HELMET && chestplate == ModItems.GALLIUM_CHESTPLATE &&
                legging == ModItems.GALLIUM_LEGGINGS && boots == ModItems.GALLIUM_BOOTS;
    }


    private boolean hasFullSuitOfArmor(PlayerEntity player) {
        ItemStack helmet = player.getInventory().getArmorStack(3);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack boots = player.getInventory().getArmorStack(0);
        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }
}
