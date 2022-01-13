package dev.lolcrunchy.kitpvpcore.placeholders;

import dev.lolcrunchy.kitpvpcore.Main;
import dev.lolcrunchy.kitpvpcore.level.LevelSystem;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class PlaceholderAPI extends PlaceholderExpansion {

    private final Main plugin;
    public PlaceholderAPI(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean persist(){
        return true;
    }

    @Override
    public boolean canRegister(){
        return true;
    }

    @Override
    public String getAuthor(){
        return "LoL_Crunchy";
    }

    @Override
    public String getIdentifier(){
        return "kitpvpcore";
    }

    @Override
    public String getVersion(){
        return "1.0.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {

        final int lvl = LevelSystem.level.get(player.getUniqueId());
        final int xp = LevelSystem.xp.get(player.getUniqueId());

        if (player == null){
            return "";
        }

        if (identifier.equals("exp")) {
            return String.valueOf(xp);
        }

        if (identifier.equals("lvl")) {
            return String.valueOf(lvl);
        }

        return null;
    }
}
