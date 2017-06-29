package net.warvale.lobbycore.mechanics;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.material.MaterialData;
import org.bukkit.util.Vector;

/**
 * Created by CommandFox on 29/6/2017.
 */
class LobbyMechanics implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if(event.getAction() == Action.PHYSICAL) {
            // Player triggers physical interaction event

            if(event.getClickedBlock().getType() == Material.GOLD_PLATE) {
                // Player steps on stone pressure plate

                player.setVelocity(player.getLocation().getDirection().multiply(3));
                player.setVelocity(new Vector(player.getVelocity().getX(), 1.0D, player.getVelocity().getZ()));

            }
        }
    }
}
