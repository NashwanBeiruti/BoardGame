package tests;

import static org.junit.Assert.*;


import org.junit.Test;

import code.Model.Model;
import code.Tiles.ElbowTile;
import code.Tiles.StraightTiles;
import code.Tiles.TTile;
import code.Tiles.Tiles;
import code.Tokens.Token;

public class BoardTest {
	/**@author Nash
	 * Checks to see if tile set is static
	 */
	
	@Test
	public void test12() {
		Tiles expected = new ElbowTile("East");
		Model board = new Model();
		board.setStaticTiles();
		Tiles actual=board.getTile(0, 0);
		assertTrue("",expected.getRotation().equals(actual.getRotation()));
		
	}
	/**@author Nash
	 * Tests 13-24: For each specific tile and rotation, checks if the 
	 * new tile created matches matches contents of the old one 
	 * 
	 */
	@Test
	public void test13() {
		String expected = "North";
		Model board = new Model();
		Tiles old_place = new ElbowTile("North");
		board.setholdTile(old_place);
		Tiles new_place = board.moveTiles(0, 1);
		String actual = board.getTile(0, 1).getRotation();
		assertTrue("", expected.equals(actual));
	}
	@Test
	public void test14() {
		code.Driver d = new code.Driver();
		String expected = "South";
		Model board = new Model();
		Tiles old_place = new ElbowTile("South");
		board.setholdTile(old_place);
		Tiles new_place = board.moveTiles(0, 1);
		String actual = board.getTile(0, 1).getRotation();
		assertTrue("", expected.equals(actual));
	}
	@Test
	public void test15() {
		String expected = "East";
		Model board = new Model();
		Tiles old_place = new ElbowTile("East");
		board.setholdTile(old_place);
		Tiles new_place = board.moveTiles(0, 1);
		String actual = board.getTile(0, 1).getRotation();
		assertTrue("", expected.equals(actual));
	}
	@Test
	public void test16() {
		String expected = "West";
		Model board = new Model();
		Tiles old_place = new ElbowTile("West");
		board.setholdTile(old_place);
		Tiles new_place = board.moveTiles(0, 1);
		String actual = board.getTile(0, 1).getRotation();
		assertTrue("", expected.equals(actual));
	}
	@Test
	public void test17() {
		String expected = "North";
		Model board = new Model();
		Tiles old_place = new StraightTiles("North");
		board.setholdTile(old_place);
		Tiles new_place = board.moveTiles(0, 1);
		String actual = board.getTile(0, 1).getRotation();
		assertTrue("", expected.equals(actual));
	}
	@Test
	public void test18() {
		String expected = "South";
		Model board = new Model();
		Tiles old_place = new StraightTiles("South");
		board.setholdTile(old_place);
		Tiles new_place = board.moveTiles(0, 1);
		String actual = board.getTile(0, 1).getRotation();
		assertTrue("", expected.equals(actual));
	}
	public void test19() {
		String expected = "West";
		Model board = new Model();
		Tiles old_place = new StraightTiles("West");
		board.setholdTile(old_place);
		Tiles new_place = board.moveTiles(0, 1);
		String actual = board.getTile(0, 1).getRotation();
		assertTrue("", expected.equals(actual));
	}
	@Test
	public void test20() {
		String expected = "East";
		Model board = new Model();
		Tiles old_place = new StraightTiles("East");
		board.setholdTile(old_place);
		Tiles new_place = board.moveTiles(0, 1);
		String actual = board.getTile(0, 1).getRotation();
		assertTrue("", expected.equals(actual));
	}
	
	
	@Test
	public void test21() {
		String expected = "North";
		Model board = new Model();
		Tiles old_place = new TTile("North");
		board.setholdTile(old_place);
		Tiles new_place = board.moveTiles(0, 1);
		String actual = board.getTile(0, 1).getRotation();
		assertTrue("", expected.equals(actual));
	}
	@Test
	public void test22() {
		String expected = "South";
		Model board = new Model();
		Tiles old_place = new TTile("South");
		board.setholdTile(old_place);
		Tiles new_place = board.moveTiles(0, 1);
		String actual = board.getTile(0, 1).getRotation();
		assertTrue("", expected.equals(actual));
	}
	@Test
	public void test23() {
		String expected = "East";
		Model board = new Model();
		Tiles old_place = new TTile("East");
		board.setholdTile(old_place);
		Tiles new_place = board.moveTiles(0, 1);
		String actual = board.getTile(0, 1).getRotation();
		assertTrue("", expected.equals(actual));
	}
	@Test	
	public void test24() {
		String expected = "West";
		Model board = new Model();
		Tiles old_place = new TTile("West");
		board.setholdTile(old_place);
		Tiles new_place = board.moveTiles(0, 1);
		String actual = board.getTile(0, 1).getRotation();
		assertTrue("", expected.equals(actual));
	}
	/**@author Nash
	 * Test 25-36 :Checks to see if tiles are moved to correct location
	 * 
	 */
	@Test
	public void test25() {
		Model board = new Model();
		Tiles new_place = new ElbowTile("North");
		board.setholdTile(new_place);
		Tiles old_place = board.moveTiles(0, 6);
		assertTrue("", old_place.equals(new_place));
	}
	
