package cortex.cortexaio.Utils;

import cortex.cortexaio.PermissionsSystem.RankManager;
import org.bukkit.entity.Player;

public class CheckForStaffPerms {
    private static RankManager rankManager;
    public static boolean STAFFPERMS(Player player){
        int rank = rankManager.getPlayerRank(player);
        return rank >= 6;
    }
}
