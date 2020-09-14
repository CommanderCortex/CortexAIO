package cortex.cortexaio.Global.PlayerHandlers;

import cortex.cortexaio.Global.Strings.PathStrings;
import cortex.cortexaio.PermissionsSystem.Ranks;
import cortex.cortexaio.Utils.ColorUtil;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerManager {

    static Ranks ranks = new Ranks();

    //Setup the player file
    public static void setupPlayer(Player player){
        String PlayerFile = PathStrings.getPlayerFile(player);
        File __PlayerFile = new File(PlayerFile);
        //Check to see if File exists, if not create la player file
        if(!__PlayerFile.exists()) { try { __PlayerFile.createNewFile(); } catch (IOException e) { e.printStackTrace(); } }
        YamlConfiguration playerConfig = YamlConfiguration.loadConfiguration(__PlayerFile);
        playerConfig.addDefault("Player", player.getName());
        playerConfig.addDefault("Rank", ranks.NULL);
        playerConfig.options().copyDefaults(true);
        try { playerConfig.save(__PlayerFile); } catch (IOException e) { e.printStackTrace(); }
        player.sendMessage(ColorUtil.Color("&aYour player file has been created / updated"));
    }

}
