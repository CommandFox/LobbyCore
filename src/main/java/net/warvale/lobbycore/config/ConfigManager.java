package net.warvale.lobbycore.config;

import net.warvale.lobbycore.LobbyCore;
import net.warvale.lobbycore.utils.files.FileUtils;
import net.warvale.lobbycore.utils.text.Broadcast;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigManager {

    private static ConfigManager instance;

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public static FileConfiguration getConfig() {
        return config;
    }

    private static FileConfiguration config;
    private File configFile;

    public void setup() {
        Broadcast.toConsole("Setting up config(s)...");

        try {
            if (!LobbyCore.getInstance().getDataFolder().exists()) {
                LobbyCore.getInstance().getDataFolder().mkdir();
            }

            configFile = new File(LobbyCore.getInstance().getDataFolder(), "config.yml");
            if (!configFile.exists()) {
                FileUtils.loadFile("config.yml");
            }

            reloadConfig();
        } catch (Exception ex) {
            ex.printStackTrace();
            Broadcast.toConsole("Failed to setup config(s)!");
        }
    }

    public void reloadConfig() {
        try {
            config = new YamlConfiguration();
            config.load(configFile);
        } catch (Exception ex) {
            ex.printStackTrace();
            Broadcast.toConsole("Failed to reload config: config.yml!");
        }
    }

    public void saveConfig() {
        try {
            config.save(configFile);
        } catch(Exception ex) {
            ex.printStackTrace();
            Broadcast.toConsole("Failed to save config: config.yml!");
        }
    }
}
