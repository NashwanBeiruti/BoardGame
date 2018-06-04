package code.Tiles;


public class ElbowTile extends Tiles {
	
	
	public ElbowTile(String orientation){
		this.Rotate(orientation);
	}
	
	public ElbowTile(){
		
	}
	
	
	public void Rotate(String direction){
		_rotation = direction;
		switch (direction){
		case "North": 
			this._north = true;
			this._east = true;
			this._west = false;
			this._south = false;
			break;
		case "South":
			this._north = false;
			this._east = false;
			this._west = true;
			this._south = true;
			break;
		case "East":
			this._north = false;
			this._east = true;
			this._west = false;
			this._south = true;
			break;
		case "West":
			this._north = true;
			this._east = false;
			this._west = true;
			this._south = false;
			break;
		}
	}
	
}
