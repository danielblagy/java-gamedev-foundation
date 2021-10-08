package com.danielblagy.gamedev;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Window extends JFrame {
	
	private JPanel panel;
	
	private BufferedImage image;
	private Graphics2D graphics;
	
	public Color clearColor;
	
	public ArrayList<GameObject> scene = new ArrayList<GameObject>();
	
	public KeyboardInput keyboardInput;
	
	
	public Window(int width, int height, String title, Color clearColor) {
		this.clearColor = clearColor;
		
		keyboardInput = new KeyboardInput();
		addKeyListener(keyboardInput);
		
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        graphics = image.createGraphics();
		
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));
        
		setTitle(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setContentPane(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void update() {

		// input handling
		keyboardInput.update();
		
		// clear
		graphics.setColor(clearColor);
		graphics.fillRect(0, 0, getWidth(), getHeight());
		
		// render the scene
		for (GameObject gameObject : scene) {
			gameObject.draw(graphics);
		}
				
		// commit render
		Graphics panelGraphics = panel.getGraphics();
		panelGraphics.drawImage(image, 0, 0, null);
		panelGraphics.dispose();
	}
}
