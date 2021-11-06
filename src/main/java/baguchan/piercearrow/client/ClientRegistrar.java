package baguchan.piercearrow.client;

import baguchan.piercearrow.PierceArrow;
import baguchan.piercearrow.client.layer.LivingArrowLayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ArrowLayer;
import net.minecraft.client.renderer.entity.layers.BeeStingerLayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

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