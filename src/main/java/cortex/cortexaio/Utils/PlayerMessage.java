package cortex.cortexaio.Utils;

import cortex.cortexaio.Global.Messages.ErrorMessages;
import cortex.cortexaio.Global.Messages.PluginPrefix;
import org.bukkit.entity.Player;

public class PlayerMessage {
    public static void message(Player player, String message){
        player.sendMessage(ColorUtil.Color(message));
    }
    public static void NOPERMSMSG(Player player){
        message(player, ErrorMessages.PERMSMESSAGE);
    }
    public static void NOPLAYERMSG(Player player, Player target){
        message(player, ErrorMessages.PLAYERNOTFOUND + target);
    }
    public static String KICKMSG(String KickMessage){
        return PluginPrefix.PLUGINPREFIX + ColorUtil.Color(KickMessage);
    }
}
