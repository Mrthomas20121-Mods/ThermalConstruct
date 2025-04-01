package mrthomas20121.thermalconstruct.modifiers;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;

import java.util.List;

public class BlisteringModifier extends Modifier implements ProjectileHitModifierHook {

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this, ModifierHooks.PROJECTILE_HIT);
    }

    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, ModDataNBT persistentData, ModifierEntry modifier, Projectile projectile, EntityHitResult hit, @Nullable LivingEntity attacker, @Nullable LivingEntity target) {
        if (target != null) {
            Level level = target.level();
            if (!level.isClientSide) {
                List<LivingEntity> list = level.getEntitiesOfClass(LivingEntity.class, projectile.getBoundingBox().inflate(4.0D, 2.0D, 4.0D));
                AreaEffectCloud areaeffectcloud = new AreaEffectCloud(level, projectile.getX(), projectile.getY(), projectile.getZ());
                Entity entity = projectile.getOwner();
                if (entity instanceof LivingEntity) {
                    areaeffectcloud.setOwner((LivingEntity) entity);
                }

                areaeffectcloud.setParticle(ParticleTypes.DRAGON_BREATH);
                areaeffectcloud.setRadius(3.0F);
                areaeffectcloud.setDuration(600);
                areaeffectcloud.setRadiusPerTick((7.0F - areaeffectcloud.getRadius()) / (float) areaeffectcloud.getDuration());
                areaeffectcloud.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 1));
                if (!list.isEmpty()) {
                    for (LivingEntity livingentity : list) {
                        double d0 = projectile.distanceToSqr(livingentity);
                        if (d0 < 16.0D) {
                            areaeffectcloud.setPos(livingentity.getX(), livingentity.getY(), livingentity.getZ());
                            break;
                        }
                    }
                }

                level.levelEvent(2006, projectile.blockPosition(), projectile.isSilent() ? -1 : 1);
                level.addFreshEntity(areaeffectcloud);
            }
        }
        return false;
    }
}
