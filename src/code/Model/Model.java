package code.Model;

import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import code.Recipes;
import code.Tiles.ElbowTile;
import code.Tiles.StraightTiles;
import code.Tiles.TTile;
import code.Tiles.Tiles;
import code.Tokens.Token;
import code.fileIo.FileIO;
import code.Model.Model;
import code.Model.Model;
import code.pawn.Pawn;

public class Model {
		
		int rows = 7;
		int col = 7;
		private Observer _observer;
		private ArrayList<Token>tokens;
		public Boolean firstMove = true;
		code.Tiles.Tiles[][] board  = new code.Tiles.Tiles[col][rows];
		Tiles hold = null;
		public Pawn[] pawns;
		public int tokenCounter = 1;
		public int playerUp = 1;
		
		public Recipes allRecipes = new Recipes();
		
	   public static final String SAVE_FILENAME = "Group156.mls";
		
		
		
		//error in code caused by pawn needing fourth parameter from command line input. New parameter sets the player's name into the pawn
		public Model(){
			this.setStaticTiles();
			this.setBoard();
			pawns = new Pawn[4];
			//load(SAVE_FILENAME);
			
			
		}
		
		public Model(String test){
			if (test == "test"){
				this.setStaticTiles();
				board[2][3] = new StraightTiles("East");
				board[1][2] = new StraightTiles();
				board[3][2] = new TTile();
				board[2][1] = new StraightTiles();
				board[5][5] = new ElbowTile();
				board[4][5] = new StraightTiles();
				board[5][4] = new TTile("West");
				board[3][3] = new StraightTiles("East");
				board[3][4] = new ElbowTile("West");
				board[4][3] = new StraightTiles();
				
				
			}
		}
		
		public Boolean getTileBool(int x, int y, String direction){
			return board[x][y].getDirection(direction);
			
		}
		
		
		public void setObserver(Observer o){
			_observer = o;
		}
		
		
		public void gameChanged(){
			if (_observer != null) {
				_observer.update();
			}
		}
		
		
		public void setStaticTiles(){
			board [0][0] = new ElbowTile("East");
			board [0][0].isPermanent(true);
			board [0][2] = new TTile("East");
			board [0][2].isPermanent(true);
			board [0][4] = new TTile("East");
			board [0][4].isPermanent(true);
			board [0][6] = new ElbowTile("North");
			board [0][6].isPermanent(true);
			
			board [2][0] = new TTile("South");
			board [2][0].isPermanent(true);
			board [2][2] = new TTile("East");
			board [2][2].isPermanent(true);
			board [2][4] = new TTile("North");
			board [2][4].isPermanent(true);
			board [2][6] = new TTile("North");
			board [2][6].isPermanent(true);
			
			board [4][0] = new TTile("South");
			board [4][0].isPermanent(true);
			board [4][2] = new TTile("South");
			board [4][2].isPermanent(true);
			board [4][4] = new TTile("West");
			board [4][4].isPermanent(true);
			board [4][6] = new TTile("North");
			board [4][6].isPermanent(true);	
			
			board [6][0] = new ElbowTile("South");
			board [6][0].isPermanent(true);
			board [6][2] = new TTile("West");
			board [6][2].isPermanent(true);
			board [6][4] = new TTile("West");
			board [6][4].isPermanent(true);
			board [6][6] = new ElbowTile("West");
			board [6][6].isPermanent(true);
		}
		
		public void setBoard(){
			setupTokens();
			int ttiles = 6;
			int elbow = 15;
			int straight = 13;
			//CHANGED*********
			for(int i=0; i<col; i++){
				for(int j =0; j<rows; j++){
					if(board[i][j]==null){
						if(elbow>0){
							board[i][j] = new ElbowTile("North");
							elbow--;
							continue;
						}
						if(straight>0){
							board[i][j] = new StraightTiles("East");
							straight--;
							continue;
						}
						if(ttiles>0){
							board[i][j] = new TTile("South");
							ttiles--;
							continue;
						}
						
						
					}
				}
				
			}
			//System.out.println(straight);System.out.println(ttiles);System.out.println(elbow);
			if(straight==1){
				Tiles tile = new StraightTiles("North");
				setholdTile(tile);
			}
			else if(elbow==1){
				Tiles tile = new ElbowTile("North");
				setholdTile(tile);
			}
			else if(ttiles==1){
				Tiles tile = new TTile("North");
				setholdTile(tile);
			}
			
			
			int counter = 0;
			for(int col=1;col<6;col=col+2){
				for(int row=1;row<6;row++ ){
					board[col][row].setToken(tokens.get(counter));
					board[col][row].hasToken= true;
				    counter++;
				    }
				}
			for(int col=2;col<6;col=col+2){
				for(int row=1;row<6;row=row+2){
					board[col][row].setToken(tokens.get(counter));
					board[col][row].hasToken= true;
				    counter++;
				    }
				}
			
			for(int col=0;col<7;col++){
				for(int row=0;row<7;row++){					
					if(board[col][row].checkToken())System.out.println("Col: "+col+ " " +"Row: "+ row + " Token: "+board[col][row].getToken().getValue());
				}
			}
			
			
			
		}
		
