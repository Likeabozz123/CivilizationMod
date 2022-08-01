package xyz.gamars.civilization.capabilities.provider;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.capabilities.CivCapabilities;
import xyz.gamars.civilization.capabilities.impl.TemperatureImpl;

public class TemperatureProvider implements ICapabilitySerializable<CompoundTag> {

    public static final ResourceLocation IDENTIFIER = new ResourceLocation(Civilization.MOD_ID, TemperatureImpl.NBT_KEY_TEMPERATURE);

    private final TemperatureImpl backend = new TemperatureImpl();
    private final LazyOptional<TemperatureImpl> optionalData = LazyOptional.of(() -> backend);

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return CivCapabilities.TEMPERATURE.orEmpty(cap, this.optionalData);
    }

    void invalidate() {
        this.optionalData.invalidate();
    }

    @Override
    public CompoundTag serializeNBT() {
        return this.backend.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.backend.deserializeNBT(nbt);
    }

}
