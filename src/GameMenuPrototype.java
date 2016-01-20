/*
 * Class: CS 111B Object-Oriented Programming Methodologies in Java
 * Description: JavaPad is a word processing program that has 4 buttons on a top panel that clear, save, and load whatever is unput in the text area, as well as a quit button that prompts to save. 
 * There are two additional buttons to change the text color, as well as to change the font size.
 * Due Date: 11/30/2015
 * Name: Sebastian Kleinerman
 * File Name: JavaPad.java
 * Assignment #9
 */

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.awt.*;

public class GameMenuPrototype extends JFrame
{	
	private JFrame communityWindow, battleWindow, shopWindow, machineWindow, friendsWindow, optionsWindow;
	private JPanel buttonPanel, changeColorPanel;
	public JPanel windowPanel, communityWindowPanel, battleWindowPanel, shopWindowPanel, machineWindowPanel, friendsWindowPanel, optionsWindowPanel;
	private JButton battleButton, communityButton, shopButton, machineButton, friendsButton, optionsButton;
	private JButton communityWindowTeamButton, communityWindowPowerUpButton, communityWindowEvoButton, communityWindowSellButton, communityWindowPurchaseButton, communityWindowBoxButton;
	private JButton battleWindowSpecialButton, battleWindowTrippyButton, battleWindowNormalButton;
	private JButton shopWindowShopButton;
	private JButton machineWindowSpinButton;
	private JButton friendsWindowAddButton, friendsWindowDeleteButton;
	private JButton black, blue, cyan, darkGray, gray, green, lightGray, magenta, orange, pink, red, white, yellow;
	public 	Dimension buttonDimension = new Dimension(200, 50);
		
	//Constructor
	public GameMenuPrototype()
	{			
		setTitle("Macrosoft JavaPad XP");	
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(0, 0);
        
        Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.setBackground(Color.WHITE);
		
		createWindowPanel();
		contentPane.add(windowPanel, BorderLayout.NORTH, SwingConstants.CENTER);
		
		createButtonPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH, SwingConstants.CENTER);	
		
		//JScrollPane scrollPane = new JScrollPane(contentPane);
		//scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//contentPane.add(scrollPane, BorderLayout.CENTER);
		
