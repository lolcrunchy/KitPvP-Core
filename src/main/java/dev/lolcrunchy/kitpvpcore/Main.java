package dev.lolcrunchy.kitpvpcore;

import dev.lolcrunchy.kitpvpcore.commands.PlayerCommands;
import dev.lolcrunchy.kitpvpcore.files.Data;
import dev.lolcrunchy.kitpvpcore.level.LevelSystem;
import dev.lolcrunchy.kitpvpcore.listeners.OnDeathEvents;
import dev.lolcrunchy.kitpvpcore.listeners.StarEvents;
import dev.lolcrunchy.kitpvpcore.menus.KitUpgrade;
import dev.lolcrunchy.kitpvpcore.menus.MainMenu;
import dev.lolcrunchy.kitpvpcore.menus.Shop;
import dev.lolcrunchy.kitpvpcore.placeholders.PlaceholderAPI;
import dev.lolcrunchy.kitpvpcore.quests.farming.LapisOre;
import dev.lolcrunchy.kitpvpcore.quests.farming.WheatFarming;
import dev.lolcrunchy.kitpvpcore.securesystem.AntiBotSystem;
import dev.lolcrunchy.kitpvpcore.securesystem.PermissionSystem;
import dev.lolcrunchy.kitpvpcore.staff.StaffMode;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class Main extends JavaPlugin {

    public static Economy economy;

    /**
     * PERMISSIONS
     *
     * ADMIN PERMISSIONS:
     * kitpvp.staffmode
     * kitpvp.antibot
     * |Giver adgang til staffmode /staffmode
     *
     * kitpvp.*
     * |Giver adgang til alt
     *
     * SPILLER PERMISSIONS:
     *
     */

    /**
     * PLACEHOLDERS
     *
     * PLACEHOLDERAPI:
     * kitpvpcore.xp | viser spillerens xp
     * kitpvpcore.level | viser spillerens level
     *
     */

    @Override
    public void onEnable() {
        if (!setupEconomy() ) {
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
            new PlaceholderAPI(this).register();
        }

        PlayerCommands cmd = new PlayerCommands();
        StaffMode sm = new StaffMode();
        this.getCommand("kitpvp").setExecutor(cmd);
        this.getCommand("staffmode").setExecutor(sm);
        this.getCommand("level").setExecutor(cmd);
        this.getCommand("xp").setExecutor(cmd);
        this.getServer().getPluginManager().registerEvents(cmd, this);
        this.getServer().getPluginManager().registerEvents(sm, this);

        this.getServer().getPluginManager().registerEvents(new KitUpgrade(), this);
        this.getServer().getPluginManager().registerEvents(new Shop(), this);
        this.getServer().getPluginManager().registerEvents(new MainMenu(), this);
        this.getServer().getPluginManager().registerEvents(new OnDeathEvents(), this);
        this.getServer().getPluginManager().registerEvents(new StarEvents(), this);

        this.getServer().getPluginManager().registerEvents(new WheatFarming(), this);
        this.getServer().getPluginManager().registerEvents(new LapisOre(), this);

        this.getServer().getPluginManager().registerEvents(new LevelSystem(), this);

        this.getServer().getPluginManager().registerEvents(new PermissionSystem(), this);
        this.getServer().getPluginManager().registerEvents(new AntiBotSystem(), this);

        Data.setup();

        Data.get().addDefault("Prefix", "§8§l( §3§l! §8§l)");
        Data.get().addDefault("numPrefix", "§8§l( §c§l! §8§l)");

        restore();
    }

    @Override
    public void onDisable() {
        save();
        Data.save();
    }

    private boolean setupEconomy() {
        final RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

    public static Economy getEconomy() {

        return economy;
    }

    public static void save() {
        for (UUID uuid : KitUpgrade.sword.keySet()) {
            Data.get().set(uuid.toString(), KitUpgrade.sword.get(uuid));
        }
        for (UUID uuid : KitUpgrade.bow.keySet()) {
            Data.get().set(uuid.toString(), KitUpgrade.bow.get(uuid));
        }
        for (UUID uuid : KitUpgrade.helmet.keySet()) {
            Data.get().set(uuid.toString(), KitUpgrade.helmet.get(uuid));
        }
        for (UUID uuid : KitUpgrade.chestplate.keySet()) {
            Data.get().set(uuid.toString(), KitUpgrade.chestplate.get(uuid));
        }
        for (UUID uuid : KitUpgrade.leggings.keySet()) {
            Data.get().set(uuid.toString(), KitUpgrade.leggings.get(uuid));
        }
        for (UUID uuid : KitUpgrade.boots.keySet()) {
            Data.get().set(uuid.toString(), KitUpgrade.boots.get(uuid));
        }
        for (UUID uuid : KitUpgrade.rod.keySet()) {
            Data.get().set(uuid.toString(), KitUpgrade.rod.get(uuid));
        }
        for (UUID uuid : LevelSystem.level.keySet()) {
            Data.get().set(uuid.toString(), LevelSystem.level.get(uuid));
        }
        for (UUID uuid : LevelSystem.xp.keySet()) {
            Data.get().set(uuid.toString(), LevelSystem.xp.get(uuid));
        }
    }

    public static void restore() {
        for (String key : Data.get().getKeys(false)) {
            KitUpgrade.sword.put(UUID.fromString(key), Data.get().getInt(key));
        }
        for (String key : Data.get().getKeys(false)) {
            KitUpgrade.bow.put(UUID.fromString(key), Data.get().getInt(key));
        }
        for (String key : Data.get().getKeys(false)) {
            KitUpgrade.helmet.put(UUID.fromString(key), Data.get().getInt(key));
        }
        for (String key : Data.get().getKeys(false)) {
            KitUpgrade.chestplate.put(UUID.fromString(key), Data.get().getInt(key));
        }
        for (String key : Data.get().getKeys(false)) {
            KitUpgrade.leggings.put(UUID.fromString(key), Data.get().getInt(key));
        }
        for (String key : Data.get().getKeys(false)) {
            KitUpgrade.boots.put(UUID.fromString(key), Data.get().getInt(key));
        }
        for (String key : Data.get().getKeys(false)) {
            KitUpgrade.rod.put(UUID.fromString(key), Data.get().getInt(key));
        }
        for (String key : Data.get().getKeys(false)) {
            LevelSystem.level.put(UUID.fromString(key), Data.get().getInt(key));
        }
        for (String key : Data.get().getKeys(false)) {
            LevelSystem.xp.put(UUID.fromString(key), Data.get().getInt(key));
        }
    }

}