		public Tiles moveTiles(int col, int row){//takes in two ints for points to move and one Tile which is the one tile not on the board
			Tiles tempTile = hold;							//also returns the tile that fell off the board
			Tiles[][] tempBoard = new Tiles[7][];
			
			if(firstMove){
			for(int i=0;i<7;i++){
				tempBoard[i] = Arrays.copyOf(board[i], board[i].length);
			} 
			
			if(col==0 && row==1 || col==0 && row==3 || col==0 && row==5){//left
				
				hold=tempBoard[col+6][row];
				if(hold.checkToken()){
					tempTile.setToken(hold.getToken());
					tempTile.hasToken=true;
					hold.hasToken=false;
				}			
				board[col][row]=tempTile;
				board[col+1][row]=tempBoard[col][row];
				board[col+2][row]=tempBoard[col+1][row];
				board[col+3][row]=tempBoard[col+2][row];
				board[col+4][row]=tempBoard[col+3][row];
				board[col+5][row]=tempBoard[col+4][row];
				board[col+6][row]=tempBoard[col+5][row];
				firstMove = false;
				
				for(int i=0;i<7;i++){
					if(pawns[0].getPositionX()==col+i && pawns[0].getPositionY()==row){
						if(pawns[0].getPositionX()+1>6){
							pawns[0].setCurrentLocation(pawns[0].getPositionY(), pawns[0].getPositionX()-6);
							break;
						}
						pawns[0].setCurrentLocation(pawns[0].getPositionY(), pawns[0].getPositionX()+1);
						break;
					}
				}
				for(int i=0;i<7;i++){
					if(pawns[1].getPositionX()==col+i && pawns[1].getPositionY()==row){
						if(pawns[1].getPositionX()+1>6){
							pawns[1].setCurrentLocation(pawns[1].getPositionY(), pawns[1].getPositionX()-6);
							break;
						}
						pawns[1].setCurrentLocation(pawns[1].getPositionY(), pawns[1].getPositionX()+1);
						break;
					}
				}
				for(int i=0;i<7;i++){
					if(pawns[2].getPositionX()==col+i && pawns[2].getPositionY()==row){
						if(pawns[2].getPositionX()+1>6){
							pawns[2].setCurrentLocation(pawns[0].getPositionY(), pawns[2].getPositionX()-6);
							break;
						}
						pawns[2].setCurrentLocation(pawns[2].getPositionY(), pawns[2].getPositionX()+1);
						break;
					}
				}
				for(int i=0;i<7;i++){
					if(pawns[3].getPositionX()==col+i && pawns[3].getPositionY()==row){
						if(pawns[3].getPositionX()+1>6){
							pawns[3].setCurrentLocation(pawns[3].getPositionY(), pawns[3].getPositionX()-6);
							break;
						}
						pawns[3].setCurrentLocation(pawns[3].getPositionY(), pawns[3].getPositionX()+1);
						break;
					}
				}
				
				gameChanged();
			}
			//shift Top
			else if(col==1 && row==0 || col==3 && row==0 || col==5 && row==0){
				hold=tempBoard[col][row+6];
				if(hold.checkToken()){
					tempTile.setToken(hold.getToken());
					tempTile.hasToken=true;
					hold.hasToken=false;
				}		
				board[col][row]=tempTile;
				board[col][row+1]=tempBoard[col][row];
				board[col][row+2]=tempBoard[col][row+1];
				board[col][row+3]=tempBoard[col][row+2];
				board[col][row+4]=tempBoard[col][row+3];
				board[col][row+5]=tempBoard[col][row+4];
				board[col][row+6]=tempBoard[col][row+5];
				firstMove = false;
				
				for(int i=0;i<7;i++){
					if(pawns[0].getPositionX()==col && pawns[0].getPositionY()==row+i){
						if(pawns[0].getPositionY()+1>6){
							pawns[0].setCurrentLocation(pawns[0].getPositionY()-6, pawns[0].getPositionX());
							break;
						}
						pawns[0].setCurrentLocation(pawns[0].getPositionY()+1, pawns[0].getPositionX());					
						break;
					}
				}
				for(int i=0;i<7;i++){
					if(pawns[1].getPositionX()==col && pawns[1].getPositionY()==row+i){
						if(pawns[1].getPositionY()+1>6){
							pawns[1].setCurrentLocation(pawns[1].getPositionY()-6, pawns[1].getPositionX());
							break;
						}
						pawns[1].setCurrentLocation(pawns[1].getPositionY()+1, pawns[1].getPositionX());
						break;
					}
				}
				for(int i=0;i<7;i++){
					if(pawns[2].getPositionX()==col && pawns[2].getPositionY()==row+i){
						if(pawns[2].getPositionY()+1>6){
							pawns[2].setCurrentLocation(pawns[2].getPositionY()-6, pawns[2].getPositionX());
							break;
						}
						pawns[2].setCurrentLocation(pawns[2].getPositionY()+1, pawns[2].getPositionX());
						break;
					}
				}
				for(int i=0;i<7;i++){
					if(pawns[3].getPositionX()==col && pawns[3].getPositionY()==row+i){
						if(pawns[3].getPositionY()+1>6){
							pawns[3].setCurrentLocation(pawns[3].getPositionY()-6, pawns[3].getPositionX());
							break;
						}
						pawns[3].setCurrentLocation(pawns[3].getPositionY()+1, pawns[3].getPositionX());
						break;
					}
				}
				
				gameChanged();
			}
			//Shift Right
			else if(col==6 && row==1 || col==6 && row==3 ||col==6 && row==5){
				hold=tempBoard[col-6][row];
				if(hold.checkToken()){
					tempTile.setToken(hold.getToken());
					tempTile.hasToken=true;
					hold.hasToken=false;
				}	
				board[col][row]=tempTile;
				board[col-1][row]=tempBoard[col][row];
				board[col-2][row]=tempBoard[col-1][row];
				board[col-3][row]=tempBoard[col-2][row];
				board[col-4][row]=tempBoard[col-3][row];
				board[col-5][row]=tempBoard[col-4][row];
				board[col-6][row]=tempBoard[col-5][row];
				firstMove = false;
				
				for(int i=0;i<7;i++){
					if(pawns[0].getPositionX()==col-i && pawns[0].getPositionY()==row){
						if(pawns[0].getPositionX()-1<0){
							pawns[0].setCurrentLocation(pawns[0].getPositionY(), pawns[0].getPositionX()+6);
							break;
						}
						pawns[0].setCurrentLocation(pawns[0].getPositionY(), pawns[0].getPositionX()-1);
						break;
					}
				}
				for(int i=0;i<7;i++){
					if(pawns[1].getPositionX()==col-i && pawns[1].getPositionY()==row){
						if(pawns[1].getPositionX()-1<0){
							pawns[1].setCurrentLocation(pawns[1].getPositionY(), pawns[1].getPositionX()+6);
							break;
						}
						pawns[1].setCurrentLocation(pawns[1].getPositionY(), pawns[1].getPositionX()-1);
						break;
					}
				}
				for(int i=0;i<7;i++){
					if(pawns[2].getPositionX()==col-i && pawns[2].getPositionY()==row){
						if(pawns[2].getPositionX()-1<0){
							pawns[2].setCurrentLocation(pawns[2].getPositionY(), pawns[2].getPositionX()+6);
							break;
						}
						pawns[2].setCurrentLocation(pawns[2].getPositionY(), pawns[2].getPositionX()-1);
						break;
					}
				}
				for(int i=0;i<7;i++){
					if(pawns[3].getPositionX()==col-i && pawns[3].getPositionY()==row){
						if(pawns[3].getPositionX()-1<0){
							pawns[3].setCurrentLocation(pawns[3].getPositionY(), pawns[3].getPositionX()+6);
							break;
						}
						pawns[3].setCurrentLocation(pawns[3].getPositionY(), pawns[3].getPositionX()-1);
						break;
					}
				}
				gameChanged();
			}
			
			//shift bottom. 
			else if(col==1 && row==6 || col==3 && row==6 || col==5 && row==6){//bottom
				hold=tempBoard[col][row-6];
				if(hold.checkToken()){
					tempTile.setToken(hold.getToken());
					tempTile.hasToken=true;
					hold.hasToken=false;
				}	
				board[col][row]=tempTile;
				board[col][row-1]=tempBoard[col][row];
				board[col][row-2]=tempBoard[col][row-1];
				board[col][row-3]=tempBoard[col][row-2];
				board[col][row-4]=tempBoard[col][row-3];
				board[col][row-5]=tempBoard[col][row-4];
				board[col][row-6]=tempBoard[col][row-5];
				firstMove = false;
				
				for(int i=0;i<7;i++){
					if(pawns[0].getPositionX()==col && pawns[0].getPositionY()==row-i){
						if(pawns[0].getPositionY()-1<0){
							pawns[0].setCurrentLocation(pawns[0].getPositionY()+6, pawns[0].getPositionX());
							break;
						}
						pawns[0].setCurrentLocation(pawns[0].getPositionY()-1, pawns[0].getPositionX());
						break;
					}
				}
				for(int i=0;i<7;i++){
					if(pawns[1].getPositionX()==col && pawns[1].getPositionY()==row-i){
						if(pawns[1].getPositionY()-1<0){
							pawns[1].setCurrentLocation(pawns[1].getPositionY()+6, pawns[1].getPositionX());
							break;
						}
						pawns[1].setCurrentLocation(pawns[1].getPositionY()-1, pawns[1].getPositionX());
						break;
					}
				}
				for(int i=0;i<7;i++){
					if(pawns[2].getPositionX()==col && pawns[2].getPositionY()==row-i){
						if(pawns[2].getPositionY()-1<0){
							pawns[2].setCurrentLocation(pawns[2].getPositionY()+6, pawns[2].getPositionX());
							break;
						}
						pawns[2].setCurrentLocation(pawns[2].getPositionY()-1, pawns[2].getPositionX());
						break;
					}
				}
				for(int i=0;i<7;i++){
					if(pawns[3].getPositionX()==col && pawns[3].getPositionY()==row-i){
						if(pawns[3].getPositionY()-1<0){
							pawns[3].setCurrentLocation(pawns[3].getPositionY()+6, pawns[3].getPositionX());
							break;
						}
						pawns[3].setCurrentLocation(pawns[3].getPositionY()-1, pawns[3].getPositionX());
						break;
					}
				}
				gameChanged();
			}
			else{
				System.out.println("I'm sorry, that's a permanent structure");
			}			
			}
			return hold;

		}
		
