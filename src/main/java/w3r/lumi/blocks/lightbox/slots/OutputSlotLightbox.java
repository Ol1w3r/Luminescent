package w3r.lumi.blocks.lightbox.slots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class OutputSlotLightbox extends Slot {

	private static IInventory emptyInventory = new InventoryBasic("[Null]", true, 0);
	private final EntityPlayer player;
	private int removeCount;
	
	public OutputSlotLightbox(EntityPlayer player, int index, int x, int y) {
		super(emptyInventory, index, x, y);
		this.player = player;
		
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return false;
	}
	
	@Override
	public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) {
		this.onCrafting(stack);
		super.onTake(thePlayer, stack);
		return stack;
	}
	
	@Override
	public ItemStack decrStackSize(int amount) {
		if(this.getHasStack()) this.removeCount += Math.min(amount, this.getStack().getCount());
		return super.decrStackSize(amount);
	}
}
