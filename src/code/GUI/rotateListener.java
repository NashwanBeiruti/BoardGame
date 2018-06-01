package code.GUI;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import code.Model.Model;

public class rotateListener implements ActionListener{

	private String _direction;
	private Model _model;
	
	
	public rotateListener(Model m,String d) {
		// TODO Auto-generated constructor stub
		_model = m;
		_direction = d;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(_direction.equals("North"))_model.getHoldTile().Rotate("East");
		if(_direction.equals("East"))_model.getHoldTile().Rotate("South");
		if(_direction.equals("South"))_model.getHoldTile().Rotate("West");
		if(_direction.equals("West"))_model.getHoldTile().Rotate("North");
		_model.gameChanged();
		
	}

}
