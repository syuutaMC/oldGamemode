package syuuta.test;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(new PlayerCommands(), this);
    }

    @Override
    public void onDisable(){

    }
}