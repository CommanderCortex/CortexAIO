package cortex.cortexaio.Commands;

import cortex.cortexaio.Utils.CheckForPlayer;
import cortex.cortexaio.Utils.CheckForStaffPerms;
import cortex.cortexaio.Utils.ConsoleMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CortexBaseCommand {

    public CommandSender sender;
    public Player player;

    public void Console(Boolean check){
        if(check){
            if((!(sender instanceof Player))){
                ConsoleMessage.instanceOfConsole(sender);
            }
        }else{
            assert sender instanceof Player;
            Player player = (Player) sender;
        }
    }
    public void PermsPass(Player player){
        CheckForStaffPerms.STAFFPERMS(player);
    }
    public boolean args(String[] args){
        if(args != null){
            return true;
        }
        return false;
    }
    public String target(Player args){
        Player target = Bukkit.getPlayerExact(String.valueOf(args));
        CheckForPlayer.PLAYERTRUE(target);
        return String.valueOf(true);
    }
}
