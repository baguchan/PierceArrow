package baguchan.piercearrow.mixin.client;

import baguchan.piercearrow.api.ICubes;
import com.google.common.collect.ImmutableList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.client.renderer.model.ModelRenderer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(ModelRenderer.class)
public class ModelRendererMixin implements ICubes {
	@Shadow(remap = false)
	@Final
	private ObjectList<ModelRenderer.ModelBox> cubes;
	@Shadow(remap = false)
	@Final
	private ObjectList<ModelRenderer> children;

	public ObjectList<ModelRenderer.ModelBox> getCubes() {
		return cubes;
	}

	public List<ModelRenderer> getAllParts() {
		return this.children.stream().filter((p_170824_) -> {
			return !((ICubes) p_170824_).isEmpty();
		}).collect(ImmutableList.toImmutableList());
	}

	public boolean isEmpty() {
		return this.cubes.isEmpty();
	}
}
