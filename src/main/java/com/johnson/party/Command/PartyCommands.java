package com.johnson.party.Command;

import com.johnson.party.dataManager.TeamManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PartyCommands implements CommandExecutor {
    TeamManager teamManager = new TeamManager();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ( sender instanceof Player){
            Player player = (Player) sender;

            if (args.length == 0 ){
                return true;
            }
            else if ( args.length == 2 && args[0].equalsIgnoreCase("create")){
                String name = args[1];
                teamManager.create(player, name);
            }
            else if ( args.length == 1 && args[0].equalsIgnoreCase("list")){
                teamManager.showTeam(player);
            }
            else if ( args.length == 1 && args[0].equalsIgnoreCase("leave")){

            }
            else if ( args.length == 2 && args[0].equalsIgnoreCase("join")){
                String name = args[1];

            }
        }
        return true;
    }
}