		public Tiles getTile(int col, int row){
			return board[col][row];
		}
		
		public void setholdTile(Tiles tile){
			hold = tile;
		}
		
		public Tiles getHoldTile(){
			return hold;
		}
		
		/**
		 * @author <jtmirfie>
		 * Returns the 'board' tiles. Used to associate between other classes.
		 * @return 'board' tiles in order to access it from other classes.
		 */	
		public Tiles[][] getBoard(){
			return board;
		}
		
		
		public void setupTokens(){
			tokens = new ArrayList<Token>();
			for(int i=0;i<21;i++){
				tokens.add(new Token());
			}
			Collections.shuffle(tokens);
			
		}
		
		
		public void endGame(){
			int player1score=0;
			int player2score=0;
			int player3score=0;
			int player4score=0;
			
			System.out.println();
			System.out.println(pawns[0].getPlayer() +":");
			System.out.println(pawns[0].tokenCount());
			for(int i=0;i<pawns[0].tokenCount().size();i++){
				player1score= player1score +pawns[0].tokenCount().get(i);
			}
			System.out.println("Score: "+player1score);
			System.out.println();
			
			System.out.println(pawns[1].getPlayer() +":");
			System.out.println(pawns[1].tokenCount());
			for(int i=0;i<pawns[1].tokenCount().size();i++){
				player2score= player2score +pawns[1].tokenCount().get(i);
			}
			System.out.println("Score: "+player2score);
			System.out.println();
			
			System.out.println(pawns[2].getPlayer() +":");
			System.out.println(pawns[2].tokenCount());
			for(int i=0;i<pawns[2].tokenCount().size();i++){
				player3score= player3score +pawns[2].tokenCount().get(i);
			}
			System.out.println("Score: "+player3score);
			System.out.println();
			
			System.out.println(pawns[3].getPlayer() +":");
			System.out.println(pawns[3].tokenCount());
			for(int i=0;i<pawns[3].tokenCount().size();i++){
				player4score= player4score +pawns[3].tokenCount().get(i);
			}
			System.out.println("Score: "+player4score);
			System.out.println();
			
			System.exit(0);
		}
		
