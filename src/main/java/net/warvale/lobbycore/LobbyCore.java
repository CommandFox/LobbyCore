package net.warvale.lobbycore;

import net.warvale.lobbycore.commands.CommandHandler;
import net.warvale.lobbycore.config.ConfigManager;
import net.warvale.lobbycore.utils.text.Broadcast;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbyCore extends JavaPlugin {

    private static LobbyCore instance;
    private static String version;

    private static CommandHandler cmds;

    @Override
    public void onEnable() {
        Broadcast.toConsole("Loading...");
        try {
            initialise();
            Broadcast.toConsole("Successfully enabled!");
        } catch(Exception ex) {
            ex.printStackTrace();
            Broadcast.toConsole("Failed to enable!");
        }
    }

    @Override
    public void onDisable() {
        Broadcast.toConsole("Successfully disabled!");
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
