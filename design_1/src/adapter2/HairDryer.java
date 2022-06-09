package adapter2;

public class HairDryer implements IElectronic110v{

	@Override
	public void connect() {
		System.out.println("헤어드라이더 동작");
	}

}
