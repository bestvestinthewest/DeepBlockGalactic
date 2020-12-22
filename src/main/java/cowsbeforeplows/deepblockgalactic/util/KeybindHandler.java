package cowsbeforeplows.deepblockgalactic.util;

import org.lwjgl.glfw.GLFW;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import cowsbeforeplows.deepblockgalactic.init.ItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeybindHandler {

	private static KeyBinding throwFlare;
	
	public static void onClientSetup() {
		throwFlare = new KeyBinding("keybind.deepblockgalactic.throwflare", GLFW.GLFW_KEY_G, DeepBlockGalactic.MOD_ID);
		ClientRegistry.registerKeyBinding(throwFlare);
	}
	
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		PlayerEntity player = Minecraft.getInstance().player;
		
		if (player == null) {
			return;
		}
		
		ItemStack flare = new ItemStack(ItemInit.FLARE.get());
		
		if (player.inventory.hasItemStack(flare)) {
			if (throwFlare.isPressed()) {
				DeepBlockGalactic.LOGGER.debug("FLARE THROWN");
			}
		}
	}
	
}
