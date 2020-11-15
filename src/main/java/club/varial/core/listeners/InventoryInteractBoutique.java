package club.varial.core.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryInteractBoutique implements Listener {

    @EventHandler
    public void onInventoryInteract(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle() == "§bBoutique:") {

            ItemStack item = event.getCurrentItem();
            event.setCancelled(true);

            if (item == null) return;
            if (item != null) {
                player.sendMessage("c");
                if (!item.getType().equals(Material.STAINED_GLASS_PANE) ||
                        !item.getType().equals(Material.SKULL_ITEM)) {
                    player.sendMessage("§7» §fBoutique du serveur : §6https://shop.varial.club/");
                } else {
                    return;
                }

            }
        }
    }

}
