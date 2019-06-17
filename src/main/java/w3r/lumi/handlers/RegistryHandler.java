package w3r.lumi.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import w3r.lumi.init.Blocks;
import w3r.lumi.init.Items;
import w3r.lumi.util.IHasModel;
import w3r.lumi.Luminescent;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(Items.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(Blocks.BLOCKS.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : Items.ITEMS ) 
		{
			if(item instanceof IHasModel) 
			{
				((IHasModel)item).registerModels();
				Luminescent.logger.debug("Model registered for Item '" + item + "'.");
			}
		}
		
		for(Block block : Blocks.BLOCKS ) 
		{
			if(block instanceof IHasModel) 
			{
				((IHasModel)block).registerModels();
				Luminescent.logger.debug("Model registered for Block '" + block + "'.");
			}
		}
	}
}
