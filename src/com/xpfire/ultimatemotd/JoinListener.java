package com.xpfire.ultimatemotd;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class JoinListener implements Listener {
	
	public JoinListener(JavaPlugin e) {
		this.config = e;
	}
	
	private JavaPlugin config = null;
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		BossBar bossBar = Bukkit.createBossBar(config.getConfig().getString("FirstBossBar"), BarColor.GREEN, BarStyle.SOLID);
		bossBar.addPlayer(e.getPlayer());
		
	}

}
