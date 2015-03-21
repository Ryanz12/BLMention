package Mention;

import java.util.HashSet;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnablerCommand implements CommandExecutor
{
	private Main main;
	public HashSet<String> disableMention = Main.disableMention;
	
	public EnablerCommand(Main main){
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args ){
		if(sender instanceof Player){
			if(cmd.getName().equalsIgnoreCase("mention")){
				if(disableMention.contains(sender.getName())){
					disableMention.remove(sender.getName());
					sender.sendMessage(ChatColor.BLUE+"Kamu mengaktifkan mention!");
					return true;
				}
				else{
					disableMention.add(sender.getName());
					sender.sendMessage(ChatColor.BLUE+"Kamu menonaktifkan mention!");
					return true;
				}
			}
		}
		return false;
	}
	
}
