package adapter2;

public class AirConditioner implements IElectronic220v {

	@Override
	public void connect() {
		System.out.println("에어컨 동작 220v");
	}
	
}
