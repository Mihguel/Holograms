package com.sainttx.holograms.commands;

import com.sainttx.holograms.HologramPlugin;
import com.sainttx.holograms.util.TextUtil;
import com.sainttx.holograms.internal.HologramImpl;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Matthew on 14/03/2015.
 */
public class CommandDelete implements CommandExecutor {

    private HologramPlugin plugin;

    public CommandDelete(HologramPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) {
            sender.sendMessage(ChatColor.RED + "Usage: /hologram delete <name>");
        } else {
            String hologramName = args[1];
            HologramImpl hologram = plugin.getHologramManager().getHologramByName(hologramName);

            if (hologram == null) {
                sender.sendMessage(ChatColor.RED + "Couldn't find a hologram with name \"" + hologramName + "\".");
            } else {
                hologram.remove();
                sender.sendMessage(TextUtil.color("&7Deleted hologram &f\"" + hologram.getName() + "\"&7."));
            }
        }

        return true;
    }
}