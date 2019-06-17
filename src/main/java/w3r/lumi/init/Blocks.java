package w3r.lumi.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import w3r.lumi.blocks.Lightbox_Table;

public class Blocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final CreativeTabs tabLumi = (new CreativeTabs("tabLumi") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Lightbox_Table);
		}
		
	});
	
	public static final Lightbox_Table Lightbox_Table = new Lightbox_Table();
}
