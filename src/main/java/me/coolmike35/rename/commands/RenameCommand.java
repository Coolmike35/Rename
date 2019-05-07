package me.coolmike35.rename.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RenameCommand
        implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            if (args.length == 0) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Usage: /rename {player} {message}");
            } else if (args.length > 0) {
                if(args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target == null){
                        String targetstr = args[0];
                        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "" + ChatColor.BOLD + targetstr + " is not a player!");
                    }else {
                        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You need to provide a name for the item the player is holding!");
                    }
                }else{
                Player target = Bukkit.getPlayer(args[0]);
                String targetstr = args[0];
                if (target == null) {
                    Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "" + ChatColor.BOLD + targetstr + " is not a player!");
                } else {
                    if (target.getItemInHand().getType() == Material.AIR) {
                        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "" + ChatColor.BOLD + target.getName() + " is not holding an item!");
                    } else {
                        ItemStack item = target.getItemInHand();
                        StringBuilder sb = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            sb.append(args[i] + " ");
                        }
                            String string = sb.toString().trim();
                            String colored = ChatColor.translateAlternateColorCodes('&', string);
                            ItemMeta item_meta = item.getItemMeta();
                            item_meta.setDisplayName(ChatColor.RESET + colored.trim());
                            item.setItemMeta(item_meta);
                            Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "You have renamed " + target.getName() + "'s " + item.getType().name().toLowerCase() + " to \"" + colored.trim() + ChatColor.BLUE + "\"" + "!");
                            target.sendMessage(ChatColor.BLUE + "Your " + item.getType().name().toLowerCase() + " has been renamed to " + "\"" + colored.trim() + ChatColor.BLUE + "\"" + "!");
                    }
                }
            }
        }
    } else if(sender instanceof Player) {
        Player player = (Player) sender;
        if (player.hasPermission("rename.rename")) {
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Usage: /rename {player} {message}");
            } else if (args.length > 0) {
                if(args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target == null) {
                        String targetstr = args[0];
                        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + targetstr + " is not a player!");
                    }else{
                        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You need to provide a name for the item the player is holding!");
                }
                }else{
                Player target = Bukkit.getPlayer(args[0]);
                String targetstr = args[0];
                if (target == null) {
                    player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + targetstr + " is not a player!");
                } else {
                    if (target.getItemInHand().getType() == Material.AIR) {
                        if (target == player) {
                            target.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You are not holding an item");
                        } else {
                            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + target.getName() + " is not holding an item");
                        }
                    } else {
                        if(target == player){
                            ItemStack item = target.getItemInHand();
                            StringBuilder sb = new StringBuilder();
                            for (int i = 1; i < args.length; i++) {
                                sb.append(args[i] + " ");
                            }
                                ItemMeta item_meta = item.getItemMeta();
                                String string = sb.toString().trim();
                                String colored = ChatColor.translateAlternateColorCodes('&', string);
                                item_meta.setDisplayName(ChatColor.RESET + colored.trim());
                                item.setItemMeta(item_meta);
                                player.sendMessage(ChatColor.BLUE + "You have renamed your " + item.getType().name().toLowerCase() + " to \"" + colored.trim() + ChatColor.BLUE + "\"!");
                        }else if(!(target == player)) {
                            ItemStack item = target.getItemInHand();
                            StringBuilder sb = new StringBuilder();
                            for (int i = 1; i < args.length; i++) {
                                sb.append(args[i] + " ");
                            }
                                String string = sb.toString().trim();
                                String colored = ChatColor.translateAlternateColorCodes('&', string);
                                ItemMeta item_meta = item.getItemMeta();
                                item_meta.setDisplayName(ChatColor.RESET + colored.trim());
                                item.setItemMeta(item_meta);
                                target.sendMessage(ChatColor.BLUE + "Your " + item.getType().name().toLowerCase() + "has been renamed" + " to \"" + colored.trim() + ChatColor.BLUE + "\"!");
                                player.sendMessage(ChatColor.BLUE + "You have renamed " + target.getName() + "'s " + item.getType().name().toLowerCase() + " to \"" + colored.trim() + ChatColor.BLUE + "\"" + "!");
                        }
                    }
                }
                    }
                }
            }
        }
        return true;
    }
}