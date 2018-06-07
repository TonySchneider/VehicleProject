package overideClasses;

import addCarFrame.imagePanel;
import addCarFrame.openFilePanel;
import Vehicles.Vehicle;
import generalFrame.*;

public class updateDatabaseAfterAddVehicle extends updateDatabase {
	private Vehicle vehicle;
	public updateDatabaseAfterAddVehicle(Vehicle vehicle){
		this.vehicle = vehicle;
	}
	public void reduce(){
		super.reduce();
		if(openFilePanel.opened())
			vehicle.setImagePath(openFilePanel.getFilePath());
		else
			vehicle.setImage(imagePanel.getSelected());
//		Contents.vehicles.add(vehicle);
		Contents.getVehicles().add(vehicle);
		Contents.addImage();	
	}
}
