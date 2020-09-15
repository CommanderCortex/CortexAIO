package cortex.cortexaio.Commands.GeneralCommands;

import cortex.cortexaio.Utils.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            ConsoleMessage.instanceOfConsole(sender);

        assert sender instanceof Player;
        Player player = (Player) sender;

        Player target = Bukkit.getPlayer(args[0]);
        assert target != null;

        if(CheckForStaffPerms.STAFFPERMS(player)){
            if(CheckForPlayer.PLAYERTRUE(target)){
                target.kickPlayer(PlayerMessage.KICKMSG("Kicked by console!"));
            }else{
                PlayerMessage.NOPLAYERMSG(player, target); }
        }else{
            PlayerMessage.NOPERMSMSG(player); }
        return false;
    }
}