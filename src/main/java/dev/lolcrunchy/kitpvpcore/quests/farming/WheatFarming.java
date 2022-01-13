package dev.lolcrunchy.kitpvpcore.quests.farming;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WheatFarming implements Listener {

    private Map<UUID, Long> cooldown = new HashMap<UUID, Long>();

    @EventHandler
    private void wheatBreaking(BlockBreakEvent e) {
        final Player player = e.getPlayer();
        boolean isFullyGrown = e.getBlock().getData() == 7;
        if (e.getBlock().getType() == Material.CROPS) {
            if (isFullyGrown) {
                if (cooldown.containsKey(player.getUniqueId())) {
                    if (cooldown.get(player.getUniqueId()) > System.currentTimeMillis()) {
                        e.setCancelled(true);
                        return;
                    }
                }
                e.setCancelled(true);
                e.getBlock().setType(Material.CROPS);
                final Location loc = new Location(e.getBlock().getLocation().getWorld(), e.getBlock().getLocation().getBlockX() + 0.5, e.getBlock().getLocation().getBlockY() + 0.5, e.getBlock().getLocation().getBlockZ() + 0.5);
                final Location loc1 = new Location(e.getBlock().getLocation().getWorld(), e.getBlock().getLocation().getBlockX() + 0.7, e.getBlock().getLocation().getBlockY() + 0.7, e.getBlock().getLocation().getBlockZ() + 0.7);
                final Location loc2 = new Location(e.getBlock().getLocation().getWorld(), e.getBlock().getLocation().getBlockX() + 0.2, e.getBlock().getLocation().getBlockY() + 0.2, e.getBlock().getLocation().getBlockZ() + 0.2);
                final Location loc3 = new Location(e.getBlock().getLocation().getWorld(), e.getBlock().getLocation().getBlockX() + 0.9, e.getBlock().getLocation().getBlockY() + 0.9, e.getBlock().getLocation().getBlockZ() + 0.9);
                loc.getWorld().playEffect(loc, Effect.SLIME, 500, 500);
                loc1.getWorld().playEffect(loc1, Effect.SLIME, 500, 500);
                loc2.getWorld().playEffect(loc2, Effect.SLIME, 500, 500);
                loc3.getWorld().playEffect(loc3, Effect.SLIME, 500, 500);
                player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 1.0F, 1.0F);
                final Location dropLoc = new Location(e.getBlock().getLocation().getWorld(), e.getBlock().getLocation().getBlockX() + 0.5, e.getBlock().getLocation().getBlockY() + 0.8, e.getBlock().getLocation().getBlockZ() + 0.5);
                dropLoc.getWorld().dropItemNaturally(dropLoc, new ItemStack(Material.WHEAT));
                cooldown.put(player.getUniqueId(), System.currentTimeMillis() + (1 * 250));
            } else {
                e.setCancelled(true);
            }
        }
    }

}
