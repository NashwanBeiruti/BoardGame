package code.GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import code.Model.Model;
import code.pawn.Pawn;

public class keyMovement implements KeyListener {
	
	private Pawn _pawn;
	private Model _model;
	
	
	public keyMovement(Model m,Pawn p) {
		// TODO Auto-generated constructor stub
		_pawn = p;
		_model = m;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(!_model.firstMove){
		int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	            _pawn.move("North");
	            System.out.println(_pawn.checkIfValidMove());
	            if(_pawn.validMove){
	            	_pawn.pickUpToken();
	            	System.out.println(_pawn.tokenCount());
	            }
	            _model.gameChanged();
	            break;
	        case KeyEvent.VK_DOWN:
	        	_pawn.move("South");
	        	System.out.println(_pawn.checkIfValidMove());
	        	if(_pawn.validMove){
	            	_pawn.pickUpToken();
	            	System.out.println(_pawn.tokenCount());
	            }
	        	_model.gameChanged();
	            break;
	        case KeyEvent.VK_LEFT:
	        	_pawn.move("West");
	        	System.out.println(_pawn.checkIfValidMove());
	        	if(_pawn.validMove){
	            	_pawn.pickUpToken();
	            	System.out.println(_pawn.tokenCount());
	            }
	        	_model.gameChanged();
	            break;
	        case KeyEvent.VK_RIGHT :
	        	_pawn.move("East");
	        	System.out.println(_pawn.checkIfValidMove());
	        	if(_pawn.validMove){
	            	_pawn.pickUpToken();
	            	System.out.println(_pawn.tokenCount());
	            }
	        	_model.gameChanged();
	            break;
	            
	        case KeyEvent.VK_KP_UP:
	            _pawn.move("North");
	            System.out.println(_pawn.checkIfValidMove());
	            if(_pawn.validMove){
	            	_pawn.pickUpToken();
	            	System.out.println(_pawn.tokenCount());
	            }
	            _model.gameChanged();
	            break;
	        case KeyEvent.VK_KP_DOWN:
	        	_pawn.move("South");
	        	System.out.println(_pawn.checkIfValidMove());
	        	if(_pawn.validMove){
	            	_pawn.pickUpToken();
	            	System.out.println(_pawn.tokenCount());
	            }
	        	_model.gameChanged();
	            break;
	        case KeyEvent.VK_KP_LEFT:
	        	_pawn.move("West");
	        	System.out.println(_pawn.checkIfValidMove());
	        	if(_pawn.validMove){
	            	_pawn.pickUpToken();
	            	System.out.println(_pawn.tokenCount());
	            }
	        	_model.gameChanged();
	            break;
	        case KeyEvent.VK_KP_RIGHT :
	        	_pawn.move("East");
	        	System.out.println(_pawn.checkIfValidMove());
	        	if(_pawn.validMove){
	            	_pawn.pickUpToken();
	            	System.out.println(_pawn.tokenCount());
	            }
	        	_model.gameChanged();
	            break;    
	    	}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
