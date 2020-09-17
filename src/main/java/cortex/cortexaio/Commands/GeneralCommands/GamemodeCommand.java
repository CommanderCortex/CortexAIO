package cortex.cortexaio.Commands.GeneralCommands;

import cortex.cortexaio.Global.Messages.ErrorMessages;
import cortex.cortexaio.Global.Messages.PluginPrefix;
import cortex.cortexaio.PermissionsSystem.RankManager;
import cortex.cortexaio.Utils.ColorUtil;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    final RankManager rankManager = new RankManager();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            sender.sendMessage("Player Command Only!");

        assert sender instanceof Player;
        Player player = (Player) sender;
        int rank = rankManager.getPlayerRank(player);
        String updated = PluginPrefix.PLUGINPREFIX+ "&aYour gamemode has been updated!";

        if(rank >=6){
            if(player.getGameMode().equals(GameMode.SURVIVAL)){
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ColorUtil.Color(updated));
            }else{
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(ColorUtil.Color(updated));
            }
        }else{
            player.sendMessage(ColorUtil.Color(ErrorMessages.PERMSMESSAGE));
        }
        return false;
    }
}
