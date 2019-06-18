package w3r.lumi.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import w3r.lumi.inventory.ContainerLB;
import w3r.lumi.tileentity.TileEntityLightBox;

public class GuiHandler implements IGuiHandler{
	
	public static final int GUI_LIGHTBOX = 0;
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world,	int x, int y, int z) {
		
		TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
	    switch (id)
	    {
	    case GUI_LIGHTBOX: 
	      if ((tileEntity instanceof TileEntityLightBox)) {
	        return new ContainerLB(player.inventory, (TileEntityLightBox)tileEntity);
	      }
	      
	    }
	    return null;
	    
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world,	int x, int y, int z) {
		  
		TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
	    switch (id)
	    {
	    case GUI_LIGHTBOX: 
	      if ((tileEntity instanceof TileEntityLightBox)) {
	        return new GuiLB(player.inventory, (TileEntityLightBox)tileEntity);
	      }
	      
	    }
	    
	    return null;
	  }

}