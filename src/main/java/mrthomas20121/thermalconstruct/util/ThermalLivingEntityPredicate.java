package mrthomas20121.thermalconstruct.util;

import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraftforge.common.Tags;
import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;

public interface ThermalLivingEntityPredicate {

    // around 8 is when deepslate start to spawn
    LivingEntityPredicate HAS_POTION_EFFECT = LivingEntityPredicate.simple(entity -> !entity.getActiveEffects().isEmpty());

    // check if the entity is in the end
    LivingEntityPredicate IS_IN_END = LivingEntityPredicate.simple(entity -> entity.level().dimensionTypeId().equals(BuiltinDimensionTypes.END));

    // check if entity is in the nether
    LivingEntityPredicate IS_IN_NETHER = LivingEntityPredicate.simple(entity -> entity.level().dimensionTypeId().equals(BuiltinDimensionTypes.NETHER));
}
