package club.varial.core.commands;

import club.varial.core.gui.BoutiqueGui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BoutiqueCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            if (command.getName().equalsIgnoreCase("boutique")) {

                new BoutiqueGui((Player) sender);

            }

        } else {
            sender.sendMessage("§cImpossible chakal.");
        }

        return false;
    }

}
