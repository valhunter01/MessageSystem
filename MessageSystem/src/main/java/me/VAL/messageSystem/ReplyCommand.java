package me.VAL.messageSystem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ReplyCommand implements CommandExecutor {

    private MessageSystem main;
    public ReplyCommand(MessageSystem main) {
        this.main = main;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(args.length >= 1){
                if(main.getRecentMessage().containsKey(player.getUniqueId())){
                    UUID uuid = main.getRecentMessage().get(player.getUniqueId());
                    if(Bukkit.getPlayer(uuid) != null){

                    }else{
                        player.sendMessage(ChatColor.RED + "The player you are replying to is not online");
                    }

                }else{
                    player.sendMessage(ChatColor.RED + "You have no recent messages");
                }
            }
        }else{
            System.out.println(ChatColor.RED + "You must be a player to use this command");
        }



        return false;
    }
}
