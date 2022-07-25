package xyz.gamars.civilization.capabilities.provider;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.capabilities.CivCapabilities;
import xyz.gamars.civilization.capabilities.impl.AgeImpl;
import xyz.gamars.civilization.capabilities.impl.ThirstImpl;

public class ThirstProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static final ResourceLocation IDENTIFIER = new ResourceLocation(Civilization.MOD_ID, ThirstImpl.NBT_KEY_THIRST);


    private final ThirstImpl backend = new ThirstImpl();
    private final LazyOptional<ThirstImpl> optionalData = LazyOptional.of(() -> backend);

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return CivCapabilities.THIRST.orEmpty(cap, this.optionalData);
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
