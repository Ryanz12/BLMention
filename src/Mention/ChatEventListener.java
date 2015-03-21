package Mention;

import java.util.HashSet;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEventListener implements Listener
{
	
	
	HashSet<String> disableMention= Main.disableMention;
	
	@EventHandler
	public void onEvent(AsyncPlayerChatEvent e)
		{
			String chat = e.getMessage(); //setting chat to event's message
			for(Player p : e.getRecipients()) //Get Online Players
				{
					String hash = p.getName();
					String name = "@" + hash;
					if(chat.toLowerCase().contains(name.toLowerCase())) //checks if chat contains any of the online player's name
					{
						if(!disableMention.contains(hash)){
							Location ploc = p.getLocation().add(0, 1, 0);
							chat = chat.replaceAll(name, ChatColor.GOLD + name + ChatColor.GRAY); //replaces all of the target names in the chat
							e.setMessage(chat); //sets the message
							p.sendMessage(ChatColor.RED+"Kamu dipanggil oleh "+e.getPlayer().getDisplayName()+"!"); //sends the player a message
							p.playSound(ploc, Sound.CREEPER_HISS, 0f, 10f);
							p.damage(0);
						}
						else{
							e.getPlayer().sendMessage(ChatColor.GRAY+"Player "+ChatColor.GOLD+ChatColor.ITALIC+name+ChatColor.RESET+ChatColor.GRAY+" tidak dapat dimention!");
						}
					}
				}
		}
}