	@Test
	public void test26() {
		Model board = new Model();
		Tiles new_place = new ElbowTile("South");
		board.setholdTile(new_place);
		Tiles old_place = board.moveTiles(0, 6);
		assertTrue("", old_place.equals(new_place));
	}
	@Test
	public void test27() {
		Model board = new Model();
		Tiles new_place = new ElbowTile("East");
		board.setholdTile(new_place);
		Tiles old_place = board.moveTiles(0, 6);
		assertTrue("", old_place.equals(new_place));
	}
	@Test
	public void test28() {
		Model board = new Model();
		Tiles new_place = new ElbowTile("West");
		board.setholdTile(new_place);
		Tiles old_place = board.moveTiles(0, 6);
		assertTrue("", old_place.equals(new_place));
	}
	@Test
	public void test29() {
		Model board = new Model();
		Tiles new_place = new StraightTiles("North");
		board.setholdTile(new_place);
		Tiles old_place = board.moveTiles(0, 6);
		assertTrue("", old_place.equals(new_place));
	}
	@Test
	public void test30() {
		Model board = new Model();
		Tiles new_place = new StraightTiles("South");
		board.setholdTile(new_place);
		Tiles old_place = board.moveTiles(0, 6);
		assertTrue("", old_place.equals(new_place));
	}
	@Test
	public void test31() {
		Model board = new Model();
		Tiles new_place = new StraightTiles("East");
		board.setholdTile(new_place);
		Tiles old_place = board.moveTiles(0, 6);
		assertTrue("", old_place.equals(new_place));
	}
	@Test
	public void test32() {
		Model board = new Model();
		Tiles new_place = new StraightTiles("West");
		board.setholdTile(new_place);
		Tiles old_place = board.moveTiles(0, 6);
		assertTrue("", old_place.equals(new_place));
	}
	@Test
	public void test33() {
		Model board = new Model();
		Tiles new_place = new TTile("North");
		board.setholdTile(new_place);
		Tiles old_place = board.moveTiles(0, 6);
		assertTrue("", old_place.equals(new_place));
	}
	@Test
	public void test34() {
		Model board = new Model();
		Tiles new_place = new TTile("South");
		board.setholdTile(new_place);
		Tiles old_place = board.moveTiles(0, 6);
		assertTrue("", old_place.equals(new_place));
	}
	@Test
	public void test35() {
		Model board = new Model();
		Tiles new_place = new TTile("East");
		board.setholdTile(new_place);
		Tiles old_place = board.moveTiles(0, 6);
		assertTrue("", old_place.equals(new_place));
	}
	@Test
	public void test36() {
		Model board = new Model();
		Tiles new_place = new TTile("West");
		board.setholdTile(new_place);
		Tiles old_place = board.moveTiles(0, 6);
		assertTrue("", old_place.equals(new_place));
	}
/**@author Nash
 * Test 37-41: Checks if the held tile stays the same 
 */

