package baguchan.piercearrow.mixin.client;

import baguchan.piercearrow.api.IRandomModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.RandomSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(HierarchicalModel.class)
public abstract class HierarchicalModelMixin implements IRandomModelPart {
	private List<ModelPart> parts;

	public ModelPart getRandomModelPart(RandomSource p_103407_) {
		if (this.parts == null) {
			this.parts = this.root().getAllParts().filter((p_170824_) -> {
				return !p_170824_.isEmpty();
			}).collect(ImmutableList.toImmutableList());
		}

		return this.parts.get(p_103407_.nextInt(this.parts.size()));
	}

	@Shadow
	public abstract ModelPart root();
}
