package code;

import javax.swing.SwingUtilities;

import code.GUI.GUI;
import code.Model.Model;
import code.pawn.Pawn;

public class Driver {

	public static void main(String[] args) {
		Model model = new Model();
		if ( args.length == 0 ) {
			model.pawns[0] = new Pawn(2,2, model,"player 1");
			model.pawns[1] = new Pawn(4,4, model,"player 2");
			model.pawns[2] = new Pawn(2,4, model,"player 3");
			model.pawns[3] = new Pawn(4,2, model,"player 4");
			SwingUtilities.invokeLater(new GUI(model));
			}
		else {
			model.pawns[0] = new Pawn(2,2, model,args[0]);
			model.pawns[1] = new Pawn(4,4, model,args[1]);
			model.pawns[2] = new Pawn(2,4, model,args[2]);
			model.pawns[3] = new Pawn(4,2, model,args[3]);
			SwingUtilities.invokeLater(new GUI(model));
			}
		
	}

}
