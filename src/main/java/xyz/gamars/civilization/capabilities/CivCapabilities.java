package xyz.gamars.civilization.capabilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import xyz.gamars.civilization.capabilities.impl.AgeImpl;
import xyz.gamars.civilization.capabilities.impl.StatImpl;
import xyz.gamars.civilization.capabilities.impl.ThirstImpl;
import xyz.gamars.civilization.capabilities.impl.TribeImpl;

public class CivCapabilities {



    public static Capability<AgeImpl> AGE = CapabilityManager.get(new CapabilityToken<>(){});;
    public static Capability<TribeImpl> TRIBE = CapabilityManager.get(new CapabilityToken<>(){});;
    public static Capability<ThirstImpl> THIRST = CapabilityManager.get(new CapabilityToken<>(){});;
    public static Capability<StatImpl> STATS = CapabilityManager.get(new CapabilityToken<>(){});;



}