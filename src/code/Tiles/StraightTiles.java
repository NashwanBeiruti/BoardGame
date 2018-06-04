package code.Tiles;


public class StraightTiles extends Tiles{
	
	
	public StraightTiles(String orientation){
		this.Rotate(orientation);
	}
	
	public StraightTiles(){
		this.Rotate("North");
		
	}
	
	public void Rotate(String orientation){
		this._rotation = orientation;
		switch (orientation){
		case "North": 
			this._north = true;
			this._east = false;
			this._west = false;
			this._south = true;
			break;
		case "South":
			this._north = true;
			this._east = false;
			this._west = false;
			this._south = true;
			break;
		case "East":
			this._north = false;
			this._east = true;
			this._west = true;
			this._south = false;
			break;
		case "West":
			this._north = false;
			this._east = true;
			this._west = true;
			this._south = false;
			break;
		}
	}
}
