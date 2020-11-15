package club.varial.core.enums;

import java.util.HashMap;
import java.util.Map;

public enum SanctionsList {

    SPAM("Spam", SanctionsType.MUTE_B),
    FLOOD("Flood", SanctionsType.MUTE_A),
    MAJUSCULE("Majuscule", SanctionsType.MUTE_A),
    PROVOCATION("Provocation", SanctionsType.MUTE_C),
    INSULTE_MINEUR("Insulte -> Mineur", SanctionsType.MUTE_B),
    INSULTE_MAJEUR("Insulte -> Majeur", SanctionsType.MUTE_C),
    INSULTE_STAFF("Insulte -> Staff", SanctionsType.MUTE_C),
    RACISME("Racisme", SanctionsType.MUTE_C),
    PUB("Pub", SanctionsType.MUTE_B),
    DIFFAMATION("Diffamation", SanctionsType.MUTE_C),
    LANGAGE("Langage inapproprié", SanctionsType.MUTE_A),
    PSEUDO("Pseudo inapproprié", SanctionsType.MUTE_C),
    DDOS("DDOS", SanctionsType.BAN_C),
    PING("PING", SanctionsType.KICK),
    AFK("AFK", SanctionsType.KICK),
    XRAY("Cheat -> XRay", SanctionsType.BAN_B),
    FLY("Cheat -> Fly", SanctionsType.BAN_B),
    SPEEDHACK("Cheat -> SpeedHack", SanctionsType.BAN_B),
    KILLAURA("Cheat -> KillAura", SanctionsType.BAN_C),
    AIMBOT("Cheat -> AimBot", SanctionsType.BAN_C),
    ANTIKB("Cheat -> AntiKB", SanctionsType.BAN_C),
    AUTOCLICK("Cheat -> AutoClick", SanctionsType.BAN_C),
    SCHEMATICA("Mod -> Schematica", SanctionsType.BAN_A),
    SPAM_MONEY("Spam Money", SanctionsType.BAN_A),
    REFUS_VERIF("Refus de vérif", SanctionsType.BAN_B),
    CHEAT_AVOUE("Cheat avoué", SanctionsType.BAN_B);

    private String reason;
    private SanctionsType sanctionsType;

    public static Map<String, SanctionsList> sanctionsListMap = new HashMap<>();

    SanctionsList(String reason, SanctionsType sanctionsType) {
        this.reason = reason;
        this.sanctionsType = sanctionsType;
    }

    static {
        for (SanctionsList sanctions : SanctionsList.values()) {
            sanctionsListMap.put(sanctions.getReason(), sanctions);
        }
    }

    public String getReason() {
        return this.reason;
    }

    public SanctionsType getSanctionsType() {
        return this.sanctionsType;
    }

    public static SanctionsList getSanctionByReason(String reason) {
        return sanctionsListMap.get(reason);
    }

}
