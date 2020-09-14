package cortex.cortexaio.Commands.GeneralCommands;

import cortex.cortexaio.Global.Messages.ErrorMessages;
import cortex.cortexaio.Global.Messages.PluginPrefix;
import cortex.cortexaio.PermissionsSystem.RankManager;
import cortex.cortexaio.Utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCommand implements CommandExecutor {

    RankManager rankManager = new RankManager();

    public void clearChat(){
        for(int i = 0; i<150; i++){
            Bukkit.broadcastMessage("");
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            clearChat();
            sender.sendMessage("Chat Cleared!");
        }
        assert sender instanceof Player;
        Player player = (Player) sender;
        int rank = rankManager.getPlayerRank(player);
        if(rank >= 6){
            clearChat();
            player.sendMessage(ColorUtil.Color(PluginPrefix.PLUGINPREFIX+"&bChat Cleared!"));
        }else {
            player.sendMessage(ColorUtil.Color(ErrorMessages.PERMSMESSAGE));
        }
        return false;
    }
}
