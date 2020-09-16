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

public class BanUtils {

    private static YamlConfiguration BanYmlFile;
    private Plugin plugin;
    private File __BanFile;

    public void setupBanFile(Plugin plugin){
        this.plugin = plugin;
        String BanFile = PathStrings.BANDIR;
        File __BanFile = new File(BanFile + "BanList.yml");
        if(!__BanFile.exists()){ try { __BanFile.createNewFile(); } catch (IOException e) { e.printStackTrace(); } }
        BanYmlFile = YamlConfiguration.loadConfiguration(__BanFile);
    }
    public void ban(String UUID, String Reason, long seconds){
        if(isBanned(UUID)){
            return;
        }
        long time = 0;
        long current = System.currentTimeMillis();
        long millis = seconds*1000;
        time = current + millis;

        if(seconds == -1){
            time = -1;
        }

        BanYmlFile.set("Bans." + UUID + ".time", time);
        BanYmlFile.set("Bans." + UUID + ".reason", Reason);

        saveFile();
    }

    public void sendBanScreen(Player player){
        player.kickPlayer(ColorUtil.Color("&cYou Have been banned!\n\n" +
                "&7Reason: &c" + getReason(player.getUniqueId().toString()) + "\n\n"+
                "&7Unban Date: &c" + getUnbanDate(player.getUniqueId().toString())));
    }
    public String getReason(String UUID){
        return BanYmlFile.getString("Bans." + UUID + ".reason");
    }

    public String getUnbanDate(String UUID){
        long time = BanYmlFile.getLong("Bans." + UUID + ".time");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("New Zealand"));
        Date date = new Date(time);
        return dateFormat.format(date);
    }

    public boolean isBanned(String UUID){
        return BanYmlFile.get("Bans." + UUID + ".reason") != null;
    }

    public long getBanMillis(String UUID) {
        return BanYmlFile.getLong("Bans." + UUID + ".time");
    }

    public void saveFile(){ try { BanYmlFile.save(__BanFile); } catch (IOException e) { e.printStackTrace(); } }
}
