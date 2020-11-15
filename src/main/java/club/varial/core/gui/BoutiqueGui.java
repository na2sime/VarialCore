package club.varial.core.gui;

import club.varial.core.utils.VarialItems;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class BoutiqueGui {

    public BoutiqueGui(Player player) {

        Inventory inventory = Bukkit.createInventory(null, 45, "§bBoutique:");

        inventory.setItem(4,
                new VarialItems(Material.SKULL_ITEM, 1, (short) 3, "§b" + player.getName(), "§f  ", "§7» §9Grade : §f", "§c     ")
                        .createInSkull(player.getName()));

        inventory.setItem(19,
                new VarialItems(Material.DIAMOND_CHESTPLATE, 1, (short) 0, "§b§lDiamant", "§f  ",
                        "§7» §7Avantages :", "§f  ", "§7» §cDeath-Ban§f: 30 minutes", "§7» §dTournois§f: 1/semaine", "§7» §9Prefix§f: Custom", "§7» §bDurée§f: A vie",
                        "§7» §6Offert§f: 12 vies", "§c     ", "§7» §9§lPrix: §a19,99€", "§7Clickez pour y accéder ", "§b      ").create());

        inventory.setItem(20,
                new VarialItems(Material.GOLD_CHESTPLATE, 1, (short) 0, "§6§lGold", "§f  ",
                        "§7» §7Avantages :", "§f  ", "§7» §cDeath-Ban§f: 50 minutes", "§7» §dTournois§f: 1/mois", "§7» §9Prefix§f: 4 au choix", "§7» §bDurée§f: 1 Map",
                        "§7» §6Offert§f: 5 vies", "§c     ", "§7» §9§lPrix: §a11,99€", "§7Clickez pour y accéder ", "§b      ").create());

        inventory.setItem(21,
                new VarialItems(Material.DIAMOND_CHESTPLATE, 1, (short) 0, "§8§lIron", "§f  ",
                        "§7» §7Avantages :", "§f  ", "§7» §cDeath-Ban§f: 1 heure 10 minutes", "§7» §dTournois§f: Aucun", "§7» §9Prefix§f: Aucun", "§7» §bDurée§f: 1 Map",
                        "§7» §6Offert§f: 1 vies", "§c     ", "§7» §9§lPrix: §a4,99€", "§7Clickez pour y accéder ", "§b      ").create());

        inventory.setItem(23,
                new VarialItems(Material.NETHER_STAR, 1, (short) 0, "§dVie", "§f    ",
                        "§7» §9Quantitée§f: 1 ", "§c     ", "§7» §9§lPrix: §a1,99€", "§7Clickez pour y accéder ", "§b      ").create());

        inventory.setItem(24,
                new VarialItems(Material.NETHER_STAR, 5, (short) 0, "§dVie", "§f    ",
                        "§7» §9Quantitée§f: 5 ", "§c     ", "§7» §9§lPrix: §a5,99€", "§7Clickez pour y accéder ", "§b      ").create());

        inventory.setItem(25,
                new VarialItems(Material.NETHER_STAR, 12, (short) 0, "§dVie", "§f    ",
                        "§7» §9Quantitée§f: 12 ", "§c     ", "§7» §9§lPrix: §a11,99€", "§7Clickez pour y accéder ", "§b      ").create());

        inventory.setItem(0,
                new VarialItems(Material.STAINED_GLASS_PANE, 1, (short) 11, "§c  ", "§f    ").create());
        inventory.setItem(1,
                new VarialItems(Material.STAINED_GLASS_PANE, 1, (short) 11, "§c  ", "§f    ").create());
        inventory.setItem(2,
                new VarialItems(Material.STAINED_GLASS_PANE, 1, (short) 11, "§c  ", "§f    ").create());
        inventory.setItem(3,
                new VarialItems(Material.STAINED_GLASS_PANE, 1, (short) 11, "§c  ", "§f    ").create());
        inventory.setItem(5,
                new VarialItems(Material.STAINED_GLASS_PANE, 1, (short) 11, "§c  ", "§f    ").create());
        inventory.setItem(6,
                new VarialItems(Material.STAINED_GLASS_PANE, 1, (short) 11, "§c  ", "§f    ").create());
        inventory.setItem(7,
                new VarialItems(Material.STAINED_GLASS_PANE, 1, (short) 11, "§c  ", "§f    ").create());
        inventory.setItem(8,
                new VarialItems(Material.STAINED_GLASS_PANE, 1, (short) 11, "§c  ", "§f    ").create());

        inventory.setItem(36,
                new VarialItems(Material.STAINED_GLASS_PANE, 1, (short) 11, "§c  ", "§f    ").create());
        inventory.setItem(37,
                new VarialItems(Material.STAINED_GLASS_PANE, 1, (short) 11, "§c  ", "§f    ").create());
        inventory.setItem(38,
                new VarialItems(Material.STAINED_GLASS_PANE, 1, (short) 11, "§c  ", "§f    ").create());
        inventory.setItem(39,
                new VarialItems(Material.STAINED_GLASS_PANE, 1, (short) 11, "§c  ", "§f    ").create());
        inventory.setItem(40,
                new VarialItems(Material.STAINED_GLASS_PANE, 1, (short) 11, "§c  ", "§f    ").create());
        inventory.setItem(41,
                new VarialItems(Material.STAINED_GLASS_PANE, 1, (short) 11, "§c  ", "§f    ").create());
        inventory.setItem(42,
                new VarialItems(Material.STAINED_GLASS_PANE, 1, (short) 11, "§c  ", "§f    ").create());
        inventory.setItem(43,
                new VarialItems(Material.STAINED_GLASS_PANE, 1, (short) 11, "§c  ", "§f    ").create());
        inventory.setItem(44,
                new VarialItems(Material.STAINED_GLASS_PANE, 1, (short) 11, "§c  ", "§f    ").create());

        player.openInventory(inventory);

    }

}
