package net.warvale.lobbycore;

import net.warvale.lobbycore.commands.CommandHandler;
import net.warvale.lobbycore.config.ConfigManager;
import net.warvale.lobbycore.utils.text.Broadcast;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class LobbyCore extends JavaPlugin {

    private static LobbyCore instance;
    private static String version;

    private static CommandHandler cmds;

    @Override
    public void onEnable() {
        getLogger().log(Level.INFO, "Loading LobbyCore...");
        try {
            initialise();
            Broadcast.toConsole(Level.INFO, "Successfully enabled!");
        } catch(Exception ex) {
            ex.printStackTrace();
            getLogger().log(Level.WARNING, "Failed to enable LobbyCore!");
        }
    }

    @Override
    public void onDisable() {
        Broadcast.toConsole(Level.INFO, "Successfully disabled!");
    }

    private void initialise() {
        instance = this;
        version = getDescription().getVersion();

        ConfigManager.getInstance().setup();

        cmds = new CommandHandler(this);
        cmds.registerCommands();
    }

    public static LobbyCore getInstance() {
        return instance;
    }

    public static String getVersion() {
        return version;
    }
}
