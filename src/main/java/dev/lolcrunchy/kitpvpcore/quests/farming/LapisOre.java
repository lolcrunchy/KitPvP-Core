package dev.lolcrunchy.kitpvpcore.quests.farming;

import dev.lolcrunchy.kitpvpcore.Main;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LapisOre implements Listener {
    private static Plugin plugin = Main.getPlugin(Main.class);

    private Map<UUID, Long> cooldown = new HashMap<UUID, Long>();

    @EventHandler
    private void miner(BlockBreakEvent e) {
        final Player player = e.getPlayer();
        if (e.getBlock().getType() == Material.LAPIS_ORE) {
            if (cooldown.containsKey(player.getUniqueId())) {
                if (cooldown.get(player.getUniqueId()) > System.currentTimeMillis()) {
                    e.setCancelled(true);
                    return;
                }
            }
            e.setCancelled(true);
            e.getBlock().setType(Material.STONE);
            final Location loc = new Location(e.getBlock().getLocation().getWorld(), e.getBlock().getLocation().getBlockX() + 0.5, e.getBlock().getLocation().getBlockY() + 0.5, e.getBlock().getLocation().getBlockZ() + 0.5);
            final Location loc1 = new Location(e.getBlock().getLocation().getWorld(), e.getBlock().getLocation().getBlockX() + 0.7, e.getBlock().getLocation().getBlockY() + 0.7, e.getBlock().getLocation().getBlockZ() + 0.7);
            final Location loc2 = new Location(e.getBlock().getLocation().getWorld(), e.getBlock().getLocation().getBlockX() + 0.2, e.getBlock().getLocation().getBlockY() + 0.2, e.getBlock().getLocation().getBlockZ() + 0.2);
            final Location loc3 = new Location(e.getBlock().getLocation().getWorld(), e.getBlock().getLocation().getBlockX() + 0.9, e.getBlock().getLocation().getBlockY() + 0.9, e.getBlock().getLocation().getBlockZ() + 0.9);
            loc.getWorld().playEffect(loc, Effect.SMOKE, 500, 500);
            loc1.getWorld().playEffect(loc1, Effect.SMOKE, 500, 500);
            loc2.getWorld().playEffect(loc2, Effect.SMOKE, 500, 500);
            loc3.getWorld().playEffect(loc3, Effect.SMOKE, 500, 500);
            player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 1.0F, 1.0F);
            final Location dropLoc = new Location(e.getBlock().getLocation().getWorld(), e.getBlock().getLocation().getBlockX() + 0.5, e.getBlock().getLocation().getBlockY() + 0.8, e.getBlock().getLocation().getBlockZ() + 0.5);
            ItemStack item = new ItemStack(351, 1, (short)4);
            dropLoc.getWorld().dropItemNaturally(dropLoc, item);
            cooldown.put(player.getUniqueId(), System.currentTimeMillis() + (1 * 250));
            restore(e.getBlock());
        }
    }

    private void restore(Block block) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                block.setType(Material.LAPIS_ORE);
            }
        }, 160L);
    }

}
