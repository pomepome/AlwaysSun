package pome.alwayssun;

import java.io.File;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

@Mod(name="AlwaysSun",modid="alwayssun",version="v1")
public class AlwaysSun
{
	public static boolean enabled;
	public static boolean daytime;
	public static boolean sunny;

	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		if(enabled)
		{
			FMLCommonHandler.instance().bus().register(new TickHandler());
		}
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		File cfgFile = event.getSuggestedConfigurationFile();
		Configuration cfg = new Configuration(cfgFile);
		cfg.load();
		enabled = cfg.getBoolean("enabled","general",true,"is the mod enabled?");
		daytime = cfg.getBoolean("Daytime","general",true,"Always daytime?");
		sunny = cfg.getBoolean("Sunny","general",true,"Always sunny?");
		cfg.save();
	}
}
