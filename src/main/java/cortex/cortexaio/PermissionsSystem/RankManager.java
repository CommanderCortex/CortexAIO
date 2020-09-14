package cortex.cortexaio.PermissionsSystem;

import cortex.cortexaio.Global.Strings.PathStrings;
import cortex.cortexaio.Utils.ColorUtil;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class RankManager extends Ranks{ //Using yml files to simplify the process

    //Get the players set rank from <UUID>.yml
    public int getPlayerRank(Player player){
        String PlayerFile = PathStrings.getPlayerFile(player);
        File PlayerRank = new File(PlayerFile);
        YamlConfiguration PlayerYAMLFile = YamlConfiguration.loadConfiguration(PlayerRank);
        return PlayerYAMLFile.getInt("Rank");
    }
    //Set the players rank via an int in <UUID>.yml
    public void setPlayerRank(Player player, int rank){
        String PlayerFile = PathStrings.getPlayerFile(player);
        File PlayerRank = new File(PlayerFile);
        YamlConfiguration PlayerYAMLFile = YamlConfiguration.loadConfiguration(PlayerRank);
        PlayerYAMLFile.set("Rank", rank);
        try { PlayerYAMLFile.save(PlayerRank); } catch (IOException e) { e.printStackTrace(); }
    }
    //Getting a rank value as int then returning a string in the form of a Prefix
    public String getRankPrefix(int rank){
        if(rank == DEVELOPER)
            return Color("&4&lDEV &r");
        if(rank == ADMIN)
            return Color("&4&lADMIN &r");
        return "";
    }


    //Implementing Color Util to make getting Color(<string>) easy
    String Color(String string){
        return ColorUtil.Color(string);
    }
}
