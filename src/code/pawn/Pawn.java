package code.pawn;

import java.util.ArrayList;


import code.Model.Model;
import code.Tokens.Token;

/**
 * Class will create a Pawn object. Class contains methods for movement of the pawn, which
	  calls to the tile/board to verify movement is possible. There are method stubs
	  and some additional code beyond the scope of the project, but any additional coding can be
	  taken as ideas that were noted for possible future implementation.
 * @author Nash
 *
 */
public class Pawn {
	
	/**
	 * @author Nash
	 * wcount: Field containing the number of wands the player has. Future implementation.
	 */
	public int wcount = 3;
	/**
	 * @author Nash
	 * points: current point value player has for winning condition.
	 */
	private int points;
	/**
	 * @author Nash
	 * numOfTokens: Number of tokens the player current has. For winning condition. Future implementation.
	 */
	private int numOfTokens;
	/**
	 * @author Nash
	 * positionX: Player's current X position. Horizontal.
	 */
	private int positionX;
	/**
	 * @author Nash
	 * positionY: Player's current Y position. Vertical.
	 */
	private int positionY;
	/**
	 * @author Nash
	 * board: associates the board to the pawn for calling methods back to the board.
	 */
	private Model board;
	/** 
	 * @author Nash
	 * next: Storage field for testing the canMove method.
	 */
	private Boolean next = false;
	
	private ArrayList<Integer>tokenCounts;
	
	public ArrayList<Integer> recipe;
	
	public Boolean validMove = false;
	
	public int startX;
	public int startY;
	
	private String player ="";
	
	
	/**
	 * @author Nash
	 * Method can create a pawn at a specified position for game creation.
	 * @param y coordinate
	 * @param x coordinate
	 * @param board links to board.
	 */
	public Pawn(int y, int x, Model board,String player){
		
		this.board = board;
		this.positionX = x;
		this.positionY = y;
		this.player = player;
		tokenCounts = new ArrayList<Integer>();
		
		startX = x;
		startY = y;

		//new code
		recipe = board.allRecipes.getRandomRecipe();
	}
	
	/**
	 * @author <Nash>
	 * @return checks 'validMove' if the pawn has made a movement that is not the same spot
	 * it has started from
	 */	
	public Boolean checkIfValidMove(){
		validMove = !board.getTile(positionX, positionY).equals(board.getTile(startX, startY));
		return validMove;
		
	}
	
	/**
	 * @author <Nash>
	 * @return checks 'tokenCounts' to see how many tokens each pawn has collected.
	 */	
	public ArrayList<Integer> tokenCount(){
		return tokenCounts;
	}
	
	/**
	 * @author Nash
	 * This method sets the current location of the pawn's instance variable at a specific position
	 * on the board using x and y coordinates. This method may be used for game creation as well as
	 * moving the player piece during the game play.
	 * @param x sets the pawns's positionX field
	 * @param y sets the pawn's positionY field
	 */
	public void setCurrentLocation(int y, int x){
		this.positionX = x;
		this.positionY = y;
	}
	/**
	 * @author Nash
	 * Returns pawn's positionX value, which is where it is horizontally on the board.
	 * @return
	 */
	public int getPositionX(){
		return positionX;
	}
	/**
	 * @author Nash
	 * Returns pawn's positionY value, which is where it is vertically on the board.
	 * @return
	 */
	public int getPositionY(){
		return positionY;
	}
	/**
	 * @author Nash
	*This method takes in, as a string, the direction of movement called on the pawn. The direction,
	*taken in as a String, is set to lowercase and only the zeroth index is checked for the direction.
	*Once the input is taken into the parameter, it is passed into the first if statement, which
	*calls on the canMove method to verify the movement is possible prior to any further action
	*taking place. If the canMove method returns true, the pawn's instance variables for
	*it's position are then incremented, which is determined by the direction in which the pawn
	* moves.
	*/
	public void move(String direction){
		if (this.canMove(direction)==true){
			switch (direction){
			case "North": positionY = positionY -1;
			break;
			case "West": positionX = positionX - 1;
			break;
			case "South": positionY = positionY + 1;
			break;
			case "East": positionX = positionX + 1;
			}
			
		}else{
			System.out.println("Path "+direction+" is blocked. Please choose another direction.");
		}
	}
	/**
	 * @author Nash
	 * This method takes in the direction the pawn is attempting to move, sends the information to the
	*board, which determines the location the pawn is on. It then checks the tile at that location,
	*verifies the boolean value set for the direction it wishes to go, then checks the target tile
	*to determine if it is accepting movement from that direction. If this method returns true, then 
	*and only then can the pawn move.
	*/
	public Boolean canMove(String direction){
		Boolean current = board.getTileBool(positionX, positionY, direction);
		switch (direction){
		
		case "North": next = board.getTileBool((positionX), positionY-1, "South");
		System.out.println("positionY:"+positionY);
		System.out.println("Current: "+current+"\nNext: "+next);
		return (current&&next);
		
		case "South": next = board.getTileBool((positionX), positionY+1, "North");
		System.out.println("Current: "+current+"Next: "+next);
		return (current&&next);
		
		case "West": next=board.getTileBool(positionX-1, (positionY), "East");
		System.out.println("Current: "+current+"Next: "+next);
		return (current&&next);
		
		case "East": next = board.getTileBool(positionX+1, (positionY), "West");
		System.out.println("Current: "+current+"Next: "+next);
		return (current&&next);
		}
		return false;
		
	}
	/**
	 * @author Nash
	 * Method returns the boolean value of the next field.
	 * @return
	 */
	public Boolean getNext(){
		return next;
	}
	
		

