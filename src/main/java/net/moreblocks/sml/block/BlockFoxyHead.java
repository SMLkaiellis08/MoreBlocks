
package net.moreblocks.sml.block;

import net.moreblocks.sml.procedure.ProcedureFoxyHeadEntityWalksOnTheBlock;
import net.moreblocks.sml.creativetab.TabFNAF;
import net.moreblocks.sml.ElementsMoreblocksMod;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

@ElementsMoreblocksMod.ModElement.Tag
public class BlockFoxyHead extends ElementsMoreblocksMod.ModElement {
	@GameRegistry.ObjectHolder("moreblocks:foxy_head")
	public static final Block block = null;
	public BlockFoxyHead(ElementsMoreblocksMod instance) {
		super(instance, 96);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("foxy_head"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("moreblocks:foxy_head", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.IRON);
			setUnlocalizedName("foxy_head");
			setSoundType(SoundType.METAL);
			setHardness(0.15F);
			setResistance(10F);
			setLightLevel(0.97F);
			setLightOpacity(0);
			setCreativeTab(TabFNAF.tab);
		}

		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}

		@Override
		public int quantityDropped(Random random) {
			return 0;
		}

		@Override
		public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer entity, boolean willHarvest) {
			boolean retval = super.removedByPlayer(state, world, pos, entity, willHarvest);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureFoxyHeadEntityWalksOnTheBlock.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
