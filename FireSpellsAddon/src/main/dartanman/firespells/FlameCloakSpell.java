package main.dartanman.firespells;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import main.dartanman.firespells.utils.FireMagicContainers;
import main.dartanman.firespells.utils.FireParticles;
import main.dartanman.nordicrpg.spells.SelfTargetSpell;

public class FlameCloakSpell extends SelfTargetSpell{

	public FlameCloakSpell(String name, String permission) {
		super(name, permission);
	}

	@Override
	public void applyEffectToTarget(Player caster, LivingEntity target) {
		FireMagicContainers.flameCloaks.add(caster.getUniqueId());
		super.setCooldown(caster, Main.getInstance().getConfig().getInt("FireSpells.FlameCloak.BaseCooldown"));
		if(Main.getInstance().getConfig().getBoolean("FireSpells.FlameCloak.UseParticles")) {
			FireParticles.createFlameCloak(caster);
		}
		
		Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable()
        {
          public void run()
          {
            FireMagicContainers.flameCloaks.remove(caster.getUniqueId());
          }
        },  Main.getInstance().getConfig().getInt("FireSpells.FlameCloak.CloakTimeSeconds")*20L);
		
	}

	@Override
	public boolean hasPermission(Player caster) {
		return caster.hasPermission(getPermission());
	}

}
