package cortex.cortexaio.Commands.RankCommands;

import cortex.cortexaio.Global.Messages.ErrorMessages;
import cortex.cortexaio.PermissionsSystem.RankManager;
import cortex.cortexaio.Utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetRankCommand implements CommandExecutor {

    RankManager rankManager = new RankManager();

    public String __GETRANKPREFIX(Player player){
        return rankManager.getRankPrefix(rankManager.getPlayerRank(player));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            sender.sendMessage("Player Command Only!");

        assert sender instanceof Player;
        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);

        int rank = rankManager.getPlayerRank(player);

        if(rank >= 9){
            if(target != null && target.isOnline()){
                String newPrefix = __GETRANKPREFIX(player);
                switch (args[1]){
                    case "DEVELOPER":
                        rankManager.setPlayerRank(target, rankManager.DEVELOPER);
                        break;
                    case "ADMIN":
                        rankManager.setPlayerRank(target, rankManager.ADMIN);
                        break;
                    case "SNRMODERATOR":
                        rankManager.setPlayerRank(target, rankManager.SNR_MODERATOR);
                        break;
                    case "MODERATOR":
                        rankManager.setPlayerRank(target, rankManager.MODERATOR);
                        break;
                    case "TRAINEE":
                        rankManager.setPlayerRank(target, rankManager.TRAINIEE);
                        break;
                    default:
                        rankManager.setPlayerRank(target, rankManager.NULL);
                }
                rankManager.RankPrefixForTab();
                player.sendMessage(Color("Rank Updated to: "+newPrefix));
            }else{
                assert target != null;
                player.sendMessage(ErrorMessages.PLAYERNOTFOUND + target.getName());
            }
        }else{
            player.sendMessage(ErrorMessages.PERMSMESSAGE);
        }
        return true;
    }
    //Implementing Color Util to make getting Color(<string>) easy
    String Color(String string){
        return ColorUtil.Color(string);
    }
}
