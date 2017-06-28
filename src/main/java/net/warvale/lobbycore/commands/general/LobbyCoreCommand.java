package net.warvale.lobbycore.commands.general;

import net.warvale.lobbycore.LobbyCore;
import net.warvale.lobbycore.commands.AbstractCommand;
import net.warvale.lobbycore.exceptions.CommandException;
import net.warvale.lobbycore.utils.text.Broadcast;
import net.warvale.lobbycore.utils.text.Chat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class LobbyCoreCommand extends AbstractCommand {

    public LobbyCoreCommand() {
        super("lobbycore", "");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) throws CommandException {
        if(!(sender instanceof Player)) {
            throw new CommandException("Only players can execute this command!");
        }

        Broadcast.toSender(sender, Broadcast.BroadcastType.BASIC, "LobbyCore is currently running on version " + Chat.AQUA + LobbyCore.getVersion() + Chat.YELLOW + ".");
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) {
        return new ArrayList<>();
    }
}
