//Sami shamoon ashdod
//Tony Schneider 205515828, Dani suhrayev 205583008
package Vehicles;


public class AirVehicle extends Vehicle {
	protected String Using;
	public AirVehicle(String Model,int MaxPassengers,int MaxSpeed,String Using){
		super(Model,MaxPassengers,MaxSpeed);
		this.Using = Using;
	}
	public String getUsing(){return this.Using;}
	public void setUsing(String Using){this.Using = Using;}
	public String toString(){
		return super.toString() + " Using: " + this.Using;
	}
	public boolean equals(AirVehicle other){
		if(super.equals(other) && this.Using == other.Using) return true;
		return false;
	}
	public String getType(){
		return "Air";
	}
}
