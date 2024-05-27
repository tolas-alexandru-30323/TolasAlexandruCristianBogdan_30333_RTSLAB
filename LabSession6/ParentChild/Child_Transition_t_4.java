package LabSession6.ParentChild;

import LabSession6.ParentChild.Interfaces.PlaceHandlerTemplate;
import LabSession6.ParentChild.Interfaces.TransitionTemplate;

public class Child_Transition_t_4 implements TransitionTemplate {
	Integer timeUnitControl = 500;
	Integer eet;
	Integer let;
	String Name;
	PlaceHandlerTemplate PH;
	Child c;

	public Child_Transition_t_4(String name, PlaceHandlerTemplate PH, Integer delay) {
		this.Init(name, PH);
		this.SetDelay(delay);
	}

	public Child_Transition_t_4(String name, PlaceHandlerTemplate PH, Integer eet, Integer let) {
		this.Init(name, PH);
		this.SetDelayInRange(eet, let);
	}

	@Override
	public void TransitionDelay() {
		try {
			if (this.let == null) {
				Thread.sleep(this.eet * timeUnitControl);
			} else {
				Thread.sleep(Math.round(Math.random() * (this.let - this.eet) + this.eet) * timeUnitControl);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public Boolean TransitionGuardsMappings() {
		TransitionDelay();
		String toPrint = "--------------Child-------------------\n";

		if (!PH.GetPlaceByName("p_23").IsNull() && (Float) (PH.GetPlaceByName("p_23").Get()) >= 2.0f) {

			toPrint = toPrint.concat(Print() + "\n");
			toPrint = toPrint.concat("ChildrPH\n" + PH.PrintAllPlaces() + "\n");

			System.out.println("The thread is stopped, the state is passive");
			c.StopThread();
			toPrint = toPrint.concat(Print() + "\n");
			toPrint = toPrint.concat("ChildPH\n" + PH.PrintAllPlaces() + "\n");
			toPrint = toPrint.concat("--------------------------------------\n");

			System.out.println(toPrint);

			return true;
		} else
			return false;
	}

	@Override
	public void Init(String name, PlaceHandlerTemplate PH) {
		this.PH = PH;
		this.Name = name;
	}

	@Override
	public void SetDelay(int value) {
		this.eet = value;
	}

	@Override
	public void SetDelayInRange(int eet, int let) {
		this.eet = eet;
		this.let = let;
	}

	@Override
	public String Print() {
		return this.Name + "\n" + this.PH.PrintAllPlaces();
	}
}
