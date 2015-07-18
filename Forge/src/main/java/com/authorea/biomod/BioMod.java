package com.authorea.biomod;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class BioMod {
		
	// Blocks, items, and event handlers must be declared as fields
	public static Block newkidontheBlock;
	public static Item testItem;
	TestEventHandler events = new TestEventHandler();
	
	// This helps stop client from messing us up. Not sure how really.
	@Instance(Reference.MODID)
	public static BioMod instance;
	
	// For setting up a proxy to be used by the client or server differently
	@SidedProxy(clientSide = "com.authorea.biomod.client.ClientProxy", 
			serverSide = "com.authorea.biomod.client.CommonProxy")
	public static CommonProxy proxy;
	
	
	@EventHandler
	/*
	 * This is a pre-initialization method.
	 * 
	 * Here we declare recipes, blocks, items, events, smelting info, for our mod.
	 */
	public void preinit(FMLPreInitializationEvent event) {
		// Add a recipe in which 9 cookies gives an obsidian block
		GameRegistry.addRecipe(
				new ItemStack(Blocks.obsidian), 	// Output item(S)
				new Object[]{						// Input array
					"AAA",							// Crafting arrangement
			    	"AAA",
			    	"AAA",
			    	'A', Items.cookie				// Dictates what 'A' means above
				});
		
		// Add a recipe in which 4 cobblestone gives 4 apples
		GameRegistry.addRecipe(new ItemStack(Items.apple, 4), new Object [] {
			"AA",
			"AA",
			'A', Blocks.cobblestone
		});
		
		// Add a complex recipe to make 2 bonemeal (dye metadata 15) 
		GameRegistry.addRecipe(new ItemStack(Items.dye, 2, 15), new Object [] {
			"AB ",
			"AAC",
			"A  ",
			'A', Items.cookie,
			'B', Blocks.dirt,
			'C', new ItemStack(Items.dye, 1, 1) 	// 1 red dye
			// To require more of one type of block, add another comma reference to it.
			// Supposedly it won't work to put a 2 in second ItemStack parameter.
		});
		
		// Add a shapeless recipe to make 2 red dye (dye metadata 1)
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 2, 1), new Object [] {
			new ItemStack(Items.dye, 1, 1), 		// 1 red dye
			Items.redstone
		});
		
		// Add a smelting recipe for turninc cobblesstone into stone
		GameRegistry.addSmelting(
				new ItemStack(Items.dye, 1, 1), 	// Input item
				new ItemStack(Items.dye, 1, 11), 	// Output item
				0.1F);								// Experience gained (1.0F for diamond ore)
		
		// Add a test block
		newkidontheBlock = new TestBlock();
		GameRegistry.registerBlock(newkidontheBlock, "testBlock");
		
		// Add a test item
		testItem = new TestItem();
		GameRegistry.registerItem(testItem, "testItem");
		
		// Events can be registered with FML and forge like so:
		FMLCommonHandler.instance().bus().register(events);
		MinecraftForge.EVENT_BUS.register(events);
	}
	
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		
	}
}








