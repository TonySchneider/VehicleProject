//Sami shamoon ashdod
//Tony Schneider 205515828, Dani suhrayev 205583008
package Vehicles;

import Interfaces.CommercialVehicle;
import Interfaces.MotorizedVehicle;

public class Jeep extends LandVehicle implements MotorizedVehicle,CommercialVehicle {
	private double Average_fuel;
	private int lifetime_engine;
	private String commercial_license = "MINI";
	public Jeep(String name,int MaxSpeed,double Average_fuel,int lifetime_engine){
		super(name, 5, MaxSpeed, 4, "dirt");
		this.Average_fuel = Average_fuel;
		this.lifetime_engine = lifetime_engine;
	}
	public double get_Average_fuel(){return this.Average_fuel;}
	public void set_Average_fuel(double fuel){Average_fuel = fuel;}
	public int get_lifetime_engine(){return this.lifetime_engine;}
	public void set_lifetime_engine(int lifetime){lifetime_engine = lifetime;}
	public void setCommercial(String com){commercial_license = com;}
	public String getCommercial(){return commercial_license;}
	public String toString(){
		return super.toString() + ", Average fuel: " + this.Average_fuel + ", Lifetime engine: " + this.lifetime_engine + ", Commercial license:" + this.commercial_license + " .";
	}
	public boolean equals(Jeep other){
		if(super.equals(other) && this.Average_fuel == other.Average_fuel && this.lifetime_engine == other.lifetime_engine && this.commercial_license == other.commercial_license) return true;
		return false;
	}
}
