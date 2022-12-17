package mod.acgaming.universaltweaks.util;

import java.util.List;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiErrorScreen;
import net.minecraftforge.fml.client.CustomModLoadingErrorDisplayException;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class UTObsoleteModsException
{
    public static void throwException(List<String> messages)
    {
        throw new Exception(messages);
    }

    public static class Exception extends CustomModLoadingErrorDisplayException
    {
        public final List<String> messages;

        public Exception(List<String> messages)
        {
            this.messages = messages;
        }

        @Override
        public void initGui(GuiErrorScreen errorScreen, FontRenderer fontRenderer) {}

        @Override
        public void drawScreen(GuiErrorScreen errorScreen, FontRenderer fontRenderer, int mouseRelX, int mouseRelY, float tickTime)
        {
            int x = errorScreen.width / 2;
            int y = 75;
            for (String message : messages)
            {
                errorScreen.drawCenteredString(fontRenderer, message, x, y, 0xFFFFFF);
                y += 15;
            }
        }
    }
}