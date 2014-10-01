package mezz.jei;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import mezz.jei.util.Log;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = JustEnoughItems.MODID, version = JustEnoughItems.VERSION)
public class JustEnoughItems {
    public static final String MODID = "JustEnoughItems";
    public static final String VERSION = "1.0";

	public static ItemRegistry itemRegistry;

    @EventHandler
    public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new GuiEventHandler());

		itemRegistry = new ItemRegistry();

	}
}
