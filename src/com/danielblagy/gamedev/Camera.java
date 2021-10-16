package com.danielblagy.gamedev;

public class Camera {
	
	public double x, y, width, height;
	public double scaleX, scaleY;
	
	public Camera(double x, double y, double width, double height, Window window) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		scaleX = window.getWidth() / width;
		scaleY = window.getHeight() / height;
	}
	
	public boolean captures(GameObject object) {
		return 	object.x <= (x + width) && (object.x + object.width) >= x &&
				object.y <= (y + height) && (object.y + object.height) >= y;
	}
}
