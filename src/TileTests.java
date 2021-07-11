package tests;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import code.Tiles.StraightTiles;
import code.Tiles.TTile;
import code.Tiles.Tiles;
import code.Tokens.Token;

public class TileTests {
	/**
	 * @author Nash
	 * all tests
	 */
	@Test public void test01(){
		String expected="North";
		code.Tiles.ElbowTile ebt = new code.Tiles.ElbowTile("North");
		String actual = ebt.getRotation();
		assertTrue(""+actual,actual.equals(expected));
	}
	/**
	 * Creates a new tile and rotates it 'South'.
	 * Checkes if the rotation of the tile is correct
	 */
	@Test public void test02(){
		String expected = "South";
		code.Tiles.TTile tt = new code.Tiles.TTile();
		tt.Rotate("South");
		String actual = tt.getRotation();
		assertTrue("",expected.equals(actual));
	}
	/**
	 * Creates a tile and makes that tile static.
	 * Tries to rotate a static tile and should fail
	 * because its a static tile.
	 */
	@Test public void test03(){
		Tiles tt = new TTile();
		tt.isPermanent(true);
		tt.Rotate("North");
	}
	/**
	 * Creates a tile and rotates it twice.
	 * Checks to see if the tile is rotated the last chosen rotation.
	 */
	@Test public void test04(){
		Tiles st = new StraightTiles("East");
		st.Rotate("North");
		st.Rotate("East");
		String string = st.getRotation();
		assertTrue("string: " + string,string.equals("East"));
	}
	/*@Test public void test05(){
		Token t25 = new Token(25);
		String expected = "Mistletoe";
		String actual = t25.GetType();
		
		assertTrue("Expected: "+ expected + " Actual: "+actual,expected.equals(actual));
	}
	*/
}

