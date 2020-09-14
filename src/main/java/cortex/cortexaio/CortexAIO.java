package cortex.cortexaio;

import cortex.cortexaio.Global.Files.MainDIRSetup;
import org.bukkit.plugin.java.JavaPlugin;

public final class CortexAIO extends JavaPlugin {

    @Override
    public void onEnable() {
        MainDIRSetup.SETUP(true);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
