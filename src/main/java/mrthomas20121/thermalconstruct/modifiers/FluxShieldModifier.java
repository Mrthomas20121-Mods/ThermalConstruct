package mrthomas20121.thermalconstruct.modifiers;

import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ToolStatsModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.DurabilityShieldModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.capability.ToolEnergyCapability;
import slimeknights.tconstruct.library.tools.nbt.IToolContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;

import static slimeknights.tconstruct.library.tools.capability.ToolEnergyCapability.ENERGY_HANDLER;
import static slimeknights.tconstruct.library.tools.capability.ToolEnergyCapability.MAX_STAT;

public class FluxShieldModifier extends DurabilityShieldModifier implements ToolStatsModifierHook {

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this, ModifierHooks.TOOL_STATS);
        hookBuilder.addModule(ENERGY_HANDLER);
    }

    @Override
    public Component getDisplayName(IToolStackView tool, ModifierEntry entry, @Nullable RegistryAccess access) {
        return this.getDisplayName(entry.getLevel());
    }

    @Override
    public void addToolStats(IToolContext context, ModifierEntry modifier, ModifierStatsBuilder builder) {
        int value = 50000;

        if(modifier.intEffectiveLevel() > 1) {
            value = value+10000*modifier.intEffectiveLevel();
        }

        MAX_STAT.add(builder, value);
    }

    @Override
    public int getShieldCapacity(IToolStackView tool, ModifierEntry modifier) {
        return tool.getStats().getInt(MAX_STAT);
    }

    @Override
    public int onDamageTool(IToolStackView tool, ModifierEntry modifier, int amount, @javax.annotation.Nullable LivingEntity holder) {
        int realAmount = 200;
        int shield = getShield(tool);
        if (shield > 0) {
            // if we have more overslime than amount, remove some overslime
            if (shield >= realAmount) {
                setShield(tool, modifier, shield - realAmount);
                return 0;
            }
            // amount is more than overslime, reduce and clear overslime
            amount -= shield;
            setShield(tool, modifier, 0);
        }
        return amount;
    }

    @Nullable
    @Override
    public Boolean showDurabilityBar(IToolStackView tool, ModifierEntry modifier) {
        return getShield(tool) > 0 && getShield(tool) < getShieldCapacity(tool, modifier) ? true : null;
    }

    @Override
    public int getShield(IToolStackView tool) {
        return ToolEnergyCapability.getEnergy(tool);
    }

    @Override
    public void setShield(IToolStackView tool, ModifierEntry modifier, int amount) {
        ToolEnergyCapability.setEnergy(tool, amount);
    }

    @Override
    public int getDurabilityRGB(IToolStackView tool, ModifierEntry modifier) {
        return 0x95CFE6;
    }
}
