package syuuta.test;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommands implements Listener {

    @EventHandler
    public void SendCommands(PlayerCommandPreprocessEvent e){
        Player player = e.getPlayer();
        String msg = e.getMessage();
        if(msg.matches(".*/gamemode.*")){
            e.setCancelled(true);
            if(player.isOp()){
                if(msg.matches(".*0.*")) {
                    //gamemode 0
                    player.setGameMode(GameMode.SURVIVAL);
                    sendMsg(player);
                }else if(msg.matches(".*1.*")){
                    //gamemode 1
                    player.setGameMode(GameMode.CREATIVE);
                    sendMsg(player);
                }else if(msg.matches(".*2.*")){
                    //gamemode 2
                    player.setGameMode(GameMode.ADVENTURE);
                    sendMsg(player);
                }else if(msg.matches(".*3.*")){
                    //gamemode 3
                    player.setGameMode(GameMode.SPECTATOR);
                    sendMsg(player);
                }else{
                    player.sendMessage("値が無効です");
                }
            }else{
                player.sendMessage("権限がないため使えません");
            }
        }
    }

    public void sendMsg(Player player){
        player.sendMessage("ゲームモードを" + String.valueOf(player.getGameMode()) + "に変更しました");
    }
}
