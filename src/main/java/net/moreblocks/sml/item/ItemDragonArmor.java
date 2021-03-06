
package net.moreblocks.sml.item;

import net.moreblocks.sml.procedure.ProcedureDragonArmorBody;
import net.moreblocks.sml.creativetab.TabMoreOres;
import net.moreblocks.sml.ElementsMoreblocksMod;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import java.util.Map;
import java.util.HashMap;

@ElementsMoreblocksMod.ModElement.Tag
public class ItemDragonArmor extends ElementsMoreblocksMod.ModElement {
	@GameRegistry.ObjectHolder("moreblocks:dragon_armorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("moreblocks:dragon_armorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("moreblocks:dragon_armorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("moreblocks:dragon_armorboots")
	public static final Item boots = null;
	public ItemDragonArmor(ElementsMoreblocksMod instance) {
		super(instance, 42);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("DRAGON_ARMOR", "moreblocks:dragon__", 35, new int[]{3, 10, 9, 5}, 17,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("dragon_armorhelmet")
				.setRegistryName("dragon_armorhelmet").setCreativeTab(TabMoreOres.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureDragonArmorBody.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("dragon_armorbody").setRegistryName("dragon_armorbody").setCreativeTab(TabMoreOres.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("dragon_armorlegs")
				.setRegistryName("dragon_armorlegs").setCreativeTab(TabMoreOres.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("dragon_armorboots")
				.setRegistryName("dragon_armorboots").setCreativeTab(TabMoreOres.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("moreblocks:dragon_armorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("moreblocks:dragon_armorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("moreblocks:dragon_armorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("moreblocks:dragon_armorboots", "inventory"));
	}
}
