package cortex.cortexaio.BossBar;

import cortex.cortexaio.Utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.List;

public class BossBarMAIN {

    private void addPlayers(){
        for(Player player : Bukkit.getOnlinePlayers()){
            bossBar.setProgress(100);
            bossBar.setVisible(true);
            bossBar.setStyle(BarStyle.SOLID);
            bossBar.addFlag(BarFlag.PLAY_BOSS_MUSIC);
            bossBar.addPlayer(player);
        }
    }


    final BossBar bossBar = new BossBar() {
        @Override
        public String getTitle() {
            return null;
        }

        @Override
        public void setTitle(String title) {

        }

        @Override
        public BarColor getColor() {
            return null;
        }

        @Override
        public void setColor(BarColor color) {

        }

        @Override
        public BarStyle getStyle() {
            return null;
        }

        @Override
        public void setStyle(BarStyle style) {

        }

        @Override
        public void removeFlag(BarFlag flag) {

        }

        @Override
        public void addFlag(BarFlag flag) {

        }

        @Override
        public boolean hasFlag(BarFlag flag) {
            return false;
        }

        @Override
        public void setProgress(double progress) {

        }

        @Override
        public double getProgress() {
            return 0;
        }

        @Override
        public void addPlayer(Player player) {

        }

        @Override
        public void removePlayer(Player player) {

        }

        @Override
        public void removeAll() {

        }

        @Override
        public List<Player> getPlayers() {
            return null;
        }

        @Override
        public void setVisible(boolean visible) {

        }

        @Override
        public boolean isVisible() {
            return false;
        }

        @Override
        public void show() {

        }

        @Override
        public void hide() {

        }
    };


    public String Color(String s){
        return ColorUtil.Color(s);
    }
}
