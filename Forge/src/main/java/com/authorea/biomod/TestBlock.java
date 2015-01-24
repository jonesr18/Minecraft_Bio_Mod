package com.authorea.biomod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class TestBlock extends Block {
	
	public TestBlock() {
		
		// Initialize this block with the properties of a rock block
		super(Material.rock);
		
		// Sets the unlocalized block name - include the mod ID so there is no confusion
		this.setUnlocalizedName(Reference.MODID + "_" + "testBlock");
		
		// Sets where the block is found in creative mode
		this.setCreativeTab(CreativeTabs.tabBlock);
		
		// Set hardness to a float value. 0.5F -> dirt, 50.0F -> obsidian
		this.setHardness(5.0F);
		
		// Set resistance to explosions 6,000,000.0F -> bedrock
		this.setResistance(50.0F);
		
		// Set the sound when walked on
		this.setStepSound(Block.soundTypeStone);
	}	
}
