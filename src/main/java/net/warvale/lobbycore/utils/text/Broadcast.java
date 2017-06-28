package net.warvale.lobbycore.utils.text;

import net.warvale.lobbycore.LobbyCore;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Level;

public class Broadcast {

    public enum BroadcastType {
        SUCCESS,
        FAILURE,
        BASIC
    }

    public static void toConsole(Level level, String message) {
        LobbyCore.getInstance().getLogger().log(level, "[LobbyCore v" + LobbyCore.getVersion() + "] " + message);
    }

    public static void toPlayer(Player player, String message) {
        player.sendMessage(message);
    }

    public static void toSender(CommandSender sender, String message) {
        sender.sendMessage(message);
    }

    public static void toPlayer(Player player, BroadcastType broadcastType, String message) {
        if(broadcastType == BroadcastType.SUCCESS) {
            player.sendMessage(Chat.DARK_GREEN + "[LobbyCore] " + Chat.GREEN + message);
        } else if(broadcastType == BroadcastType.FAILURE) {
            player.sendMessage(Chat.DARK_RED + "[LobbyCore] " + Chat.RED + message);
        } else if(broadcastType == BroadcastType.BASIC) {
            player.sendMessage(Chat.GOLD + "[LobbyCore] " + Chat.YELLOW + message);
        }
    }

    public static void toSender(CommandSender sender, BroadcastType broadcastType, String message) {
        if(broadcastType == BroadcastType.SUCCESS) {
            sender.sendMessage(Chat.DARK_GREEN + "[LobbyCore] " + Chat.GREEN + message);
        } else if(broadcastType == BroadcastType.FAILURE) {
            sender.sendMessage(Chat.DARK_RED + "[LobbyCore] " + Chat.RED + message);
        } else if(broadcastType == BroadcastType.BASIC) {
            sender.sendMessage(Chat.GOLD + "[LobbyCore] " + Chat.YELLOW + message);
        }
    }
}
