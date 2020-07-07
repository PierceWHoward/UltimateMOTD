package com.xpfire.ultimatemotd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SetMaxPlayersCommand implements CommandExecutor {

	public SetMaxPlayersCommand(JavaPlugin e) {
		this.config = e;
	}
	
	private JavaPlugin config = null;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (args.length == 0) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				
				player.sendMessage(ChatColor.AQUA + "UltimateMOTD" + ChatColor.WHITE + " \u226b " + ChatColor.RED + "Invalid Number of Arguments! Usage: /setmaxplayers <maxPlayers>");
			} else {
				System.out.println("Invalid Number of Arguments! Usage: setmaxplayers <maxPlayers>");
			}
		} else if (args.length >= 2) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				
				player.sendMessage(ChatColor.AQUA + "UltimateMOTD" + ChatColor.WHITE + " \u226b " + ChatColor.RED + "Invalid Number of Arguments! Usage: /setmaxplayers <maxPlayers>");
			} else {
				System.out.println("Invalid Number of Arguments! Usage: setmaxplayers <maxPlayers>");
			}
		} else {
			try {
				int maxPlayers = Integer.parseInt(args[0]);
								
				config.getConfig().set("maxPlayers", maxPlayers);
				config.saveConfig();
				
				if(sender instanceof Player) {
					Player player = (Player) sender;
					String maxP = Integer.toString(maxPlayers);
					player.sendMessage(ChatColor.AQUA + "UltimateMOTD" + ChatColor.WHITE + " \u226b " + ChatColor.GREEN + "Max Players Succesfully set to " + maxP);
				} else {
					System.out.println("Max Players Succesfully set to " + maxPlayers);
				}
				
			} catch(Exception e) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					
					player.sendMessage(ChatColor.AQUA + "UltimateMOTD" + ChatColor.WHITE + " \u226b " + ChatColor.RED + "Invalid Number of Players! Usage: /setmaxplayers <maxPlayers>");
				} else {
					System.out.println("Invalid Number of Players! Usage: setmaxplayers <maxPlayers>");
				}
			}
		}
		
		return false;
	}

}
