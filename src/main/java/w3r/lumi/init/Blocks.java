package w3r.lumi.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import w3r.lumi.blocks.lightbox.Lightbox;

public class Blocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block LIGHTBOX = new Lightbox("lightbox");
	
	
	public static final CreativeTabs tabLumi = (new CreativeTabs("tabLumi") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Items.GLOWSTONE_DUST);
		}
		
	});
}
