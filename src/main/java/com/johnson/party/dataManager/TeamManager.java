package com.johnson.party.dataManager;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TeamManager {
    List<TeamData> createTeam = new ArrayList<>();

    public class TeamData{
        String TeamName;
        Player Leader;
        Player meat1;
        Player meat2;
        Player meat3;
    }


    public void create(Player player, String name){
        if ( noTeam(player)){
            //沒有隊伍
            if ( CreateCheckName(name)){
                //隊伍名沒重複
                CreateAddTeam( name, player );
                player.sendMessage("創建成功 隊伍名:" + name);
            }
            else {
                //隊伍名重複
                player.sendMessage("你的隊伍名重複 無法建立");
            }
        }
        else {
            //有隊伍
            player.sendMessage("你已經擁有隊伍了");
        }
    }

    public boolean CreateCheckName(String Name){
        //如果有名字就不成立 如果沒有就成立
        boolean checkout = false;
        if ( !(createTeam.isEmpty())){
            for ( TeamData data : createTeam ){
                if ( data.TeamName.equals(Name)){
                    checkout = false;
                }
                else {
                    checkout = true;
                }
            }
        }
        else {
            checkout = true;
        }
        return checkout;
    }


    public boolean noTeam(Player player){
        boolean noTeam = true;
        for ( TeamData data : createTeam){
            if ( data.Leader == player ||
                 data.meat1 == player ||
                 data.meat2 == player ||
                 data.meat3 == player
            ){
                noTeam = false;
            }
            else {
                noTeam = true;
            }
        }
        return noTeam;
    }


    public boolean JoinCheckName(String Name){
        boolean checkout = false;
        if (!(createTeam.isEmpty())){
            for ( TeamData data : createTeam ){
                if ( data.TeamName.equals(Name)){
                    checkout = true;
                }
                else {
                    checkout = false;
                }
            }
        }
        else {
            checkout = false;
        }
        return checkout;
    }

    public void CreateAddTeam(String teamName, Player leader){
        TeamData teamData = new TeamData();
        teamData.TeamName = teamName;
        teamData.Leader = leader;
        createTeam.add(teamData);
    }

    public void join(Player player, String name){
        if (noTeam(player) ){
            //沒有隊伍
            if ( JoinCheckName(name) ){
                //有名字
            }
            else {
                //查無名字
                player.sendMessage("查無此隊伍名");
            }
        }
        else {
            //有隊伍
            player.sendMessage("你已經擁有隊伍了");
        }

    }



    public void showTeam(Player player){
        if ( !(createTeam.isEmpty())){
            player.sendMessage("=========隊伍列表=========");
            for ( TeamData data : createTeam){
                player.sendMessage("隊長: " + data.Leader.getName()  + "隊伍名: " + data.TeamName  + "隊員1: " + data.meat1 );
            }
        }
        else {
            player.sendMessage("目前無任何隊伍");
        }
    }



}
