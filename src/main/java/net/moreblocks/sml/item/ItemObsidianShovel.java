
package net.moreblocks.sml.item;

import net.moreblocks.sml.creativetab.TabMoreOres;
import net.moreblocks.sml.ElementsMoreblocksMod;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import java.util.Set;
import java.util.HashMap;

@ElementsMoreblocksMod.ModElement.Tag
public class ItemObsidianShovel extends ElementsMoreblocksMod.ModElement {
	@GameRegistry.ObjectHolder("moreblocks:obsidian_shovel")
	public static final Item block = null;
	public ItemObsidianShovel(ElementsMoreblocksMod instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemSpade(EnumHelper.addToolMaterial("OBSIDIAN_SHOVEL", 4, 1200, 8f, 2f, 14)) {
			{
				this.attackSpeed = -3.1f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("spade", 4);
				return ret.keySet();
			}
		}.setUnlocalizedName("obsidian_shovel").setRegistryName("obsidian_shovel").setCreativeTab(TabMoreOres.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("moreblocks:obsidian_shovel", "inventory"));
	}
}
