package jss.bugtorch.mixins.random.block;

import jss.bugtorch.util.RandomXoshiro256StarStar;
import net.minecraft.block.BlockChest;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

@Mixin(BlockChest.class)
public class MixinBlockChest {

    @Final
    private Random field_149955_b = new RandomXoshiro256StarStar();

}
