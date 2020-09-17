package cortex.cortexaio.BanSystem.BanMessages;


import cortex.cortexaio.Global.Messages.PluginPrefix;
import cortex.cortexaio.Utils.ColorUtil;
import org.bukkit.entity.Player;

public class BanMessages {

    public static String alreadyBanned = PluginPrefix.PLUGINPREFIX + "&cPlayer Already Banned!";
    public static String banUsageMSG = PluginPrefix.PLUGINPREFIX + "&aUsage : &b/tempban player <time> <reason>";

    public static void Message(String message, Player player){
        player.sendMessage(ColorUtil.Color(message));
    }

    public static void AlreadyBanned(Player player) {
         Message(alreadyBanned, player);
    }
    public static void BanUsageMSG(Player player){
        Message(banUsageMSG, player);
    }


}
