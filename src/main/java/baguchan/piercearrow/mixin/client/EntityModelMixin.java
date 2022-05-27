package baguchan.piercearrow.mixin.client;

import baguchan.piercearrow.api.ICubes;
import baguchan.piercearrow.api.IRandomModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

@Mixin(EntityModel.class)
public abstract class EntityModelMixin extends Model implements IRandomModelPart {
	private List<ModelRenderer> cubes;

	public EntityModelMixin(Function<ResourceLocation, RenderType> p_i225947_1_) {
		super(p_i225947_1_);
	}

	public void accept(ModelRenderer p_accept_1_) {
		this.cubes = ((ICubes) p_accept_1_).getAllParts();
	}

	public ModelRenderer getRandomModelPart(Random p_228288_1_) {
		if (!cubes.isEmpty() && this.cubes.size() > 0) {
			return this.cubes.get(p_228288_1_.nextInt(this.cubes.size()));
		}
		return null;
	}
}
