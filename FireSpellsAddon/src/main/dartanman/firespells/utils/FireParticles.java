package main.dartanman.firespells.utils;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import main.dartanman.firespells.Main;

public class FireParticles {
	
	public static void createFlameCloak(Player player) {
    	int time = Main.getInstance().getConfig().getInt("FireSpells.FlameCloak.CloakTimeSeconds");
    	double particleTimeNumber = 7d;
    	if(time < 8) {
    		particleTimeNumber = 5d;
    	}
    	while(time > 8) {
    		time -= 5;
    		particleTimeNumber += 3.5d;
    	}
    	final double lastTime = particleTimeNumber;
		new BukkitRunnable(){
		    double phi = 0;
		    public void run(){
		    	phi += Math.PI/8;
		    	double x;
		    	double y;
		    	double z;
		    	Location loc = player.getLocation();
		    	for(double t = 0; t <= 2*Math.PI; t += Math.PI/2){
		    		for(double i = 0; i <= 1; i++){
		    			x = 0.3*(2*Math.PI-t)*0.5*Math.cos(t+phi+i*Math.PI);
		    			y = 0.5*t;
		    			z = 0.3*(2*Math.PI-t)*0.5*Math.sin(t+phi+i*Math.PI);
		    			loc.add(x,y,z);
		    			World world = loc.getWorld();
		    			world.spawnParticle(Particle.FLAME, loc, 1, 0, 0, 0, 0.005);
		    			loc.subtract(x,y,z);
		    		}
		    	}
		    	if(phi > lastTime*Math.PI){
		    		this.cancel();
		    	}
		    }
		}.runTaskTimer(Main.getInstance(), 0, 3);
	}

}
