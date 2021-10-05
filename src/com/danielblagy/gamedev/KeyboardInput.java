package com.danielblagy.gamedev;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyboardInput implements KeyListener {
	
	private final int bufferSize = 5;

	ArrayList<Integer> pressedKeys = new ArrayList<Integer>(bufferSize);
	ArrayList<Integer> strokedKeys = new ArrayList<Integer>(bufferSize);
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (!pressedKeys.contains(e.getKeyCode()))
			pressedKeys.add(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		pressedKeys.remove((Integer)(e.getKeyCode()));
		
		if (strokedKeys.size() >= bufferSize)
			strokedKeys.clear();
		
		strokedKeys.add(e.getKeyCode());
	}
	
	public boolean isKeyPressed(int keycode) {
		return pressedKeys.contains(keycode);
	}
	
	public boolean wasKeyStroked(int keycode) {
		return strokedKeys.remove((Integer)keycode);
	}
}
