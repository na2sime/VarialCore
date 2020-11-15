package club.varial.core.manager;

import club.varial.core.enums.SanctionsList;
import club.varial.core.enums.SanctionsType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class SanctionManager {

    public List<SanctionsType> sanctionsTypes;
    public List<SanctionsList> sanctionsLists;

    public SanctionManager() {
        this.sanctionsTypes = new ArrayList<>(EnumSet.allOf(SanctionsType.class));
        Bukkit.getServer().getConsoleSender().sendMessage("§cSanction Type loaded (" + sanctionsTypes.size() + ") :");
        for (SanctionsType sanctionsType : sanctionsTypes) {
            Bukkit.getServer().getConsoleSender().sendMessage("§7-> §a" + sanctionsType);
        }
        this.sanctionsLists = new ArrayList<>(EnumSet.allOf(SanctionsList.class));
        Bukkit.getServer().getConsoleSender().sendMessage("§cSanction List loaded (" + sanctionsLists.size() + ") :");
        for (SanctionsList sanctionsList : sanctionsLists) {
            Bukkit.getServer().getConsoleSender().sendMessage("§7-> §a" + sanctionsList);
        }
    }

    public void sanction(Player staff, Player sanctionned) {

    }

}
