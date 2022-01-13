package dev.lolcrunchy.kitpvpcore.menus;

import dev.lolcrunchy.kitpvpcore.Main;
import dev.lolcrunchy.kitpvpcore.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class MainMenu implements Listener {
    private static Plugin plugin = Main.getPlugin(Main.class);

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
                for (int i = 36; i < 40; i++) {
                    item = itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 7, loreMaker(""));
                    inv.setItem(i, item);
                }
                item = itemMaker("§c§lLUK MENUEN", Material.BARRIER, 1, 0, loreMaker(""));
                inv.setItem(40, item);
                for (int i = 41; i < 44; i++) {
                    item = itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 7, loreMaker(""));
                    inv.setItem(i, item);
                }
                //items
                item = itemMaker("§3§lTAG DIT KIT", Material.IRON_SWORD, 1, 0, loreMaker(
                        "",
                        "§7Klik her for at,",
                        "§7påføre dit kit.",
                        "",
                        "§8[ §bKlik Her §8]"));
                inv.setItem(20, item);
                item = itemMaker("§3§lOPGRADER DIT KIT", Material.COMMAND_MINECART, 1, 0, loreMaker(
                        "",
                        "§7Opgradér dit kit,",
                        "§7ved at klikke her.",
                        "",
                        "§8[ §bKlik Her §8]"));
                inv.setItem(22, item);
                item = itemMaker("§3§lSHOP", Material.DOUBLE_PLANT, 1, 0, loreMaker(
                        "",
                        "§7"));
                inv.setItem(24, item);
                if (!player.hasPermission("*")) {
                    item = itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 7, loreMaker(""));
                    inv.setItem(45, item);
                } else {
                    item = itemMaker("§C§lADMIN MENU", Material.EXPLOSIVE_MINECART, 1, 0, loreMaker(""));
                    inv.setItem(45, item);
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


    @EventHandler
    public static void onInvClick(InventoryClickEvent e) {
        final Player player = (Player) e.getWhoClicked();
        final InventoryView view = player.getOpenInventory();
        final Inventory topInventory = view.getTopInventory();
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
            if (e.getSlot() == 20) {
                if (e.getCurrentItem().getType() == Material.IRON_SWORD) {
                    e.setCancelled(true);
                    if (KitUpgrade.sword.get(player.getUniqueId()) == 0) {
                        ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
                        ItemMeta meta = sword.getItemMeta();
                        meta.setDisplayName("§3§lSVÆRD");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s sværd.",
                                "",
                                "§7Level§8: §30",
                                ""));
                        sword.setItemMeta(meta);
                        player.getInventory().addItem(sword);
                    } else if (KitUpgrade.sword.get(player.getUniqueId()) == 1) {
                        ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
                        ItemMeta meta = sword.getItemMeta();
                        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lSVÆRD");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s sværd.",
                                "",
                                "§7Skade§8: §c10%",
                                "§7Styrke§8: §c20%",
                                "",
                                "§7Level§8: §31",
                                ""));
                        sword.setItemMeta(meta);
                        player.getInventory().addItem(sword);
                    } else if (KitUpgrade.sword.get(player.getUniqueId()) == 2) {
                        ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
                        ItemMeta meta = sword.getItemMeta();
                        meta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lSVÆRD");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s sværd.",
                                "",
                                "§7Skade§8: §c20%",
                                "§7Styrke§8: §c40%",
                                "",
                                "§7Level§8: §32"));
                        sword.setItemMeta(meta);
                        player.getInventory().addItem(sword);
                    } else if (KitUpgrade.sword.get(player.getUniqueId()) == 3) {
                        ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
                        ItemMeta meta = sword.getItemMeta();
                        meta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lSVÆRD");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s sværd.",
                                "",
                                "§7Skade§8: §c30%",
                                "§7Styrke§8: §c60%",
                                "",
                                "§7Level§8: §33"));
                        sword.setItemMeta(meta);
                        player.getInventory().addItem(sword);
                    } else if (KitUpgrade.sword.get(player.getUniqueId()) == 4) {
                        ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
                        ItemMeta meta = sword.getItemMeta();
                        meta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lSVÆRD");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s sværd.",
                                "",
                                "§7Skade§8: §c40%",
                                "§7Styrke§8: §c80%",
                                "",
                                "§7Level§8: §34"));
                        sword.setItemMeta(meta);
                        player.getInventory().addItem(sword);
                    }

                    if (KitUpgrade.bow.get(player.getUniqueId()) == 0) {
                        ItemStack bow = new ItemStack(Material.BOW, 1);
                        ItemMeta meta = bow.getItemMeta();
                        meta.setDisplayName("§3§lBUE");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s bue.",
                                "",
                                "§7Level§8: §30"));
                        bow.setItemMeta(meta);
                        player.getInventory().addItem(bow);
                    } else if (KitUpgrade.bow.get(player.getUniqueId()) == 1) {
                        ItemStack bow = new ItemStack(Material.BOW, 1);
                        ItemMeta meta = bow.getItemMeta();
                        meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lBUE");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s bue.",
                                "",
                                "§7Skade§8: §c10%",
                                "§7Styrke§8: §c20%",
                                "",
                                "§7Level§8: §31"));
                        bow.setItemMeta(meta);
                        player.getInventory().addItem(bow);
                    } else if (KitUpgrade.bow.get(player.getUniqueId()) == 2) {
                        ItemStack bow = new ItemStack(Material.BOW, 1);
                        ItemMeta meta = bow.getItemMeta();
                        meta.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lBUE");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s bue.",
                                "",
                                "§7Skade§8: §c20%",
                                "§7Styrke§8: §c40%",
                                "",
                                "§7Level§8: §32"));
                        bow.setItemMeta(meta);
                        player.getInventory().addItem(bow);
                    } else if (KitUpgrade.bow.get(player.getUniqueId()) == 3) {
                        ItemStack bow = new ItemStack(Material.BOW, 1);
                        ItemMeta meta = bow.getItemMeta();
                        meta.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lBUE");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s bue.",
                                "",
                                "§7Skade§8: §c30%",
                                "§7Styrke§8: §c60%",
                                "",
                                "§7Level§8: §33"));
                        bow.setItemMeta(meta);
                        player.getInventory().addItem(bow);
                    } else if (KitUpgrade.bow.get(player.getUniqueId()) == 4) {
                        ItemStack bow = new ItemStack(Material.BOW, 1);
                        ItemMeta meta = bow.getItemMeta();
                        meta.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lBUE");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s bue.",
                                "",
                                "§7Skade§8: §c40%",
                                "§7Styrke§8: §c80%",
                                "",
                                "§7Level§8: §34"));
                        bow.setItemMeta(meta);
                        player.getInventory().addItem(bow);
                    }

                    if (KitUpgrade.helmet.get(player.getUniqueId()) == 0) {
                        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
                        ItemMeta meta = helmet.getItemMeta();
                        meta.setDisplayName("§3§lHJELM");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s hjelm.",
                                "",
                                "§7Level§8: §30"));
                        helmet.setItemMeta(meta);
                        player.getInventory().setHelmet(helmet);
                    } else if (KitUpgrade.helmet.get(player.getUniqueId()) == 1) {
                        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
                        ItemMeta meta = helmet.getItemMeta();
                        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lHJELM");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s hjelm.",
                                "",
                                "§7Beskyttelse§8: §c10%",
                                "§7Forsvar§8: §c20%",
                                "",
                                "§7Level§8: §31"));
                        helmet.setItemMeta(meta);
                        player.getInventory().setHelmet(helmet);
                    } else if (KitUpgrade.helmet.get(player.getUniqueId()) == 2) {
                        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
                        ItemMeta meta = helmet.getItemMeta();
                        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lHJELM");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s hjelm.",
                                "",
                                "§7Beskyttelse§8: §c20%",
                                "§7Forsvar§8: §c40%",
                                "§7Level§8: §32"));
                        helmet.setItemMeta(meta);
                        player.getInventory().setHelmet(helmet);
                    } else if (KitUpgrade.helmet.get(player.getUniqueId()) == 3) {
                        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
                        ItemMeta meta = helmet.getItemMeta();
                        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lHJELM");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s hjelm.",
                                "",
                                "§7Beskyttelse§8: §c30%",
                                "§7Forsvar§8: §c60%",
                                "",
                                "§7Level§8: §33"));
                        helmet.setItemMeta(meta);
                        player.getInventory().setHelmet(helmet);
                    } else if (KitUpgrade.helmet.get(player.getUniqueId()) == 4) {
                        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
                        ItemMeta meta = helmet.getItemMeta();
                        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lHJELM");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s hjelm.",
                                "",
                                "§7Beskyttelse§8: §c40%",
                                "§7Forsvar§8: §c80%",
                                "",
                                "§7Level§8: §34"));
                        helmet.setItemMeta(meta);
                        player.getInventory().setHelmet(helmet);
                    }

                    if (KitUpgrade.chestplate.get(player.getUniqueId()) == 0) {
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                        ItemMeta meta = chestplate.getItemMeta();
                        meta.setDisplayName("§3§lBRYSTPLADE");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s brystplade.",
                                "",
                                "§7Level§8: §30"));
                        chestplate.setItemMeta(meta);
                        player.getInventory().setChestplate(chestplate);
                    } else if (KitUpgrade.chestplate.get(player.getUniqueId()) == 1) {
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                        ItemMeta meta = chestplate.getItemMeta();
                        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lBRYSTPLADE");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s brystplade.",
                                "",
                                "§7Beskyttelse§8: §c10%",
                                "§7Forsvar§8: §c20%",
                                "",
                                "§7Level§8: §31"));
                        chestplate.setItemMeta(meta);
                        player.getInventory().setChestplate(chestplate);
                    } else if (KitUpgrade.chestplate.get(player.getUniqueId()) == 2) {
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                        ItemMeta meta = chestplate.getItemMeta();
                        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lBRYSTPLADE");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s brystplade.",
                                "",
                                "§7Beskyttelse§8: §c20%",
                                "§7Forsvar§8: §c40%",
                                "",
                                "§7Level§8: §32"));
                        chestplate.setItemMeta(meta);
                        player.getInventory().setChestplate(chestplate);
                    } else if (KitUpgrade.chestplate.get(player.getUniqueId()) == 3) {
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                        ItemMeta meta = chestplate.getItemMeta();
                        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lBRYSTPLADE");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s brystplade.",
                                "",
                                "§7Beskyttelse§8: §c30%",
                                "§7Forsvar§8: §c60%",
                                "",
                                "§7Level§8: §33"));
                        chestplate.setItemMeta(meta);
                        player.getInventory().setChestplate(chestplate);
                    } else if (KitUpgrade.chestplate.get(player.getUniqueId()) == 4) {
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                        ItemMeta meta = chestplate.getItemMeta();
                        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lBRYSTPLADE");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s brystplade.",
                                "",
                                "§7Beskyttelse§8: §c40%",
                                "§7Forsvar§8: §c80%",
                                "",
                                "§7Level§8: §34"));
                        chestplate.setItemMeta(meta);
                        player.getInventory().setChestplate(chestplate);
                    }

                    if (KitUpgrade.leggings.get(player.getUniqueId()) == 0) {
                        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
                        ItemMeta meta = leggings.getItemMeta();
                        meta.setDisplayName("§3§lBUKSER");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s bukser.",
                                "",
                                "§7Level§8: §30"));
                        leggings.setItemMeta(meta);
                        player.getInventory().setLeggings(leggings);
                    } else if (KitUpgrade.leggings.get(player.getUniqueId()) == 1) {
                        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
                        ItemMeta meta = leggings.getItemMeta();
                        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lBUKSER");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s bukser.",
                                "",
                                "§7Beskyttelse§8: §c10%",
                                "§7Forsvar§8: §c20%",
                                "",
                                "§7Level§8: §31"));
                        leggings.setItemMeta(meta);
                        player.getInventory().setLeggings(leggings);
                    } else if (KitUpgrade.leggings.get(player.getUniqueId()) == 2) {
                        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
                        ItemMeta meta = leggings.getItemMeta();
                        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lBUKSER");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s bukser.",
                                "",
                                "§7Beskyttelse§8: §c20%",
                                "§7Forsvar§8: §c40%",
                                "",
                                "§7Level§8: §32"));
                        leggings.setItemMeta(meta);
                        player.getInventory().setLeggings(leggings);
                    } else if (KitUpgrade.leggings.get(player.getUniqueId()) == 3) {
                        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
                        ItemMeta meta = leggings.getItemMeta();
                        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lBUKSER");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s bukser.",
                                "",
                                "§7Beskyttelse§8: §c30%",
                                "§7Forsvar§8: §c60%",
                                "",
                                "§7Level§8: §33"));
                        leggings.setItemMeta(meta);
                        player.getInventory().setLeggings(leggings);
                    } else if (KitUpgrade.leggings.get(player.getUniqueId()) == 4) {
                        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
                        ItemMeta meta = leggings.getItemMeta();
                        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lBUKSER");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s bukser.",
                                "",
                                "§7Beskyttelse§8: §c40%",
                                "§7Forsvar§8: §c80%",
                                "",
                                "§7Level§8: §34"));
                        leggings.setItemMeta(meta);
                        player.getInventory().setLeggings(leggings);
                    }

                    if (KitUpgrade.boots.get(player.getUniqueId()) == 0) {
                        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
                        ItemMeta meta = boots.getItemMeta();
                        meta.setDisplayName("§3§lSKO");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s sko.",
                                "",
                                "§7Level§8: §30"));
                        boots.setItemMeta(meta);
                        player.getInventory().setBoots(boots);
                    } else if (KitUpgrade.boots.get(player.getUniqueId()) == 1) {
                        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
                        ItemMeta meta = boots.getItemMeta();
                        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lSKO");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s sko.",
                                "",
                                "§7Beskyttelse§8: §c10%",
                                "§7Forsvar§8: §c20%",
                                "",
                                "§7Level§8: §31"));
                        boots.setItemMeta(meta);
                        player.getInventory().setBoots(boots);
                    } else if (KitUpgrade.boots.get(player.getUniqueId()) == 2) {
                        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
                        ItemMeta meta = boots.getItemMeta();
                        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lSKO");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s sko.",
                                "",
                                "§7Beskyttelse§8: §c20%",
                                "§7Forsvar§8: §c40%",
                                "",
                                "§7Level§8: §32"));
                        boots.setItemMeta(meta);
                        player.getInventory().setBoots(boots);
                    } else if (KitUpgrade.boots.get(player.getUniqueId()) == 3) {
                        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
                        ItemMeta meta = boots.getItemMeta();
                        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lSKO");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s sko.",
                                "",
                                "§7Beskyttelse§8: §c30%",
                                "§7Forsvar§8: §c60%",
                                "",
                                "§7Level§8: §33"));
                        boots.setItemMeta(meta);
                        player.getInventory().setBoots(boots);
                    } else if (KitUpgrade.boots.get(player.getUniqueId()) == 4) {
                        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
                        ItemMeta meta = boots.getItemMeta();
                        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        meta.setDisplayName("§3§lSKO");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s sko.",
                                "",
                                "§7Beskyttelse§8: §c40%",
                                "§7Forsvar§8: §c80%",
                                "",
                                "§7Level§8: §34"));
                        boots.setItemMeta(meta);
                        player.getInventory().setBoots(boots);
                    }
                    if (KitUpgrade.rod.get(player.getUniqueId()) == 1) {
                        ItemStack rod = new ItemStack(Material.FISHING_ROD, 1);
                        ItemMeta meta = rod.getItemMeta();
                        meta.setDisplayName("§3§lFISKESTANG");
                        meta.setLore(loreMaker(
                                "§8§o"+player.getName()+"'s fiskestang.",
                                ""));
                        rod.setItemMeta(meta);
                        player.getInventory().addItem(rod);
                    }
                    ItemStack a = new ItemStack(Material.GOLDEN_CARROT, 16);
                    ItemMeta ameta = a.getItemMeta();
                    ameta.setDisplayName("§3§lGULEROD");
                    ameta.setLore(loreMaker(
                            "§8§o"+player.getName()+"'s gulerod.",
                            ""));
                    a.setItemMeta(ameta);
                    player.getInventory().addItem(a);
                    ItemStack ar = new ItemStack(Material.ARROW, 32);
                    ItemMeta armeta = ar.getItemMeta();
                    armeta.setDisplayName("§3§lPILE");
                    armeta.setLore(loreMaker(
                            "§8§o"+player.getName()+"'s pile.",
                            ""));
                    ar.setItemMeta(armeta);
                    player.getInventory().addItem(ar);
                    player.sendMessage(Prefix.prefix+"Du modtog dit kit.");
                    player.closeInventory();
                }
            } else if (e.getSlot() == 22) {
                if (e.getCurrentItem().getType() == Material.COMMAND_MINECART) {
                    e.setCancelled(true);
                    KitUpgrade.inventory(player);
                }
            } else if (e.getSlot() == 24) {
                if (e.getCurrentItem().getType() == Material.DOUBLE_PLANT) {
                    e.setCancelled(true);
                    Shop.inventory(player);
                }
            }
            if (e.getSlot() == 40) {
                e.setCancelled(true);
                player.closeInventory();
            }
            if (e.getSlot() == 39) {
                e.setCancelled(true);
                if (e.getCurrentItem().getType() == Material.ARROW) {
                    inventory(player);
                }
            }
        }
    }
    @EventHandler
    public void repair(PlayerItemDamageEvent e) {
        e.setCancelled(true);
    }
    @EventHandler
    private static void onJoin(PlayerJoinEvent e) {
        final Player player = e.getPlayer();
        if (!player.hasPlayedBefore()) {
            if (KitUpgrade.sword.get(player.getUniqueId()) == 0) {
                ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
                ItemMeta meta = sword.getItemMeta();
                meta.setDisplayName("§3§lSVÆRD");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s sværd.",
                        "",
                        "§7Level§8: §30",
                        ""));
                sword.setItemMeta(meta);
                player.getInventory().addItem(sword);
            } else if (KitUpgrade.sword.get(player.getUniqueId()) == 1) {
                ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
                ItemMeta meta = sword.getItemMeta();
                meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lSVÆRD");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s sværd.",
                        "",
                        "§7Skade§8: §c10%",
                        "§7Styrke§8: §c20%",
                        "",
                        "§7Level§8: §31",
                        ""));
                sword.setItemMeta(meta);
                player.getInventory().addItem(sword);
            } else if (KitUpgrade.sword.get(player.getUniqueId()) == 2) {
                ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
                ItemMeta meta = sword.getItemMeta();
                meta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lSVÆRD");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s sværd.",
                        "",
                        "§7Skade§8: §c20%",
                        "§7Styrke§8: §c40%",
                        "",
                        "§7Level§8: §32"));
                sword.setItemMeta(meta);
                player.getInventory().addItem(sword);
            } else if (KitUpgrade.sword.get(player.getUniqueId()) == 3) {
                ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
                ItemMeta meta = sword.getItemMeta();
                meta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lSVÆRD");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s sværd.",
                        "",
                        "§7Skade§8: §c30%",
                        "§7Styrke§8: §c60%",
                        "",
                        "§7Level§8: §33"));
                sword.setItemMeta(meta);
                player.getInventory().addItem(sword);
            } else if (KitUpgrade.sword.get(player.getUniqueId()) == 4) {
                ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
                ItemMeta meta = sword.getItemMeta();
                meta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lSVÆRD");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s sværd.",
                        "",
                        "§7Skade§8: §c40%",
                        "§7Styrke§8: §c80%",
                        "",
                        "§7Level§8: §34"));
                sword.setItemMeta(meta);
                player.getInventory().addItem(sword);
            }

            if (KitUpgrade.bow.get(player.getUniqueId()) == 0) {
                ItemStack bow = new ItemStack(Material.BOW, 1);
                ItemMeta meta = bow.getItemMeta();
                meta.setDisplayName("§3§lBUE");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s bue.",
                        "",
                        "§7Level§8: §30"));
                bow.setItemMeta(meta);
                player.getInventory().addItem(bow);
            } else if (KitUpgrade.bow.get(player.getUniqueId()) == 1) {
                ItemStack bow = new ItemStack(Material.BOW, 1);
                ItemMeta meta = bow.getItemMeta();
                meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lBUE");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s bue.",
                        "",
                        "§7Skade§8: §c10%",
                        "§7Styrke§8: §c20%",
                        "",
                        "§7Level§8: §31"));
                bow.setItemMeta(meta);
                player.getInventory().addItem(bow);
            } else if (KitUpgrade.bow.get(player.getUniqueId()) == 2) {
                ItemStack bow = new ItemStack(Material.BOW, 1);
                ItemMeta meta = bow.getItemMeta();
                meta.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lBUE");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s bue.",
                        "",
                        "§7Skade§8: §c20%",
                        "§7Styrke§8: §c40%",
                        "",
                        "§7Level§8: §32"));
                bow.setItemMeta(meta);
                player.getInventory().addItem(bow);
            } else if (KitUpgrade.bow.get(player.getUniqueId()) == 3) {
                ItemStack bow = new ItemStack(Material.BOW, 1);
                ItemMeta meta = bow.getItemMeta();
                meta.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lBUE");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s bue.",
                        "",
                        "§7Skade§8: §c30%",
                        "§7Styrke§8: §c60%",
                        "",
                        "§7Level§8: §33"));
                bow.setItemMeta(meta);
                player.getInventory().addItem(bow);
            } else if (KitUpgrade.bow.get(player.getUniqueId()) == 4) {
                ItemStack bow = new ItemStack(Material.BOW, 1);
                ItemMeta meta = bow.getItemMeta();
                meta.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lBUE");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s bue.",
                        "",
                        "§7Skade§8: §c40%",
                        "§7Styrke§8: §c80%",
                        "",
                        "§7Level§8: §34"));
                bow.setItemMeta(meta);
                player.getInventory().addItem(bow);
            }

            if (KitUpgrade.helmet.get(player.getUniqueId()) == 0) {
                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
                ItemMeta meta = helmet.getItemMeta();
                meta.setDisplayName("§3§lHJELM");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s hjelm.",
                        "",
                        "§7Level§8: §30"));
                helmet.setItemMeta(meta);
                player.getInventory().setHelmet(helmet);
            } else if (KitUpgrade.helmet.get(player.getUniqueId()) == 1) {
                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
                ItemMeta meta = helmet.getItemMeta();
                meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lHJELM");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s hjelm.",
                        "",
                        "§7Beskyttelse§8: §c10%",
                        "§7Forsvar§8: §c20%",
                        "",
                        "§7Level§8: §31"));
                helmet.setItemMeta(meta);
                player.getInventory().setHelmet(helmet);
            } else if (KitUpgrade.helmet.get(player.getUniqueId()) == 2) {
                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
                ItemMeta meta = helmet.getItemMeta();
                meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lHJELM");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s hjelm.",
                        "",
                        "§7Beskyttelse§8: §c20%",
                        "§7Forsvar§8: §c40%",
                        "§7Level§8: §32"));
                helmet.setItemMeta(meta);
                player.getInventory().setHelmet(helmet);
            } else if (KitUpgrade.helmet.get(player.getUniqueId()) == 3) {
                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
                ItemMeta meta = helmet.getItemMeta();
                meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lHJELM");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s hjelm.",
                        "",
                        "§7Beskyttelse§8: §c30%",
                        "§7Forsvar§8: §c60%",
                        "",
                        "§7Level§8: §33"));
                helmet.setItemMeta(meta);
                player.getInventory().setHelmet(helmet);
            } else if (KitUpgrade.helmet.get(player.getUniqueId()) == 4) {
                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
                ItemMeta meta = helmet.getItemMeta();
                meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lHJELM");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s hjelm.",
                        "",
                        "§7Beskyttelse§8: §c40%",
                        "§7Forsvar§8: §c80%",
                        "",
                        "§7Level§8: §34"));
                helmet.setItemMeta(meta);
                player.getInventory().setHelmet(helmet);
            }

            if (KitUpgrade.chestplate.get(player.getUniqueId()) == 0) {
                ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                ItemMeta meta = chestplate.getItemMeta();
                meta.setDisplayName("§3§lBRYSTPLADE");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s brystplade.",
                        "",
                        "§7Level§8: §30"));
                chestplate.setItemMeta(meta);
                player.getInventory().setChestplate(chestplate);
            } else if (KitUpgrade.chestplate.get(player.getUniqueId()) == 1) {
                ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                ItemMeta meta = chestplate.getItemMeta();
                meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lBRYSTPLADE");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s brystplade.",
                        "",
                        "§7Beskyttelse§8: §c10%",
                        "§7Forsvar§8: §c20%",
                        "",
                        "§7Level§8: §31"));
                chestplate.setItemMeta(meta);
                player.getInventory().setChestplate(chestplate);
            } else if (KitUpgrade.chestplate.get(player.getUniqueId()) == 2) {
                ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                ItemMeta meta = chestplate.getItemMeta();
                meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lBRYSTPLADE");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s brystplade.",
                        "",
                        "§7Beskyttelse§8: §c20%",
                        "§7Forsvar§8: §c40%",
                        "",
                        "§7Level§8: §32"));
                chestplate.setItemMeta(meta);
                player.getInventory().setChestplate(chestplate);
            } else if (KitUpgrade.chestplate.get(player.getUniqueId()) == 3) {
                ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                ItemMeta meta = chestplate.getItemMeta();
                meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lBRYSTPLADE");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s brystplade.",
                        "",
                        "§7Beskyttelse§8: §c30%",
                        "§7Forsvar§8: §c60%",
                        "",
                        "§7Level§8: §33"));
                chestplate.setItemMeta(meta);
                player.getInventory().setChestplate(chestplate);
            } else if (KitUpgrade.chestplate.get(player.getUniqueId()) == 4) {
                ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                ItemMeta meta = chestplate.getItemMeta();
                meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lBRYSTPLADE");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s brystplade.",
                        "",
                        "§7Beskyttelse§8: §c40%",
                        "§7Forsvar§8: §c80%",
                        "",
                        "§7Level§8: §34"));
                chestplate.setItemMeta(meta);
                player.getInventory().setChestplate(chestplate);
            }

            if (KitUpgrade.leggings.get(player.getUniqueId()) == 0) {
                ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
                ItemMeta meta = leggings.getItemMeta();
                meta.setDisplayName("§3§lBUKSER");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s bukser.",
                        "",
                        "§7Level§8: §30"));
                leggings.setItemMeta(meta);
                player.getInventory().setLeggings(leggings);
            } else if (KitUpgrade.leggings.get(player.getUniqueId()) == 1) {
                ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
                ItemMeta meta = leggings.getItemMeta();
                meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lBUKSER");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s bukser.",
                        "",
                        "§7Beskyttelse§8: §c10%",
                        "§7Forsvar§8: §c20%",
                        "",
                        "§7Level§8: §31"));
                leggings.setItemMeta(meta);
                player.getInventory().setLeggings(leggings);
            } else if (KitUpgrade.leggings.get(player.getUniqueId()) == 2) {
                ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
                ItemMeta meta = leggings.getItemMeta();
                meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lBUKSER");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s bukser.",
                        "",
                        "§7Beskyttelse§8: §c20%",
                        "§7Forsvar§8: §c40%",
                        "",
                        "§7Level§8: §32"));
                leggings.setItemMeta(meta);
                player.getInventory().setLeggings(leggings);
            } else if (KitUpgrade.leggings.get(player.getUniqueId()) == 3) {
                ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
                ItemMeta meta = leggings.getItemMeta();
                meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lBUKSER");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s bukser.",
                        "",
                        "§7Beskyttelse§8: §c30%",
                        "§7Forsvar§8: §c60%",
                        "",
                        "§7Level§8: §33"));
                leggings.setItemMeta(meta);
                player.getInventory().setLeggings(leggings);
            } else if (KitUpgrade.leggings.get(player.getUniqueId()) == 4) {
                ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
                ItemMeta meta = leggings.getItemMeta();
                meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lBUKSER");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s bukser.",
                        "",
                        "§7Beskyttelse§8: §c40%",
                        "§7Forsvar§8: §c80%",
                        "",
                        "§7Level§8: §34"));
                leggings.setItemMeta(meta);
                player.getInventory().setLeggings(leggings);
            }

            if (KitUpgrade.boots.get(player.getUniqueId()) == 0) {
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
                ItemMeta meta = boots.getItemMeta();
                meta.setDisplayName("§3§lSKO");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s sko.",
                        "",
                        "§7Level§8: §30"));
                boots.setItemMeta(meta);
                player.getInventory().setBoots(boots);
            } else if (KitUpgrade.boots.get(player.getUniqueId()) == 1) {
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
                ItemMeta meta = boots.getItemMeta();
                meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lSKO");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s sko.",
                        "",
                        "§7Beskyttelse§8: §c10%",
                        "§7Forsvar§8: §c20%",
                        "",
                        "§7Level§8: §31"));
                boots.setItemMeta(meta);
                player.getInventory().setBoots(boots);
            } else if (KitUpgrade.boots.get(player.getUniqueId()) == 2) {
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
                ItemMeta meta = boots.getItemMeta();
                meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lSKO");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s sko.",
                        "",
                        "§7Beskyttelse§8: §c20%",
                        "§7Forsvar§8: §c40%",
                        "",
                        "§7Level§8: §32"));
                boots.setItemMeta(meta);
                player.getInventory().setBoots(boots);
            } else if (KitUpgrade.boots.get(player.getUniqueId()) == 3) {
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
                ItemMeta meta = boots.getItemMeta();
                meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lSKO");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s sko.",
                        "",
                        "§7Beskyttelse§8: §c30%",
                        "§7Forsvar§8: §c60%",
                        "",
                        "§7Level§8: §33"));
                boots.setItemMeta(meta);
                player.getInventory().setBoots(boots);
            } else if (KitUpgrade.boots.get(player.getUniqueId()) == 4) {
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
                ItemMeta meta = boots.getItemMeta();
                meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setDisplayName("§3§lSKO");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s sko.",
                        "",
                        "§7Beskyttelse§8: §c40%",
                        "§7Forsvar§8: §c80%",
                        "",
                        "§7Level§8: §34"));
                boots.setItemMeta(meta);
                player.getInventory().setBoots(boots);
            }
            if (KitUpgrade.rod.get(player.getUniqueId()) == 1) {
                ItemStack rod = new ItemStack(Material.FISHING_ROD, 1);
                ItemMeta meta = rod.getItemMeta();
                meta.setDisplayName("§3§lFISKESTANG");
                meta.setLore(loreMaker(
                        "§8§o"+player.getName()+"'s fiskestang.",
                        ""));
                rod.setItemMeta(meta);
                player.getInventory().addItem(rod);
            }
            ItemStack a = new ItemStack(Material.GOLDEN_CARROT, 16);
            ItemMeta ameta = a.getItemMeta();
            ameta.setDisplayName("§3§lGULEROD");
            ameta.setLore(loreMaker(
                    "§8§o"+player.getName()+"'s gulerod.",
                    ""));
            a.setItemMeta(ameta);
            player.getInventory().addItem(a);
            ItemStack ar = new ItemStack(Material.ARROW, 32);
            ItemMeta armeta = ar.getItemMeta();
            armeta.setDisplayName("§3§lPILE");
            armeta.setLore(loreMaker(
                    "§8§o"+player.getName()+"'s pile.",
                    ""));
            ar.setItemMeta(armeta);
            player.getInventory().addItem(ar);
        }
    }
}
