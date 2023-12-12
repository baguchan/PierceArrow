package baguchan.piercearrow;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PierceArrow.MODID)
public class PierceArrow
{
    public static final String MODID = "piercearrow";

    public PierceArrow() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }
}
