package baguchan.piercearrow.api;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.RandomSource;

public interface IRandomModelPart {
	ModelPart getRandomModelPart(RandomSource paramRandom);
}
