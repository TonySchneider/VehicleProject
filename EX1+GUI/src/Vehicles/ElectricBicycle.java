package Vehicles;

import Interfaces.ILandVehicle;
import Interfaces.MotorizedVehicle;

public class ElectricBicycle extends LandVehicle implements MotorizedVehicle, ILandVehicle {
	private double Average_fuel = 20;
	private int lifetime_engine;
	public ElectricBicycle(String Model,int MaxPassengers,int MaxSpeed,String type_of_road,int lifetime_engine) {
		super(Model, MaxPassengers, MaxSpeed, 2, type_of_road);
		this.lifetime_engine = lifetime_engine;
	}
	public double get_Average_fuel() {return this.Average_fuel;}
	public void set_Average_fuel(double fuel) {this.Average_fuel = fuel;}
	public int get_lifetime_engine() {return this.lifetime_engine;}
	public void set_lifetime_engine(int lifetime) {this.lifetime_engine = lifetime;}
	public String toString(){return super.toString() + ", Average fuel: " + this.Average_fuel + ", Lifetime engine: " + this.lifetime_engine + " .";}
	public boolean equals(ElectricBicycle other){return (super.equals(other) && this.Average_fuel == other.Average_fuel && this.lifetime_engine == other.lifetime_engine );}
}

