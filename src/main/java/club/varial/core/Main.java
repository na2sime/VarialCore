package club.varial.core;

import club.varial.core.commands.BoutiqueCommand;
import club.varial.core.commands.PrefixCommand;
import club.varial.core.commands.SanctionCommand;
import club.varial.core.listeners.InventoryInteractBoutique;
import club.varial.core.listeners.InventoryInteractPrefix;
import club.varial.core.manager.PrefixManager;
import club.varial.core.manager.SanctionManager;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
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

    }

    private void loadCommands() {
        getCommand("prefix").setExecutor(new PrefixCommand());
        getCommand("boutique").setExecutor(new BoutiqueCommand());
        getCommand("sanction").setExecutor(new SanctionCommand());
    }

}
