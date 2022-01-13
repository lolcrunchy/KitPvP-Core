package dev.lolcrunchy.kitpvpcore.commands;

import dev.lolcrunchy.kitpvpcore.Main;
import dev.lolcrunchy.kitpvpcore.Prefix;
import dev.lolcrunchy.kitpvpcore.files.Data;
import dev.lolcrunchy.kitpvpcore.level.LevelSystem;
import dev.lolcrunchy.kitpvpcore.menus.KitUpgrade;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class PlayerCommands implements CommandExecutor, Listener {
    private static Plugin plugin = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("kitpvp")) {
            if (player.hasPermission("kitpvp.*")) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("reload")) {
                        player.sendMessage(Prefix.prefix + "Reloadede data.yml.");
                        Data.reload();
                        Data.save();
                    } else if (args[0].equalsIgnoreCase("kill")) {
                        player.sendMessage(Prefix.prefix+"Cleared alle online spillere.");
                        LevelSystem.xp.clear();
                        LevelSystem.level.clear();
                        KitUpgrade.sword.clear();
                        KitUpgrade.bow.clear();
                        KitUpgrade.rod.clear();
                        KitUpgrade.helmet.clear();
                        KitUpgrade.chestplate.clear();
                        KitUpgrade.leggings.clear();
                        KitUpgrade.boots.clear();
                        Data.save();
                    } else {
                        player.sendMessage(Prefix.numPrefix + "Ugyldig argument.");
                    }
                    return true;
                } else if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("clearxp")) {
                        if (!args[1].isEmpty()) {
                            final Player argP = Bukkit.getPlayer(args[1]);
                            if (argP == null) {
                                player.sendMessage(Prefix.numPrefix + "Denne spiller er ikke online.");
                                return true;
                            }
                            LevelSystem.xp.remove(argP.getUniqueId());
                            LevelSystem.xp.put(argP.getUniqueId(), 0);
                            player.sendMessage(Prefix.prefix + "Cleared §b" + argP.getName());
                            Data.save();
                        } else {
                            player.sendMessage(Prefix.numPrefix + "Ugyldig argument.");
                        }
                    } else if (args[0].equalsIgnoreCase("clearlevel")) {
                        if (!args[1].isEmpty()) {
                            final Player argP = Bukkit.getPlayer(args[1]);
                            if (argP == null) {
                                player.sendMessage(Prefix.numPrefix + "Denne spiller er ikke online.");
                                return true;
                            }
                            LevelSystem.level.remove(argP.getUniqueId());
                            LevelSystem.level.put(argP.getUniqueId(), 0);
                            player.sendMessage(Prefix.prefix + "Cleared §b" + argP.getName());
                            Data.save();
                        } else {
                            player.sendMessage(Prefix.numPrefix + "Ugyldig argument.");
                        }
                    } else if (args[0].equalsIgnoreCase("clear")) {
                        if (!args[1].isEmpty()) {
                            final Player argP = Bukkit.getPlayer(args[1]);
                            if (argP == null) {
                                player.sendMessage(Prefix.numPrefix + "Denne spiller er ikke online.");
                                return true;
                            }
                            KitUpgrade.sword.remove(argP.getUniqueId());
                            KitUpgrade.sword.put(argP.getUniqueId(), 0);
                            KitUpgrade.bow.remove(argP.getUniqueId());
                            KitUpgrade.bow.put(argP.getUniqueId(), 0);
                            KitUpgrade.helmet.remove(argP.getUniqueId());
                            KitUpgrade.helmet.put(argP.getUniqueId(), 0);
                            KitUpgrade.chestplate.remove(argP.getUniqueId());
                            KitUpgrade.chestplate.put(argP.getUniqueId(), 0);
                            KitUpgrade.leggings.remove(argP.getUniqueId());
                            KitUpgrade.leggings.put(argP.getUniqueId(), 0);
                            KitUpgrade.boots.remove(argP.getUniqueId());
                            KitUpgrade.boots.put(argP.getUniqueId(), 0);
                            KitUpgrade.rod.remove(argP.getUniqueId());
                            KitUpgrade.rod.put(argP.getUniqueId(), 0);
                            player.sendMessage(Prefix.prefix + "Cleared §b" + argP.getName());
                            Data.save();
                        } else {
                            player.sendMessage(Prefix.numPrefix + "Ugyldig argument.");
                        }
                    } else if (args[0].equalsIgnoreCase("clearall")) {
                        if (!args[1].isEmpty()) {
                            final Player argP = Bukkit.getPlayer(args[1]);
                            if (argP == null) {
                                player.sendMessage(Prefix.numPrefix + "Denne spiller er ikke online.");
                                return true;
                            }
                            LevelSystem.level.remove(argP.getUniqueId());
                            LevelSystem.level.put(argP.getUniqueId(), 0);
                            player.sendMessage(Prefix.prefix + "Cleared §b" + argP.getName());
                            KitUpgrade.sword.remove(argP.getUniqueId());
                            KitUpgrade.sword.put(argP.getUniqueId(), 0);
                            KitUpgrade.bow.remove(argP.getUniqueId());
                            KitUpgrade.bow.put(argP.getUniqueId(), 0);
                            KitUpgrade.helmet.remove(argP.getUniqueId());
                            KitUpgrade.helmet.put(argP.getUniqueId(), 0);
                            KitUpgrade.chestplate.remove(argP.getUniqueId());
                            KitUpgrade.chestplate.put(argP.getUniqueId(), 0);
                            KitUpgrade.leggings.remove(argP.getUniqueId());
                            KitUpgrade.leggings.put(argP.getUniqueId(), 0);
                            KitUpgrade.boots.remove(argP.getUniqueId());
                            KitUpgrade.boots.put(argP.getUniqueId(), 0);
                            KitUpgrade.rod.remove(argP.getUniqueId());
                            KitUpgrade.rod.put(argP.getUniqueId(), 0);
                            LevelSystem.xp.remove(argP.getUniqueId());
                            LevelSystem.xp.put(argP.getUniqueId(), 0);
                            Data.save();
                        } else {
                            player.sendMessage(Prefix.numPrefix + "Ugyldig argument.");
                        }
                    } else {
                        player.sendMessage(Prefix.numPrefix + "Ugyldig argument.");
                    }
                    return true;
                }
                player.sendMessage(Prefix.prefix);
                player.sendMessage(Prefix.prefix + "Commands§8:");
                player.sendMessage(Prefix.prefix);
                player.sendMessage(Prefix.prefix + " §8/§7Kitpvp");
                player.sendMessage(Prefix.prefix + " §8/§7Kitpvp clear §8(§7Spiller§8) §8- §bClear spillerens kit data.");
                player.sendMessage(Prefix.prefix + " §8/§7Kitpvp clearxp §8(§7Spiller§8) §8- §bClear spillerens xp.");
                player.sendMessage(Prefix.prefix + " §8/§7Kitpvp clearlevel §8(§7Spiller§8) §8- §bClear spillerens level.");
                player.sendMessage(Prefix.prefix + " §8/§7Kitpvp clearall §8(§7Spiller§8) §8- §bClear alle spillerens data.");
                player.sendMessage(Prefix.prefix + " §8/§7Kitpvp kill §8- §bClear alle spilleres data.");
                player.sendMessage(Prefix.prefix + " §8/§7Kitpvp reload §8- §bReloader data.yml");
                player.sendMessage(Prefix.prefix + " ");
                player.sendMessage(Prefix.prefix + " §7Version§8: §31.0.0");
                player.sendMessage(Prefix.prefix + " ");
            } else {
                player.sendMessage(Prefix.numPrefix + "Du har ikke adgang til dette.");
            }
        }
        if (cmd.getName().equalsIgnoreCase("xp")) {
            if (args.length == 1) {
                if (!args[0].isEmpty()) {
                    final Player argP = Bukkit.getPlayer(args[0]);
                    if (argP == null) {
                        player.sendMessage(Prefix.numPrefix + "Denne spiller er ikke online.");
                        return true;
                    }
                    player.sendMessage(Prefix.prefix + argP.getName() + " har§8: §3" + LevelSystem.xp.get(argP.getUniqueId()) + " §7xp.");
                    return true;
                } else {
                    player.sendMessage(Prefix.numPrefix + "Ugyldig argument.");
                }
            } else {
                player.sendMessage(Prefix.prefix + "Du har§8: §3" + LevelSystem.xp.get(player.getUniqueId()) + " §7xp.");
            }
        }
        if (cmd.getName().equalsIgnoreCase("level")) {
            if (args.length == 1) {
                if (!args[0].isEmpty()) {
                    final Player argP = Bukkit.getPlayer(args[0]);
                    if (argP == null) {
                        player.sendMessage(Prefix.numPrefix + "Denne spiller er ikke online.");
                        return true;
                    }
                    player.sendMessage(Prefix.prefix + "§b" + argP.getName() + " §7er i level§8: §3" + LevelSystem.level.get(player.getUniqueId()));
                    return true;
                } else {
                    player.sendMessage(Prefix.numPrefix + "Ugyldig argument.");
                }
            } else {
                player.sendMessage(Prefix.prefix + "Du er i level§8: §3" + LevelSystem.level.get(player.getUniqueId()));
            }
        }
        return false;
    }
}
