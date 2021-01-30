package main.dartanman.firespells;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import main.dartanman.nordicrpg.spells.TargetSpell;

public class PowerFlameSpell extends TargetSpell{

	public PowerFlameSpell(String name, String permission) {
		super(name, permission);
	}

	@Override
	public void applyEffectToTarget(Player caster, LivingEntity target) {
		int burnTime = Main.getInstance().getConfig().getInt("FireSpells.PowerFlame.BurnTime");
		int cooldown = Main.getInstance().getConfig().getInt("FireSpells.PowerFlame.BaseCooldown");
		double damage = Main.getInstance().getConfig().getDouble("FireSpells.PowerFlame.Damage");
		boolean pDamage = Main.getInstance().getConfig().getBoolean("FireSpells.PowerFlame.PlayerDamage");
		
		if(pDamage) {
			target.damage(damage, caster);
		}else {
			target.damage(damage);
		}
		
		target.setFireTicks(burnTime * 20);
		super.setCooldown(caster, cooldown);
	}

	@Override
	public boolean hasPermission(Player caster) {
		return(caster.hasPermission(getPermission()));
	}

}
