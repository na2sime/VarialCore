package club.varial.core.manager;

import club.varial.core.enums.SanctionsList;
import club.varial.core.enums.SanctionsType;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
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

    public void sanction(Player staff, OfflinePlayer sanctionned, SanctionsList sanctionsList) {

        SanctionsType sanctionsType = sanctionsList.getSanctionsType();

        staff.sendMessage("§7§m--------------------------------------------");
        staff.sendMessage("      §b§lVarial §7- §aSanction§7[§fStaff§7]");
        staff.sendMessage("§aVous avez sanctionné: §f" + sanctionned.getName() + "§a:");
        staff.sendMessage("§7[§c" + sanctionsList.name() + "§7/§c"
                + sanctionsType + "§7/§c" + sanctionsType.getDescription() + "§7]");
        staff.sendMessage("§7§m--------------------------------------------");

        for (Player players : Bukkit.getOnlinePlayers()) {
            if (players.hasPermission("varial.sanction")) {
                if (players != staff) {
                    players.sendMessage("§7§m--------------------------------------------");
                    players.sendMessage("      §b§lVarial §7- §aSanction§7[§fStaff§7]");
                    players.sendMessage("§f" + sanctionned.getName() + "§a a été sanctionné par §f" + staff.getName());
                    players.sendMessage("§7[§c" + sanctionsList.name() + "§7/§c"
                            + sanctionsType.name() + "§7/§c" + sanctionsType.getDescription() + "§7]");
                    players.sendMessage("§7§m--------------------------------------------");
                }
            }
        }

        if (sanctionsType == SanctionsType.BAN_A || sanctionsType == SanctionsType.BAN_B) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                    "tempban " + sanctionned.getName() + " "
                            + sanctionsType.getLitebanInfo()
                            + " " + sanctionsList.getReason());
        } else if (sanctionsType == SanctionsType.BAN_C) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                    "ban " + sanctionned.getName() + " " + sanctionsList.getReason());
        } else if (sanctionsType == SanctionsType.MUTE_A || sanctionsType == SanctionsType.MUTE_B) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                    "tempmute " + sanctionned.getName() + " "
                            + sanctionsType.getLitebanInfo()
                            + " " + sanctionsList.getReason());
        } else if (sanctionsType == SanctionsType.MUTE_C) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                    "mute " + sanctionned.getName() + " " + sanctionsList.getReason());
        } else if (sanctionsType == SanctionsType.KICK) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                    "kick " + sanctionned.getName() + " " + sanctionsList.getReason());
        }

    }

}
