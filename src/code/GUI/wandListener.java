package code.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import code.Model.Model;
import code.pawn.Pawn;
/**
 * Issues with existing code: When a token is collected the turn automatically ends. 
 * This is an issue because it doesn't give the player a chance to use the wand.
 * What needs to be done: When wand is pressed it replays turn
 *  @author blmej
 * 
 * 
 *
 */

public class wandListener implements ActionListener{
	private Model _model; 

	
	
	public wandListener(Model m){
		_model = m;

		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 _model.useWand();
		  
		  
		
		
	}

}
