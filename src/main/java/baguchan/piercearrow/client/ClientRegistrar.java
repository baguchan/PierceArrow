package baguchan.piercearrow.client;

import baguchan.piercearrow.PierceArrow;
import baguchan.piercearrow.client.layer.LivingArrowLayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.BeeStingerLayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = PierceArrow.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegistrar {

	@SubscribeEvent
	public static void registerEntityRenders(EntityRenderersEvent.AddLayers event) {
		Minecraft.getInstance().getEntityRenderDispatcher().renderers.values().forEach(r -> {
			if (r instanceof LivingEntityRenderer) {
				((LivingEntityRenderer) r).addLayer(new LivingArrowLayer(Minecraft.getInstance().getEntityRenderDispatcher(), ((LivingEntityRenderer) r)));
				((LivingEntityRenderer) r).addLayer(new BeeStingerLayer(((LivingEntityRenderer) r)));
			}
		});
	}
}