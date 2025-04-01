package mrthomas20121.thermalconstruct.modifiers;

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

public class PowerShieldModifier extends DurabilityShieldModifier implements ToolStatsModifierHook {

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this, ModifierHooks.TOOL_STATS);
        hookBuilder.addModule(ENERGY_HANDLER);
    }

    @Override
    public void addToolStats(IToolContext context, ModifierEntry modifier, ModifierStatsBuilder builder) {
        MAX_STAT.add(builder, 5000*modifier.getEffectiveLevel());
    }

    @Override
    public int getShieldCapacity(IToolStackView tool, ModifierEntry modifier) {
        return tool.getStats().getInt(MAX_STAT);
    }

    @Nullable
    @Override
    public Boolean showDurabilityBar(IToolStackView tool, ModifierEntry modifier) {
        return getShield(tool) < getShieldCapacity(tool, modifier) ? true : null;
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
