package club.varial.core.manager;

import java.util.HashMap;
import java.util.Map;

public enum PrefixList {

    COVID("COVID-19", "§7[§aCOVID-19§7] ", "varial.prefix.covid"),
    LOVER("The Lover","§7[§dLover <3§7] ", "varial.prefix.lover"),
    BDOG("Bull Bog","§7[§8B-Dog§7] ", "varial.prefix.bdog"),
    ANGEL("The Angel","§7[§bAngel§7] ", "varial.prefix.angel"),
    PRO("Minecraft Pro","§7[§ePRO§7] ", "varial.prefix.pro"),
    DEMON("The Demon","§7[§cDemon§7] ", "varial.prefix.demon"),
    BESTEU("Best-EU PvP Player","§7[§6Best§9E§fU§7] ", "varial.prefix.besteu"),
    FISTERPRO("FisteurPro...","§7[§dFister§5§oPro§7] ", "varial.prefix.fisterpro"),
    CONTRESENS("Tié à contre sens","§7[§1Contre-Sens§7] ", "varial.prefix.contresens"),
    BADBOY("BadBoy","§7[§bBadBoy§7] ", "varial.prefix.badboy"),
    BADGIRL("BadGirl","§7[§dBadGirl§7] ", "varial.prefix.badgirl"),
    BABY("Baby","§7[§fBaby§7] ", "varial.prefix.baby"),
    SUEUR("T'es en sueur??","§7[§4Sueur§7] ", "varial.prefix.sueur"),
    NOEL("Noel","§7[§cNo§fel§7] ", "varial.prefix.noel"),
    WHATTHE("What the ****","§7[§cwHaT§ftHe§7] ", "varial.prefix.whatthe"),
    PRIDE("LGBTQIA+","§7[§cP§6R§eI§aD§bE§7] ", "varial.prefix.pride");

    private String name;
    private String display;
    private String permission;

    public static Map<String, PrefixList> prefixes = new HashMap<>();

    PrefixList(String name, String display, String permission) {
        this.name = name;
        this.display = display;
        this.permission = permission;
    }

    static {
        for(PrefixList prefix : PrefixList.values()){
            prefixes.put(prefix.getName(), prefix);
        }
    }

    public String getName() {
        return this.name;
    }

    public String getDisplay() {
        return this.display;
    }

    public String getPermission() {
        return this.permission;
    }

    public static PrefixList getPrefixByName(String name){
        return prefixes.get(name);
    }



}
