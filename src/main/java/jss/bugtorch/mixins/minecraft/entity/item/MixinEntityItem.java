package jss.bugtorch.mixins.minecraft.entity.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = EntityItem.class)
public abstract class MixinEntityItem extends Entity {

    public MixinEntityItem(World world) {
        super(world);
    }

    /**
     * @author jss2a98aj
     * @reason If an item stack is full don't attempt to stack with nearby stacks
     */
    @Inject(method = "searchForOtherItemsNearby", at = @At("HEAD"), cancellable = true)
    private void searchForOtherItemsNearbyHead(CallbackInfo ci) {
        final ItemStack stack = getDataWatcher().getWatchableObjectItemStack(10);
        if (stack.stackSize >= stack.getMaxStackSize()) {
            // System.out.println("Cancelled searchForOtherItemsNearby due to max stack size");
            ci.cancel();
        }
    }
}
