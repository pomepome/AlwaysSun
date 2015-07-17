package pome.alwayssun;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;

public class TickHandler
{
	@SubscribeEvent
	public void onTick(TickEvent.WorldTickEvent event)
	{
		if(event.side == Side.SERVER)
		{
			WorldServer ws = MinecraftServer.getServer().worldServers[0];
			WorldInfo wi = ws.getWorldInfo();
			if(AlwaysSun.sunny)
			{
				wi.setRainTime(0);
				wi.setThunderTime(0);
				wi.setRaining(false);
				wi.setThundering(false);
			}
			if(AlwaysSun.daytime)
			{
				wi.setWorldTime(6000);
			}
		}
	}
}
