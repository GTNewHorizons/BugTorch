package jss.bugtorch.mixins.late.llibrary.fix;

import java.util.List;

import net.ilexiconn.llibrary.server.util.WebUtils;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = WebUtils.class, remap = false)
public abstract class MixinWebUtils {

    /**
     * @author jss2a98aj
     * @reason Fixes a crash caused by invalid data being provided from regional blocks.
     */
    @Overwrite
    public static String readPastebin(String pasteID) {
        return readURL("http://pastebinp.com/raw.php?i=" + pasteID);
    }

    /**
     * @author jss2a98aj
     * @reason Fixes a crash caused by invalid data being provided from regional blocks.
     */
    @Overwrite
    public static List<String> readPastebinAsList(String pasteID) {
        return readURLAsList("http://pastebinp.com/raw.php?i=" + pasteID);
    }

    @Shadow
    public static String readURL(String url) {
        return null;
    }

    @Shadow
    public static List<String> readURLAsList(String url) {
        return null;
    }

}
