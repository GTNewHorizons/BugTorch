package jss.bugtorch.mixins.random.world;

import java.util.Random;

import jss.bugtorch.util.RandomXoshiro256StarStar;
import org.spongepowered.asm.mixin.Mixin;
/*
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
*/

import net.minecraft.world.World;

@Mixin(World.class)
public class MixinWorld {

    public Random rand = new RandomXoshiro256StarStar();

    /*
    @Inject(method = "<init>*", at = @At("RETURN"))
    private void onWorldInit(CallbackInfo ci) {
        if(rand instanceof XSTR) {
            System.out.println("World is using XSTR for Random");
        } else {
            System.out.println("World is NOT using XSTR for Random");
        }
    }
    */

}
