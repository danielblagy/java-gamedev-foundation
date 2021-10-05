package com.danielblagy.gamedev;

import java.awt.Color;
import java.awt.Graphics2D;

public class Rectangle extends GameObject {

	public Rectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void update() {
		System.out.println("Rectangle update!");
	}

}
