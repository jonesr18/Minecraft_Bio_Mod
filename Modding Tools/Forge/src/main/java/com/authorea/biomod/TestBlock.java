package com.authorea.biomod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class TestBlock extends Block {
	
	public TestBlock() {
		
		// Initialize this block with the properties of a rock block
		super(Material.rock);
		
		// Sets the unlocalized block name - include the mod ID so there is no confusion
		setUnlocalizedName(BioMod.MODID + "_" + "testBlock");
		
		// Sets where the block is found in creative mode
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
}
