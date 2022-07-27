package xyz.gamars.civilization.entities.goals;

import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import xyz.gamars.civilization.objects.entities.CivMob;

public class FocusPlayerGoal extends LookAtPlayerGoal {

    private CivMob civMob;

    public FocusPlayerGoal(CivMob mob) {
        super(mob, Player.class, 8.0F);
        this.civMob = mob;

    }

    @Override
    public boolean canUse() {
        if (civMob.isTalking()) {
            this.lookAt = civMob.getTalkingPlayer();
            return true;
        } else {
            return false;
        }
    }


}
