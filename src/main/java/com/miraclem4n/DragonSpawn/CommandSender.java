package com.miraclem4n.dragonspawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public class CommandSender implements CommandExecutor {
    DragonSpawn plugin;
    
    public CommandSender(DragonSpawn plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand (org.bukkit.command.CommandSender sender, Command command, String label, String[] args) {
        String cmd = command.getName();

        if (cmd.equals("dragonspawn")) {
            if (args.length >= 1)
                if (args[0].equals("reload")) {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;

                        if (!(player.hasPermission("dragonspawn.reload"))) {
                            player.sendMessage(plugin.getAPI().addColour("&4[" + plugin.pdfFile.getName() + "] You dont have Permissions to do this."));
                            return true;
                        }
                    }

                    plugin.configReload();
                    sender.sendMessage(plugin.getAPI().addColour("&4[" + plugin.pdfFile.getName() + "] Config reloaded."));

                    return true;
                }

        }

        return false;
    }
}
