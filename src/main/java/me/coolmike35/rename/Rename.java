package me.coolmike35.rename;

import me.coolmike35.rename.commands.RenameCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Rename extends JavaPlugin {
    
    private long start;
    
    @Override
    public void onLoad() {
        super.onLoad();
        this.start = System.currentTimeMillis();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        super.getCommand("rename").setExecutor(new RenameCommand());
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "[RenameCommand] This plugin has started up " + ChatColor.GREEN + "successfully" + ChatColor.BLUE + "" + ChatColor.BOLD + " in " + (System.currentTimeMillis() - start + "ms!");
    }
}
