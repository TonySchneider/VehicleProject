//Sami shamoon ashdod
//Tony Schneider 205515828, Dani suhrayev 205583008
package Vehicles;
import Interfaces.ILandVehicle;
import Interfaces.ISeaVehicle;
import Interfaces.MotorizedVehicle;

public class Amphibious extends Vehicle implements ILandVehicle, ISeaVehicle,MotorizedVehicle {
	private LandVehicle land;
	private SeaVehicle sea;
	private double Average_fuel;
	private int lifetime_engine;
	public Amphibious(String name,int MaxPassengers,int MaxSpeed,int Wheels,String type_of_road,boolean direction_wind,String country_flag,double Average_fuel,int lifetime_engine){
		super(name,MaxPassengers,MaxSpeed);
		land = new LandVehicle(name,MaxPassengers,MaxSpeed,Wheels,"paved");
		sea = new SeaVehicle(name,MaxPassengers,MaxSpeed,direction_wind,country_flag);
		this.Average_fuel = Average_fuel;
		this.lifetime_engine = lifetime_engine;
	}
	public LandVehicle getLand(){return land;}
	public SeaVehicle getSea(){return sea;}
	public int getWheels(){return land.getWheels();}
	public void setWheels(int Wheels){land.setWheels(Wheels);}
	public String get_type_of_road(){return land.get_type_of_road();}
	public void set_type_of_road(String type_of_road){land.set_type_of_road(type_of_road);}
	public boolean get_direction_wind(){return sea.get_direction_wind();}
	public void set_direction_wind(boolean direction_wind){sea.set_direction_wind(direction_wind);}
	public String get_country_flag(){return sea.get_country_flag();}
	public void set_country_flag(String country_flag){sea.set_country_flag(country_flag);}
	public double get_Average_fuel(){return this.Average_fuel;}
	public void set_Average_fuel(double fuel){Average_fuel = fuel;}
	public int get_lifetime_engine(){return this.lifetime_engine;}
	public void set_lifetime_engine(int lifetime){lifetime_engine = lifetime;}
	public String toString(){
		if(sea.get_direction_wind())
			return super.toString() + ", Wheels: " + land.getWheels() + ", Type of road: " + land.get_type_of_road() + "with the wind, Under: " + sea.get_country_flag() + " flag"+ ", Average fuel: " + this.Average_fuel + ", Lifetime engine: " + this.lifetime_engine + " .";
		else
			return super.toString() + ", Wheels: " + land.getWheels() + ", Type of road: " + land.get_type_of_road() + "Not with the wind, Under: " + sea.get_country_flag() + " flag"+ ", Average fuel: " + this.Average_fuel + ", Lifetime engine: " + this.lifetime_engine + " .";
	}
	public boolean equals(Amphibious other){
		if(super.equals(other)&& sea.get_direction_wind() == other.getSea().get_direction_wind() && sea.get_country_flag() == other.getSea().get_country_flag() && land.getWheels() == other.getLand().getWheels() && land.get_type_of_road() == other.getLand().get_type_of_road() && this.Average_fuel == other.Average_fuel && this.lifetime_engine == other.lifetime_engine ) return true;
		return false;
	}
}
