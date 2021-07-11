package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Model.Model;
import code.Tiles.ElbowTile;
import code.Tiles.StraightTiles;
import code.Tiles.Tiles;

public class TileMovementTest {
	
	/**
	 * Version 1.1 of test01
	 * removed separate method calls for setting the board's tiles and permanent tiles as I 
	 * created a constructor in the Board class that will automate this.
	 * Removed "North" Parameters from tiles created in test01 and test02 as Tiles default 
	 * constructor automatically designates North as the orientation when no parameter is included.
	 * @author Team.
	 */
	@Test public void test01(){
		String expected = "North";
		Model board = new Model();
		Tiles old_place = new StraightTiles();
		board.setholdTile(old_place);
		Tiles new_place = board.moveTiles(0, 1);
		String actual = board.getTile(0,1).getRotation();
		assertTrue("",expected.equals(actual));
	}
	@Test public void test02(){
		Model board = new Model();
		Tiles new_place = new ElbowTile();
		board.setholdTile(new_place);
		Tiles old_place = board.moveTiles(0, 6);
		assertTrue("",old_place.equals(new_place));
	}
	@Test public void test03(){
		Model board = new Model();
		Tiles new_place = new StraightTiles("South");
		Tiles old_place = null;
		board.setholdTile(new_place);
		String s="";
		for(int i=0; i<6;i++){
			old_place = board.moveTiles(0, 1);
			new_place=old_place;
			s = board.getTile(0,1).getRotation();
		}
		assertTrue("",s.equals("South"));
	}
}
