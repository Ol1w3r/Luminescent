package w3r.lumi.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import w3r.lumi.Luminescent;
import w3r.lumi.init.Blocks;
import w3r.lumi.init.Items;
import w3r.lumi.util.IHasModel;

public class BlockBase extends Block implements IHasModel 
{
	public BlockBase(String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Blocks.tabLumi);
		
		Blocks.BLOCKS.add(this);
		Items.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() 
	{
		Luminescent.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}