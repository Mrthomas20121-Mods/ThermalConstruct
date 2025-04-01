package mrthomas20121.thermalconstruct.modifiers;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ToolStatsModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileLaunchModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.capability.ToolEnergyCapability;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;

import static slimeknights.tconstruct.library.tools.capability.ToolEnergyCapability.ENERGY_HANDLER;
import static slimeknights.tconstruct.library.tools.capability.ToolEnergyCapability.MAX_STAT;

public class PowerAttackModifier extends Modifier implements ToolStatsModifierHook, MeleeDamageModifierHook, ProjectileLaunchModifierHook {

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder
                .addHook(this, ModifierHooks.TOOL_STATS).
                addHook(this, ModifierHooks.MELEE_DAMAGE)
                .addHook(this, ModifierHooks.PROJECTILE_LAUNCH);
        hookBuilder.addModule(ENERGY_HANDLER);
    }

    @Override
    public void addToolStats(IToolContext context, ModifierEntry modifier, ModifierStatsBuilder builder) {
        MAX_STAT.add(builder, 3000*modifier.getEffectiveLevel());
    }

    @Override
    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {
        if(ToolEnergyCapability.getEnergy(tool) > 100) {
            ToolEnergyCapability.setEnergy(tool, ToolEnergyCapability.getEnergy(tool)-100);
            return damage+(2f*modifier.getEffectiveLevel());
        }

        return damage;
    }

    @Override
    public void onProjectileLaunch(IToolStackView tool, ModifierEntry modifier, LivingEntity shooter, Projectile projectile, @Nullable AbstractArrow arrow, ModDataNBT persistentData, boolean primary) {
        double damage = arrow != null ? arrow.getBaseDamage(): 0;
        if(ToolEnergyCapability.getEnergy(tool) > 100 && arrow != null) {
            ToolEnergyCapability.setEnergy(tool, ToolEnergyCapability.getEnergy(tool)-100);
             arrow.setBaseDamage(damage+modifier.getEffectiveLevel());
        }
    }
}
