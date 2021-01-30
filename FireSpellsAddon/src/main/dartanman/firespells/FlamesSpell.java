package main.dartanman.firespells;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import main.dartanman.nordicrpg.spells.TargetSpell;

public class FlamesSpell extends TargetSpell{

	public FlamesSpell(String name, String permission) {
		super(name, permission);
	}

	@Override
	public void applyEffectToTarget(Player caster, LivingEntity target) {
		int burnTime = Main.getInstance().getConfig().getInt("FireSpells.Flames.BurnTime");
		int cooldown = Main.getInstance().getConfig().getInt("FireSpells.Flames.BaseCooldown");
		target.setFireTicks(burnTime * 20);
		super.setCooldown(caster, cooldown);
	}

	@Override
	public boolean hasPermission(Player caster) {
		return(caster.hasPermission(getPermission()));
	}

}
