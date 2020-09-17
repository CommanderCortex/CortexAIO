package cortex.cortexaio.Commands.RankCommands;

import cortex.cortexaio.Commands.CortexBaseCommand;
import cortex.cortexaio.PermissionsSystem.RankManager;
import cortex.cortexaio.PermissionsSystem.RankMessages.RankMessages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class CortexSetRankCommand extends CortexBaseCommand implements CommandExecutor {
    RankManager rankManager = new RankManager();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Console(true);
        PermsPass(player);
        if(args(args)) {
            Player target = Bukkit.getPlayerExact(target(Objects.requireNonNull(Bukkit.getPlayer(args[0]))));
            switch (args[1]) {
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
            RankMessages.updatedRank(player);
        }
        return false;
    }
}
