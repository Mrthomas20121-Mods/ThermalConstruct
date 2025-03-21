package mrthomas20121.thermalconstruct;

import mrthomas20121.thermalconstruct.datagen.ThermalDatagen;
import mrthomas20121.thermalconstruct.init.ThermalConstructFluids;
import mrthomas20121.thermalconstruct.init.ThermalConstructItems;
import mrthomas20121.thermalconstruct.init.ThermalConstructModifiers;
import mrthomas20121.thermalconstruct.util.ThermalLivingEntityPredicate;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;
import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;

@Mod(ThermalConstruct.MOD_ID)
public class ThermalConstruct {

	public static final String MOD_ID = "thermalconstruct";

	public static String makeDescriptionId(String type, String name) {
		return type + "." + MOD_ID + "." + name;
	}

	public static ResourceLocation getResource(String name) {
		return new ResourceLocation(MOD_ID, name);
	}

	public ThermalConstruct() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		ThermalConstructItems.ITEMS.register(bus);
		ThermalConstructItems.CREATIVE_TABS.register(bus);
		ThermalConstructFluids.FLUIDS.register(bus);
		ThermalConstructModifiers.MODIFIERS.register(bus);

		bus.addListener(EventPriority.NORMAL, false, GatherDataEvent.class, ThermalDatagen::init);
		bus.addListener(EventPriority.NORMAL, false, RegisterEvent.class, this::register);
	}

	private void register(RegisterEvent event) {
		if(event.getRegistryKey() == Registries.RECIPE_SERIALIZER) {
			LivingEntityPredicate.LOADER.register(new ResourceLocation("thermalconstruct:has_potion_effect"), ThermalLivingEntityPredicate.HAS_POTION_EFFECT.getLoader());
			LivingEntityPredicate.LOADER.register(new ResourceLocation("thermalconstruct:is_in_end"), ThermalLivingEntityPredicate.IS_IN_END.getLoader());
			LivingEntityPredicate.LOADER.register(new ResourceLocation("thermalconstruct:is_in_nether"), ThermalLivingEntityPredicate.IS_IN_NETHER.getLoader());
		}
	}
}
