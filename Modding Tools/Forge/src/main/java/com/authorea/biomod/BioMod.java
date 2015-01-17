package com.authorea.biomod;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = BioMod.MODID, version = BioMod.VERSION)
public class BioMod {
	
	public static final String MODID = "biomod";
	public static final String VERSION = "0.1.0";
	
	// Blocks must be declared as fields
	public static Block newkidontheBlock;
	
	
	@EventHandler
	/*
	 * This is a pre-initialization method.
	 * 
	 * Here we declare recipes, blocks, smelting info, etc that we are adding in our mod.
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
		GameRegistry.addRecipe(new ItemStack(Items.dye, 2, 1), new Object [] {
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
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
}








