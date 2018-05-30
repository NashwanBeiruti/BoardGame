package code.GUI;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import code.Model.Model;

public class endTurnListener implements ActionListener{

	private Model _model;
	
	/**
	 * @author <Nash>
	 * Constructor
	 * Creates a button action listener for ending a turn
	 * @param m associates the Model class with this one
	 */	
	public endTurnListener(Model m) {
		// TODO Auto-generated constructor stub
		_model = m;
	}

	
	/**
	 * @author <Nash>
	 * Checks to see if a pawn has first shifted the board in order to end turn. After it checks to see 
	 * if a move is valid then saves the next coordinates to know for the next turn what that pawns 
	 * valid movements are. It then calls calls on the update method in the model class to show the recent changes.
	 * @param e 
	 */	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(!_model.firstMove){
			if(_model.pawns[_model.playerUp-1].validMove){
				_model.pawns[_model.playerUp-1].validMove = false;
				_model.pawns[_model.playerUp-1].startX = _model.pawns[_model.playerUp-1].getPositionX();
				_model.pawns[_model.playerUp-1].startY = _model.pawns[_model.playerUp-1].getPositionY();
			}
			_model.firstMove = true;
			_model.playerUp = _model.playerUp + 1;
			if(_model.playerUp>4)_model.playerUp = 1;
			_model.gameChanged();
		}
		
	}

}
