package cortex.cortexaio.Utils;

import org.bukkit.ChatColor;

public class ColorUtil {

    //Simple way of getting an easy to implement method of '&' Color codes
    public static String Color(String string){
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    //Old Method of getting color ignore!
    public static String SetColor(String string){
        if(string.equalsIgnoreCase("RED"))
            return ChatColor.RED.toString();
        if(string.equalsIgnoreCase("GOLD"))
            return ChatColor.GOLD.toString();

        return "NULL";
    }
}
