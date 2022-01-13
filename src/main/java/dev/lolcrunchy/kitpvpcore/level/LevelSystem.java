package dev.lolcrunchy.kitpvpcore.level;

import dev.lolcrunchy.kitpvpcore.Prefix;
import dev.lolcrunchy.kitpvpcore.files.Data;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LevelSystem implements Listener {

    public static Map<UUID, Integer> level = new HashMap<>();
    public static Map<UUID, Integer> xp = new HashMap<>();

    @EventHandler
    private void onKill(PlayerDeathEvent e) {
        final Player player = e.getEntity().getPlayer();
        final Player killer = e.getEntity().getKiller();
        int exp = xp.get(killer.getUniqueId());
        if (e.getEntity() instanceof Player) {
            if (e.getEntity().getKiller() instanceof Player) {
                xp.put(killer.getUniqueId(), xp.get(killer.getUniqueId())+1);
                killer.sendMessage(Prefix.prefix+"Du dræbte §3"+player.getName()+" §7og modtog §b1 §7xp.");
                if (exp == 49) {
                    level.put(killer.getUniqueId(), 1);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 99) {
                    level.put(killer.getUniqueId(), 2);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 174) {
                    level.put(killer.getUniqueId(), 3);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 249) {
                    level.put(killer.getUniqueId(), 4);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 399) {
                    level.put(killer.getUniqueId(), 5);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 524) {
                    level.put(killer.getUniqueId(), 6);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 699) {
                    level.put(killer.getUniqueId(), 7);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 849) {
                    level.put(killer.getUniqueId(), 8);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 999) {
                    level.put(killer.getUniqueId(), 9);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 1499) {
                    level.put(killer.getUniqueId(), 10);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 1799) {
                    level.put(killer.getUniqueId(), 11);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 1999) {
                    level.put(killer.getUniqueId(), 12);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 2599) {
                    level.put(killer.getUniqueId(), 13);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 2999) {
                    level.put(killer.getUniqueId(), 14);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 3999) {
                    level.put(killer.getUniqueId(), 15);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 5499) {
                    level.put(killer.getUniqueId(), 16);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 6999) {
                    level.put(killer.getUniqueId(), 17);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 8999) {
                    level.put(killer.getUniqueId(), 18);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 10499) {
                    level.put(killer.getUniqueId(), 19);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 13499) {
                    level.put(killer.getUniqueId(), 20);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 16499) {
                    level.put(killer.getUniqueId(), 21);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 19499) {
                    level.put(killer.getUniqueId(), 22);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 21499) {
                    level.put(killer.getUniqueId(), 23);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 28499) {
                    level.put(killer.getUniqueId(), 24);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 40499) {
                    level.put(killer.getUniqueId(), 25);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 61499) {
                    level.put(killer.getUniqueId(), 26);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 94499) {
                    level.put(killer.getUniqueId(), 27);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 198499) {
                    level.put(killer.getUniqueId(), 28);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 356499) {
                    level.put(killer.getUniqueId(), 29);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                } else if (exp == 543499) {
                    level.put(killer.getUniqueId(), 30);
                    killer.sendMessage(Prefix.prefix+"Level up§8: §3"+level.get(killer.getUniqueId()));
                    Bukkit.broadcastMessage(Prefix.prefix+"§b"+killer.getName()+" §7er level up til level§8: §3"+level.get(killer.getUniqueId()));
                    killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                }
            }
        }
    }

    /**
     *
     * @param e
     */
    @EventHandler
    private void onJoin(PlayerJoinEvent e) {
        final Player player = e.getPlayer();
        if (!level.containsKey(player.getUniqueId())) {
            level.put(player.getUniqueId(), 0);
            Data.save();
        }
        if (!xp.containsKey(player.getUniqueId())) {
            xp.put(player.getUniqueId(), 0);
            Data.save();
        }
    }

}
