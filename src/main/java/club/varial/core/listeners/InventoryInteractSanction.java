package club.varial.core.listeners;

import club.varial.core.Main;
import club.varial.core.enums.SanctionsList;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryInteractSanction implements Listener {

    @EventHandler
    public void onInventoryInteract(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().contains("§cSanction pour")) {

            ItemStack item = event.getCurrentItem();
            event.setCancelled(true);

            if (item == null) return;
            if (item != null) {

                net.minecraft.server.v1_8_R3.ItemStack itemStack = CraftItemStack.asNMSCopy(item);

                player.sendMessage("a");

                if (itemStack.getTag().hasKey("reason")) {
                    player.sendMessage("b");
                    SanctionsList sanction = SanctionsList.getSanctionByReason(itemStack.getTag().getString("reason"));
                    OfflinePlayer sanctionned = Bukkit.getPlayer(itemStack.getTag().getString("sanctionned"));
                    Main.INSTANCE.sanctionManager.sanction(player, sanctionned, sanction);
                } else {
                    player.sendMessage("c");
                    return;
                }
            }
        }
    }

}
