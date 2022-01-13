package dev.lolcrunchy.kitpvpcore.listeners;

import dev.lolcrunchy.kitpvpcore.Main;
import dev.lolcrunchy.kitpvpcore.Prefix;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class OnDeathEvents implements Listener {

    private Economy economy = Main.economy;

    @EventHandler
    private void death(PlayerDeathEvent e) {
        final Player player = e.getEntity().getPlayer();
        final Player killer = e.getEntity().getKiller();
        if (e.getEntity() instanceof Player) {
            if (e.getEntity().getKiller() instanceof Player) {
                economy.depositPlayer(killer, 1);
                killer.sendMessage(Prefix.prefix+"Du dræbte §3"+player.getName()+ "§7 og modtog §a$1");
                player.getInventory().clear();
                player.getInventory().setHelmet(null);
                player.getInventory().setChestplate(null);
                player.getInventory().setLeggings(null);
                player.getInventory().setBoots(null);
                player.getInventory().setItem(8, StarEvents.star());
            }
        }
    }
}
