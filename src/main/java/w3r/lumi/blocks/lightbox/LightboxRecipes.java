package w3r.lumi.blocks.lightbox;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class LightboxRecipes 
{	
	private static final LightboxRecipes INSTANCE = new LightboxRecipes();
	private final ArrayList<Recipe> smeltingList;
	//private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
	public static LightboxRecipes getInstance()
	{
		return INSTANCE;
	}
	
	private LightboxRecipes() 
	{
		
		//addSinteringRecipe(new ItemStack(Blocks.ACACIA_FENCE), new ItemStack(Blocks.ACACIA_FENCE_GATE), new ItemStack(BlockInit.COPPER_CHEST), 5.0F);
	}

	
	public void addLightboxRecipe(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4, ItemStack input5,
									ItemStack result) 
	{
		if(getLightboxResult(input1, input2, input3, input4, input5) != ItemStack.EMPTY) return;
		this.smeltingList.put(input1, input2, input3, input4, input5, result);
		//this.experienceList.put(result, Float.valueOf(experience));
	}
	
	public ItemStack getLightboxResult(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4, ItemStack input5) 
	{
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()) 
		{
			if(this.compareItemStacks(input1, (ItemStack)entry.getKey())) 
			{
				for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) 
				{
					if(this.compareItemStacks(input2, (ItemStack)ent.getKey())) 
					{
						return (ItemStack)ent.getValue();
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public ArrayList<Recipe> getDualSmeltingList() 
	{
		return this.smeltingList;
	}
	
	public float getSinteringExperience(ItemStack stack)
	{
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) 
		{
			if(this.compareItemStacks(stack, (ItemStack)entry.getKey())) 
			{
				return ((Float)entry.getValue()).floatValue();
			}
		}
		return 0.0F;
	}
	
	private void loadRecipes() {
		//Test Recipe
		smeltingList.add(new Recipe(new ItemStack(Items.REDSTONE), new ItemStack(Items.REDSTONE), 
									new ItemStack(Items.REDSTONE), new ItemStack(Items.REDSTONE),
									new ItemStack(Items.REDSTONE), new ItemStack(Items.GLOWSTONE_DUST)));
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
		
		private boolean compareRecipe(ItemStack item1, ItemStack item2, ItemStack item3, ItemStack item4, ItemStack item5) {
			if(this.item1 == item1 && this.item2 == item2 && this.item3 == item3 && this.item4 == item4 && this.item5 == item5) return true;
			return false;
		}
	}
}