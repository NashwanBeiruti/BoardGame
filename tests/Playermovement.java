package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Model.Model;
import code.pawn.Pawn;

public class Playermovement {
	
	/**
	 * @author Nash
	 * Test checks for player movement and correct functionality of player movement
	 * Boolean check for canMove method. Will return true for both statements
	 * if player is able to make the legal move. Also will return true
	 * if player is unable to make the move and does not make the move. 
	 * 
	 * Version is giving unstable results. Further testing is necessary to determine
	 * where the issue is in the code. 
	 */
	
	/**@author Nash
	 * commonAbleMoveBoolTest for pawn positioned at grid space 2,2
	 * @param dir direction pawn will travel
	 * @param expected expected result.
	 */
	public void commonAbleMoveBoolTest(String dir, Boolean expected){
		Model b = new Model("test");
		Pawn p = new Pawn(2,2,b,"");
		Pawn d = new Pawn(4,4,b,"");
		Boolean actual = p.canMove(dir);
		assertTrue("Expected: "+expected+" Result: "+actual,expected==actual);
		
	}
	/**@author Nash
	 * commonAbleMoveBoolTest for pawn positioned at grid space 4,4
	 * @param dir direction pawn will travel
	 * @param expected expected result.
	 */
	public void commonAbleMoveBoolTestD(String dir, Boolean expected){
		Model b = new Model("test");
	    Pawn d = new Pawn(4,4,b,"");
		Boolean actual = d.canMove(dir);
		assertTrue("Expected: "+expected+" Result: "+actual,expected==actual);
		
	}
	/**
	 * @author Nash
	 * All tests
	 */
	
	/**
	 * Test for pawn at 2,2 traveling west.
	 */
	@Test
	public final void test00() {
		commonAbleMoveBoolTest ("East", true);
	}
	/**
	 * Test for pawn at 2,2 traveling north
	 */
	@Test
	public final void test01() {
		commonAbleMoveBoolTest ("North", true);
	}
	/**
	 * Test for pawn at 2,2 traveling west
	 */
	@Test
	public final void test02() {
		commonAbleMoveBoolTest ("West", false);
	}
	/**
	 * Test for pawn at 2,2 traveling UP, which is not a valid move
	 */
	@Test
	public final void test03() {
		commonAbleMoveBoolTest ("UP", false);
	}
	/**
	 * Test for pawn at 2,2 traveling FLOPPY, which is invalid.
	 */
	@Test
	public final void test04() {
		commonAbleMoveBoolTest ("Floppy", false);
	}
	/**
	 * Test for pawn at 2,2 traveling south
	 */
	@Test
	public final void test05() {
		commonAbleMoveBoolTest ("South", true);
	}
	/**
	 * Test for pawn at 2,2 traveling Middle, which is invalid
	 */
	@Test
	public final void test06() {
		commonAbleMoveBoolTest ("Middle", false);
	}
	/**
	 * Test for pawn at 4,4 traveling north
	 */
	@Test
	public final void test07() {
		commonAbleMoveBoolTestD ("North", false);
	}
	/**
	 * Test for pawn at 4,4 traveling west
	 */
	@Test
	public final void test08() {
		commonAbleMoveBoolTestD ("West", false);
	}
	/**
	 * Test for pawn at 4,4 traveling south
	 */
	@Test
	public final void test09() {
		commonAbleMoveBoolTestD ("South", true);
	}
	/**
	 * Test for pawn at 4,4 traveling east
	 */
	@Test
	public final void test10() {
		commonAbleMoveBoolTestD ("East", false);
	}
	
	

}
