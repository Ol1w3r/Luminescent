package w3r.lumi.blocks.lightbox.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import w3r.lumi.blocks.lightbox.LightboxTileEntity;

public class FuelSlotLightbox extends Slot {

	private static IInventory emptyInventory = new InventoryBasic("[Null]", true, 0);
	
	
	public FuelSlotLightbox(int index, int x, int y) {
		
		super(emptyInventory, index, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		
		return LightboxTileEntity.isItemFuel(stack);
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) {
		return super.getItemStackLimit(stack);
	}
}
