package com.tohu.tofusamples.Events.Player;

import com.tohu.tofusamples.TofuSamples;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class ChangeEvent implements Listener {
    TofuSamples plugin;
    World world;
    public ChangeEvent(TofuSamples plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
        this.world = plugin.getServer().getWorld("world");
    }

    @EventHandler
    public void onPlayerChangedWorld(PlayerChangedWorldEvent e) {
        Player player = e.getPlayer();
        World world = player.getWorld();
        if (!world.equals(this.world)) return;
        player.sendTitle("SampleCode", "サンプルコード", 20, 20, 20);
        player.sendMessage("楽しくプラグインを作ろう！");
    }
}
