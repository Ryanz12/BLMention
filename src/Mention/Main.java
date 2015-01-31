/*
 *THIS IS MY FIRST WORKING BUKKIT PLUGIN
 *These comments may be pretty useless for advanced developers
 *but i'll add them for myself 
 */

package Mention;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener
{
	@Override
	public void onEnable()
		{
			getServer().getPluginManager().registerEvents(this,this);
		}
	
	@EventHandler
	public void onEvent(AsyncPlayerChatEvent e)
		{
			String chat = e.getMessage(); //setting chat to event's message
			for(Player p : e.getRecipients()) //Get Online Players
				{
					String name = "@" + p.getName();
					if(chat.toLowerCase().contains(name.toLowerCase())) //checks if chat contains any of the online player's name
					{
						Location ploc = p.getLocation().add(0, 1, 0);
						chat = chat.replaceAll(name, ChatColor.GOLD + name+ChatColor.RESET); //replaces all of the target names in the chat
						e.setMessage(chat); //sets the message
						p.sendMessage(ChatColor.RED+"Kamu dipanggil oleh "+e.getPlayer().getDisplayName()+"!"); //sends the player a message
						p.playSound(ploc, Sound.CREEPER_HISS, 0f, 10f);
						p.damage(0);
					}
				}
		}
	@Override
	public void onDisable(){}
}
