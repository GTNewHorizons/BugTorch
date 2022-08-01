package jss.bugtorch.mixins.minecraft.server;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = MinecraftServer.class)
public abstract class MixinMinecraftServer {

    /**
     * @author jss2a98aj
     * @reason Makes initial world loading faster
     */
    @Overwrite()
    public void initialWorldChunkLoad() {}
}
