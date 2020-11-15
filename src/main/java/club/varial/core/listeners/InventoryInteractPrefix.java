package club.varial.core.listeners;

import club.varial.core.Main;
import club.varial.core.enums.PrefixList;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryInteractPrefix implements Listener {

    @EventHandler
    public void onInventoryInteract(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle() == "§bPréfix diponible:") {

            ItemStack item = event.getCurrentItem();
            event.setCancelled(true);

            if (item == null) return;
            if (item != null) {

                net.minecraft.server.v1_8_R3.ItemStack itemStack = CraftItemStack.asNMSCopy(item);

                if (itemStack.getTag().hasKey("prefix")) {

                    PrefixList prefix = PrefixList.getPrefixByName(itemStack.getTag().getString("prefix"));

                    if (player.hasPermission(prefix.getPermission())) {
                        player.sendMessage("§aVous avez mainetant le préfix: " + prefix.getName());
                        Main.INSTANCE.prefixManager.addPrefix(player, prefix);
                    } else {
                        player.sendMessage("§cVous n'avez pas la permissions !");
                    }
                }
            }
        }
    }

}
