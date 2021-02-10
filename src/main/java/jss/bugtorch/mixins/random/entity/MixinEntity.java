package jss.bugtorch.mixins.random.entity;

import jss.bugtorch.util.RandomXoshiro256StarStar;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(Entity.class)
public class MixinEntity {

    @Redirect(method = "<init>*", at = @At(value = "NEW", target = "java/util/Random"))
    private Random redirectInitRandom() {
        return new RandomXoshiro256StarStar();
    }

}
