package com.danielblagy.gamedev;

import java.awt.Graphics2D;

public abstract class GameObject {
	
	public int x, y, width, height;
	
	
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void draw(Graphics2D g);
	
	public abstract void update(double delta);
}
