package cowsbeforeplows.deepblockgalactic.client.render;

import cowsbeforeplows.deepblockgalactic.DeepBlockGalactic;
import cowsbeforeplows.deepblockgalactic.entities.FlareBoltEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class FlareBoltRenderer extends ArrowRenderer<FlareBoltEntity>{

	public FlareBoltRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public ResourceLocation getEntityTexture(FlareBoltEntity entity) {
		Item item = entity.getArrowStack().getItem();
		return new ResourceLocation(DeepBlockGalactic.MOD_ID, "textures/entity/projectile/flare_bolt.png");
	}

}
