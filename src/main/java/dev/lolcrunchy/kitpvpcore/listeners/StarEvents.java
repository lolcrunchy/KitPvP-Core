package dev.lolcrunchy.kitpvpcore.listeners;

import dev.lolcrunchy.kitpvpcore.menus.MainMenu;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class StarEvents implements Listener {

    public static ItemStack star() {
        ItemStack star = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = star.getItemMeta();
        meta.setDisplayName("§3KitPvP Menu §7(Højre Klik)");
        star.setItemMeta(meta);
        return star;
    }

    @EventHandler
    private void star(PlayerJoinEvent e) {
        final Player player = e.getPlayer();
        if (!player.getInventory().contains(star())) {
            player.getInventory().setItem(8, star());
        }
    }

    @EventHandler
    private void e(InventoryCreativeEvent e) {
        final Player player = (Player) e.getWhoClicked();
        if (player.getGameMode() == GameMode.CREATIVE) {
            return;
        }
        if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3KitPvP Menu §7(Højre Klik)")) {
                e.setCancelled(true);
            }
        }
        if (e.getCursor().getType() == Material.NETHER_STAR) {
            if (e.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase("§3KitPvP Menu §7(Højre Klik)")) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    private void move(InventoryClickEvent e) {
        final Player player = (Player) e.getWhoClicked();
        if (player.getGameMode() == GameMode.CREATIVE) {
            return;
        }
        if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3KitPvP Menu §7(Højre Klik)")) {
                e.setCancelled(true);
            }
        }
        if (e.getCursor().getType() == Material.NETHER_STAR) {
            if (e.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase("§3KitPvP Menu §7(Højre Klik)")) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    private void moveH(InventoryDragEvent e) {
        final Player player = (Player) e.getWhoClicked();
        if (player.getGameMode() == GameMode.CREATIVE) {
            return;
        }
        if (e.getCursor().getType() == Material.NETHER_STAR) {
            if (e.getCursor().getItemMeta().getDisplayName().equalsIgnoreCase("§3KitPvP Menu §7(Højre Klik)")) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    private void drop(PlayerDropItemEvent e) {
        final Player player = e.getPlayer();
        PlayerInventory playerInventory = player.getInventory();
        if (playerInventory.getHeldItemSlot() == 8) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    private void interact(PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (player.getInventory().getItemInHand().equals(star())) {
                MainMenu.inventory(player);
            }
        }
    }
}