package day2;

import java.util.Scanner;

public class FanDemo {
	public static void main(String[] args) {
		//Fan shaitan=new Fan();
		GoodFan khaitan=new GoodFan();
		while(true) {
			Scanner scan=new Scanner(System.in);
			System.out.println("please pull the chain....");
			int n=scan.nextInt();
			khaitan.pull();
		}
	}
}

class Fan{
	int state;
	public void pull() {
		if(state==0) {
			System.out.println("switch on state....");
			state=1;
		}
		else if(state==1) {
			System.out.println("medium speed state...");
			state=2;
		}
		else if(state==2) {
			System.out.println("high speed state....");
			state=3;
		}
		else if(state==3) {
			System.out.println("switch off state...");
			state=0;
		}
	}
}

class GoodFan{
	State state=new SwitchOffState();
	public void pull() {
		state.pull(this);
	}
}

abstract class State{
	public abstract void pull(GoodFan fan);
}
class SwitchOffState extends State{
	@Override
	public void pull(GoodFan fan) {
		System.out.println("switch on state....");
		fan.state=new SwitchOnState();
	}
}
class SwitchOnState extends State{
	@Override
	public void pull(GoodFan fan) {
		System.out.println("Medium speed state....");
		fan.state=new MediumSpeedState();
	}
}
class MediumSpeedState extends State{
	@Override
	public void pull(GoodFan fan) {
		System.out.println("High Speed state...");
		fan.state=new HighSpeedState();
	}
}
class HighSpeedState extends State{
	@Override
	public void pull(GoodFan fan) {
		System.out.println("switch off state...");
		fan.state=new SwitchOffState();
	}
}