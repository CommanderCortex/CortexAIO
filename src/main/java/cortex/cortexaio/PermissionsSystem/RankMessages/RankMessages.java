package cortex.cortexaio.PermissionsSystem.RankMessages;

import cortex.cortexaio.Global.Messages.PluginPrefix;
import cortex.cortexaio.PermissionsSystem.RankManager;
import cortex.cortexaio.Utils.ColorUtil;
import org.bukkit.entity.Player;

public class RankMessages {
    static RankManager rankManager = new RankManager();
    public static void Message(String message, Player player){
        player.sendMessage(ColorUtil.Color(message));
    }
    public static void updatedRank(Player player){
        int rank = rankManager.getPlayerRank(player);
        String rankPrefix = rankManager.getRankPrefix(rank);
        Message(PluginPrefix.PLUGINPREFIX +"&bRank Updated to " + rankPrefix, player);
    }
}
