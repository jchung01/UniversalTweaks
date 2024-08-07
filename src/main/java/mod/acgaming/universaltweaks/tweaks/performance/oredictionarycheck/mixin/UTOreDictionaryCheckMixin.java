package mod.acgaming.universaltweaks.tweaks.performance.oredictionarycheck.mixin;

import net.minecraftforge.oredict.OreDictionary;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import mod.acgaming.universaltweaks.config.UTConfigTweaks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

// Courtesy of fonnymunkey
@Mixin(OreDictionary.class)
public abstract class UTOreDictionaryCheckMixin
{
    @WrapWithCondition(
        method = "registerOreImpl",
        at = @At(value = "INVOKE", target = "Lnet/minecraftforge/fml/common/FMLLog;bigWarning(Ljava/lang/String;[Ljava/lang/Object;)V"),
        remap = false
    )
    private static boolean utCheckOreDictionary(String i, Object[] format)
    {
        return !UTConfigTweaks.PERFORMANCE.utOreDictionaryCheckToggle;
    }
}