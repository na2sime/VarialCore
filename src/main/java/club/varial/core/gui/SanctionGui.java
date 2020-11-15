package club.varial.core.gui;

import club.varial.core.Main;
import club.varial.core.enums.SanctionsList;
import club.varial.core.enums.SanctionsType;
import club.varial.core.manager.SanctionManager;
import litebans.api.Database;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SanctionGui {

    public SanctionGui(Player staff, Player sanctionned) {

        List<String> lastBan = new ArrayList<>();
        lastBan.add("§c  ");

        String uuid = sanctionned.getUniqueId().toString();
        String query = "SELECT * FROM {bans} WHERE uuid=?";
        try (PreparedStatement st = Database.get().prepareStatement(query)) {
            st.setString(1, uuid);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    String reason = rs.getString("reason");
                    long time = rs.getLong("time");
                    long until = rs.getLong("until");
                    long id = rs.getLong("id");
                    boolean active = rs.getBoolean("active");
                    lastBan.add("§7» Ban-ID[" + id + "]§7: §c"
                            + reason + " §f| §c" + time + " §f| §c" + until + " §f| §c" + active);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        Inventory inventory = Bukkit.createInventory(null, 54,
                "§cSanction pour §f" + sanctionned.getName());

        SanctionManager sanctionManager = Main.INSTANCE.sanctionManager;

        ItemStack playerInfos = new ItemStack(Material.BOOK, 1);
        ItemMeta playerInfosMeta = playerInfos.getItemMeta();
        playerInfosMeta.setDisplayName("§7Liste des bans de : §c" + sanctionned.getName());
        playerInfosMeta.setLore(lastBan);
        playerInfos.setItemMeta(playerInfosMeta);

        inventory.setItem(4, playerInfos);

        for (int i = 0; i < SanctionsList.values().length; i++) {

            SanctionsType sanctionsType = sanctionManager.sanctionsLists.get(i).getSanctionsType();

            ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta itemMeta = (SkullMeta) itemStack.getItemMeta();
            itemMeta.setOwner(sanctionned.getName());
            itemMeta.setDisplayName("§7» §f" + sanctionManager.sanctionsLists.get(i).getReason());
            List<String> lore = new ArrayList<>();
            lore.add("§c  ");
            lore.add("§7Sanction type: §f" + sanctionsType.getName());
            lore.add("§7» §c" + sanctionsType.getDescription());
            lore.add("§c  ");
            itemMeta.setLore(lore);
            itemStack.setItemMeta(itemMeta);

            net.minecraft.server.v1_8_R3.ItemStack itemData = CraftItemStack.asNMSCopy(itemStack);
            NBTTagCompound comp = itemData.getTag();

            if (comp == null)
                comp = new NBTTagCompound();
            comp.setString("reason", sanctionManager.sanctionsLists.get(i).getReason());
            comp.setString("type", sanctionsType.getName());
            comp.setString("litebanInfo", sanctionsType.getLitebanInfo());
            comp.setString("banned_by", staff.getName());

            itemData.setTag(comp);
            itemStack = CraftItemStack.asBukkitCopy(itemData);

            int slot = i + 9;

            inventory.setItem(slot, itemStack);

        }

        ItemStack itemStack = new ItemStack(Material.BARRIER, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§cFermer !");
        itemStack.setItemMeta(itemMeta);

        inventory.setItem(49, itemStack);

        staff.openInventory(inventory);
    }

}
