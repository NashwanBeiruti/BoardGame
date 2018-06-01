package code.GUI;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import code.Model.Model;

public class shiftListener implements ActionListener {

	private Model _model;
	private int col;
	private int row;
	
	
	public shiftListener(Model m,int x, int y){
		_model=m;
		col = x;
		row = y;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_model.moveTiles(col,row);
		
	}

}
