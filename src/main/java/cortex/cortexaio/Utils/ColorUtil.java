package cortex.cortexaio.Utils;

import org.bukkit.ChatColor;

public class ColorUtil {

    //Simple way of getting an easy to implement method of '&' Color codes
    public static String Color(String string){
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
