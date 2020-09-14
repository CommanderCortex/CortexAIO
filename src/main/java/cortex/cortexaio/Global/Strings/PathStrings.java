package cortex.cortexaio.Global.Strings;

import org.bukkit.entity.Player;

public class PathStrings {
    public static String MAINDIR = "plugins/cortex/";
    public static String PLAYERDIR = "plugins/cortex/players/";
    public static String getPlayerFile(Player player){
        return PLAYERDIR + player.getUniqueId() + ".yml";
    }
}
