//Sami shamoon ashdod
//Tony Schneider 205515828, Dani suhrayev 205583008
package Vehicles;

import Interfaces.NotMotorizedVehicle;

public class DownGame extends AirVehicle implements NotMotorizedVehicle {
	private String power_source = "manual";
	private char energetic_score = 'A';
	public DownGame(String name){
		super(name,0,10,"civil");
	}
	public void setPowerSource(String power){power_source = power;}
	public String getPowerSource(){return power_source;}
	public void setEnergeticScore(char score){energetic_score = score;}
	public char getEnergeticScore(){return energetic_score;}
	public String toString(){
		return super.toString() + ", Power source: " + this.power_source + ", Energetic score: " + this.energetic_score;
	}
	public boolean equals(DownGame other){
		if(super.equals(other) && this.power_source == other.power_source && this.energetic_score == other.energetic_score) return true;
		return false;
	}
}
