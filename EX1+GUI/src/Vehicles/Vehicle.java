//Sami shamoon ashdod
//Tony Schneider 205515828, Dani suhrayev 205583008
package Vehicles;

import javax.swing.ImageIcon;

public abstract class Vehicle {
	protected String name;
	protected int KM=0;
	protected int MaxPassengers;
	protected int MaxSpeed;
	protected String imageName = null;
	protected String imagePath = null;
	public Vehicle(String name,int MaxPassengers,int MaxSpeed){
		this.name = name;
		this.MaxPassengers = MaxPassengers;
		this.MaxSpeed = MaxSpeed;
	}
	public void addKM(int KM){this.KM += KM;}
	public void setZero(){KM = 0;}
	public String getName(){
		return name+"("+this.getClass().getSimpleName()+")";
		}
	public String toString(){
		return "Model: " + this.name+"("+this.getClass().getSimpleName()+")"+ ", traveled: " + this.KM + " km, can carry max of: " + this.MaxPassengers + " people, Max speed of: " + this.MaxSpeed +" Mph "; 
	}
	public boolean equals(Vehicle other){
		if(this.name == other.name && this.KM == other.KM && this.MaxPassengers == other.MaxPassengers && this.MaxSpeed == other.MaxSpeed) return true;
		return false;
	}
	public void setImage(String imageName){ this.imageName = imageName;}
	public String getImage(){return imageName;}
	public void setImagePath(String imagePath){ this.imagePath = imagePath;}
	public String getImagePath(){return imagePath;}
}