		setSize(800, 500);
		setVisible(true);
		
	}
	
	/*public void setWindowLabel(String selection)
	{
		windowPanel.remove(windowLabel);
		windowLabel = new JLabel(selection);
		windowPanel.add(windowLabel, BorderLayout.WEST, SwingConstants.CENTER);
	}
	*/
	private void createWindowPanel()
	{
		windowPanel = new JPanel();
		optionsButton = new JButton("Options");
		optionsButton.addActionListener(new ButtonListener());
	    windowPanel.add(optionsButton, BorderLayout.EAST, SwingConstants.CENTER);
	}
	
	private void createButtonPanel()
	{
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.BLACK);
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
		
		battleButton = new JButton("Battle");
		battleButton.addActionListener(new ButtonListener());
	    buttonPanel.add(battleButton, BorderLayout.NORTH);
	    
	    communityButton = new JButton("Community");
	    communityButton.addActionListener(new ButtonListener());
	    buttonPanel.add(communityButton, BorderLayout.NORTH);
	    
	    shopButton = new JButton("Shop");
	    shopButton.addActionListener(new ButtonListener());
	    buttonPanel.add(shopButton, BorderLayout.NORTH);
	    
	    machineButton = new JButton("Machine");
	    machineButton.addActionListener(new ButtonListener());
	    buttonPanel.add(machineButton, BorderLayout.NORTH);
	    
	    friendsButton = new JButton("Friends");
	    friendsButton.addActionListener(new ButtonListener());
	    buttonPanel.add(friendsButton, BorderLayout.NORTH);
	    
	}
	
	private class ButtonListener implements ActionListener
	{
	 public void actionPerformed(ActionEvent event)
	 {
		 Object source = event.getSource();
	     if (source == battleButton)
	     { 
	    	 battleWindow = new JFrame();
	    	 battleWindowPanel = new JPanel();
	    	 
	    	 battleWindowSpecialButton = createButtons("Special Battles", buttonDimension, Color.ORANGE, Color.RED);
	    	 battleWindowPanel.add(battleWindowSpecialButton);
	    	 
	    	 battleWindowTrippyButton = createButtons("Trippy Battles", buttonDimension, Color.CYAN, Color.MAGENTA);
	    	 battleWindowPanel.add(battleWindowTrippyButton);
	    	 
	    	 battleWindowNormalButton = createButtons("Normal Battles", buttonDimension, Color.GREEN, Color.DARK_GRAY);
	    	 battleWindowPanel.add(battleWindowNormalButton);
	    	 
	    	 battleWindow.setSize(new Dimension(200, 300));
	    	 battleWindow.setTitle("Battles");
	    	 battleWindow.setLayout(new BorderLayout());
	    	 battleWindow.setLocation(300, 100);
	    	 battleWindow.add(battleWindowPanel);
	    	 battleWindow.setVisible(true);
	    	
	     }
	     else if(source == communityButton)
	     { 
	    	 communityWindow = new JFrame();
	    	 communityWindowPanel = new JPanel();
	         
	         communityWindowTeamButton = createButtons("Edit Teams", buttonDimension, Color.DARK_GRAY, Color.GREEN);
	         communityWindowPanel.add(communityWindowTeamButton, BorderLayout.WEST);
	         
	         communityWindowPowerUpButton = createButtons("Power-Up Fusion", buttonDimension, Color.DARK_GRAY, Color.CYAN);
	         communityWindowPanel.add(communityWindowPowerUpButton, BorderLayout.WEST);

	         communityWindowEvoButton = createButtons("Evolution", buttonDimension, Color.DARK_GRAY, Color.BLUE);
	         communityWindowPanel.add(communityWindowEvoButton, BorderLayout.WEST);
	        
	         communityWindowSellButton = createButtons("Sell Shit", buttonDimension, Color.DARK_GRAY, Color.MAGENTA);
	         communityWindowPanel.add(communityWindowSellButton, BorderLayout.WEST);
	         
	         communityWindowPurchaseButton = createButtons("Purchase Shit", buttonDimension, Color.DARK_GRAY, Color.ORANGE);
	         communityWindowPanel.add(communityWindowPurchaseButton, BorderLayout.WEST);
	         
	         communityWindowBoxButton = createButtons("All Yo Shit", buttonDimension, Color.DARK_GRAY, Color.PINK);
	         communityWindowPanel.add(communityWindowBoxButton, BorderLayout.WEST);
	        
	         communityWindow.setSize(new Dimension(200, 300));
	    	 communityWindow.setTitle("Community");
	    	 communityWindow.setLayout(new BorderLayout());
	    	 communityWindow.setLocation(300, 100);
	         communityWindow.add(communityWindowPanel);
	         communityWindow.setVisible(true);
	         
	     }
	     else if(source == communityWindowTeamButton)
	     {
				communityWindow.dispose();
	     }
	     else if(source == shopButton)
	     {
	    	 shopWindow = new JFrame();
	    	 shopWindow.setSize(new Dimension(200, 300));
	    	 shopWindow.setTitle("Shop");
	    	 shopWindow.setLayout(new BorderLayout());
	    	 shopWindow.setLocation(300, 100);
	    	 
	    	 shopWindowPanel = new JPanel();
	    	 shopWindowShopButton = createButtons("Shop", buttonDimension, Color.YELLOW, Color.BLUE);
	    	 shopWindowPanel.add(shopWindowShopButton, BorderLayout.NORTH);
	    	 shopWindow.add(shopWindowPanel);
	    	 shopWindow.setVisible(true);
	     }
	     else if(source == machineButton)
	     {
	    	 machineWindow = new JFrame();
    		 machineWindow.setSize(new Dimension(200, 300));
    		 machineWindow.setTitle("Spin Machine");
    		 machineWindow.setLayout(new BorderLayout());
    		 machineWindow.setLocation(300, 100);
    		 
    		 machineWindowPanel = new JPanel();
    		 machineWindowSpinButton = new JButton("SPIN");
    		 machineWindowSpinButton.setBackground(Color.YELLOW);
    		 machineWindowSpinButton.setForeground(Color.MAGENTA);
    		 machineWindowSpinButton.setBorder(null);
    		 machineWindowSpinButton.setOpaque(true);
    		 machineWindowSpinButton.addActionListener(this);
    		 machineWindowSpinButton.setPreferredSize(buttonDimension);
    		 machineWindowPanel.add(machineWindowSpinButton);
    		 machineWindow.add(machineWindowPanel);
	    	 machineWindow.setVisible(true);
	     }
	     else if(source == friendsButton)
	     {
	    	 friendsWindow = new JFrame();
	    	 friendsWindow.setSize(new Dimension(200, 300));
	    	 friendsWindow.setTitle("Friends");
	    	 friendsWindow.setLayout(new BorderLayout());
	    	 friendsWindow.setLocation(300, 100);
	    	 
	    	 friendsWindowPanel = new JPanel();
	    	 friendsWindowAddButton = new JButton("Add");
	    	 friendsWindowAddButton.addActionListener(this);
	    	 friendsWindowAddButton.setBackground(Color.GRAY);
	    	 friendsWindowAddButton.setForeground(Color.CYAN);
	    	 friendsWindowAddButton.setBorder(null);
	    	 friendsWindowAddButton.setOpaque(true);
	    	 friendsWindowAddButton.setPreferredSize(buttonDimension);
	    	 friendsWindowDeleteButton = new JButton("Delete");
	    	 friendsWindowDeleteButton.addActionListener(this);
	    	 friendsWindowDeleteButton.setBackground(Color.LIGHT_GRAY);
	    	 friendsWindowDeleteButton.setForeground(Color.RED);
	    	 friendsWindowDeleteButton.setBorder(null);
	    	 friendsWindowDeleteButton.setOpaque(true);
	    	 friendsWindowDeleteButton.setPreferredSize(buttonDimension);
	    	 friendsWindowPanel.add(friendsWindowAddButton, BorderLayout.NORTH);
	    	 friendsWindowPanel.add(friendsWindowDeleteButton, BorderLayout.NORTH);
	    	 friendsWindow.add(friendsWindowPanel);
	    	 friendsWindow.setVisible(true);
	     }
	     else if(source == optionsButton)
	     {
	    	optionsWindow = new JFrame();
	    	optionsWindow.setSize(new Dimension(200, 300));
	    	optionsWindow.setTitle("Options");
	    	optionsWindow.setLayout(new BorderLayout());
	    	optionsWindow.setLocation(300, 100);
	    	optionsWindow.setVisible(true);
	     }
	  }
	}
	
	public JButton createButtons(String name, Dimension dimension, Color back, Color text)
	{
		dimension = buttonDimension;
		JButton button = new JButton(name);
		button.setLayout(new BorderLayout());
		button.setPreferredSize(dimension);
		button.setBackground(back);
		button.setForeground(text);
		button.setOpaque(true);
		return button;
	}
	
	/*private class ColorButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object source = event.getSource();
			if(source == black)
			{
				textArea.setForeground(Color.BLACK);
				changeColorWindow.dispose();
			}
			else if(source == blue)
			{
				textArea.setForeground(Color.BLUE);
				changeColorWindow.dispose();
			}
			else if(source == cyan)
			{
				textArea.setForeground(Color.CYAN);
				changeColorWindow.dispose();
			}
			else if(source == darkGray)
			{
				textArea.setForeground(Color.DARK_GRAY);
				changeColorWindow.dispose();
			}
			else if(source == gray)
			{
				textArea.setForeground(Color.GRAY);
				changeColorWindow.dispose();
			}
			else if(source == green)
			{
				textArea.setForeground(Color.GREEN);
				changeColorWindow.dispose();
			}
			else if(source == lightGray)
			{
				textArea.setForeground(Color.LIGHT_GRAY);
				changeColorWindow.dispose();
			}
			else if(source == magenta)
			{
				textArea.setForeground(Color.MAGENTA);
				changeColorWindow.dispose();
			}
			else if(source == orange)
			{
				textArea.setForeground(Color.ORANGE);
				changeColorWindow.dispose();
			}
			else if(source == pink)
			{
				textArea.setForeground(Color.PINK);
				changeColorWindow.dispose();
			}
			else if(source == red)
			{
				textArea.setForeground(Color.RED);
				changeColorWindow.dispose();
			}
			else if(source == white)
			{
				textArea.setForeground(Color.WHITE);
				changeColorWindow.dispose();
			}
			else if(source == yellow)
			{
				textArea.setForeground(Color.YELLOW);
				changeColorWindow.dispose();
			}
		}
		
		//just some color changing bullshit
		
		 black = new JButton("Black");
	    	 black.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(black, BorderLayout.CENTER);
	    	 
	    	 blue = new JButton("Blue");
	    	 blue.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(blue, BorderLayout.CENTER);
	    	 
	    	 cyan = new JButton("Cyan");
	    	 cyan.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(cyan, BorderLayout.CENTER);
	    	 
	    	 darkGray = new JButton("Dark Gray");
	    	 darkGray.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(darkGray, BorderLayout.CENTER);
	    	 
	    	 gray = new JButton("Gray");
	    	 gray.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(gray, BorderLayout.CENTER);
	    	 
	    	 green = new JButton("Green");
	    	 green.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(green, BorderLayout.CENTER);
	    	 
	    	 lightGray = new JButton("Light Gray");
	    	 lightGray.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(lightGray, BorderLayout.CENTER);
	    	 
	    	 magenta = new JButton("Magenta");
	    	 magenta.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(magenta, BorderLayout.CENTER);
	    	 
	    	 orange = new JButton("Orange");
	    	 orange.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(orange, BorderLayout.CENTER);
	    	 
	    	 pink = new JButton("Pink");
	    	 pink.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(pink, BorderLayout.CENTER);
	    	 
	    	 red = new JButton("Red");
	    	 red.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(red, BorderLayout.CENTER);
	    	 
	    	 white = new JButton("White");
	    	 white.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(white, BorderLayout.CENTER);
	    	 
	    	 yellow = new JButton("Yellow");
	    	 yellow.addActionListener(new ColorButtonListener());
	    	 changeColorPanel.add(yellow, BorderLayout.CENTER);
		
		
	}*/
}
