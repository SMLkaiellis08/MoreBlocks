
package net.moreblocks.sml.item;

import net.moreblocks.sml.creativetab.TabMoreOres;
import net.moreblocks.sml.ElementsMoreblocksMod;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

@ElementsMoreblocksMod.ModElement.Tag
public class ItemBronzeArmor extends ElementsMoreblocksMod.ModElement {
	@GameRegistry.ObjectHolder("moreblocks:bronze_armorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("moreblocks:bronze_armorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("moreblocks:bronze_armorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("moreblocks:bronze_armorboots")
	public static final Item boots = null;
	public ItemBronzeArmor(ElementsMoreblocksMod instance) {
		super(instance, 37);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("BRONZE_ARMOR", "moreblocks:bronze_", 9, new int[]{1, 4, 3, 1}, 5,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("bronze_armorhelmet")
				.setRegistryName("bronze_armorhelmet").setCreativeTab(TabMoreOres.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("bronze_armorbody")
				.setRegistryName("bronze_armorbody").setCreativeTab(TabMoreOres.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("bronze_armorlegs")
				.setRegistryName("bronze_armorlegs").setCreativeTab(TabMoreOres.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("bronze_armorboots")
				.setRegistryName("bronze_armorboots").setCreativeTab(TabMoreOres.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("moreblocks:bronze_armorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("moreblocks:bronze_armorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("moreblocks:bronze_armorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("moreblocks:bronze_armorboots", "inventory"));
	}
}
