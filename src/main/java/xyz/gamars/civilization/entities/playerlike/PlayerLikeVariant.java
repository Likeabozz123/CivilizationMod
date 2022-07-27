package xyz.gamars.civilization.entities.playerlike;

import java.util.Arrays;
import java.util.Comparator;

public enum PlayerLikeVariant {
    DEFAULT(0),
    JEFFCHICKEN13(1),
    HEROBRINE(2);

    private static final PlayerLikeVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(PlayerLikeVariant::getId)).toArray(PlayerLikeVariant[]::new);
    private final int id;

    PlayerLikeVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static PlayerLikeVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
