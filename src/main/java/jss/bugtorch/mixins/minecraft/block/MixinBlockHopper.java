package jss.bugtorch.mixins.minecraft.block;

import java.util.Random;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import jss.util.RandomXoshiro256StarStar;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.world.World;

@Mixin(value = BlockHopper.class)
public abstract class MixinBlockHopper extends BlockContainer {
    
    protected MixinBlockHopper(Material material) {
        super(material);
    }

    @Final
    private Random field_149922_a = new RandomXoshiro256StarStar();
    
    /**
     * @author jss2a98aj
     * @reason Splitting dropped item stacks just for them to stack right after is basically pointless.
     */
    @Overwrite()
    public void breakBlock(World world, int x, int y, int z, Block block, int p_149749_6_) {
        TileEntityHopper tileEntityHopper = (TileEntityHopper)world.getTileEntity(x, y, z);
        if (tileEntityHopper != null) {
            for (int slot = 0; slot < tileEntityHopper.getSizeInventory(); ++slot) {
                ItemStack itemStack = tileEntityHopper.getStackInSlot(slot);
                if (itemStack != null) {
                    float randX = this.field_149922_a.nextFloat() * 0.8F + 0.1F;
                    float randY = this.field_149922_a.nextFloat() * 0.8F + 0.1F;
                    float randZ = this.field_149922_a.nextFloat() * 0.8F + 0.1F;
                    EntityItem entityitem = new EntityItem(world, (double)((float)x + randX), (double)((float)y + randY), (double)((float)z + randZ), itemStack);
                    float motionMult = 0.05F;
                    entityitem.motionX = (double)((float)this.field_149922_a.nextGaussian() * motionMult);
                    entityitem.motionY = (double)((float)this.field_149922_a.nextGaussian() * motionMult + 0.2F);
                    entityitem.motionZ = (double)((float)this.field_149922_a.nextGaussian() * motionMult);
                    if (itemStack.hasTagCompound()) {
                        entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemStack.getTagCompound().copy());
                    }
                    world.spawnEntityInWorld(entityitem);
                }
            }
            world.func_147453_f(x, y, z, block);
        }
        super.breakBlock(world, x, y, z, block, p_149749_6_);
    }

}
