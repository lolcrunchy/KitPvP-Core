package dev.lolcrunchy.kitpvpcore.securesystem;

import dev.lolcrunchy.kitpvpcore.Main;
import dev.lolcrunchy.kitpvpcore.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class AntiBotSystem implements CommandExecutor, Listener {
    private static Plugin plugin = Main.getPlugin(Main.class);

    private ArrayList<Boolean> cooldown = new ArrayList<>();
    private ArrayList<Boolean> bot = new ArrayList<>();

    @EventHandler
    private void onJoinEvent(PlayerJoinEvent e) {
        final Player player = e.getPlayer();
        if (!cooldown.isEmpty()) {
            player.kickPlayer("§cVent venligst..");
            return;
        }
        cooldown.add(true);
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                cooldown.clear();
            }
        }, 60L);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("antibot")) {
            if (player.hasPermission("kitpvp.antibot") || player.hasPermission("kitpvp.*")) {
                if (bot.isEmpty()) {
                    bot.add(true);
                    player.sendMessage(Prefix.prefix+"Du aktiverede antibot.");
                } else {
                    bot.clear();
                    player.sendMessage(Prefix.prefix+"Du deaktiverede antibot.");
                }
            }
        }
        return false;
    }
}
