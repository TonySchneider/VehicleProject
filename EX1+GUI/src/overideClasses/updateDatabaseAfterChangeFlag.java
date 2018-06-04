package overideClasses;

import generalFrame.Contents;
import Vehicles.SeaVehicle;

public class updateDatabaseAfterChangeFlag extends updateDatabase {
	private String flag;
	public updateDatabaseAfterChangeFlag(String flag){
		this.flag = flag;
	}
	public void reduce(){
		for(int i=0;i<Contents.getVehicles().size();i++)
			if(Contents.getVehicles().get(i) instanceof SeaVehicle){
				((SeaVehicle)Contents.getVehicles().get(i)).set_country_flag(flag);
				Contents.getImages().get(i).setToolTipText(Contents.getVehicles().get(i).toString());
			}
	}
}
