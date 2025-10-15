package me.VAL.messageSystem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand implements CommandExecutor {

    private MessageSystem main;
    public MessageCommand(MessageSystem main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length >= 2) {
                if (player.hasPermission("messagesystem.message")) {
                    if (Bukkit.getPlayer(args[0]) != null) {
                        Player target = Bukkit.getPlayer(args[0]);
                        StringBuilder message = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            message.append(args[i]).append(" ");
                        }

                        player.sendMessage(ChatColor.GRAY + "You -> " + ChatColor.GREEN + target.getName() + ": " + ChatColor.GRAY + message);
                        target.sendMessage(ChatColor.GRAY + target.getName() + " -> " + ChatColor.GREEN + player.getName() + ": " + ChatColor.GRAY + message);

                        main.getRecentMessage().put(player.getUniqueId(), target.getUniqueId());
                    } else {
                        System.out.println(ChatColor.RED + "You don't have permission to use this command");
                    }
                } else {
                    System.out.println(ChatColor.RED + "Usage: /message <player> <message>");
                }
            } else {
                System.out.println(ChatColor.RED + "You must be a player to use this command");
            }



        }
        return false;
    }
}
