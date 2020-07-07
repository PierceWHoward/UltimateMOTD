package com.xpfire.ultimatemotd;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable() {
		System.out.println("UltimateMOTD Plugin Enabled!");
		
		this.getConfig().options().copyDefaults();
		saveDefaultConfig();
		
		Bukkit.getPluginManager().registerEvents(new PingListener(this), this);
		Bukkit.getPluginManager().registerEvents(new JoinListener(this), this);
		
		getCommand("motd").setExecutor(new MOTDCommand(this));
		getCommand("setmaxplayers").setExecutor(new SetMaxPlayersCommand(this));
		getCommand("bossbar").setExecutor(new BossBarCommand(this));
	}
	
}
