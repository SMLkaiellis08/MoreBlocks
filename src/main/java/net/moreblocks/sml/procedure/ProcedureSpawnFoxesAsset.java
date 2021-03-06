package net.moreblocks.sml.procedure;

import net.moreblocks.sml.MoreblocksModVariables;
import net.moreblocks.sml.ElementsMoreblocksMod;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.GuiTextField;

import java.util.Map;
import java.util.HashMap;

@ElementsMoreblocksMod.ModElement.Tag
public class ProcedureSpawnFoxesAsset extends ElementsMoreblocksMod.ModElement {
	public ProcedureSpawnFoxesAsset(ElementsMoreblocksMod instance) {
		super(instance, 301);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SpawnFoxesAsset!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			System.err.println("Failed to load dependency guistate for procedure SpawnFoxesAsset!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SpawnFoxesAsset!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		World world = (World) dependencies.get("world");
		if ((((new Object() {
			public String getText() {
				GuiTextField textField = (GuiTextField) guistate.get("text:Spawn_foxes");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())).equals("true"))) {
			MoreblocksModVariables.MapVariables.get(world).Foxes_Normal_Spawn = (boolean) (true);
			MoreblocksModVariables.MapVariables.get(world).syncData(world);
		} else if ((((new Object() {
			public String getText() {
				GuiTextField textField = (GuiTextField) guistate.get("text:Spawn_foxes");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())).equals("false"))) {
			MoreblocksModVariables.MapVariables.get(world).Foxes_Normal_Spawn = (boolean) (false);
			MoreblocksModVariables.MapVariables.get(world).syncData(world);
		} else {
			if (entity instanceof EntityPlayer && !entity.world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("<MoreBlocks> Error In Text Field Try false or true"), (false));
			}
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).closeScreen();
		}
	}
}
