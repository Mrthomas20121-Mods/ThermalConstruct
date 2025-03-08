package mrthomas20121.thermalconstruct.util;

import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;

public interface ThermalLivingEntityPredicate {

    LivingEntityPredicate IS_TAIGA = LivingEntityPredicate.simple(entity -> entity.level().getBiome(entity.getOnPos()).is(BiomeTags.IS_TAIGA));
    LivingEntityPredicate IS_BADLANDS = LivingEntityPredicate.simple(entity -> entity.level().getBiome(entity.getOnPos()).is(BiomeTags.IS_BADLANDS));
    LivingEntityPredicate IS_FOREST = LivingEntityPredicate.simple(entity -> entity.level().getBiome(entity.getOnPos()).is(BiomeTags.IS_FOREST));
    LivingEntityPredicate IS_JUNGLE = LivingEntityPredicate.simple(entity -> entity.level().getBiome(entity.getOnPos()).is(BiomeTags.IS_JUNGLE));

    // check if the entity is in the end
    LivingEntityPredicate IS_IN_END = LivingEntityPredicate.simple(entity -> entity.level().dimensionTypeId().equals(BuiltinDimensionTypes.END));

    // check if entity is in the nether
    LivingEntityPredicate IS_IN_NETHER = LivingEntityPredicate.simple(entity -> entity.level().dimensionTypeId().equals(BuiltinDimensionTypes.NETHER));
}
