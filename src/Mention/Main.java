package Mention;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener
{
	public void onEnable()
		{
			getServer().getPluginManager().registerEvents(this,this);
		}
	
	@EventHandler
	public void onEvent(AsyncPlayerChatEvent e)
		{
			String chat = e.getMessage();
			for(Player p : Bukkit.getServer().getOnlinePlayers())
				{
					String name = "@" + p.getName();
					if(chat.toLowerCase().contains(name.toLowerCase()))
					{
						Player target = p;
						chat = chat.replaceAll(name, ChatColor.GOLD+name+ChatColor.RESET);
						e.setMessage(chat);
						target.sendMessage(ChatColor.RED+"Kamu dipanggil oleh "+e.getPlayer().getName()+"!");
						target.playSound(target.getLocation(),Sound.CREEPER_HISS, 5, 0);
						target.damage(0);
					}
				}
		}
}
