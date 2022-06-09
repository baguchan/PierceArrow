package baguchan.piercearrow.mixin.client;

import baguchan.piercearrow.api.IRandomModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.RandomSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(QuadrupedModel.class)
public class QuadrupedModelMixin implements IRandomModelPart {

	private List<ModelPart> parts;

	@Inject(method = "<init>", at = @At("TAIL"))
	public void onConstructor(ModelPart p_170857_, boolean p_170858_, float p_170859_, float p_170860_, float p_170861_, float p_170862_, int p_170863_, CallbackInfo callbackInfo) {
		this.parts = p_170857_.getAllParts().filter((p_170824_) -> {
			return !p_170824_.isEmpty();
		}).collect(ImmutableList.toImmutableList());
	}

	public ModelPart getRandomModelPart(RandomSource p_103407_) {
		return this.parts.get(p_103407_.nextInt(this.parts.size()));
	}
}
