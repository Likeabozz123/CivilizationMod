package xyz.gamars.civilization.entities.goals;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import xyz.gamars.civilization.objects.entities.CivMob;

import java.util.EnumSet;

/* prevents the mob from moving when interacting with player */
public class StopMovingGoal extends Goal {

    private CivMob civMob;

    public StopMovingGoal(CivMob mob) {
        this.civMob = mob;
        this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        if (!this.civMob.isAlive()) {
            return false;
        } else if (this.civMob.isInWater()) {
            return false;
        } else if (!this.civMob.isOnGround()) {
            return false;
        } else if (this.civMob.hurtMarked) {
            return false;
        } else {
            Player player = this.civMob.getTalkingPlayer();
            if (player == null) {
                return false;
            } else if (this.civMob.distanceToSqr(player) > 16.0D) {
                return false;
            } else {
                return true;
            }
        }
    }

    @Override
    public void start() {
        this.civMob.getNavigation().stop();
    }

    @Override
    public void stop() {
        this.civMob.setTalkingPlayer(null);
    }

}
