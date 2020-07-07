package com.xpfire.ultimatemotd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class BossBarCommand implements CommandExecutor {

	public BossBarCommand(JavaPlugin e) {
		this.config = e;
	}
	
	private JavaPlugin config = null;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {		
		if (args.length == 0) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				
				player.sendMessage(ChatColor.AQUA + "UltimateMOTD" + ChatColor.WHITE + " \u226b " + ChatColor.RED + "Invalid Number of Arguments! Usage: /bossbar [message]");
			} else {
				System.out.println("Invalid Number of Arguments! Usage: bossbar [message]");
			}
		} else {
			String FirstBossBar = null;
			if (args.length == 0) {
				FirstBossBar = "";
			} else {
				FirstBossBar = args[0];
				for (int i=1; i < args.length; ++i) {
					FirstBossBar += " " + args[i];
				}
			}
				
			config.getConfig().set("FirstBossBar", FirstBossBar);
			config.saveConfig();
				
			if (sender instanceof Player) {
				Player player = (Player) sender;
					
				player.sendMessage(ChatColor.AQUA + "UltimateMOTD" + ChatColor.WHITE + " \u226b " + ChatColor.GREEN + "Boss Bar Succesfully Changed to " + FirstBossBar);
			} else {
				System.out.println("Boss Bar Succesfully Changed to " + FirstBossBar);
			}
				
		}
		
		
		return false;
	}
}
