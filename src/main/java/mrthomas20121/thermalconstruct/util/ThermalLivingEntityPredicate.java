package mrthomas20121.thermalconstruct.util;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;

public interface ThermalLivingEntityPredicate {

    // around 8 is when deepslate start to spawn
    LivingEntityPredicate HAS_POTION_EFFECT = LivingEntityPredicate.simple(entity -> !entity.getActiveEffects().isEmpty());

    // check if the entity is in the end
    LivingEntityPredicate IS_IN_END = LivingEntityPredicate.simple(entity -> entity.level().dimensionTypeId().equals(BuiltinDimensionTypes.END));

    // check if entity is in the nether
    LivingEntityPredicate IS_IN_NETHER = LivingEntityPredicate.simple(entity -> entity.level().dimensionTypeId().equals(BuiltinDimensionTypes.NETHER));

    LivingEntityPredicate IS_WARDEN = LivingEntityPredicate.simple(entity -> entity.getType().equals(EntityType.WARDEN));
}
