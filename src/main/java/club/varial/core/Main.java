package club.varial.core;

import club.varial.core.commands.PrefixCommand;
import club.varial.core.listeners.InventoryInteract;
import club.varial.core.manager.PrefixManager;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main INSTANCE;

    public PrefixManager prefixManager;

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
    }

    private void loadListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new InventoryInteract(), this);

    }

    private void loadCommands() {
        getCommand("prefix").setExecutor(new PrefixCommand());
    }

}
