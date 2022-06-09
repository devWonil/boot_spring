package adapter2;

public class MyHouse {

	public static void homeConnect(IElectronic220v electronic220v) {
		System.out.println("220v 전원 연결");
		electronic220v.connect();
	}
	
	public static void main(String[] args) {
		AirConditioner aircon = new AirConditioner();
		homeConnect(aircon);
		
		
	}

	
}
