package net.primaxstudios.primaxteamglow;

import com.booksaw.betterTeams.Team;
import fr.skytasul.glowingentities.GlowingEntities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PrimaxTeamGlow extends JavaPlugin {

    private GlowingEntities glowing;

    @Override
    public void onEnable() {
        if (!isPluginPresent("BetterTeams")) {
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        glowing = new GlowingEntities(this);

        Bukkit.getScheduler().runTaskTimer(this, this::updateGlowForAll, 20L, 20L);
        getLogger().info("PrimaxTeamGlow enabled successfully!");
    }

    @Override
    public void onDisable() {
        if (glowing != null) {
            glowing.disable(); // Properly cleanup glowing API
        }
        getLogger().info("PrimaxTeamGlow disabled.");
    }

    private boolean isPluginPresent(String pluginName) {
        if (Bukkit.getPluginManager().getPlugin(pluginName) == null) {
            getLogger().severe(pluginName + " not found! Disabling...");
            return false;
        }
        return true;
    }

    private void updateGlowForAll() {
        for (Player viewer : Bukkit.getOnlinePlayers()) {
            Team viewerTeam = Team.getTeam(viewer);

            for (Player target : Bukkit.getOnlinePlayers()) {

                Team targetTeam = Team.getTeam(target);

                try {
                    if (viewerTeam != null && viewerTeam.equals(targetTeam)) {
                        // Teammates
                        glowing.setGlowing(target, viewer, ChatColor.GREEN);
                    } else {
                        // Not teammates
                        glowing.unsetGlowing(target, viewer);
                    }
                } catch (ReflectiveOperationException e) {
                    getLogger().warning("Error applying glow: " + e.getMessage());
                }
            }
        }
    }
}