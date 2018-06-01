package code.GUI;

import javax.swing.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.Model.Model;

public class SaveButtonActionListener implements ActionListener {
	//Instance variables. 
	private Model _model;
	private Component _mainWindow;
   //creation of constructors and assigning instance variables to local variables.  
	public SaveButtonActionListener(Component mainWindow, Model model) {
		
		_mainWindow = mainWindow;
		
		_model = model;
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
   //use joptionPane as a way to create a dialog box. 	
   if(JOptionPane.showConfirmDialog(_mainWindow, "Are you sure you want to save?","Save Game",JOptionPane.YES_OPTION)==0) {
	   
	  try {
		_model.save(Model.SAVE_FILENAME);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	   
	   
	   
   }
	
		
		
		
		
		
		
	}

}