package cortex.cortexaio.Global.Files;

import cortex.cortexaio.Global.Strings.PathStrings;
import org.bukkit.Bukkit;

import java.io.File;

public class MainDIRSetup {

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void MAINDIRSETUP(){
        File __MAINDIR = new File(PathStrings.MAINDIR);
        if(!__MAINDIR.exists()) {
            __MAINDIR.mkdirs();
        }
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void PLAYERDIRSETUP(){
        File __PLAYERDIR = new File(PathStrings.PLAYERDIR);
        if(!__PLAYERDIR.exists()){
            __PLAYERDIR.mkdirs();
        }
    }

    public static void SETUP(boolean SetupValue){
        if(SetupValue) {
            MAINDIRSETUP();
            PLAYERDIRSETUP();
        }else{
            Bukkit.broadcastMessage("DIR Setup Has Been Disabled! Skipping DIR Setup");
        }
    }
}
