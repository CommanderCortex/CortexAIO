package cortex.cortexaio.Commands.BanCommands;

import cortex.cortexaio.BanSystem.BanMessages.BanMessages;
import cortex.cortexaio.BanSystem.BanUtils;
import cortex.cortexaio.Utils.CheckForStaffPerms;
import cortex.cortexaio.Utils.ConsoleMessage;
import cortex.cortexaio.Utils.PlayerMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TempBanCommand implements CommandExecutor {
    BanUtils banUtils = new BanUtils();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            ConsoleMessage.instanceOfConsole(sender);

        assert sender instanceof Player;
        Player player = (Player) sender;

        if(CheckForStaffPerms.STAFFPERMS(player)){
            if(args.length >= 4){
                String playerName = args[0];

                if(!banUtils.isBanned(player)){

                }else{
                    BanMessages.AlreadyBanned(player);
                }
            }else{
                BanMessages.BanUsageMSG(player);
            }
        }else{
            PlayerMessage.NOPERMSMSG(player);
        }
        return false;
    }
}