		//new code3
		public void useWand() {
			Pawn currentPlayer = pawns[playerUp - 1];
			if(currentPlayer.wcount == 0 || firstMove)
				return;
			//wand can be used
			currentPlayer.wcount--;
			firstMove = true;
			gameChanged();
		}
		
		//NEW FUNCTION
		public void save(String fileName) throws Exception {
			    
			FileWriter writer = new FileWriter(fileName);
			
			//first line: write pawns
			for(int i=0;i< pawns.length; i++)
			{
				if(i != 0)
					writer.write(",");
				
				Pawn p = pawns[i];
				writer.write("[");
				
				//player name
				writer.write(p.getPlayer() + ",");
				
				//player color
				if(i==0) writer.write("ORANGE");
				else if(i==1) writer.write("RED");
				else if(i==2) writer.write("BLUE");
				else if(i==3) writer.write("GREEN");
				
				writer.write(",");
				
				//wands remaining
				writer.write(p.wcount + ",");
				
				//recipe
				ArrayList<Integer> recipe = p.recipe;
				writer.write("[");
				for(int index = 0; index < recipe.size(); index++)
				{
					if(index != 0)
						writer.write(",");
					writer.write(recipe.get(index));
				}
				writer.write("]");
				
				//list of tokens
				ArrayList<Integer> tokens = p.tokenCount();
				writer.write("[");
				for(int index = 0; index < tokens.size(); index++)
				{
					if(index != 0)
						writer.write(",");
					writer.write(tokens.get(index));
				}
				writer.write("]");
				
				//end of pawn bracket
				writer.write("]");								
			}
			
			writer.write("\n");
			
			//second line: write tiles
			for(int row = 0; row < 7; row++)
			{
				for(int col = 0; col < 7; col++)
				{
					if(row != 0 || col != 0)
						writer.write(",");
					
					Tiles tile = board[col][row];
					String direction = tile.getRotation();
					//write the tile type
					if(tile instanceof TTile)
					{
						if(direction.equals("North"))
						{
							writer.write("T0");
						}
						else if(direction.equals("South"))
						{
							writer.write("T2");							
						}
						else if(direction.equals("East"))
						{
							writer.write("T1");														
						}
						else if(direction.equals("West"))
						{
							writer.write("T3");							
						}
					}
					else if(tile instanceof ElbowTile)
					{
						if(direction.equals("North"))
						{
							writer.write("L0");
						}
						else if(direction.equals("South"))
						{
							writer.write("L2");							
						}
						else if(direction.equals("East"))
						{
							writer.write("L1");														
						}
						else if(direction.equals("West"))
						{
							writer.write("L3");							
						}
					}
					else if(tile instanceof StraightTiles)
					{
						if(direction.equals("North"))
						{
							writer.write("I0");
						}
						else if(direction.equals("South"))
						{
							writer.write("I2");							
						}
						else if(direction.equals("East"))
						{
							writer.write("I1");														
						}
						else if(direction.equals("West"))
						{
							writer.write("I3");							
						}
					}
					
					writer.write(",");
				}
			}
			
			//have to call close or file isn't written
			writer.close();
		}
/*
			//loop through the two dimensional array that saves the character and color once the button clicks. 
			    
			    //Now we loop through the rows and columns of the board. 
			    for(int c=0; c<col;c++) {
			    	for(int r=0; r<rows;r++) {
			        //aceesor method that accesses the rows and columns from the ITile class.
			    
			    	 ITile t = get(c,r);
			    	
			       //now access the characters 
			    	 
			    	saveString = saveString + t.getCharacter();
			    	
			    // now access the color properties from the ITile class and incoporate it into the saveString.  
			    	 Color color = t.getColor();
			    	
			    	 saveString = saveString + ColorUtility.color2char(color);
			    	 
			    		
			    	}
			    }
			    
			    FileIO.writeStringToFile(fileName,saveString);
			    
			    	
			    	
			    }   */
	
    //Now we create a load method after the save method.     		
		
		
	// And this is the load method that we discussed before. 	
		  /* public void load(String fileName) {
			  String loadString = FileIO.readFileToString(fileName);
			  
			  
			  if(loadString == null || loadString.length()<rows*col*2) 
				  return;
			  
			char[] loadCharArray = loadString.toCharArray();
			
			int charIndex = 0;
			
		    // Now load the characters and colors into the two dimensional board. 
			for(int c=0; c<col;c++) {
				for(int r=0; r<rows;r++) {
		    // Now load the characters onto the board. 
				char letter = loadCharArray[charIndex];
				charIndex++; 
				
				//Now load the colors onto the two-dimensional board. 
				char colorCode = loadCharArray[charIndex];
				charIndex++;
				
				//If the color code is equal to K, then I would load a placeholder tile.  
				if(colorCode == 'K') {
					board.get(c).set(r, new PlaceHolderTile());
					
					
					
					
			    //For everything else I would load a real tile. 
				}else{
					Color color = ColorUtility.char2color(colorCode);
					RealTile realTile = new RealTile(color);
					realTile.setCharacter(letter);
					_board.get(c).set(r, realTile);
					
				}   
				
					
					
				}  
			} */
			
		
}