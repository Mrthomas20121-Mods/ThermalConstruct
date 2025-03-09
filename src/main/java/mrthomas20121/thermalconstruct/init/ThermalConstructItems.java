package mrthomas20121.thermalconstruct.init;

import mrthomas20121.thermalconstruct.ThermalConstruct;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import slimeknights.mantle.registration.deferred.SynchronizedDeferredRegister;

public class ThermalConstructItems {

    public static SynchronizedDeferredRegister<Item> ITEMS = SynchronizedDeferredRegister.create(Registries.ITEM, ThermalConstruct.MOD_ID);


}
