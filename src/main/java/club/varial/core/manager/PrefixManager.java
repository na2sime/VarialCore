package club.varial.core.manager;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class PrefixManager {

    LuckPerms luckPerms = LuckPermsProvider.get();

    public List<PrefixList> loadedPrefix;

    public PrefixManager() {
        loadedPrefix = new ArrayList<>(EnumSet.allOf(PrefixList.class));
    }

    public void addPrefix(Player player, PrefixList prefix) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                "lp user " + player.getName() + " meta setprefix 9 " + prefix.getDisplay());
    }

    public void removePrefix(Player player) {

    }

}
