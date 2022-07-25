package xyz.gamars.civilization.attacher;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.gamars.civilization.Civilization;
import xyz.gamars.civilization.capabilities.CivCapabilities;
import xyz.gamars.civilization.capabilities.impl.AgeImpl;
import xyz.gamars.civilization.interfaces.IAge;

public class AgeAttacher {

    private static class AgeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

        public static final ResourceLocation IDENTIFIER = new ResourceLocation(Civilization.MOD_ID, "ageCapability");

        private final IAge backend = new AgeImpl();
        private final LazyOptional<IAge> optionalData = LazyOptional.of(() -> backend);

        @NotNull
        @Override
        public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
            return CivCapabilities.AGE.orEmpty(cap, this.optionalData);
        }

        @Override
        public CompoundTag serializeNBT() {
            return this.backend.serializeNBT();
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {
            this.backend.deserializeNBT(nbt);
        }

        void invalidate() {
            this.optionalData.invalidate();
        }

    }

    public static void attach(final AttachCapabilitiesEvent<Player> event) {
        final AgeProvider provider = new AgeProvider();
        event.addCapability(AgeProvider.IDENTIFIER, provider);
    }

    public AgeAttacher() {


    }
}
