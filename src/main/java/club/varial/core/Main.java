package club.varial.core;

import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main INSTANCE;

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

    }

    private void loadListeners() {

    }

    private void loadCommands() {

    }

}
