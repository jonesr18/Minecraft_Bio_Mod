package com.authorea.biomod;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class TestEventHandler {
	
	// This is an example with FML
	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event) {
		
	}
	
	// This is an example with forge
	@SubscribeEvent
	public void throwEgg(PlayerInteractEvent event) {
		
	}
	
}
