package jss.bugtorch.mixins.late.crayfishfurniture.fix;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import com.mrcrayfish.furniture.tileentity.TileEntityWashingMachine;

@Mixin(value = TileEntityWashingMachine.class)
public abstract class MixinTileEntityWashingMachine {

    /**
     * @author jss2a98aj
     * @reason Stop crashing vanilla and modded content that looks for ISidedInventory.
     */
    @Overwrite
    public int[] getAccessibleSlotsFromSide(int side) {
        return new int[] {};
    }

}
