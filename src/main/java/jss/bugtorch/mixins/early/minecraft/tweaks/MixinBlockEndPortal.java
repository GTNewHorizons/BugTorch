package jss.bugtorch.mixins.early.minecraft.tweaks;

import net.minecraft.block.BlockEndPortal;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = BlockEndPortal.class)
public abstract class MixinBlockEndPortal {

    /**
     * @author jss2a98aj
     * @reason Allows end portals to be placed outside of the overworld.
     */
    @Overwrite()
    public void onBlockAdded(World worldIn, int x, int y, int z) {}

}