	/**
	 * @author Nash
	 * This method may be called to check the victory condition of the game on the pawn. As this
	 * implementation is not required at this stage, this method has not be completed.
	 */
	public void checkFormula(){
		
	}
	/**
	 * @author Nash
	 * Future method implementation for initial game creation. Pawn will get the formula in the future,
	 * once that portion of the code has been implemented.
	 */
	public void getFormula(){
		
	}
	/**
	 * @author Nash
	 * Future method stub for the player seeing what the victory condition actually is for their pawn.
	 */
	public void displayFormula(){
		
	}
	/**
	 * @author Nash
	 * Method stub, partially written, for the pawn being able to pick up the token at the position
	 * he is currently in. Implementation has not been finalized. Any code contained in the method
	 * at this time can be used only for a notation of a thought process for future implementation.
	 */
	private void getToken(Token token){
		if (token.getValue()==token.getPickUpCount()){
			
		}
		
	}
	/**
	 * @author Nash
	 * Method stub. Will, once completed, act as the boolean check to ensure that the token
	 * will be obtainable via the getToken method in combination with a data structure
	 * such as a hashmap for the token values and a method, such as currentAvailableToken, implemented
	 * in either the Board class or the Tile structures.
	 * @param token unused at this time.
	 */
	public Boolean ablePickup(Token token){
		
		return false;
	}
	/**
	 * @author Nash
	 * Method for future implementation, which will enable the player to see the current inventory 
	 * for his pawn object. Code currently contained is unfinished and can only be considered as
	 * noted ideas for the implementation of the code.
	 */
	public void inventory(){
		System.out.println("Number of wands: "+wcount);
		System.out.println("Number of tokens: " +numOfTokens);
		System.out.println("Tokens in possession: " ); 
		
	}
	
	/**
	 * @author <Nash>
	 * Runs after each pawn movement and checks if the move was valid. Following that it checks if a tile is
	 * in place and picks it up if that it is the next token in order.
	 */	
	public void pickUpToken(){
		if(validMove){
			if(board.getTile(positionX, positionY).hasToken){
				System.out.println(board.getTile(positionX, positionY).getToken().getValue());
				if(board.tokenCounter==board.getTile(positionX, positionY).getToken().getValue()){
					tokenCounts.add(board.getTile(positionX, positionY).getToken().getValue());
					System.out.println("Token picked up");
					board.getTile(positionX, positionY).hasToken=false;
					board.tokenCounter = board.tokenCounter + 1;
					if(board.tokenCounter == 21){
						board.tokenCounter=25;
					}
				
					if(board.tokenCounter==26)board.endGame();
					
					
					if(!board.firstMove){
						if(board.pawns[board.playerUp-1].validMove){
							board.pawns[board.playerUp-1].validMove = false;
							board.pawns[board.playerUp-1].startX = board.pawns[board.playerUp-1].getPositionX();
							board.pawns[board.playerUp-1].startY = board.pawns[board.playerUp-1].getPositionY();
						}
						board.firstMove = true;
						board.playerUp = board.playerUp + 1;
						if(board.playerUp>4)board.playerUp = 1;
						board.gameChanged();
					}
				
				}
			}
		}
	}
	
	
	/**
	 * @author <Nash>
	 * @return accesses 'player' in order to know the name of the player using the pawn.
	 */	
	public String getPlayer(){
		return this.player;
	}
	


}
