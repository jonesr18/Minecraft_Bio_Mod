package com.authorea.biomod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TestItem extends Item {
	
	public TestItem() {
		
		setUnlocalizedName(Reference.MODID + "_" + "testItem");
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
}
