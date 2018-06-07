package overideClasses;
import generalFrame.*;
public class updateDatabaseAfterBuy extends updateDatabase {
	private String selected;
	public updateDatabaseAfterBuy(String selected){
		this.selected = selected;
	}
	public void reduce(){
		super.reduce();
		Contents.removeImage(selected);
	}
}
