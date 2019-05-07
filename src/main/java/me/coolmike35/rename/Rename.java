package me.coolmike35.rename;

import me.coolmike35.rename.commands.RenameCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Rename extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "[RenameCommand] This plugin has started up " + ChatColor.GREEN + "successfully!");
        getCommand("rename").setExecutor(new RenameCommand());
    }
}
