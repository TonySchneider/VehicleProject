//Sami shamoon ashdod
//Tony Schneider 205515828, Dani suhrayev 205583008
package Vehicles;

import Interfaces.MotorizedVehicle;

public class Frigate extends SeaVehicle implements MotorizedVehicle {
	private double Average_fuel = 500;
	private int lifetime_engine = 4;
	public Frigate(String name,int MaxPassengers,int MaxSpeed,boolean direction_wind,String country_flag){
		super(name,MaxPassengers,MaxSpeed,direction_wind,country_flag);
	}
	public double get_Average_fuel(){return this.Average_fuel;}
	public void set_Average_fuel(double fuel){Average_fuel = fuel;}
	public int get_lifetime_engine(){return this.lifetime_engine;}
	public void set_lifetime_engine(int lifetime){lifetime_engine = lifetime;}
	public String toString(){
		return super.toString() + ", Average fuel: " + this.Average_fuel + ", Lifetime engine: " + this.lifetime_engine + " Years.";
	}
	public boolean equals(Frigate other){
		if(super.equals(other) && this.Average_fuel == other.Average_fuel && this.lifetime_engine == other.lifetime_engine) return true;
		return false;
	}
}