	@Test
	public void test37() {
		Model board = new Model();
		Tiles tile = new StraightTiles("East");
		board.setholdTile(tile);
		Tiles actual = board.getHoldTile();
		assertTrue("", actual.equals(tile));
	}
	@Test
	public void test38() {
		Model board = new Model();
		Tiles tile = new ElbowTile("North");
		board.setholdTile(tile);
		Tiles actual = board.getHoldTile();
		assertTrue("", actual.equals(tile));
	}
	@Test
	public void test39() {
		Model board = new Model();
		Tiles tile = new ElbowTile("South");
		board.setholdTile(tile);
		Tiles actual = board.getHoldTile();
		assertTrue("", actual.equals(tile));
	}
	@Test
	public void test40() {
		Model board = new Model();
		Tiles tile = new ElbowTile("East");
		board.setholdTile(tile);
		Tiles actual = board.getHoldTile();
		assertTrue("", actual.equals(tile));
	}
	@Test
	public void test41() {
		Model board = new Model();
		Tiles tile = new ElbowTile("West");
		board.setholdTile(tile);
		Tiles actual = board.getHoldTile();
		assertTrue("", actual.equals(tile));
				
	}
	/**@author Nash
	 * Tests 42-44: Checks if the specific tiles can be moved to certain orientations
	 * 
	 */
	@Test
	public void test42() {
		Model board = new Model();
		Tiles hold = new TTile("East");
		board.setholdTile(hold);
		board.moveTiles(0, 1);// 1
		board.moveTiles(0, 1);// 2
		board.moveTiles(0, 1);// 3
		board.moveTiles(0, 1);// 4
		board.moveTiles(0, 1);// 5
		board.moveTiles(0, 1);// 6
		Tiles actual = board.getHoldTile();
		assertTrue("", actual.equals(hold));
	}

	@Test
	public void test43() {
		Model board = new Model();
		Tiles hold = new StraightTiles("North");
		board.setholdTile(hold);
		board.moveTiles(0, 1);// 1
		board.moveTiles(0, 1);// 2
		board.moveTiles(0, 1);// 3
		board.moveTiles(0, 1);// 4
		board.moveTiles(0, 1);// 5
		board.moveTiles(0, 1);// 6
		Tiles actual = board.getHoldTile();
		assertTrue("", actual.equals(hold));
	}
	@Test
	public void test44() {
		Model board = new Model();
		Tiles hold = new ElbowTile("South");
		board.setholdTile(hold);
		board.moveTiles(0, 1);// 1
		board.moveTiles(0, 1);// 2
		board.moveTiles(0, 1);// 3
		board.moveTiles(0, 1);// 4
		board.moveTiles(0, 1);// 5
		board.moveTiles(0, 1);// 6
		Tiles actual = board.getHoldTile();
		assertTrue("", actual.equals(hold));
	}
	
	@Test public void test45(){
		Model board = new Model();
		Tiles tile = board.getTile(1, 1);
		Tiles tile2 = board.getTile(1, 2);
		Tiles tile3 = board.getTile(1, 3);
		Tiles tile4 = board.getTile(1, 4);
		Token token = tile.getToken();
		/*String s = token.GetType();
		int i = token.getTokenNum();
		Token token2 = tile2.getToken();
		String s2 = token2.GetType();
		int i2 = token2.getTokenNum();
		Token token3 = tile3.getToken();
		String s3 = token3.GetType();
		int i3 = token3.getTokenNum();
		Token token4 = tile4.getToken();
		String s4 = token4.GetType();
		int i4 = token4.getTokenNum();
		System.out.println(s+" " + i);
		System.out.println(s2+" " + i2);
		System.out.println(s3+" " + i3);
		System.out.println(s4+" " + i4);*/
	}
}