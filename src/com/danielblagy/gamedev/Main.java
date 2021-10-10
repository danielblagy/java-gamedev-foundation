package com.danielblagy.gamedev;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;

public class Main {

	public static void main(String[] args) {
		
		// init
		
		Window gameWindow = new Window(1280, 720, "Our Game", Color.PINK);
		
		Rectangle rect1 = new Rectangle(250, 250, 130, 80);
		gameWindow.scene.add(rect1);
		
		DeltaDisplay deltaDisplay = new DeltaDisplay(50, 50, 0, 0);
		gameWindow.scene.add(deltaDisplay);
		
		// main game loop
		
		long previousTime = System.nanoTime();
		
		while (gameWindow.isVisible()) {
			long currentTime = System.nanoTime();
			double delta = (currentTime - previousTime) / 1000000000.0;	// delta is in seconds
			previousTime = currentTime;
			
			deltaDisplay.update(delta);
			
			gameWindow.update();
			
			if (gameWindow.mouseInput.getButton(3).pressedOnce) {
				System.out.println("Safety off!");
			}
			
			if (gameWindow.keyboardInput.isKeyPressed(KeyEvent.VK_F))
				System.out.println("Fire!");
			
			if (gameWindow.keyboardInput.isKeyPressedOnce(KeyEvent.VK_A))
				System.out.println("has been pressed!");
			
			if (gameWindow.keyboardInput.isKeyReleased(KeyEvent.VK_A))
				System.out.println("has been released!");
			
			
			if (gameWindow.mouseInput.getButton(3).pressed) {
				System.out.println("Shooting!");
			}
			
			if (gameWindow.mouseInput.getButton(3).released) {
				System.out.println("Reloading!");
			}
			
			if (gameWindow.mouseInput.getButton(1).clicked) {
				System.out.println("Shields up!");
			}
			
			if (gameWindow.mouseInput.getWheel() != null) {
				System.out.println("Scrolling!");
			}
			
			Point mousePosition = gameWindow.mouseInput.getPosition();
			//System.out.println(mousePosition.x + ", " + mousePosition.y);
		}
		
		// release game resources, save state, etc.
	}

}
