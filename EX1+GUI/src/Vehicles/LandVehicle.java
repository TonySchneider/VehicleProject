//Sami shamoon ashdod
//Tony Schneider 205515828, Dani suhrayev 205583008
package Vehicles;


public class LandVehicle extends Vehicle {
	protected int Wheels;
	protected String type_of_road;
	public LandVehicle(String Model,int MaxPassengers,int MaxSpeed,int Wheels,String type_of_road){
		super(Model,MaxPassengers,MaxSpeed);
		this.Wheels = Wheels;
		this.type_of_road = type_of_road;
	}
	public int getWheels(){return this.Wheels;}
	public void setWheels(int Wheels){this.Wheels = Wheels;}
	public String get_type_of_road(){return this.type_of_road;}
	public void set_type_of_road(String type_of_road){this.type_of_road = type_of_road;}
	public String toString(){
		return super.toString() + ", Wheels: " + this.Wheels + ", Type of road: " + this.type_of_road ;
	}
	public boolean equals(LandVehicle other){
		if(super.equals(other) && this.Wheels == other.Wheels && this.type_of_road == other.type_of_road) return true;
		return false;
	}
}
