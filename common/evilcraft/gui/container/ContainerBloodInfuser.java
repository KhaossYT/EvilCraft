package evilcraft.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import evilcraft.entities.tileentities.TileBloodInfuser;
import evilcraft.gui.slot.SlotFluidContainer;
import evilcraft.gui.slot.SlotInfuse;
import evilcraft.gui.slot.SlotRemoveOnly;

public class ContainerBloodInfuser extends ExtendedContainer {
    
    private static final int INVENTORY_OFFSET_X = 8;
    private static final int INVENTORY_OFFSET_Y = 84;

    private IInventory playerIInventory;
    private TileBloodInfuser tile;

    public ContainerBloodInfuser(InventoryPlayer inventory, TileBloodInfuser tile) {
        super(tile.getInventorySize());
        playerIInventory = inventory;
        this.tile = tile;

        // TODO Nicer GUI (make it more thaumcrafty than buildcrafty)

        // Adding inventory
        addSlotToContainer(new SlotFluidContainer(tile, TileBloodInfuser.SLOT_CONTAINER, 8, 36)); // Container emptier
        addSlotToContainer(new SlotInfuse(tile, TileBloodInfuser.SLOT_INFUSE, 115, 36, tile)); // Infuse slot
        addSlotToContainer(new SlotRemoveOnly(tile, TileBloodInfuser.SLOT_INFUSE_RESULT, 130, 36)); // Infuse result slot

        this.addPlayerInventory(inventory, INVENTORY_OFFSET_X, INVENTORY_OFFSET_Y);

    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return tile.canInteractWith(entityPlayer);
    }
}