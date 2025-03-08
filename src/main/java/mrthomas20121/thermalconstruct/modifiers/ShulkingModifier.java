package mrthomas20121.thermalconstruct.modifiers;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.armor.OnAttackedModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class ShulkingModifier extends Modifier implements OnAttackedModifierHook {

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this, ModifierHooks.ON_ATTACKED);
    }

    @Override
    public void onAttacked(IToolStackView tool, ModifierEntry modifier, EquipmentContext context, EquipmentSlot slotType, DamageSource source, float amount, boolean isDirectDamage) {
        Entity attacker = source.getEntity();
        LivingEntity player = context.getEntity();
        Level level = context.getLevel();

        if (attacker != null && isDirectDamage) {
            if (!level.isClientSide) {
                double d0 = player.getX();
                double d1 = player.getY();
                double d2 = player.getZ();

                for(int i = 0; i < 16; ++i) {
                    double d3 = player.getX() + (player.getRandom().nextDouble() - 0.5D) * 16.0D;
                    double d4 = Mth.clamp(player.getY() + (double)(player.getRandom().nextInt(16) - 8), level.getMinBuildHeight(), level.getMinBuildHeight() + ((ServerLevel)level).getLogicalHeight() - 1);
                    double d5 = player.getZ() + (player.getRandom().nextDouble() - 0.5D) * 16.0D;
                    if (player.isPassenger()) {
                        player.stopRiding();
                    }

                    Vec3 vec3 = player.position();
                    level.gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(player));
                    net.minecraftforge.event.entity.EntityTeleportEvent.ChorusFruit event = net.minecraftforge.event.ForgeEventFactory.onChorusFruitTeleport(player, d3, d4, d5);
                    if (event.isCanceled()) return;
                    if (player.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true)) {
                        SoundEvent soundevent = SoundEvents.CHORUS_FRUIT_TELEPORT;
                        level.playSound((Player)null, d0, d1, d2, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
                        player.playSound(soundevent, 1.0F, 1.0F);
                        break;
                    }
                }
            }


        }
    }
}
