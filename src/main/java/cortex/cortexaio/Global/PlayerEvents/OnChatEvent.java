package cortex.cortexaio.Global.PlayerEvents;

import cortex.cortexaio.PermissionsSystem.RankManager;
import cortex.cortexaio.Utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class OnChatEvent implements Listener {
    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent playerChatEvent){
        RankManager rankManager = new RankManager();
        playerChatEvent.setCancelled(true);
        Player player = playerChatEvent.getPlayer();
        String PlayerMessage = playerChatEvent.getMessage();
        String DisplayName = player.getDisplayName();
        String Prefix = rankManager.getRankPrefix(rankManager.getPlayerRank(player));
        Bukkit.broadcastMessage(ColorUtil.Color(Prefix + " " + DisplayName + " &a>>&r " + PlayerMessage));
    }
}
