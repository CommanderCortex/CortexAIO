package cortex.cortexaio.Global.Strings;

import org.bukkit.entity.Player;

public class PathStrings {
    public static final String MAINDIR = "plugins/cortex/";
    public static final String PLAYERDIR = "plugins/cortex/players/";
    public static final String BANDIR = "plugins/cortex/ban-list/";
    public static String getPlayerFile(Player player){
        return PLAYERDIR + player.getUniqueId() + ".yml";
    }
}
