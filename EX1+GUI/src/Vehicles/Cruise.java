package Vehicles;

import Interfaces.CommercialVehicle;
import Interfaces.MotorizedVehicle;

public class Cruise extends SeaVehicle implements MotorizedVehicle,
		CommercialVehicle {
	private double Average_fuel;
	private int lifetime_engine;
	private String commercial_license = "Unlimited";
	public Cruise(String name,int MaxPassengers,int MaxSpeed,String country_flag,double Average_fuel,int lifetime_engine){
		super(name,MaxPassengers,MaxSpeed,true,country_flag);
	}

	public void setCommercial(String com){commercial_license = com;}
	public String getCommercial(){return commercial_license;}
	public double get_Average_fuel(){return this.Average_fuel;}
	public void set_Average_fuel(double fuel){Average_fuel = fuel;}
	public int get_lifetime_engine(){return this.lifetime_engine;}
	public void set_lifetime_engine(int lifetime){lifetime_engine = lifetime;}
	public String toString(){
		return super.toString() + ", Average fuel: " + this.Average_fuel + ", Lifetime engine: " + this.lifetime_engine + " Years.";
	}
	public boolean equals(Cruise other){
		if(super.equals(other) && this.Average_fuel == other.Average_fuel && this.lifetime_engine == other.lifetime_engine) return true;
		return false;
	}

}
