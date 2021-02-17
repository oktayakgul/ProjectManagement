package com.oa.pma.sample;

public class Car {
	Engine e;
	Door d;
	Wheel w;
	
	public Car(Engine e, Door d, Wheel w) {
		this.e = e;
		this.d = d;
		this.w = w;
	}
	
	@Override
	public String toString() {
		return "Car{" + "e=" + e + ", d=" + d + ", w=" + w + '}';
	}
}
