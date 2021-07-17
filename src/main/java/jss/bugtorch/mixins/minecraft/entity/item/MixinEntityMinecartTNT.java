package jss.bugtorch.mixins.minecraft.entity.item;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

@Mixin(value = EntityMinecartTNT.class)
public class MixinEntityMinecartTNT extends EntityMinecart {

    public MixinEntityMinecartTNT(World world) {
        super(world);
    }

    @Shadow
    public int getMinecartType() {
        return 0;
    }

    @Shadow
    protected void explodeCart(double p_94103_1_){ 
    }

    /**
     * @author jss2a98aj
     * @reason "Fire arrow make cart go boom"
     */
    public boolean attackEntityFrom(DamageSource source, float amount) {
        Entity entity = source.getSourceOfDamage();

        if (entity instanceof EntityArrow) {
            EntityArrow entityarrow = (EntityArrow)entity;

            if (entityarrow.isBurning()) {
                this.explodeCart(entityarrow.motionX * entityarrow.motionX + entityarrow.motionY * entityarrow.motionY + entityarrow.motionZ * entityarrow.motionZ);
            }
        }
        return super.attackEntityFrom(source, amount);
    }

}
