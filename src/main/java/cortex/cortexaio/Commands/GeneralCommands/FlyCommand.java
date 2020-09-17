package cortex.cortexaio.Commands.GeneralCommands;

import cortex.cortexaio.Global.Messages.ErrorMessages;
import cortex.cortexaio.Global.Messages.PluginPrefix;
import cortex.cortexaio.PermissionsSystem.RankManager;
import cortex.cortexaio.Utils.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    final RankManager rankManager = new RankManager();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            sender.sendMessage("This command is only for players!");

        assert sender instanceof Player;
        Player player = (Player) sender;
        int rank = rankManager.getPlayerRank(player);
        String fly = PluginPrefix.PLUGINPREFIX + "Flying mode updated!";

        if(rank >= 6){
            if(player.isFlying()){
                player.setFlying(false);
                player.sendMessage(ColorUtil.Color(fly));
            }else{
                player.setFlying(true);
                player.sendMessage(ColorUtil.Color(fly));
            }
        }else {
            player.sendMessage(ColorUtil.Color(ErrorMessages.PERMSMESSAGE));
        }
        return false;
    }
}
