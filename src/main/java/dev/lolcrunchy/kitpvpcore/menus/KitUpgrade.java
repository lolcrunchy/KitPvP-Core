package dev.lolcrunchy.kitpvpcore.menus;

import dev.lolcrunchy.kitpvpcore.Main;
import dev.lolcrunchy.kitpvpcore.Prefix;
import dev.lolcrunchy.kitpvpcore.files.Data;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.*;

public class KitUpgrade implements Listener {
    private static Plugin plugin = Main.getPlugin(Main.class);

    public static Map<UUID, Integer> helmet = new HashMap<UUID, Integer>();
    public static Map<UUID, Integer> chestplate = new HashMap<UUID, Integer>();
    public static Map<UUID, Integer> leggings = new HashMap<UUID, Integer>();
    public static Map<UUID, Integer> boots = new HashMap<UUID, Integer>();

    public static Map<UUID, Integer> sword = new HashMap<UUID, Integer>();
    public static Map<UUID, Integer> bow = new HashMap<UUID, Integer>();
    public static Map<UUID, Integer> rod = new HashMap<UUID, Integer>();

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
                if (helmet.get(player.getUniqueId()) == 0) {
                    item = itemMaker("§3§lHJELM", Material.LEATHER_HELMET, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere din hjelm.",
                            "",
                            "§7Beskyttelse§8: §c+10%",
                            "§7Forsvar§8: §c+20%",
                            "",
                            "§7Nuværende§8: §3"+helmet.get(player.getUniqueId()),
                            "§7Næste§8: §31",
                            "",
                            "§7Pris§8: §350",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(19, item);
                } else if (helmet.get(player.getUniqueId()) == 1) {
                    item = itemMaker("§3§lHJELM", Material.LEATHER_HELMET, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere din hjelm.",
                            "",
                            "§7Beskyttelse§8: §c+20%",
                            "§7Forsvar§8: §c+40%",
                            "",
                            "§7Nuværende§8: §3"+helmet.get(player.getUniqueId()),
                            "§7Næste§8: §32",
                            "",
                            "§7Pris§8: §3100",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(19, item);
                } else if (helmet.get(player.getUniqueId()) == 2) {
                    item = itemMaker("§3§lHJELM", Material.LEATHER_HELMET, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere din hjelm.",
                            "",
                            "§7Beskyttelse§8: §c+30%",
                            "§7Forsvar§8: §c+60%",
                            "",
                            "§7Nuværende§8: §3"+helmet.get(player.getUniqueId()),
                            "§7Næste§8: §33",
                            "",
                            "§7Pris§8: §3200",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(19, item);
                } else if (helmet.get(player.getUniqueId()) == 3) {
                    item = itemMaker("§3§lHJELM", Material.LEATHER_HELMET, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere din hjelm.",
                            "",
                            "§7Beskyttelse§8: §c+40%",
                            "§7Forsvar§8: §c+80%",
                            "",
                            "§7Nuværende§8: §3"+helmet.get(player.getUniqueId()),
                            "§7Næste§8: §34",
                            "",
                            "§7Pris§8: §3400",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(19, item);
                } else if (helmet.get(player.getUniqueId()) == 4) {
                    item = itemMaker("§3§lHJELM", Material.LEATHER_HELMET, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere din hjelm.",
                            "",
                            "§7Beskyttelse§8: §cMAKS",
                            "§7Forsvar§8: §cMAKS",
                            "",
                            "§7Nuværende§8: §3"+helmet.get(player.getUniqueId()),
                            "§7Næste§8: §cMAKS",
                            "",
                            "§7Pris§8: §cMAKS",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(19, item);
                }

                if (chestplate.get(player.getUniqueId()) == 0) {
                    item = itemMaker("§3§lBRYSTPLADE", Material.LEATHER_CHESTPLATE, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere din brystplade.",
                            "",
                            "§7Beskyttelse§8: §c+10%",
                            "§7Forsvar§8: §c+20%",
                            "",
                            "§7Nuværende§8: §3"+chestplate.get(player.getUniqueId()),
                            "§7Næste§8: §31",
                            "",
                            "§7Pris§8: §3100",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(20, item);
                } else if (chestplate.get(player.getUniqueId()) == 1) {
                    item = itemMaker("§3§lBRYSTPLADE", Material.LEATHER_CHESTPLATE, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere din brystplade.",
                            "",
                            "§7Beskyttelse§8: §c+20%",
                            "§7Forsvar§8: §c+40%",
                            "",
                            "§7Nuværende§8: §3"+chestplate.get(player.getUniqueId()),
                            "§7Næste§8: §32",
                            "",
                            "§7Pris§8: §3200",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(20, item);
                } else if (chestplate.get(player.getUniqueId()) == 2) {
                    item = itemMaker("§3§lBRYSTPLADE", Material.LEATHER_CHESTPLATE, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere din brystplade.",
                            "",
                            "§7Beskyttelse§8: §c+30%",
                            "§7Forsvar§8: §c+60%",
                            "",
                            "§7Nuværende§8: §3"+chestplate.get(player.getUniqueId()),
                            "§7Næste§8: §33",
                            "",
                            "§7Pris§8: §3400",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(20, item);
                } else if (chestplate.get(player.getUniqueId()) == 3) {
                    item = itemMaker("§3§lBRYSTPLADE", Material.LEATHER_CHESTPLATE, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere din brystplade.",
                            "",
                            "§7Beskyttelse§8: §c+40%",
                            "§7Forsvar§8: §c+80%",
                            "",
                            "§7Nuværende§8: §3"+chestplate.get(player.getUniqueId()),
                            "§7Næste§8: §34",
                            "",
                            "§7Pris§8: §3800",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(20, item);
                } else if (chestplate.get(player.getUniqueId()) == 4) {
                    item = itemMaker("§3§lBRYSTPLADE", Material.LEATHER_CHESTPLATE, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere din brystplade.",
                            "",
                            "§7Beskyttelse§8: §cMAKS",
                            "§7Forsvar§8: §cMAKS",
                            "",
                            "§7Nuværende§8: §3"+chestplate.get(player.getUniqueId()),
                            "§7Næste§8: §cMAKS",
                            "",
                            "§7Pris§8: §cMAKS",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(20, item);
                }

                if (leggings.get(player.getUniqueId()) == 0) {
                    item = itemMaker("§3§lBUKSER", Material.LEATHER_LEGGINGS, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere dine bukser.",
                            "",
                            "§7Beskyttelse§8: §c+10%",
                            "§7Forsvar§8: §c+20%",
                            "",
                            "§7Nuværende§8: §3"+leggings.get(player.getUniqueId()),
                            "§7Næste§8: §31",
                            "",
                            "§7Pris§8: §375",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(21, item);
                } else if (leggings.get(player.getUniqueId()) == 1) {
                    item = itemMaker("§3§lBUKSER", Material.LEATHER_LEGGINGS, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere dine bukser.",
                            "",
                            "§7Beskyttelse§8: §c+20%",
                            "§7Forsvar§8: §c+40%",
                            "",
                            "§7Nuværende§8: §3"+leggings.get(player.getUniqueId()),
                            "§7Næste§8: §32",
                            "",
                            "§7Pris§8: §3150",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(21, item);
                } else if (leggings.get(player.getUniqueId()) == 2) {
                    item = itemMaker("§3§lBUKSER", Material.LEATHER_LEGGINGS, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere dine bukser.",
                            "",
                            "§7Beskyttelse§8: §c+30%",
                            "§7Forsvar§8: §c+60%",
                            "",
                            "§7Nuværende§8: §3"+leggings.get(player.getUniqueId()),
                            "§7Næste§8: §33",
                            "",
                            "§7Pris§8: §3300",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(21, item);
                } else if (leggings.get(player.getUniqueId()) == 3) {
                    item = itemMaker("§3§lBUKSER", Material.LEATHER_LEGGINGS, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere dine bukser.",
                            "",
                            "§7Beskyttelse§8: §c+40%",
                            "§7Forsvar§8: §c+80%",
                            "",
                            "§7Nuværende§8: §3"+leggings.get(player.getUniqueId()),
                            "§7Næste§8: §34",
                            "",
                            "§7Pris§8: §3600",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(21, item);
                } else if (leggings.get(player.getUniqueId()) == 4) {
                    item = itemMaker("§3§lBUKSER", Material.LEATHER_LEGGINGS, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere dine bukser.",
                            "",
                            "§7Beskyttelse§8: §cMAKS",
                            "§7Forsvar§8: §cMAKS",
                            "",
                            "§7Nuværende§8: §3"+leggings.get(player.getUniqueId()),
                            "§7Næste§8: §cMAKS",
                            "",
                            "§7Pris§8: §cMAKS",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(21, item);
                }

                if (boots.get(player.getUniqueId()) == 0) {
                    item = itemMaker("§3§lSKO", Material.LEATHER_BOOTS, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere dine sko.",
                            "",
                            "§7Beskyttelse§8: §c+10%",
                            "§7Forsvar§8: §c+20%",
                            "",
                            "§7Nuværende§8: §3"+boots.get(player.getUniqueId()),
                            "§7Næste§8: §31",
                            "",
                            "§7Pris§8: §350",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(22, item);
                } else if (boots.get(player.getUniqueId()) == 1) {
                    item = itemMaker("§3§lSKO", Material.LEATHER_BOOTS, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere dine sko.",
                            "",
                            "§7Beskyttelse§8: §c+20%",
                            "§7Forsvar§8: §c+40%",
                            "",
                            "§7Nuværende§8: §3"+boots.get(player.getUniqueId()),
                            "§7Næste§8: §32",
                            "",
                            "§7Pris§8: §3100",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(22, item);
                } else if (boots.get(player.getUniqueId()) == 2) {
                    item = itemMaker("§3§lSKO", Material.LEATHER_BOOTS, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere dine sko.",
                            "",
                            "§7Beskyttelse§8: §c+30%",
                            "§7Forsvar§8: §c+60%",
                            "",
                            "§7Nuværende§8: §3"+boots.get(player.getUniqueId()),
                            "§7Næste§8: §33",
                            "",
                            "§7Pris§8: §3200",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(22, item);
                } else if (boots.get(player.getUniqueId()) == 3) {
                    item = itemMaker("§3§lSKO", Material.LEATHER_BOOTS, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere dine sko.",
                            "",
                            "§7Beskyttelse§8: §c+40%",
                            "§7Forsvar§8: §c+80%",
                            "",
                            "§7Nuværende§8: §3"+boots.get(player.getUniqueId()),
                            "§7Næste§8: §34",
                            "",
                            "§7Pris§8: §3400",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(22, item);
                } else if (boots.get(player.getUniqueId()) == 4) {
                    item = itemMaker("§3§lSKO", Material.LEATHER_BOOTS, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere dine sko.",
                            "",
                            "§7Beskyttelse§8: §cMAKS",
                            "§7Forsvar§8: §cMAKS",
                            "",
                            "§7Nuværende§8: §3"+boots.get(player.getUniqueId()),
                            "§7Næste§8: §cMAKS",
                            "",
                            "§7Pris§8: §cMAKS",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(22, item);
                }

                if (sword.get(player.getUniqueId()) == 0) {
                    item = itemMaker("§3§lSVÆRD", Material.STONE_SWORD, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere dit sværd.",
                            "",
                            "§7Skade§8: §c+10%",
                            "§7Styrke§8: §c+20%",
                            "",
                            "§7Nuværende§8: §3"+sword.get(player.getUniqueId()),
                            "§7Næste§8: §31",
                            "",
                            "§7Pris§8: §3200",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(23, item);
                } else if (sword.get(player.getUniqueId()) == 1) {
                    item = itemMaker("§3§lSVÆRD", Material.STONE_SWORD, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere dit sværd.",
                            "",
                            "§7Skade§8: §c+20%",
                            "§7Styrke§8: §c+40%",
                            "",
                            "§7Nuværende§8: §3"+sword.get(player.getUniqueId()),
                            "§7Næste§8: §32",
                            "",
                            "§7Pris§8: §3400",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(23, item);
                } else if (sword.get(player.getUniqueId()) == 2) {
                    item = itemMaker("§3§lSVÆRD", Material.STONE_SWORD, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere dit sværd.",
                            "",
                            "§7Skade§8: §c+30%",
                            "§7Styrke§8: §c+40%",
                            "",
                            "§7Nuværende§8: §3"+sword.get(player.getUniqueId()),
                            "§7Næste§8: §33",
                            "",
                            "§7Pris§8: §3800",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(23, item);
                } else if (sword.get(player.getUniqueId()) == 3) {
                    item = itemMaker("§3§lSVÆRD", Material.STONE_SWORD, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere dit sværd.",
                            "",
                            "§7Skade§8: §c+40%",
                            "§7Styrke§8: §c+80%",
                            "",
                            "§7Nuværende§8: §3"+sword.get(player.getUniqueId()),
                            "§7Næste§8: §34",
                            "",
                            "§7Pris§8: §31600",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(23, item);
                } else if (sword.get(player.getUniqueId()) == 4) {
                    item = itemMaker("§3§lSVÆRD", Material.STONE_SWORD, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere dit sværd.",
                            "",
                            "§7Skade§8: §cMAKS",
                            "§7Styrke§8: §cMAKS",
                            "",
                            "§7Nuværende§8: §3"+sword.get(player.getUniqueId()),
                            "§7Næste§8: §cMAKS",
                            "",
                            "§7Pris§8: §cMAKS",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(23, item);
                }
                if (bow.get(player.getUniqueId()) == 0) {
                    item = itemMaker("§3§lBUE", Material.BOW, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere dit sværd.",
                            "",
                            "§7Skade§8: §c+10%",
                            "§7Styrke§8: §c+20%",
                            "",
                            "§7Nuværende§8: §3"+bow.get(player.getUniqueId()),
                            "§7Næste§8: §31",
                            "",
                            "§7Pris§8: §325",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(24, item);
                } else if (bow.get(player.getUniqueId()) == 1) {
                    item = itemMaker("§3§lBUE", Material.BOW, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere dit sværd.",
                            "",
                            "§7Skade§8: §c+20%",
                            "§7Styrke§8: §c+40%",
                            "",
                            "§7Nuværende§8: §3"+bow.get(player.getUniqueId()),
                            "§7Næste§8: §32",
                            "",
                            "§7Pris§8: §350",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(24, item);
                } else if (bow.get(player.getUniqueId()) == 2) {
                    item = itemMaker("§3§lBUE", Material.BOW, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere dit sværd.",
                            "",
                            "§7Skade§8: §c+30%",
                            "§7Styrke§8: §c+60%",
                            "",
                            "§7Nuværende§8: §3"+bow.get(player.getUniqueId()),
                            "§7Næste§8: §33",
                            "",
                            "§7Pris§8: §3100",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(24, item);
                } else if (bow.get(player.getUniqueId()) == 3) {
                    item = itemMaker("§3§lBUE", Material.BOW, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere dit sværd.",
                            "",
                            "§7Skade§8: §c+40%",
                            "§7Styrke§8: §c+80%",
                            "",
                            "§7Nuværende§8: §3"+bow.get(player.getUniqueId()),
                            "§7Næste§8: §34",
                            "",
                            "§7Pris§8: §3200",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(24, item);
                } else if (bow.get(player.getUniqueId()) == 4) {
                    item = itemMaker("§3§lBUE", Material.BOW, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at,",
                            "§7opgradere dit sværd.",
                            "",
                            "§7Skade§8: §cMAKS",
                            "§7Styrke§8: §cMAKS",
                            "",
                            "§7Nuværende§8: §3"+bow.get(player.getUniqueId()),
                            "§7Næste§8: §cMAKS",
                            "",
                            "§7Pris§8: §cMAKS",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(24, item);
                }
                if (rod.get(player.getUniqueId()) == 1) {
                    item = itemMaker("§3§lFISKESTANG", Material.FISHING_ROD, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at købe en,",
                            "§7fiskestang til dit kit.",
                            "",
                            "§7Status§8: §a✔",
                            "",
                            "§7Pris§8: §cMAKS",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(25, item);
                } else if (rod.get(player.getUniqueId()) == 0) {
                    item = itemMaker("§3§lFISKESTANG", Material.FISHING_ROD, 1, 0, loreMaker(
                            "",
                            "§7Klik her for at købe en,",
                            "§7fiskestang til dit kit.",
                            "",
                            "§7Status§8: §c✘",
                            "",
                            "§7Pris§8: §3250",
                            "",
                            "§8[ §bKlik Her §8]"));
                    inv.setItem(25, item);
                }
            }
        }, 2L);
    }

    public static ItemStack itemMaker(String name, Material mat, int amount, int sh, List<String> lore) {
        final ItemStack item = new ItemStack(mat, amount, (short)sh);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
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

    private static Economy economy = Main.economy;

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
            if (e.getSlot() == 19) {
                if (e.getCurrentItem().getType() == Material.LEATHER_HELMET) {
                    Data.save();
                    inventory(player);
                    if (helmet.get(player.getUniqueId()) == 0) {
                        if (balance >= 50) {
                            helmet.put(player.getUniqueId(), 1);
                            economy.withdrawPlayer(player, 50);
                            player.sendMessage(Prefix.prefix+"Du har opgraderet din hjelm til level 1.");
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                        }
                    } else if (helmet.get(player.getUniqueId()) == 1) {
                        if (balance >= 100) {
                            helmet.put(player.getUniqueId(), 2);
                            economy.withdrawPlayer(player, 100);
                            player.sendMessage(Prefix.prefix+"Du har opgraderet din hjelm til level 2.");
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                        }
                    } else if (helmet.get(player.getUniqueId()) == 2) {
                        if (player.hasPermission("donator") || player.hasPermission("king")) {
                            if (balance >= 200) {
                                helmet.put(player.getUniqueId(), 3);
                                economy.withdrawPlayer(player, 200);
                                player.sendMessage(Prefix.prefix+"Du har opgraderet din hjelm til level 3.");
                            } else {
                                player.closeInventory();
                                player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                            }
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke adgang til flere opgraderinger.");
                        }
                    } else if (helmet.get(player.getUniqueId()) == 3) {
                        if (player.hasPermission("king")) {
                            if (balance >= 400) {
                                helmet.put(player.getUniqueId(), 4);
                                economy.withdrawPlayer(player, 400);
                                player.sendMessage(Prefix.prefix+"Du har opgraderet din hjelm til level 4.");
                            } else {
                                player.closeInventory();
                                player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                            }
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke adgang til flere opgraderinger.");
                        }
                    } else if (helmet.get(player.getUniqueId()) == 4) {
                        player.closeInventory();
                        player.sendMessage(Prefix.numPrefix+"Din hjelm er allerede maks opgraderet.");
                    }
                }
            } else if (e.getSlot() == 20) {
                if (e.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE) {
                    Data.save();
                    inventory(player);
                    if (chestplate.get(player.getUniqueId()) == 0) {
                        if (balance >= 100) {
                            chestplate.put(player.getUniqueId(), 1);
                            economy.withdrawPlayer(player, 100);
                            player.sendMessage(Prefix.prefix+"Du har opgraderet din brystplade til level 1.");
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                        }
                    } else if (chestplate.get(player.getUniqueId()) == 1) {
                        if (balance >= 200) {
                            chestplate.put(player.getUniqueId(), 2);
                            economy.withdrawPlayer(player, 200);
                            player.sendMessage(Prefix.prefix+"Du har opgraderet din brystplade til level 2.");
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                        }
                    } else if (chestplate.get(player.getUniqueId()) == 2) {
                        if (player.hasPermission("donator") || player.hasPermission("king")) {
                            if (balance >= 400) {
                                chestplate.put(player.getUniqueId(), 3);
                                economy.withdrawPlayer(player, 400);
                                player.sendMessage(Prefix.prefix+"Du har opgraderet din brystplade til level 3.");
                            } else {
                                player.closeInventory();
                                player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                            }
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke adgang til flere opgraderinger.");
                        }
                    } else if (chestplate.get(player.getUniqueId()) == 3) {
                        if (player.hasPermission("king")) {
                            if (balance >= 800) {
                                chestplate.put(player.getUniqueId(), 4);
                                economy.withdrawPlayer(player, 800);
                                player.sendMessage(Prefix.prefix+"Du har opgraderet din brystplade til level 4.");
                            } else {
                                player.closeInventory();
                                player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                            }
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke adgang til flere opgraderinger.");
                        }
                    } else if (chestplate.get(player.getUniqueId()) == 4) {
                        player.closeInventory();
                        player.sendMessage(Prefix.numPrefix+"Din brystplade er allerede maks opgraderet.");
                    }
                }
            } else if (e.getSlot() == 21) {
                if (e.getCurrentItem().getType() == Material.LEATHER_LEGGINGS) {
                    Data.save();
                    inventory(player);
                    if (leggings.get(player.getUniqueId()) == 0) {
                        if (balance >= 75) {
                            leggings.put(player.getUniqueId(), 1);
                            economy.withdrawPlayer(player, 75);
                            player.sendMessage(Prefix.prefix+"Du har opgraderet dine bukser til level 1.");
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                        }
                    } else if (leggings.get(player.getUniqueId()) == 1) {
                        if (balance >= 150) {
                            leggings.put(player.getUniqueId(), 2);
                            economy.withdrawPlayer(player, 150);
                            player.sendMessage(Prefix.prefix+"Du har opgraderet dine bukser til level 2.");
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                        }
                    } else if (leggings.get(player.getUniqueId()) == 2) {
                        if (player.hasPermission("donator") || player.hasPermission("king")) {
                            if (balance >= 300) {
                                leggings.put(player.getUniqueId(), 3);
                                economy.withdrawPlayer(player, 300);
                                player.sendMessage(Prefix.prefix+"Du har opgraderet dine bukser til level 3.");
                            } else {
                                player.closeInventory();
                                player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                            }
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke adgang til flere opgraderinger.");
                        }
                    } else if (leggings.get(player.getUniqueId()) == 3) {
                        if (player.hasPermission("king")) {
                            if (balance >= 600) {
                                leggings.put(player.getUniqueId(), 4);
                                economy.withdrawPlayer(player, 600);
                                player.sendMessage(Prefix.prefix+"Du har opgraderet dine bukser til level 4.");
                            } else {
                                player.closeInventory();
                                player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                            }
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke adgang til flere opgraderinger.");
                        }
                    } else if (leggings.get(player.getUniqueId()) == 4) {
                        player.closeInventory();
                        player.sendMessage(Prefix.numPrefix+"Dine bukser er allerede maks opgraderet.");
                    }
                }
            } else if (e.getSlot() == 22) {
                if (e.getCurrentItem().getType() == Material.LEATHER_BOOTS) {
                    Data.save();
                    inventory(player);
                    if (boots.get(player.getUniqueId()) == 0) {
                        if (balance >= 50) {
                            boots.put(player.getUniqueId(), 1);
                            economy.withdrawPlayer(player, 50);
                            player.sendMessage(Prefix.prefix+"Du har opgraderet dine sko til level 1.");
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                        }
                    } else if (boots.get(player.getUniqueId()) == 1) {
                        if (balance >= 100) {
                            boots.put(player.getUniqueId(), 2);
                            economy.withdrawPlayer(player, 100);
                            player.sendMessage(Prefix.prefix+"Du har opgraderet dine sko til level 2.");
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                        }
                    } else if (boots.get(player.getUniqueId()) == 2) {
                        if (player.hasPermission("donator") || player.hasPermission("king")) {
                            if (balance >= 200) {
                                boots.put(player.getUniqueId(), 3);
                                economy.withdrawPlayer(player, 200);
                                player.sendMessage(Prefix.prefix+"Du har opgraderet dine sko til level 3.");
                            } else {
                                player.closeInventory();
                                player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                            }
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke adgang til flere opgraderinger.");
                        }
                    } else if (boots.get(player.getUniqueId()) == 3) {
                        if (player.hasPermission("king")) {
                            if (balance >= 400) {
                                boots.put(player.getUniqueId(), 4);
                                economy.withdrawPlayer(player, 400);
                                player.sendMessage(Prefix.prefix+"Du har opgraderet dine sko til level 4.");
                            } else {
                                player.closeInventory();
                                player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                            }
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke adgang til flere opgraderinger.");
                        }
                    } else if (boots.get(player.getUniqueId()) == 4) {
                        player.closeInventory();
                        player.sendMessage(Prefix.numPrefix+"Dine sko er allerede maks opgraderet.");
                    }
                }
            } else if (e.getSlot() == 23) {
                if (e.getCurrentItem().getType() == Material.STONE_SWORD) {
                    Data.save();
                    inventory(player);
                    if (sword.get(player.getUniqueId()) == 0) {
                        if (balance >= 200) {
                            sword.put(player.getUniqueId(), 1);
                            economy.withdrawPlayer(player, 200);
                            player.sendMessage(Prefix.prefix+"Du har opgraderet dit sværd til level 1.");
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                        }
                    } else if (sword.get(player.getUniqueId()) == 1) {
                        if (balance >= 400) {
                            sword.put(player.getUniqueId(), 2);
                            economy.withdrawPlayer(player, 400);
                            player.sendMessage(Prefix.prefix+"Du har opgraderet dit sværd til level 2.");
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                        }
                    } else if (sword.get(player.getUniqueId()) == 2) {
                        if (player.hasPermission("donator") || player.hasPermission("king")) {
                            if (balance >= 800) {
                                sword.put(player.getUniqueId(), 3);
                                economy.withdrawPlayer(player, 800);
                                player.sendMessage(Prefix.prefix+"Du har opgraderet dit sværd til level 3.");
                            } else {
                                player.closeInventory();
                                player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                            }
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke adgang til flere opgraderinger.");
                        }
                    } else if (sword.get(player.getUniqueId()) == 3) {
                        if (player.hasPermission("king")) {
                            if (balance >= 1600) {
                                sword.put(player.getUniqueId(), 4);
                                economy.withdrawPlayer(player, 1600);
                                player.sendMessage(Prefix.prefix+"Du har opgraderet dit sværd til level 4.");
                            } else {
                                player.closeInventory();
                                player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                            }
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke adgang til flere opgraderinger.");
                        }
                    } else if (sword.get(player.getUniqueId()) == 4) {
                        player.closeInventory();
                        player.sendMessage(Prefix.numPrefix+"Dit sværd er allerede maks opgraderet.");
                    }
                }
            } else if (e.getSlot() == 24) {
                if (e.getCurrentItem().getType() == Material.BOW) {
                    Data.save();
                    inventory(player);
                    if (bow.get(player.getUniqueId()) == 0) {
                        if (balance >= 25) {
                            bow.put(player.getUniqueId(), 1);
                            economy.withdrawPlayer(player, 25);
                            player.sendMessage(Prefix.prefix+"Du har opgraderet din bue til level 1.");
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                        }
                    } else if (bow.get(player.getUniqueId()) == 1) {
                        if (balance >= 50) {
                            bow.put(player.getUniqueId(), 2);
                            economy.withdrawPlayer(player, 50);
                            player.sendMessage(Prefix.prefix+"Du har opgraderet din bue til level 2.");
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                        }
                    } else if (bow.get(player.getUniqueId()) == 2) {
                        if (player.hasPermission("donator") || player.hasPermission("king")) {
                            if (balance >= 100) {
                                bow.put(player.getUniqueId(), 3);
                                economy.withdrawPlayer(player, 100);
                                player.sendMessage(Prefix.prefix+"Du har opgraderet din bue til level 3.");
                            } else {
                                player.closeInventory();
                                player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                            }
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke adgang til flere opgraderinger.");
                        }
                    } else if (bow.get(player.getUniqueId()) == 3) {
                        if (player.hasPermission("king")) {
                            if (balance >= 200) {
                                bow.put(player.getUniqueId(), 4);
                                economy.withdrawPlayer(player, 200);
                                player.sendMessage(Prefix.prefix+"Du har opgraderet din bue til level 4.");
                            } else {
                                player.closeInventory();
                                player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                            }
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke adgang til flere opgraderinger.");
                        }
                    } else if (bow.get(player.getUniqueId()) == 4) {
                        player.closeInventory();
                        player.sendMessage(Prefix.numPrefix+"Din bue er allerede maks opgraderet.");
                    }
                }
            } else if (e.getSlot() == 25) {
                if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
                    Data.save();
                    if (rod.get(player.getUniqueId()) == 1) {
                        player.closeInventory();
                        player.sendMessage(Prefix.numPrefix+"Du har allerede en fiskestang.");
                    } else if (rod.get(player.getUniqueId()) == 0) {
                        if (balance >= 200) {
                            player.sendMessage(Prefix.prefix+"Du købte en fiskestang.");
                            rod.put(player.getUniqueId(), 1);
                            economy.withdrawPlayer(player, 200);
                            inventory(player);
                        } else {
                            player.closeInventory();
                            player.sendMessage(Prefix.numPrefix+"Du har ikke nok penge.");
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    private void mapsJoin(PlayerJoinEvent e) {
        final Player player = e.getPlayer();
        if (!helmet.containsKey(player.getUniqueId())) {
            helmet.put(player.getUniqueId(), 0);
            Data.save();
        }
        if (!chestplate.containsKey(player.getUniqueId())) {
            chestplate.put(player.getUniqueId(), 0);
            Data.save();
        }
        if (!leggings.containsKey(player.getUniqueId())) {
            leggings.put(player.getUniqueId(), 0);
            Data.save();
        }
        if (!boots.containsKey(player.getUniqueId())) {
            boots.put(player.getUniqueId(), 0);
            Data.save();
        }
        if (!sword.containsKey(player.getUniqueId())) {
            sword.put(player.getUniqueId(), 0);
            Data.save();
        }
        if (!bow.containsKey(player.getUniqueId())) {
            bow.put(player.getUniqueId(), 0);
            Data.save();
        }
        if (!rod.containsKey(player.getUniqueId())) {
            rod.put(player.getUniqueId(), 0);
            Data.save();
        }
    }

}
