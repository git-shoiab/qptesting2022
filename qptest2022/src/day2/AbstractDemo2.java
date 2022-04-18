package day2;

public class AbstractDemo2 {
	public static void main(String[] args) {
		LenovoPlug lenovo=new LenovoPlug();
		ShakthiSocket ss=new ShakthiSocket();
		//ss.roundPinHole(lenovo);
		
		IndianAdapter adapter=new IndianAdapter();
		adapter.ap=lenovo;
		
		ss.roundPinHole(adapter);
		
	}
}

abstract class IndianPlug{
	public abstract void roundpin();
}
abstract class AmericanPlug{
	public abstract void slabPin();
}
abstract class IndianSocket{
	public abstract void roundPinHole(IndianPlug ip);
}

abstract class AmericanSocket{
	public abstract void slabPinHole(AmericanPlug ap);
}

class ShakthiSocket extends IndianSocket{
	@Override
	public void roundPinHole(IndianPlug ip) {
		ip.roundpin();
	}
}

class LenovoPlug extends AmericanPlug{
	@Override
	public void slabPin() {
		System.out.println("american plug is working....");
	}
}

class IndianAdapter extends IndianPlug{
	AmericanPlug ap;
	@Override
	public void roundpin() {
		ap.slabPin();
	}
}