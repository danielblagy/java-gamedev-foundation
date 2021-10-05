package com.danielblagy.gamedev;

import java.awt.Color;
import java.awt.event.KeyEvent;

public class Main {

	public static void main(String[] args) {
		
		// init
		
		Window gameWindow = new Window(1280, 720, "Our Game", Color.PINK);
		
		Rectangle rect1 = new Rectangle(250, 250, 130, 80);
		gameWindow.scene.add(rect1);
		
		// main game loop
		
		while (gameWindow.isVisible()) {
			//rect1.update();
			if (gameWindow.keyboardInput.wasKeyStroked(KeyEvent.VK_F))
				System.out.println("Fire!");
			gameWindow.renderScene();
		}
		
		// release game resources, save state, etc.
	}

}
