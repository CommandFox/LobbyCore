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
public class LobbyMechanics implements Listener {
    
    private List<Player> jumpers = new ArrayList<>();
    
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (event.getTo().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.IRON_PLATE)
                && event.getTo().getBlock().getRelative(BlockFace.DOWN, 2).getType().equals(Material.GOLD_BLOCK)) {
            event.getPlayer().setVelocity(event.getPlayer().getLocation().getDirection().multiply(3));
            event.getPlayer().setVelocity(new Vector(event.getPlayer().getVelocity().getX(), 1.0D, event.getPlayer().getVelocity().getZ()));
            jumpers.add(event.getPlayer());
        }
    }
   
    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (event.getCause().equals(EntityDamageEvent.DamageCause.FALL) && jumpers.contains(player)) {
                event.setDamage(0.0);
                jumpers.remove(player);
            }
        }
    }
}
