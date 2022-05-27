package baguchan.piercearrow.api;

import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.client.renderer.model.ModelRenderer;

import java.util.List;

public interface ICubes {
	ObjectList<ModelRenderer.ModelBox> getCubes();

	List<ModelRenderer> getAllParts();

	boolean isEmpty();
}
