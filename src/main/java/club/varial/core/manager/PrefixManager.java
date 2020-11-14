package club.varial.core.manager;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import org.bukkit.entity.Player;

import java.util.concurrent.CompletableFuture;

public class PrefixManager {

    LuckPerms luckPerms = LuckPermsProvider.get();

    public void addPrefix(Player player, String prefix) {
        User user = luckPerms.getUserManager().getUser(player.getUniqueId());
    }

    public void addCustomPrefix(Player player, String prefix) {

    }

    public void delPrefix(Player player) {

    }

}
