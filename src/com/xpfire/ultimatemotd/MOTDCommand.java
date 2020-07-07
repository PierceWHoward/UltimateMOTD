package com.xpfire.ultimatemotd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MOTDCommand implements CommandExecutor{

	public MOTDCommand(JavaPlugin e) {
		this.config = e;
	}
	
	private JavaPlugin config = null;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {		
		if (args.length == 0) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				
				player.sendMessage(ChatColor.AQUA + "UltimateMOTD" + ChatColor.WHITE + " \u226b " + ChatColor.RED + "Invalid Number of Arguments! Usage: /motd <1,2> [MOTD]");
			} else {
				System.out.println("Invalid Number of Arguments! Usage: motd <1,2> [MOTD]");
			}
		} else {
			if (args[0].equalsIgnoreCase("1")) {	
				String FirstMOTD = null;
				if (args.length <= 1) {
					FirstMOTD = "";
				} else {
					FirstMOTD = args[1];
					for (int i=2; i < args.length; ++i) {
						FirstMOTD += " " + args[i];
					}
				}
				
				config.getConfig().set("FirstMOTD", FirstMOTD);
				config.saveConfig();
				
				if (sender instanceof Player) {
					Player player = (Player) sender;
					
					player.sendMessage(ChatColor.AQUA + "UltimateMOTD" + ChatColor.WHITE + " \u226b " + ChatColor.GREEN + "First Line of MOTD Succesfully Changed to " + FirstMOTD);
				} else {
					System.out.println("First Line of MOTD Succesfully Changed to " + FirstMOTD);
				}
				
			} else if (args[0].equalsIgnoreCase("2")) {
				String SecondMOTD = null;
				if (args.length <= 1) {
					SecondMOTD = "";
				} else {
					SecondMOTD = args[1];
					for (int i=2; i < args.length; ++i) {
						SecondMOTD += " " + args[i];
					}
				}
				
				config.getConfig().set("SecondMOTD", SecondMOTD);
				config.saveConfig();
				
				if (sender instanceof Player) {
					Player player = (Player) sender;
					
					player.sendMessage(ChatColor.AQUA + "UltimateMOTD" + ChatColor.WHITE + " \u226b " + ChatColor.GREEN + "Second Line of MOTD Succesfully Changed to " + SecondMOTD);
				} else {
					System.out.println("Second Line of MOTD Succesfully Changed to " + SecondMOTD);
				}
				
				
			} else {
				
				if (sender instanceof Player) {
					Player player = (Player) sender;
					
					player.sendMessage(ChatColor.AQUA + "UltimateMOTD" + ChatColor.WHITE + " \u226b " + ChatColor.RED + "Invalid Argument! Usage: /motd <1,2> [MOTD]");
				} else {
					System.out.println("Invalid Argument! Usage: motd <1,2> [MOTD]");
				}
				
				
			}
		}
		
		
		return false;
	}

}
