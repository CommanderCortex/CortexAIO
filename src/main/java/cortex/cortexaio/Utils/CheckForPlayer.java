package cortex.cortexaio.Utils;

import org.bukkit.entity.Player;

public class CheckForPlayer {
    public static boolean PLAYERTRUE(Player target){
        return target == null || !target.isOnline();
    }
}
