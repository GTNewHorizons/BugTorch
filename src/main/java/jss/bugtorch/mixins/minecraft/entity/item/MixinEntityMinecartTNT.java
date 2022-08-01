package jss.bugtorch.mixins.minecraft.entity.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = EntityMinecartTNT.class)
public abstract class MixinEntityMinecartTNT extends EntityMinecart {

    public MixinEntityMinecartTNT(World world) {
        super(world);
    }

    @Shadow
    protected void explodeCart(double p_94103_1_) {}

    /**
     * @author jss2a98aj
     * @reason "Fire arrow make cart go boom"
     */
    public boolean attackEntityFrom(DamageSource source, float amount) {
        Entity entity = source.getSourceOfDamage();

        if (entity instanceof EntityArrow) {
            EntityArrow entityarrow = (EntityArrow) entity;

            if (entityarrow.isBurning()) {
                explodeCart(entityarrow.motionX * entityarrow.motionX
                        + entityarrow.motionY * entityarrow.motionY
                        + entityarrow.motionZ * entityarrow.motionZ);
            }
        }
        return super.attackEntityFrom(source, amount);
    }
}
