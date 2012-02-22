package in.mDev.MiracleM4n.DragonSpawn;

import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityListener implements Listener {
    DragonSpawn plugin;

    public EntityListener(DragonSpawn plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (!(event.getEntity() instanceof EnderDragon))
            return;

        event.setDroppedExp(plugin.config.getInt("dragon.droppedExp"));
    }
}
