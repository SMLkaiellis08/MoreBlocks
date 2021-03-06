
package net.moreblocks.sml.item;

import net.moreblocks.sml.procedure.ProcedureBreadItemIsCraftedsmelted;
import net.moreblocks.sml.ElementsMoreblocksMod;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import java.util.Map;
import java.util.HashMap;

@ElementsMoreblocksMod.ModElement.Tag
public class ItemBread extends ElementsMoreblocksMod.ModElement {
	@GameRegistry.ObjectHolder("moreblocks:bread")
	public static final Item block = null;
	public ItemBread(ElementsMoreblocksMod instance) {
		super(instance, 84);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("moreblocks:bread", "inventory"));
	}
	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(2, 0f, false);
			setUnlocalizedName("bread");
			setRegistryName("bread");
			setCreativeTab(CreativeTabs.FOOD);
			setMaxStackSize(64);
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}

		@Override
		public void onCreated(ItemStack itemstack, World world, EntityPlayer entity) {
			super.onCreated(itemstack, world, entity);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureBreadItemIsCraftedsmelted.executeProcedure($_dependencies);
			}
		}
	}
}
