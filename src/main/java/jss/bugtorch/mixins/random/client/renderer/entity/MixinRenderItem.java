package jss.bugtorch.mixins.random.client.renderer.entity;

import jss.bugtorch.util.RandomXoshiro256StarStar;
import net.minecraft.client.renderer.entity.RenderItem;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

@Mixin(RenderItem.class)
public class MixinRenderItem {

    private Random random = new RandomXoshiro256StarStar();

}
