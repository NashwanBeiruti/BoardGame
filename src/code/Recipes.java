

	/**
	 * @author Wiechec
	 * Class is a placeholder only for future implementation.
	 */
	package code;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Random;

	public class Recipes {
		
		//ArrayList of recipes to be created
		private ArrayList<ArrayList<Integer>> recipes;
		
		//ArrayList of chosenRecipes to make sure no one player gets the same recipe
		private ArrayList<Integer> chosenRecipes = new ArrayList<Integer>();
		
		public Recipes(){
			recipes = new ArrayList<ArrayList<Integer>>();
			
			//adds an ArrayList of ints to resemble a recipe of 3 ingredients(on the tokens)
			ArrayList<Integer> newRecipe1 = new ArrayList<Integer>();
			newRecipe1.add(12); newRecipe1.add(1); newRecipe1.add(9);
			recipes.add(newRecipe1);
			ArrayList<Integer> newRecipe2 = new ArrayList<Integer>();
			newRecipe2.add(11); newRecipe2.add(3); newRecipe2.add(14);
			recipes.add(newRecipe2);
			ArrayList<Integer> newRecipe3 = new ArrayList<Integer>();
			newRecipe3.add(8); newRecipe3.add(19); newRecipe3.add(5);
			recipes.add(newRecipe3);
			ArrayList<Integer> newRecipe4 = new ArrayList<Integer>();
			newRecipe4.add(1); newRecipe4.add(10); newRecipe4.add(13);
			recipes.add(newRecipe4);
			ArrayList<Integer> newRecipe5 = new ArrayList<Integer>();
			newRecipe5.add(17); newRecipe5.add(5); newRecipe5.add(6);
			recipes.add(newRecipe5);
			ArrayList<Integer> newRecipe6 = new ArrayList<Integer>();
			newRecipe6.add(4); newRecipe6.add(13); newRecipe6.add(20);
			recipes.add(newRecipe6);
			ArrayList<Integer> newRecipe7 = new ArrayList<Integer>();
			newRecipe7.add(25); newRecipe7.add(16); newRecipe7.add(2);
			recipes.add(newRecipe7);
			ArrayList<Integer> newRecipe8 = new ArrayList<Integer>();
			newRecipe8.add(14); newRecipe8.add(4); newRecipe8.add(10);
			recipes.add(newRecipe8);
			ArrayList<Integer> newRecipe9 = new ArrayList<Integer>();
			newRecipe9.add(1); newRecipe9.add(18); newRecipe9.add(3);
			recipes.add(newRecipe9);
			ArrayList<Integer> newRecipe10 = new ArrayList<Integer>();
			newRecipe10.add(5); newRecipe10.add(25); newRecipe10.add(18);
			recipes.add(newRecipe10);
			ArrayList<Integer> newRecipe11 = new ArrayList<Integer>();
			newRecipe11.add(19); newRecipe11.add(7); newRecipe11.add(15);
			recipes.add(newRecipe11);
			ArrayList<Integer> newRecipe12 = new ArrayList<Integer>();
			newRecipe12.add(18); newRecipe12.add(11); newRecipe12.add(19);
			recipes.add(newRecipe12);
			ArrayList<Integer> newRecipe13 = new ArrayList<Integer>();
			newRecipe13.add(13); newRecipe13.add(15); newRecipe13.add(12);
			recipes.add(newRecipe13);
			ArrayList<Integer> newRecipe14 = new ArrayList<Integer>();
			newRecipe14.add(9); newRecipe14.add(20); newRecipe14.add(11);
			recipes.add(newRecipe14);
			ArrayList<Integer> newRecipe15 = new ArrayList<Integer>();
			newRecipe15.add(10); newRecipe15.add(12); newRecipe15.add(16);
			recipes.add(newRecipe15);
			ArrayList<Integer> newRecipe16 = new ArrayList<Integer>();
			newRecipe16.add(20); newRecipe16.add(17); newRecipe16.add(3);
			recipes.add(newRecipe16);
			ArrayList<Integer> newRecipe17 = new ArrayList<Integer>();
			newRecipe17.add(7); newRecipe17.add(6); newRecipe17.add(25);
			recipes.add(newRecipe17);
			ArrayList<Integer> newRecipe18 = new ArrayList<Integer>();
			newRecipe18.add(15); newRecipe18.add(2); newRecipe18.add(4);
			recipes.add(newRecipe18);
			ArrayList<Integer> newRecipe19 = new ArrayList<Integer>();
			newRecipe19.add(16); newRecipe19.add(9); newRecipe19.add(7);
			recipes.add(newRecipe19);
			ArrayList<Integer> newRecipe20 = new ArrayList<Integer>();
			newRecipe20.add(6); newRecipe20.add(14); newRecipe20.add(18);
			recipes.add(newRecipe20);
			ArrayList<Integer> newRecipe21 = new ArrayList<Integer>();
			newRecipe21.add(2); newRecipe21.add(8); newRecipe21.add(17);
			recipes.add(newRecipe21);
		}
		
		//Method gets a random recipe for each player
		public ArrayList<Integer> getRandomRecipe(){
			Random random = new Random();
			
			int recNum =0;
			while(true)
			{
				//pick a new random record number
				recNum = random.nextInt(21);
				
				boolean alreadyChosen = false;
				//checks to see if the chosen recipe is already taken
				for(int i = 0; i < chosenRecipes.size();i++){
					if(recNum == chosenRecipes.get(i)){
						//this was already chosen
						alreadyChosen = true;
					}
				}
				//if not already chosen then we have one
				if(!alreadyChosen)
					break;
				//otherwise keep looping around and trying random rec num
			}
			//found an unused recipe
			chosenRecipes.add(recNum);
			return recipes.get(recNum);
		}

	}
