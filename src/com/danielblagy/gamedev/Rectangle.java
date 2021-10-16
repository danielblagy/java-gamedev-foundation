package com.danielblagy.gamedev;

import java.awt.Color;
import java.awt.Graphics2D;

public class Rectangle extends GameObject {

	Color color;
	
	public Rectangle(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		this.color = color;
	}

	@Override
	public void draw(Graphics2D g, Camera camera) {
		g.setColor(color);
		
		if (camera.captures(this)) {
			g.fillRect(
					(int)((x - camera.x) * camera.scaleX),
					(int)((y - camera.y) * camera.scaleY),
					(int)(width * camera.scaleX),
					(int)(height * camera.scaleY)
				);
		}
	}

	@Override
	public void update(double delta) {
		
	}

}
