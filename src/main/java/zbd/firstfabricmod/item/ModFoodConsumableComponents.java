package zbd.firstfabricmod.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import java.util.List;

import static net.minecraft.component.type.ConsumableComponents.food;

public class ModFoodConsumableComponents {
    public static final ConsumableComponent INTESTINES = food().consumeEffect(new ApplyEffectsConsumeEffect(List.of(
                        new StatusEffectInstance(StatusEffects.HUNGER, 300, 2),
                        new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0))))
                .build();
    public static final ConsumableComponent COOKED_NINE_TURN_INTESTINES = food().consumeEffect(new ApplyEffectsConsumeEffect(List.of(
            new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1),
                        new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0),
                        new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 2400, 0))))
            .build();
}
