package w3r.lumi.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import w3r.lumi.Luminescent;
import w3r.lumi.init.Blocks;

public class Lightbox_Table extends BlockBase {

	public Lightbox_Table() {
		super("lightbox_table", Material.ROCK);
		setCreativeTab(Blocks.tabLumi);
		
	}
	
	@Override
	public void registerModels() 
	{
		Luminescent.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		System.out.println("BLOCK PLACED #######");
		if (worldIn.isRemote)
        {
            return;
        }
        else
        {
        	System.out.println("CLIENT SIDE #######");
            return;
        }
	}
	/**
     * Called when the block is right clicked by a player.
     */
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	System.out.println("BLOCK RIGHT CLICKED #######");
        if (worldIn.isRemote)
        {
        	System.out.println("SERVER SIDE #######");
            return true;
        }
        else
        {
        	System.out.println("CLIENT SIDE #######");
            playerIn.displayGui(new Lightbox_Table.InterfaceLightboxTable(worldIn, pos));
            return true;
        }
    }
    
    public static class InterfaceLightboxTable implements IInteractionObject
    {
        private final World world;
        private final BlockPos position;

        public InterfaceLightboxTable(World worldIn, BlockPos pos)
        {
            this.world = worldIn;
            this.position = pos;
        }

        /**
         * Get the name of this object. For players this returns their username
         */
        public String getName()
        {
            return "lightbox_table";
        }

        /**
         * Returns true if this thing is named
         */
        public boolean hasCustomName()
        {
            return false;
        }

        /**
         * Get the formatted ChatComponent that will be used for the sender's username in chat
         */
        public ITextComponent getDisplayName()
        {
            return new TextComponentTranslation(Blocks.Lightbox_Table.getUnlocalizedName() + ".name", new Object[0]);
        }

        public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
        {
            return new ContainerWorkbench(playerInventory, this.world, this.position);
        }

        public String getGuiID()
        {
            return "minecraft:crafting_table";
        }
    }

}
