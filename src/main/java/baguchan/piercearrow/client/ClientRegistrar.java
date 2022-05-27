package baguchan.piercearrow.client;

import baguchan.piercearrow.client.layer.LivingArrowLayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.BeeStingerLayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

@OnlyIn(Dist.CLIENT)
public class ClientRegistrar {

	public static void loadComplete(FMLLoadCompleteEvent evt) {
		Minecraft.getInstance().getEntityRenderDispatcher().renderers.values().forEach(r -> {
			if (r instanceof LivingRenderer) {
				((LivingRenderer) r).addLayer(new LivingArrowLayer(((LivingRenderer) r)));
				((LivingRenderer) r).addLayer(new BeeStingerLayer(((LivingRenderer) r)));
			}
		});
	}
}