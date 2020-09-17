package cortex.cortexaio.Commands.BanCommands;

import cortex.cortexaio.Utils.CheckForPlayer;
import cortex.cortexaio.Utils.CheckForStaffPerms;
import cortex.cortexaio.Utils.ConsoleMessage;
import cortex.cortexaio.Utils.PlayerMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PermBanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            ConsoleMessage.instanceOfConsole(sender);

        assert sender instanceof Player;
        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);

        if(CheckForStaffPerms.STAFFPERMS(player)){
            if(CheckForPlayer.PLAYERTRUE(target)){


            }else{
                PlayerMessage.NOPLAYERMSG(player, target);
            }
        }else{
            PlayerMessage.NOPERMSMSG(player);
        }

        return false;
    }
}
