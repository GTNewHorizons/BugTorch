package jss.bugtorch.mixins.random.server;

import jss.bugtorch.util.RandomXoshiro256StarStar;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

@Mixin(MinecraftServer.class)
public class MixinMinecraftServer {

    @Final
    private Random field_147146_q = new RandomXoshiro256StarStar();

}