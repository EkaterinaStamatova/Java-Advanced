package JavaAdvancedExam22Feb2020.guild;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class Guild {

    private List<Player> roster;
    private String name;
    private int capacity;

    //Constructor
    public Guild(String name, int capacity) {
        this.roster = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    //Add a new player
    public void addPlayer(Player player){
        if(this.capacity>this.roster.size()){
            this.roster.add(player);
        }
    }

    //Remove a player by given name
    public boolean removePlayer(String name){
        for (int i = 0; i < this.roster.size(); i++) {
            Player player = this.roster.get(i);
            if (player.getName().equals(name)) {
                this.roster.remove(i);
                return true;
            }
        }
        return false;
    }

    //Promote player
    public void promotePlayer(String name){
        for (Player player:
             roster) {
            if(player.getName().equals(name)){
                if(!player.getRank().equals("Member")){
                    player.setRank("Member");
                }
                break;
            }
        }
    }

    //Demote player
    public void demotePlayer(String name){
        for (Player player:
                roster) {
            if(player.getName().equals(name)){
                if(!player.getRank().equals("Trial")){
                    player.setRank("Trial");
                }
                break;
            }
        }
    }

    //Kick players
    public Player[] kickPlayersByClass(String clazz){
       Player kickedPlayers[] = new Player[roster.size()];
       int i = 0;
        for (Player player:
             roster) {
            if(player.getClazz().equals(clazz)) {
                kickedPlayers[i]=player;
                i++;
            }
        }
       Player[] removedNull = Arrays.stream(kickedPlayers)
                .filter(value ->
                        value != null
                )
                .toArray(size -> new Player[size]);
        for (Player p:
             removedNull) {
            this.roster.remove(p);
        }
        return removedNull;
    }

    public int count(){
        return this.roster.size();
    }

    public String report(){
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("%nPlayers in the JavaAdvancedExam22Feb2020.guild: %s:%n",this.name));

        for (Player player:
                roster){
            builder.append(String.format(player + "%n"));
        }
        return builder.toString().trim();
    }
}
