package code.Tiles;

import code.Tokens.Token;


	public abstract class Tiles {
	
	public String _rotation;
	
	public Boolean _staticVert = false;
	
	public Boolean _staticHoriz = false;
	

	public Boolean _north = false;
	
	public Boolean _east = false;
	
	public Boolean _south = false;
	
	public Boolean _west = false;
	
	public Boolean _permanency=false;
	
	public Token token;
	
	public Boolean hasToken = false;
	
	public Boolean player = false;
	
	public boolean isStart = false;

	
	public String getRotation(){
		return _rotation;
	}
	

	
	public abstract void Rotate(String direction);

	
	public void setVert(Boolean freeze){
		if (_permanency = true){
			System.out.println("I'm sorry, that's a permanent structure");
		}else
			_staticVert = freeze;
	}
	
	public void setHoriz(Boolean freeze){
		if (_permanency = true){
			System.out.println("I'm sorry, that's a permanent structure");
		}else
			_staticHoriz = freeze;
	}
	
	public Boolean getVert(){
		return _staticVert;
		
	}
	
	public Boolean getHoriz(){
		return _staticHoriz;
	}
	
	public void isPermanent(Boolean value){
		_permanency = value;
		_staticVert = value;
		_staticHoriz = value;

	}
	
	public Boolean getDirection(String dir){
		switch(dir){
		case "North":
			return _north;
		case "South":
			return _south;
		case "East":
			return _east;
		case "West":
			return _west;
		}
		return false;
		
	}
	public void setToken(Token _token){
		token = _token;
	}
	public Token getToken(){
		return token;
	}
	public boolean checkToken(){
		return hasToken;
	}
	public Token pickUpToken(){
		Token temp=token;
		token=null;
		return temp;
	}
	public void startTile(){
		isStart=true;
	}
	public boolean isStart(){
		return isStart;
	}

}


