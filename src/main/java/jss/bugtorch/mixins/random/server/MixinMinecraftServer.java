package jss.bugtorch.mixins.random.server;

import java.util.Random;
import jss.util.RandomXoshiro256StarStar;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = MinecraftServer.class)
public abstract class MixinMinecraftServer {

    /**
     * Xoshiro256** is faster than Random
     */
    @Final
    private Random field_147146_q = new RandomXoshiro256StarStar();
}
