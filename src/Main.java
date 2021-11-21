import java.util.ArrayList;
import models.Android;
import models.Iphone;
import services.AppService;
import services.PhoneService;

public class Main {
	
	public static void main(String[] args) {
		
		//--APP CODE--
		
		AppService appService = new AppService();
		PhoneService phoneService = new PhoneService();
		
		ArrayList<Android> androidList = phoneService.getAndroidList();
		ArrayList<Iphone> iphoneList = phoneService.getIphoneList();

		appService.welcomeUser();
		appService.selectMenuOption(iphoneList, androidList);
	}
	
}
