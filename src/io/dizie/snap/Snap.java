package io.dizie.snap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Snap implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("snap")) {
            int playerCount = Bukkit.getOnlinePlayers().size();
            if (playerCount >= 2) {
                if (!(sender instanceof Player)) {
                    Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "console has summoned Thanos");
                    snapPlayers();
                    return true;
                }
                Player player = (Player) sender;
                if (player.hasPermission("snap.use")) {
                    Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + player.getName() + " has summoned Thanos");
                    snapPlayers();
                    return true;
                }

            }
            sender.sendMessage(ChatColor.RED + "There are not enough players online!");
        }
        return false;
    }

    public void snapPlayers() {
        String[] quotes = {
                "The hardest choices require the strongest wills.",
                "Perfectly balanced, as all things should be.",
                "You should have gone for the head.",
                "Fine. I'll do it myself.",
                "The universe required correction.",
                "The end is near.",
                "Your optimism is misplaced, Asgardian.",
                "I AM...INEVITABLE."
        };
        String quote = (quotes[new Random().nextInt(quotes.length)]);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Bukkit.broadcastMessage(ChatColor.YELLOW + "Thanos joined the game");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Bukkit.broadcastMessage("<Thanos> " + quote);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "*SNAP*");
        int playerCount = Bukkit.getOnlinePlayers().size();
        int snapCount;
        if (playerCount % 2 == 0) {
            snapCount = playerCount - 1 / 2;
        } else {
            snapCount = playerCount / 2;
        }
        int x = 1;
        ArrayList<Player> playerList = new ArrayList<Player>(Bukkit.getOnlinePlayers());
        while (x < snapCount) {
            int idx = new Random().nextInt(playerList.size());
            String toSnap = playerList.get(idx).getName();
            Player player = (Player) Bukkit.getPlayer(toSnap);
            player.chat("I don't feel so good...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            player.damage(100);
            x++;
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Bukkit.broadcastMessage(ChatColor.YELLOW + "Thanos left the game");
    }

}
