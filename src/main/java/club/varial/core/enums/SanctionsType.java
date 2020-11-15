package club.varial.core.enums;

public enum SanctionsType {

    MUTE_A("MUTE_A", "1 semaine", "1w"),
    MUTE_B("MUTE_B", "1 mois", "4w"),
    MUTE_C("MUTE_C", "Permanant", null),
    BAN_A("BAN_A", "1 semaine", "1w"),
    BAN_B("BAN_B", "2 mois", "2m"),
    BAN_C("BAN_C", "Permanant", null),
    KICK("KICK_A", "Kick du serveur", null);

    private String name;
    private String description;
    private String litebanInfo;

    SanctionsType(String name, String description, String litebanInfo) {
        this.name = name;
        this.description = description;
        this.litebanInfo = litebanInfo;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getLitebanInfo() {
        return this.litebanInfo;
    }
}
