package adapter;

public class MyHouse {

	// 집에 전기 콘센트에 연결하는 동작
	public static void homeConnect(IElectronic220v electronic220v) {
		electronic220v.connect();
	}

	public static void main(String[] args) {
		// 1. 에어컨
		// 2. 헤어드라이기
		// 3. 청소기

		// 추상화 하기 - 인터페이스(공통적인 동작)
		// connect(); 사용하려면 전기가 필요 연결하는 동작을 구현 해야한다.

		// 문제 인식
		// 친구가 일본에서 결혼 선물, 청소기, 헤어드라이기 선물
		// 110v 동작, 에어컨은 220v에 동작

		// 사용해 보기
		AirConditioner airConditioner = new AirConditioner();
		// 집에 전기콘센트에 연결
		homeConnect(airConditioner);

		HairDryer hairDryer = new HairDryer();
		// homeConnect(hairDryer); 연결 불가능

		Cleaner cleaner = new Cleaner();
		// homeConnect(cleaner); 연결 불가능

		// 어댑터 구매해서 사용하기
		ElectronicAdapter adapter1 = new ElectronicAdapter(hairDryer);

		// 집에있는 콘센트에 연결하기
		homeConnect(adapter1);

		// 어댑터 구매해서 사용하기
		ElectronicAdapter adapter2 = new ElectronicAdapter(cleaner);

		// 집에있는 콘센트에 연결하기
		homeConnect(adapter2);

	}

}
