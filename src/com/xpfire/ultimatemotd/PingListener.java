package com.xpfire.ultimatemotd;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PingListener implements Listener {

	public PingListener(JavaPlugin e) {
		this.config = e;
	}
	
	private JavaPlugin config = null;
	
	@EventHandler
	public void onPing(ServerListPingEvent e) {
		e.setMaxPlayers(config.getConfig().getInt("maxPlayers"));
		e.setMotd(config.getConfig().getString("FirstMOTD") + "\n" + config.getConfig().getString("SecondMOTD"));
		
	}
	
}
