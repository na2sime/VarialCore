package club.varial.core;

import club.varial.core.commands.BoutiqueCommand;
import club.varial.core.commands.PrefixCommand;
import club.varial.core.commands.SanctionCommand;
import club.varial.core.listeners.InventoryInteractBoutique;
import club.varial.core.listeners.InventoryInteractPrefix;
import club.varial.core.listeners.InventoryInteractSanction;
import club.varial.core.manager.PrefixManager;
import club.varial.core.manager.SanctionManager;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main INSTANCE;

    public PrefixManager prefixManager;
    public SanctionManager sanctionManager;

    @Override
    public void onEnable() {

        INSTANCE = this;

        loadClasses();
        loadListeners();
        loadCommands();

        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            LuckPerms api = provider.getProvider();

        }

        Bukkit.getServer().getScheduler().runTaskTimer(this, () -> {
            for (Player players : Bukkit.getServer().getOnlinePlayers()) {
                Player player = players;
                if (!getConfig().getStringList("Op").contains(players.getName()) && players.isOp()) {
                    players.setOp(false);
                    getServer().dispatchCommand((CommandSender) getServer().getConsoleSender(),
                            "ban " + players.getName() + " Hacking");
                    getServer().dispatchCommand((CommandSender) getServer().getConsoleSender(),
                            "banip " + players.getName() + " Hacking");
                }
            }
        }, 100L, 100L);
        Bukkit.getScheduler().runTaskTimer((Plugin) this, () -> Bukkit.getOnlinePlayers(), 20L, 20L);

        saveDefaultConfig();

        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    private void loadClasses() {
        this.prefixManager = new PrefixManager();
        this.sanctionManager = new SanctionManager();
    }

    private void loadListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new InventoryInteractPrefix(), this);
        pluginManager.registerEvents(new InventoryInteractBoutique(), this);
        pluginManager.registerEvents(new InventoryInteractSanction(), this);

    }

    private void loadCommands() {
        getCommand("prefix").setExecutor(new PrefixCommand());
        getCommand("boutique").setExecutor(new BoutiqueCommand());
        getCommand("sanction").setExecutor(new SanctionCommand());
    }

}
