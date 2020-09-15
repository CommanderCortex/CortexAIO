package cortex.cortexaio;

import cortex.cortexaio.Commands.GeneralCommands.ClearChatCommand;
import cortex.cortexaio.Commands.GeneralCommands.GamemodeCommand;
import cortex.cortexaio.Commands.RankCommands.SetRankCommand;
import cortex.cortexaio.Global.Files.MainDIRSetup;
import cortex.cortexaio.Global.PlayerEvents.OnChatEvent;
import cortex.cortexaio.Global.PlayerEvents.OnJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class CortexAIO extends JavaPlugin {

    @Override
    public void onEnable() {
        MainDIRSetup.SETUP(true);
        registerEvents();
        registerCommands();
    }
    public void registerEvents(){
        Bukkit.getPluginManager().registerEvents(new OnJoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new OnChatEvent(), this);
    }
    public void registerCommands(){
        Objects.requireNonNull(Bukkit.getServer().getPluginCommand("rank")).setExecutor(new SetRankCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("clearchat")).setExecutor(new ClearChatCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("gm")).setExecutor(new GamemodeCommand());
    }
}
