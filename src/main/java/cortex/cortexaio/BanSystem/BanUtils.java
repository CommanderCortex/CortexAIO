package cortex.cortexaio.BanSystem;

import cortex.cortexaio.Global.Strings.PathStrings;
import cortex.cortexaio.Utils.ColorUtil;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

@SuppressWarnings("ALL")
public class BanUtils {

    private static YamlConfiguration BanYmlFile;
    private Plugin plugin;
    private File __BanFile;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void setupBanFile(Plugin plugin){
        this.plugin = plugin;
        String BanFile = PathStrings.BANDIR;
        File __BanFile = new File(BanFile + "BanList.yml");
        if(!__BanFile.exists()){ try { __BanFile.createNewFile(); } catch (IOException e) { e.printStackTrace(); } }
        BanYmlFile = YamlConfiguration.loadConfiguration(__BanFile);
    }
    public void ban(Player player, String Reason, long seconds){
        if(isBanned(player)){
            return;
        }
        long time = 0;
        long current = System.currentTimeMillis();
        long millis = seconds*1000;
        time = current + millis;

        if(seconds == -1){
            time = -1;
        }

        BanYmlFile.set("Bans." + player + ".time", time);
        BanYmlFile.set("Bans." + player + ".reason", Reason);

        saveFile();
    }

    public void unban(Player player){
        BanYmlFile.set("Bans."+player+".time", null);
        BanYmlFile.set("Bans." + player + ".reason", null);
    }

    public void sendBanScreen(Player player){
        player.kickPlayer(ColorUtil.Color("&cYou Have been banned!\n\n" +
                "&7Reason: &c" + getReason(player) + "\n\n"+
                "&7Unban Date: &c" + getUnbanDate(player)));
    }
    public String getReason(Player player){
        return BanYmlFile.getString("Bans." + player + ".reason");
    }

    public String getUnbanDate(Player player){
        long time = BanYmlFile.getLong("Bans." + player + ".time");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("New Zealand"));
        Date date = new Date(time);
        return dateFormat.format(date);
    }

    public boolean isBanned(Player player){
        return BanYmlFile.get("Bans." + player + ".reason") != null;
    }

    public long getBanMillis(Player player) {
        return BanYmlFile.getLong("Bans." + player + ".time");
    }

    public void saveFile(){ try { BanYmlFile.save(__BanFile); } catch (IOException e) { e.printStackTrace(); } }
}
