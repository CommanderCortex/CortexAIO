package cortex.cortexaio.Global.PlayerEvents;

import cortex.cortexaio.Global.PlayerHandlers.PlayerManager;
import cortex.cortexaio.PermissionsSystem.RankManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoinEvent implements Listener {
    RankManager rankManager = new RankManager();
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent playerJoinEvent){
        Player player = playerJoinEvent.getPlayer();
        PlayerManager.setupPlayer(player);
        rankManager.RankPrefixForTab();
    }
}
