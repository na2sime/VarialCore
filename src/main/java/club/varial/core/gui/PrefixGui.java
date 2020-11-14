package club.varial.core.gui;

import club.varial.core.Main;
import club.varial.core.manager.PrefixList;
import club.varial.core.manager.PrefixManager;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PrefixGui {

    public PrefixGui(Player player) {

        Inventory inventory = Bukkit.createInventory(null, 54, "§bPréfix diponible:");
        PrefixManager prefixManager = Main.INSTANCE.prefixManager;

        for (int i = 0; i < PrefixList.values().length; i++) {

            ItemStack itemStack = new ItemStack(Material.BOOK, 1);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName("§7» §f" + prefixManager.loadedPrefix.get(i).getName());
            List<String> lore = new ArrayList<>();
            lore.add("§c  ");
            lore.add("§7Rendu en jeu: " + prefixManager.loadedPrefix.get(i).getDisplay());
            lore.add("§c  ");
            if(player.hasPermission(prefixManager.loadedPrefix.get(i).getPermission())){
                lore.add("§aDisponible");
                lore.add("§c  ");
            } else {
                lore.add("§cIndisponible");
                lore.add("§7Obtenable dans le §6§l/boutique§7.");
                lore.add("§c  ");
            }
            itemMeta.setLore(lore);
            itemStack.setItemMeta(itemMeta);

            net.minecraft.server.v1_8_R3.ItemStack itemData = CraftItemStack.asNMSCopy(itemStack);
            NBTTagCompound comp = itemData.getTag();

            if (comp == null)
                comp = new NBTTagCompound();
            comp.setString("prefix", prefixManager.loadedPrefix.get(i).getName());

            itemData.setTag(comp);
            itemStack = CraftItemStack.asBukkitCopy(itemData);

            inventory.setItem(i, itemStack);

        }

        ItemStack itemStack = new ItemStack(Material.BARRIER, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§cRetirez vos préfixes !");
        itemStack.setItemMeta(itemMeta);

        inventory.setItem(49, itemStack);

        player.openInventory(inventory);
    }

}
