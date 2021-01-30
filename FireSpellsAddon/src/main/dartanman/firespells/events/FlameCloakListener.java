package main.dartanman.firespells.events;

import java.util.UUID;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import main.dartanman.firespells.Main;
import main.dartanman.firespells.utils.FireMagicContainers;

public class FlameCloakListener implements Listener{
	
	@EventHandler
	public void flameCloak(EntityDamageByEntityEvent event) {
		if(event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if(event.getDamager() instanceof LivingEntity) {
				LivingEntity damager = (LivingEntity) event.getDamager();
				UUID uuid = player.getUniqueId();
				if(FireMagicContainers.flameCloaks.contains(uuid)) {
					damager.setFireTicks(Main.getInstance().getConfig().getInt("FireSpells.FlameCloak.BurnTimeSeconds") * 20);
				}
			}
		}
	}

}
