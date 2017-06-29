package net.warvale.lobbycore.commands.admin;

import net.warvale.lobbycore.commands.AbstractCommand;
import net.warvale.lobbycore.exceptions.CommandException;
import net.warvale.lobbycore.utils.files.FileUtils;
import net.warvale.lobbycore.utils.text.Broadcast;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class ResetLobbyCommand extends AbstractCommand {
   public ResetLobbyCommand() {
       super("reset-lobby", "");
   }

    @Override
    public boolean execute(CommandSender sender, String[] args) throws CommandException {
        if(!(sender instanceof Player)) {
            throw new CommandException("Only player's can execute this command!");
        }

        File from = Bukkit.getWorld("voidsource").getWorldFolder();
        File to = Bukkit.getWorld("void").getWorldFolder();

        Broadcast.toSender(sender, Broadcast.BroadcastType.BASIC, "Resetting the lobby...");
        try {
            Broadcast.toSender(sender, Broadcast.BroadcastType.SUCCESS, "Successfully reset the lobby!");
            for(Player player : Bukkit.getOnlinePlayers()) {
                if(player.getWorld().equals("void")) {
                    Location destA = new Location(Bukkit.getWorld("voidsrc"), 128, 48, 67);
                    Location destB = new Location(Bukkit.getWorld("void"), 128, 48, 67);
                    player.teleport(destA);
                    FileUtils.copyFolder(from, to);
                    player.teleport(destB);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            Broadcast.toSender(sender, Broadcast.BroadcastType.FAILURE, "Failed to reset the lobby!");
        }

        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) { return new ArrayList<>(); }
}
