package dev.lolcrunchy.kitpvpcore.securesystem;

import dev.lolcrunchy.kitpvpcore.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class PermissionSystem implements Listener {
    private static Plugin plugin = Main.getPlugin(Main.class);

    private static ArrayList<String> players = new ArrayList<>();

    @EventHandler(priority = EventPriority.HIGHEST)
    private static void onCmd(PlayerCommandPreprocessEvent e) {
        if (players.isEmpty()) {
            players.add("kakper");
            players.add("RealW");
            players.add("BamseFD");
            players.add("Davitoooo");
        }
        final Player player = e.getPlayer();
        if (player.getGameMode() == GameMode.CREATIVE) {
            if (!(player.hasPermission("Essentials.Gamemode.1"))) {
                e.setCancelled(true);
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode 0 " + player.getName());
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban "+player.getName()+" Kontakt admins på discord.");
                    }
                }, 2L);
            }
        }
        if (player.hasPermission("*")) {
            if (!players.contains(player.getName())) {
                e.setCancelled(true);
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban "+player.getName()+" Kontakt admins på discord.");
                        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                            @Override
                            public void run() {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+player.getName()+" permission unset *");
                                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                    @Override
                                    public void run() {
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+player.getName()+" permission unset minecraft.command.op");
                                        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                            @Override
                                            public void run() {
                                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+player.getName()+" group set default");
                                            }
                                        }, 2L);
                                    }
                                }, 2L);
                            }
                        }, 2L);
                    }
                }, 2L);
                return;
            }
        } else if (player.hasPermission("minecraft.command.op")) {
            if (!players.contains(player.getName())) {
                e.setCancelled(true);
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban "+player.getName()+" Kontakt admins på discord.");
                        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                            @Override
                            public void run() {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+player.getName()+" permission unset *");
                                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                    @Override
                                    public void run() {
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+player.getName()+" permission unset minecraft.command.op");
                                        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                            @Override
                                            public void run() {
                                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+player.getName()+" group set default");
                                            }
                                        }, 2L);
                                    }
                                }, 2L);
                            }
                        }, 2L);
                    }
                }, 2L);
                return;
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    private static void onMove(PlayerMoveEvent e) {
        if (players.isEmpty()) {
            players.add("kakper");
            players.add("RealW");
            players.add("BamseFD");
            players.add("Davitoooo");
        }
        final Player player = e.getPlayer();
        if (player.getGameMode() == GameMode.CREATIVE) {
            if (!(player.hasPermission("Essentials.Gamemode.1"))) {
                e.setTo(e.getFrom());
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode 0 " + player.getName());
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban "+player.getName()+" Kontakt admins på discord.");
                    }
                }, 2L);
            }
        }
        if (player.hasPermission("*")) {
            if (!players.contains(player.getName())) {
                e.setTo(e.getFrom());
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban "+player.getName()+" Kontakt admins på discord.");
                        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                            @Override
                            public void run() {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+player.getName()+" permission unset *");
                                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                    @Override
                                    public void run() {
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+player.getName()+" permission unset minecraft.command.op");
                                        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                            @Override
                                            public void run() {
                                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+player.getName()+" group set default");
                                            }
                                        }, 2L);
                                    }
                                }, 2L);
                            }
                        }, 2L);
                    }
                }, 2L);
                return;
            }
        } else if (player.hasPermission("minecraft.command.op")) {
            if (!players.contains(player.getName())) {
                e.setCancelled(true);
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban "+player.getName()+" Kontakt admins på discord.");
                        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                            @Override
                            public void run() {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+player.getName()+" permission unset *");
                                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                    @Override
                                    public void run() {
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+player.getName()+" permission unset minecraft.command.op");
                                        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                            @Override
                                            public void run() {
                                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+player.getName()+" group set default");
                                            }
                                        }, 2L);
                                    }
                                }, 2L);
                            }
                        }, 2L);
                    }
                }, 2L);
                return;
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    private static void onInterfgsdfsact(PlayerInteractEvent e) {
        if (players.isEmpty()) {
            players.add("kakper");
            players.add("RealW");
            players.add("BamseFD");
            players.add("Davitoooo");
        }
        final Player player = e.getPlayer();
        if (player.getGameMode() == GameMode.CREATIVE) {
            if (!(player.hasPermission("Essentials.Gamemode.1"))) {
                e.setCancelled(true);
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode 0 " + player.getName());
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban "+player.getName()+" Kontakt admins på discord.");
                    }
                }, 2L);
            }
        }
        if (player.hasPermission("*")) {
            if (!players.contains(player.getName())) {
                e.setCancelled(true);
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban "+player.getName()+" Kontakt admins på discord.");
                        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                            @Override
                            public void run() {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+player.getName()+" permission unset *");
                                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                    @Override
                                    public void run() {
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+player.getName()+" permission unset minecraft.command.op");
                                        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                            @Override
                                            public void run() {
                                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+player.getName()+" group set default");
                                            }
                                        }, 2L);
                                    }
                                }, 2L);
                            }
                        }, 2L);
                    }
                }, 2L);
                return;
            } else if (player.hasPermission("minecraft.command.op")) {
                if (!players.contains(player.getName())) {
                    e.setCancelled(true);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        @Override
                        public void run() {
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban "+player.getName()+" Kontakt admins på discord.");
                            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                @Override
                                public void run() {
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+player.getName()+" permission unset *");
                                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                        @Override
                                        public void run() {
                                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+player.getName()+" permission unset minecraft.command.op");
                                            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                                @Override
                                                public void run() {
                                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+player.getName()+" group set default");
                                                }
                                            }, 2L);
                                        }
                                    }, 2L);
                                }
                            }, 2L);
                        }
                    }, 2L);
                    return;
                }
            }
        }
    }

}
