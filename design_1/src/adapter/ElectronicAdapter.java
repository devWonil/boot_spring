package adapter;

// 220v
public class ElectronicAdapter implements IElectronic220v{
	
	// adapter 패턴을 설계하는 방법
	
	// 1. 포함 관계를 만들어준다. E110v
	private IElectronic110v electronic110v;
	
	// 2. 생성자를 통해서 의존 주입을 받을 수 있도록 설계한다
	// 생성자는 객체를 메모리에 올릴 때 반드시 호출해야하는 강제성
	public ElectronicAdapter(IElectronic110v electronic110v) {
		this.electronic110v = electronic110v;
	}
	
	@Override
	public void connect() {
		electronic110v.connect(); // 런타임 시점에 메모리에 올라가 있는 객체의 동작을 호출한다
	}

}
