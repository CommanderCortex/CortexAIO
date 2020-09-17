package cortex.cortexaio.BanSystem.BanEvents;

import cortex.cortexaio.BanSystem.BanUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnTempBannedPlayerJoin implements Listener {

    BanUtils banUtils = new BanUtils();

    public void onTempBanJoin(PlayerJoinEvent joinEvent){
        Player player = joinEvent.getPlayer();

        if(banUtils.isBanned(player)){
            if(banUtils.getBanMillis(player) <= System.currentTimeMillis()){
                banUtils.unban(player);
            }else{
                banUtils.sendBanScreen(player);
            }
        }
    }

}
