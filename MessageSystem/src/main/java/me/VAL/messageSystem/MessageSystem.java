package me.VAL.messageSystem;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class MessageSystem extends JavaPlugin implements Listener {

    private HashMap<UUID, UUID> recentMessage;

    @Override
    public void onEnable() {
        // Plugin startup logic
     getCommand("message").setExecutor(new MessageCommand(this));
    getCommand("reply").setExecutor(new ReplyCommand(this));

    recentMessage = new HashMap<>();
    }

    public HashMap<UUID, UUID> getRecentMessage() {return recentMessage;}

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        recentMessage.remove(event.getPlayer().getUniqueId());
    }


}
