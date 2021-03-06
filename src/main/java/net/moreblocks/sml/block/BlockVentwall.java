
package net.moreblocks.sml.block;

import net.moreblocks.sml.creativetab.TabFnafBlocks;
import net.moreblocks.sml.ElementsMoreblocksMod;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

@ElementsMoreblocksMod.ModElement.Tag
public class BlockVentwall extends ElementsMoreblocksMod.ModElement {
	@GameRegistry.ObjectHolder("moreblocks:ventwall")
	public static final Block block = null;
	public BlockVentwall(ElementsMoreblocksMod instance) {
		super(instance, 337);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("ventwall"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("moreblocks:ventwall", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("ventwall");
			setSoundType(SoundType.METAL);
			setHardness(1F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabFnafBlocks.tab);
		}
	}
}
