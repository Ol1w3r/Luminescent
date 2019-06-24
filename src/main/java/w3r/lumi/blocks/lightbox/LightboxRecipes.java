package w3r.lumi.blocks.lightbox;

import java.util.ArrayList;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class LightboxRecipes 
{	
	private static final LightboxRecipes INSTANCE = new LightboxRecipes();
	private final ArrayList<Recipe> smeltingList;
	
	public static LightboxRecipes getInstance()
	{
		return INSTANCE;
	}
	
	private LightboxRecipes() 
	{
		smeltingList = new ArrayList<Recipe>();
		addLightboxRecipes();
	}

	
	public void addLightboxRecipes() {
		smeltingList.add(new Recipe(new ItemStack(Items.REDSTONE), new ItemStack(Items.REDSTONE), 
				new ItemStack(Items.REDSTONE), new ItemStack(Items.REDSTONE),
				new ItemStack(Items.REDSTONE), new ItemStack(Items.GLOWSTONE_DUST)));
		
	}
	
	public ItemStack getLightboxResult(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4, ItemStack input5) 
	{
		for(Recipe recipe : smeltingList) {
			if(recipe.item1.isItemEqual(input1) &&
					recipe.item2.isItemEqual(input2) &&
					recipe.item3.isItemEqual(input3) &&
					recipe.item4.isItemEqual(input4) &&
					recipe.item5.isItemEqual(input5))
			{
				return recipe.output;
			}
		}
		return ItemStack.EMPTY;
	}
	
	public ArrayList<Recipe> getDualSmeltingList() 
	{
		return this.smeltingList;
	}
	
	private class Recipe {
		ItemStack item1;
		ItemStack item2;
		ItemStack item3;
		ItemStack item4;
		ItemStack item5;
		
		ItemStack output;
		
		private Recipe(ItemStack item1, ItemStack item2, ItemStack item3, ItemStack item4, ItemStack item5, ItemStack output) {
			this.item1 = item1;
			this.item2 = item2;
			this.item3 = item3;
			this.item4 = item4;
			this.item5 = item5;
			
			this.output = output;
		}
	}
}