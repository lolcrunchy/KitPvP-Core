package dev.lolcrunchy.kitpvpcore.menus;

import dev.lolcrunchy.kitpvpcore.Main;
import dev.lolcrunchy.kitpvpcore.Prefix;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Listener {
    private static Plugin plugin = Main.getPlugin(Main.class);

    private static Economy economy = Main.economy;

    public static void inventory(final Player player) {
        Inventory inv = Bukkit.createInventory(null, 45, "KitPvP Menu");
        player.openInventory(inv);
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                ItemStack item;
                for (int i = 0; i < 9; i++) {
                    item = itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 7, loreMaker(""));
                    inv.setItem(i, item);
                }
                for (int i = 36; i < 39; i++) {
                    item = itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 7, loreMaker(""));
                    inv.setItem(i, item);
                }
                item = itemMaker("§c§lFORRIGE SIDE", Material.ARROW, 1, 0, loreMaker(""));
                inv.setItem(39, item);
                item = itemMaker("§c§lLUK MENUEN", Material.BARRIER, 1, 0, loreMaker(""));
                inv.setItem(40, item);
                for (int i = 41; i < 45; i++) {
                    item = itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 7, loreMaker(""));
                    inv.setItem(i, item);
                }
                item = itemMaker("§3§lHASTIGHED", Material.FEATHER, 1, 0, loreMaker(
                        "",
                        "§7Køb hashtighed §b1§7,",
                        "§7i §b2§7 minutter.",
                        "",
                        "§7Pris§8: §3$25",
                        "§7Varighed§8: §32 Minutter",
                        "",
                        "§8[ §bKlik Her §8]"));
                inv.setItem(19, item);
                item = itemMaker("§3§lSTYRKE", Material.POTION, 1, 8201, loreMaker(
                        "",
                        "§7Køb styrke §b1§7,",
                        "§7i §b3§7 minutter.",
                        "",
                        "§7Pris§8: §3$50",
                        "§7Varighed§8: §33 Minutter",
                        "",
                        "§8[ §bKlik Her §8]"));
                inv.setItem(22, item);
                item = itemMaker("§3§l4 EKSTRA HJERTER", Material.GOLDEN_APPLE, 1, 0, loreMaker(
                        "",
                        "§7Køb §b4§7 ekstra hjerter.",
                        "",
                        "§7Pris§8: §3$30",
                        "",
                        "§8[ §bKlik Her §8]"));
                inv.setItem(25, item);
            }
        }, 2L);
    }

    public static ItemStack itemMaker(String name, Material mat, int amount, int sh, List<String> lore) {
        final ItemStack item = new ItemStack(mat, amount, (short)sh);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        item.setItemMeta(meta);
        return item;
    }

    public static ArrayList<String> loreMaker(String... str) {
        ArrayList<String> lore = new ArrayList<>();
        for(String s : str) {
            lore.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        return lore;
    }

    @EventHandler
    public static void onInvClick(InventoryClickEvent e) {
        final Player player = (Player) e.getWhoClicked();
        final InventoryView view = player.getOpenInventory();
        final Inventory topInventory = view.getTopInventory();
        final double balance = economy.getBalance(player);
        if (e.getClickedInventory() == null) {
            return;
        }
        if (topInventory == null) {
            return;
        }
        if (topInventory.getName().equals("KitPvP Menu")) {
            e.setCancelled(true);
        }
        if (e.getClickedInventory().getName().equals("KitPvP Menu")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            } else if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }

            if (e.getCurrentItem().getType() == Material.FEATHER) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lHASTIGHED")) {
                    if (balance >= 25) {
                        economy.withdrawPlayer(player, 25);
                        player.sendMessage(Prefix.prefix+"Du købte hastighed §b1§7 i §b2§7 minutter.");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect "+player.getName()+ " speed 120 0");
                        player.closeInventory();
                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                    }
                }
            } else if (e.getCurrentItem().getType() == Material.POTION) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lSTYRKE")) {
                    if (balance >= 50) {
                        economy.withdrawPlayer(player, 50);
                        player.sendMessage(Prefix.prefix+"Du købte styrke §b1 §7i §b3§7 minutter.");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect "+player.getName()+ " strength 180 0");
                        player.closeInventory();
                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                    }
                }
            } else if (e.getCurrentItem().getType() == Material.GOLDEN_APPLE) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§l4 EKSTRA HJERTER")) {
                    if (balance >= 30) {
                        economy.withdrawPlayer(player, 30);
                        player.sendMessage(Prefix.prefix+"Du købte §b4§7 ekstra hjerter.");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect "+player.getName()+ " absorption 99999 1");
                        player.closeInventory();
                    } else {
                        player.closeInventory();
                        player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                    }
                }
            }
        }
    }

}
