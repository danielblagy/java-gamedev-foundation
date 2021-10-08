package com.danielblagy.gamedev;

import java.awt.Color;
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
			
			if (gameWindow.keyboardInput.isKeyPressed(KeyEvent.VK_F))
				System.out.println("Fire!");
			
			if (gameWindow.keyboardInput.isKeyPressedOnce(KeyEvent.VK_A))
				System.out.println("has been pressed!");
			
			if (gameWindow.keyboardInput.isKeyReleased(KeyEvent.VK_A))
				System.out.println("has been released!");
		}
		
		// release game resources, save state, etc.
	}

}
