package club.varial.core.commands;

import club.varial.core.gui.SanctionGui;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SanctionCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (command.getName().equalsIgnoreCase("sanction")) {

                if (player.hasPermission("varial.sanction")) {

                    if (args.length == 0) {
                        player.sendMessage("§cUtilisez: /sanction <player>");
                    } else if (args.length == 1) {

                        OfflinePlayer sanctionned = Bukkit.getOfflinePlayer(args[0]);

                        if (sanctionned != null) {
                            new SanctionGui(player, sanctionned);
                        } else {
                            player.sendMessage("§cUtilisez: /sanction <player>");
                        }

                    } else {
                        player.sendMessage("§cUtilisez: /sanction <player>");
                    }

                } else {
                    player.sendMessage("§cT'es staff ?? Non...");
                }

            } else {
                sender.sendMessage("§cImpossible chakal!");
            }
        }
        return false;
    }
}
