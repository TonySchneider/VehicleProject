//Sami shamoon ashdod
//Tony Schneider 205515828, Dani suhrayev 205583008
package Vehicles;


public class SeaVehicle extends Vehicle {
	protected boolean direction_wind;
	protected String country_flag;
	public SeaVehicle(String Model,int MaxPassengers,int MaxSpeed,boolean direction_wind,String country_flag){
		super(Model,MaxPassengers,MaxSpeed);
		this.direction_wind = direction_wind;
		this.country_flag = country_flag;
	}
	public boolean get_direction_wind(){return this.direction_wind;}
	public void set_direction_wind(boolean direction_wind){this.direction_wind = direction_wind;}
	public String get_country_flag(){return this.country_flag;}
	public void set_country_flag(String country_flag){this.country_flag = country_flag;}
	public String toString(){
		if(direction_wind){
		return super.toString() + "with the wind, Under: " + this.country_flag + " flag";
		}
		return super.toString() + "Not with the wind, Under: " + this.country_flag + " flag";
	}
	public boolean equals(SeaVehicle other){
		if(super.equals(other) && this.direction_wind == other.direction_wind && this.country_flag == other.country_flag) return true;
		return false;
	}
	public String getType(){
		return "Sea";
	}
}
