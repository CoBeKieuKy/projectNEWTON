package application.model;

import javafx.scene.layout.Pane;

public class Objects extends Pane{
	private float mass=0,acceleration = 0;
	
	public float getAcceleration() {
		return acceleration;
	}
	public void setAcceleration(float acceleration) {
		this.acceleration = acceleration;
	}
	public float getMass() {
		return mass;
	}
	public void setMass(float mass) {
		this.mass = mass;
	}
}
