package mrthomas20121.thermalconstruct;

import mrthomas20121.thermalconstruct.datagen.ThermalDatagen;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ThermalConstruct.MOD_ID)
public class ThermalConstruct {

	public static final String MOD_ID = "thermalconstruct";

	public ThermalConstruct() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		bus.addListener(ThermalDatagen::init);
	}
}
