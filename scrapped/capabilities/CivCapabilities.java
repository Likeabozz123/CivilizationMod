package xyz.gamars.civilization.capabilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import xyz.gamars.civilization.interfaces.IAge;

public class CivCapabilities {

    public static final Capability<IAge> AGE = CapabilityManager.get(new CapabilityToken<IAge>() {});

    public static void register(RegisterCapabilitiesEvent event) {
        event.register(IAge.class);
    }
}
