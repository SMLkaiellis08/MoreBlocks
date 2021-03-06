
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
public class ItemSilverArmor extends ElementsMoreblocksMod.ModElement {
	@GameRegistry.ObjectHolder("moreblocks:silver_armorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("moreblocks:silver_armorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("moreblocks:silver_armorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("moreblocks:silver_armorboots")
	public static final Item boots = null;
	public ItemSilverArmor(ElementsMoreblocksMod instance) {
		super(instance, 38);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("SILVER_ARMOR", "moreblocks:silver_", 16, new int[]{2, 7, 6, 2}, 10,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0.5f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("silver_armorhelmet")
				.setRegistryName("silver_armorhelmet").setCreativeTab(TabMoreOres.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("silver_armorbody")
				.setRegistryName("silver_armorbody").setCreativeTab(TabMoreOres.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("silver_armorlegs")
				.setRegistryName("silver_armorlegs").setCreativeTab(TabMoreOres.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("silver_armorboots")
				.setRegistryName("silver_armorboots").setCreativeTab(TabMoreOres.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("moreblocks:silver_armorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("moreblocks:silver_armorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("moreblocks:silver_armorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("moreblocks:silver_armorboots", "inventory"));
	}
}
