package overideClasses;
import generalFrame.*;
public class updateDatabaseAfterReset extends updateDatabase {
	public void reduce(){
		for(int i=0;i<Contents.getVehicles().size();i++){
			Contents.getVehicles().get(i).setZero();
			Contents.getImages().get(i).setToolTipText(Contents.getVehicles().get(i).toString());
		}
	}
}
