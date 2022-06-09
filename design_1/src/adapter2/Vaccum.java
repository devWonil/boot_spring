package adapter2;

public class Vaccum implements IElectronic110v{

	@Override
	public void connect() {
		System.out.println("청소기 연결");
	}

}
