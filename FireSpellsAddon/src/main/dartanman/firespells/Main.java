package main.dartanman.firespells;

import org.bukkit.plugin.java.JavaPlugin;

import main.dartanman.firespells.events.FlameCloakListener;
import main.dartanman.nordicrpg.NordicRPG;

public class Main extends JavaPlugin{
	
	private static Main instance;
	
	// You have to register your spells like this in your onEnable() method
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(new FlameCloakListener(), this);
		registerSpells();
	}
	
	public void onDisable() {
		
	}
	
	private void registerSpells() {
		NordicRPG.getSpellManager().addSpell(new FlamesSpell("Flames", "nordicrpg.magic.flames"));
		NordicRPG.getSpellManager().addSpell(new PowerFlameSpell("PowerFlame", "nordicrpg.magic.powerflame"));
		NordicRPG.getSpellManager().addSpell(new FlameCloakSpell("FlameCloak", "nordicrpg.magic.flamecloak"));
	}
	
	public static Main getInstance() {
		return instance;
	}

}
