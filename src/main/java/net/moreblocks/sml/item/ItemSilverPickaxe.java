
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
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import java.util.Set;
import java.util.HashMap;

@ElementsMoreblocksMod.ModElement.Tag
public class ItemSilverPickaxe extends ElementsMoreblocksMod.ModElement {
	@GameRegistry.ObjectHolder("moreblocks:silver_pickaxe")
	public static final Item block = null;
	public ItemSilverPickaxe(ElementsMoreblocksMod instance) {
		super(instance, 21);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemPickaxe(EnumHelper.addToolMaterial("SILVER_PICKAXE", 2, 323, 7f, 0f, 17)) {
			{
				this.attackSpeed = -3f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("pickaxe", 2);
				return ret.keySet();
			}
		}.setUnlocalizedName("silver_pickaxe").setRegistryName("silver_pickaxe").setCreativeTab(TabMoreOres.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("moreblocks:silver_pickaxe", "inventory"));
	}
}
