package com.danielblagy.gamedev;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Main {

	public static ArrayList<GameObject> scene = new ArrayList<GameObject>();
	
	public static void main(String[] args) {
		
		// init
		
		Window gameWindow = new Window(1280, 720, "Our Game", Color.PINK);
		
		// debug objects
		DeltaDisplay deltaDisplay = new DeltaDisplay(50, 50, 0, 0);
		scene.add(deltaDisplay);
				
		// game world
		scene.add(new Rectangle(250, 250, 130, 80, Color.GREEN));
		scene.add(new Rectangle(800, 500, 200, 200, Color.CYAN));
		scene.add(new Rectangle(500, 400, 50, 50, Color.WHITE));
		
		// set the scene
		gameWindow.scene = scene;
		
		// main game loop
		
		long previousTime = System.nanoTime();
		
		while (gameWindow.isVisible()) {
			long currentTime = System.nanoTime();
			double delta = (currentTime - previousTime) / 1000000000.0;	// delta is in seconds
			previousTime = currentTime;
			
			for (GameObject entity : scene) {
				entity.update(delta);
			}
			
			// camera controls
			if (gameWindow.keyboardInput.isKeyPressed(KeyEvent.VK_UP))
				gameWindow.camera.y -= 100.0 * delta;
			
			if (gameWindow.keyboardInput.isKeyPressed(KeyEvent.VK_DOWN))
				gameWindow.camera.y += 100.0 * delta;
			
			if (gameWindow.keyboardInput.isKeyPressed(KeyEvent.VK_LEFT))
				gameWindow.camera.x -= 100.0 * delta;
			
			if (gameWindow.keyboardInput.isKeyPressed(KeyEvent.VK_RIGHT))
				gameWindow.camera.x += 100.0 * delta;
			
			gameWindow.update();
		}
		
		// release game resources, save state, etc.
	}

}
