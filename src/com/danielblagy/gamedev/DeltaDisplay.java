package com.danielblagy.gamedev;

import java.awt.Color;
import java.awt.Graphics2D;

public class DeltaDisplay extends GameObject {

	private int fps = 0;
	private double cumulativeDelta = 0.0;
	
	
	public DeltaDisplay(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.magenta);
		g.drawString(Integer.toString(fps), x, y);
	}

	@Override
	public void update(double delta) {
		cumulativeDelta += delta;
		if (cumulativeDelta >= 1.0) {
			fps = (int) (1.0 / delta);
			cumulativeDelta = 0.0;
		}
	}

}
