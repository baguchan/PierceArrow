package baguchan.piercearrow.client.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LivingArrowLayer <T extends LivingEntity, M extends EntityModel<T>> extends LivingStuckInBodyLayer<T, M> {
	private final EntityRendererManager dispatcher;

	public LivingArrowLayer(LivingRenderer<T, M> p_174466_) {
		super(p_174466_);
		this.dispatcher = p_174466_.getDispatcher();
	}

	protected int numStuck(T p_116567_) {
		return p_116567_.getArrowCount();
	}

	protected void renderStuckItem(MatrixStack p_116569_, IRenderTypeBuffer p_116570_, int p_116571_, Entity p_116572_, float p_116573_, float p_116574_, float p_116575_, float p_116576_) {
		float f = MathHelper.sqrt(p_116573_ * p_116573_ + p_116575_ * p_116575_);
		ArrowEntity arrow = new ArrowEntity(p_116572_.level, p_116572_.getX(), p_116572_.getY(), p_116572_.getZ());
		arrow.yRot = ((float) (Math.atan2((double) p_116573_, (double) p_116575_) * (double) (180F / (float) Math.PI)));
		arrow.xRot = ((float) (Math.atan2((double) p_116574_, (double) f) * (double) (180F / (float) Math.PI)));
		arrow.yRotO = arrow.yRot;
		arrow.xRotO = arrow.xRot;
		this.dispatcher.render(arrow, 0.0D, 0.0D, 0.0D, 0.0F, p_116576_, p_116569_, p_116570_, p_116571_);
	}
}