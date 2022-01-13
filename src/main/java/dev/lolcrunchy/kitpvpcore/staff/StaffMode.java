package dev.lolcrunchy.kitpvpcore.staff;

import dev.lolcrunchy.kitpvpcore.Main;
import dev.lolcrunchy.kitpvpcore.Prefix;
import dev.lolcrunchy.kitpvpcore.level.LevelSystem;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import java.util.*;

public class StaffMode implements CommandExecutor, Listener {
    private static Plugin plugin = Main.getPlugin(Main.class);

    public ArrayList<UUID> staffmode = new ArrayList<>();
    public ArrayList<UUID> tped = new ArrayList<>();

    private Map<UUID, Player> playerName = new HashMap<UUID, Player>();

    private Map<UUID, ItemStack[]> inventory = new HashMap<UUID, ItemStack[]>();
    private Map<UUID, ItemStack[]> inventoryArmor = new HashMap<UUID, ItemStack[]>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("staffmode")) {
            if (player.hasPermission("kitpvp.staffmode") || player.hasPermission("kitpvp.*")) {
                if (staffmode.contains(player.getUniqueId())) {
                    tped.remove(player.getUniqueId());
                    player.sendMessage(Prefix.numPrefix+"Deaktiverede staffmode");
                    staffmode.remove(player.getUniqueId());
                    player.getInventory().setContents(inventory.get(player.getUniqueId()));
                    player.getInventory().setArmorContents(inventoryArmor.get(player.getUniqueId()));
                    for (Player loopP : Bukkit.getOnlinePlayers()) {
                        loopP.showPlayer(player);
                    }
                    return true;
                }
                player.sendMessage(Prefix.prefix + "Aktiverede staffmode");
                tped.remove(player.getUniqueId());
                staffmode.add(player.getUniqueId());
                inventory.put(player.getUniqueId(), player.getInventory().getContents());
                inventoryArmor.put(player.getUniqueId(), player.getInventory().getArmorContents());
                player.getInventory().clear();
                player.getInventory().setHelmet(null);
                player.getInventory().setChestplate(null);
                player.getInventory().setLeggings(null);
                player.getInventory().setBoots(null);
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        player.getInventory().setItem(4, choose());
                    }
                }, 4L);
                for (Player loopP : Bukkit.getOnlinePlayers()) {
                    loopP.hidePlayer(player);
                }
            }
        }
        return false;
    }
    private ItemStack choose() {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner("User_Creative");
        meta.setDisplayName("§3Vælg Spiller §7(Højre Klik)");
        skull.setItemMeta(meta);
        return skull;
    }

    private void kickInventory(final Player player) {
        Inventory inv = Bukkit.createInventory(null, 45, "Staffmode");
        player.openInventory(inv);
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                ItemStack item;
                for (int i = 10; i < 35; i++) {
                }
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
                for (int i = 41; i < 45; i++) {
                    item = itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 7, loreMaker(""));
                    inv.setItem(i, item);
                }
                item = itemMaker("§3Provokation", Material.SIGN, 1, 0, loreMaker(""));
                inv.setItem(20, item);

                item = itemMaker("§3Andet", Material.ANVIL, 1, 0, loreMaker(""));
                inv.setItem(24, item);
            }
        }, 2L);
    }
    private void muteInventory(final Player player) {
        Inventory inv = Bukkit.createInventory(null, 45, "Staffmode");
        player.openInventory(inv);
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                ItemStack item;
                for (int i = 10; i < 35; i++) {
                }
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
                for (int i = 41; i < 45; i++) {
                    item = itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 7, loreMaker(""));
                    inv.setItem(i, item);
                }
                item = itemMaker("§3Permanent", Material.ANVIL, 1, 0, loreMaker(""));
                inv.setItem(24, item);
            }
        }, 2L);
    }
    private void banInventory(final Player player) {
        Inventory inv = Bukkit.createInventory(null, 45, "Staffmode");
        player.openInventory(inv);
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                ItemStack item;
                for (int i = 10; i < 35; i++) {
                }
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
                for (int i = 41; i < 45; i++) {
                    item = itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 7, loreMaker(""));
                    inv.setItem(i, item);
                }
                item = itemMaker("§3Permanent", Material.ANVIL, 1, 0, loreMaker(""));
                inv.setItem(24, item);
            }
        }, 2L);
    }

    @EventHandler
    private void modeEvent(PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (player.getInventory().getItemInHand().hasItemMeta()) {
                if (player.getInventory().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§3Vælg Spiller §7(Højre Klik)")) {
                    inventory(player);
                }
                if (player.getInventory().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§3Kick Spiller §7(Højre Klik)")) {
                    kickInventory(player);
                } else if (player.getInventory().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§3Mute Spiller §7(Højre Klik)")) {
                    muteInventory(player);
                } else if (player.getInventory().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§3Ban Spiller §7(Højre Klik)")) {
                    banInventory(player);
                } else if (player.getInventory().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§3Spiller Indstillinger §7(Højre Klik)")) {
                    indInventory(player);
                }
            }
        }
    }

    public void indInventory(final Player player) {
        final Player arg = playerName.get(player.getUniqueId());
        Inventory inv = Bukkit.createInventory(null, 45, "Staffmode");
        player.openInventory(inv);
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                ItemStack item;
                for (int i = 10; i < 35; i++) {
                }
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
                for (int i = 41; i < 45; i++) {
                    item = itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 7, loreMaker(""));
                    inv.setItem(i, item);
                }

                item = itemMaker("§3§lGAMEMODE", Material.COMPASS, 1, 0, loreMaker(
                        "§8§oKlik for at ændre spillerens gamemode.",
                        "",
                        "§7Gamemode§8: §3"+arg.getGameMode().name(),
                        "",
                        "§8[ §bKlik Her §8]"));
                inv.setItem(10, item);

                //SKAL OPDATERES
                item = itemMaker("§3§lRANK", Material.BOOK, 1, 0, loreMaker(
                        "§8§oKlik for at ændre spillerens rank.",
                        "",
                        "§7Rank§8: §3"+arg.getDisplayName(),
                        "",
                        "§8[ §bKlik Her §8]"));
                inv.setItem(11, item);

                item = itemMaker("§3§lMISSIONER", Material.BOOK_AND_QUILL, 1, 0, loreMaker(
                        "§8§oKlik for at ændre spillerens missioner.",
                        "",
                        "§7Fejl",
                        "",
                        "§8[ §bKlik Her §8]"));
                inv.setItem(13, item);
                item = itemMaker("§3§lNICKNAME", Material.PAPER, 1, 0, loreMaker(
                        "§8§oKlik for at ændre spillerens nickname.",
                        "",
                        "§7Nuværende§8: §cnull",
                        "",
                        "§8[ §bKlik Her §8]"));
                inv.setItem(15, item);
                item = itemMaker("§3§lKOMMER", Material.COMPASS, 1, 0, loreMaker(
                        "§8§oKlik for at ændre spillerens gamemode.",
                        "",
                        "§7Gamemode§8: §3"+arg.getGameMode().name(),
                        "",
                        "§8[ §bKlik Her §8]"));
                inv.setItem(16, item);
                item = itemMaker("§3§lSPEED", Material.FEATHER, 1, 0, loreMaker(
                        "§8§oKlik for at ændre spillerens speed.",
                        "",
                        "§7Speed§8: §3"+arg.getWalkSpeed(),
                        "",
                        "§8[ §bKlik Her §8]"));
                inv.setItem(19, item);
                item = itemMaker("§3§lXP", Material.EXP_BOTTLE, 1, 0, loreMaker(
                        "§8§oKlik for at ændre spillerens xp.",
                        "",
                        "§7Xp§8: §3"+ LevelSystem.xp.get(arg.getUniqueId()),
                        "",
                        "§8[ §bKlik Her §8]"));
                inv.setItem(21, item);
                item = itemMaker("§3§lLEVEL", Material.NETHER_STAR, 1, 0, loreMaker(
                        "§8§oKlik for at ændre spillerens level.",
                        "",
                        "§7Level§8: §3"+LevelSystem.level.get(arg.getUniqueId()),
                        "",
                        "§8[ §bKlik Her §8]"));
                inv.setItem(23, item);
                item = itemMaker("§3§lDRÆB SPILLER", Material.REDSTONE, 1, 0, loreMaker(
                        "§8§oKlik for at dræbe spilleren.",
                        "",
                        "§8[ §bKlik Her §8]"));
                inv.setItem(25, item);
                item = itemMaker("§3§lPENGE", Material.DOUBLE_PLANT, 1, 0, loreMaker(
                        "§8§oKlik for at ændre spillerens penge.",
                        "",
                        "§7Penge§8: §cnull",
                        "",
                        "§8[ §bKlik Her §8]"));
                inv.setItem(31, item);
            }
        }, 2L);
    }

    public static void inventory(final Player player) {
        Inventory inv = Bukkit.createInventory(null, 45, "Staffmode");
        player.openInventory(inv);
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                ItemStack item;
                for (int i = 10; i < 35; i++) {
                }
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
                for (int i = 41; i < 45; i++) {
                    item = itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 7, loreMaker(""));
                    inv.setItem(i, item);
                }
                Bukkit.getOnlinePlayers().forEach(lPlayer -> {
                    ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
                    SkullMeta meta = (SkullMeta) skull.getItemMeta();
                    meta.setOwner(lPlayer.getName());
                    meta.setDisplayName(lPlayer.getName());
                    skull.setItemMeta(meta);
                    inv.addItem(skull);
                });
            }
        }, 2L);
    }

    @EventHandler
    private void onClick(InventoryClickEvent e) {
        final Player player = (Player) e.getWhoClicked();
        final InventoryView view = player.getOpenInventory();
        final Inventory topInventory = view.getTopInventory();
        if (e.getClickedInventory() == null) {
            return;
        }
        if (topInventory == null) {
            return;
        }
        if (topInventory.getName().equals("Staffmode")) {
            e.setCancelled(true);
        }
        if (e.getClickedInventory().getName().equals("Staffmode")) {
            if (e.getCursor().getType() == Material.STAINED_GLASS_PANE) {
                e.setCancelled(true);
            } else if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
                e.setCancelled(true);
            }

            if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {
                e.setCancelled(true);
                player.closeInventory();
                final String argStr = e.getCurrentItem().getItemMeta().getDisplayName();
                final Player arg = Bukkit.getPlayerExact(argStr);
                if (arg.hasPermission("*")) {
                    player.sendMessage(Prefix.numPrefix+"Du kan ikke gøre dette ved denne spiller.");
                    return;
                }
                player.sendMessage(Prefix.prefix + "Teleporterede til §b"+e.getCurrentItem().getItemMeta().getDisplayName());
                tped.add(player.getUniqueId());
                player.getInventory().clear();
                player.getInventory().setItem(0, kick());
                player.getInventory().setItem(4, mute());
                player.getInventory().setItem(7, ban());
                player.getInventory().setItem(8, indstillinger());
                arg.setPassenger(player);
                playerName.put(player.getUniqueId(), arg);
            }

            if (e.getSlot() == 40) {
                e.setCancelled(true);
                player.closeInventory();
            }

            if (e.getCurrentItem().getType() == Material.SIGN) {
                e.setCancelled(true);
                player.closeInventory();
                final Player arg = playerName.get(player.getUniqueId());
                if (arg.hasPermission("*")) {
                    player.sendMessage(Prefix.numPrefix+"Du kan ikke gøre dette ved denne spiller.");
                    return;
                }
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kick "+arg.getName()+" Provokation");
                for (Player o : Bukkit.getOnlinePlayers()) {
                    o.playSound(o.getLocation(), Sound.AMBIENCE_THUNDER, 1.0F, 1.0F);
                }
                playerName.remove(player.getUniqueId());
                tped.remove(player.getUniqueId());
                player.getInventory().clear();
                player.getInventory().setItem(4, choose());
            } else if (e.getCurrentItem().getType() == Material.ANVIL) {
                e.setCancelled(true);
                player.closeInventory();
                final Player arg = playerName.get(player.getUniqueId());
                if (arg.hasPermission("*")) {
                    player.sendMessage(Prefix.numPrefix+"Du kan ikke gøre dette ved denne spiller.");
                    return;
                }
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kick "+arg.getName()+" Andet");
                for (Player o : Bukkit.getOnlinePlayers()) {
                    o.playSound(o.getLocation(), Sound.AMBIENCE_THUNDER, 1.0F, 1.0F);
                }
                playerName.remove(player.getUniqueId());
                tped.remove(player.getUniqueId());
                player.getInventory().clear();
                player.getInventory().setItem(4, choose());
            }
        }
    }

    private ItemStack kick() {
        ItemStack skull = new ItemStack(Material.STICK);
        ItemMeta meta = skull.getItemMeta();
        meta.setDisplayName("§3Kick Spiller §7(Højre Klik)");
        skull.setItemMeta(meta);
        return skull;
    }
    private ItemStack mute() {
        ItemStack skull = new ItemStack(Material.PAPER);
        ItemMeta meta = skull.getItemMeta();
        meta.setDisplayName("§3Mute Spiller §7(Højre Klik)");
        skull.setItemMeta(meta);
        return skull;
    }
    private ItemStack ban() {
        ItemStack skull = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = skull.getItemMeta();
        meta.setDisplayName("§3Ban Spiller §7(Højre Klik)");
        skull.setItemMeta(meta);
        return skull;
    }
    private ItemStack indstillinger() {
        ItemStack skull = new ItemStack(Material.REDSTONE_COMPARATOR);
        ItemMeta meta = skull.getItemMeta();
        meta.setDisplayName("§3Spiller Indstillinger §7(Højre Klik)");
        skull.setItemMeta(meta);
        return skull;
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
    private void events(InventoryClickEvent e) {
        if (staffmode.contains(e.getWhoClicked().getUniqueId())) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    private void eventsD(InventoryDragEvent e) {
        if (staffmode.contains(e.getWhoClicked().getUniqueId())) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    private void eventsDrop(PlayerDropItemEvent e) {
        if (staffmode.contains(e.getPlayer().getUniqueId())) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    private void eventsa(EntityDamageByEntityEvent e) {
        if (staffmode.contains(e.getDamager().getUniqueId())) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    private void eventsdw(PlayerPickupItemEvent e) {
        if (staffmode.contains(e.getPlayer().getUniqueId())) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    private void eventsf(BlockBreakEvent e) {
        if (staffmode.contains(e.getPlayer().getUniqueId())) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    private void eventsfP(BlockPlaceEvent e) {
        if (staffmode.contains(e.getPlayer().getUniqueId())) {
            e.setCancelled(true);
        }
    }
}
