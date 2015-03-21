/*
 *THIS IS MY FIRST WORKING BUKKIT PLUGIN
 *These comments may be pretty useless for advanced developers
 *but i'll add them for myself 
 */

package Mention;

import java.util.HashSet;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener
{
	static HashSet<String> disableMention = new HashSet<String>();
	
	@Override
	public void onEnable()
		{
			getCommand("mention").setExecutor(new EnablerCommand(this));
			getServer().getPluginManager().registerEvents(new ChatEventListener(),this);
		}
	
	@Override
	public void onDisable(){}
}
