package zbd.firstfabricmod.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent INTESTINES = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3F).alwaysEdible().build();
    public static final FoodComponent NINE_TURN_INTESTINES = new FoodComponent.Builder().nutrition(4).saturationModifier(0.6F).alwaysEdible().build();
    public static final FoodComponent COOKED_NINE_TURN_INTESTINES = new FoodComponent.Builder().nutrition(8).saturationModifier(1.2F).alwaysEdible().build();
    public static final FoodComponent STRAWBERRY = new FoodComponent.Builder().nutrition(4).saturationModifier(0.6F).build();
}
