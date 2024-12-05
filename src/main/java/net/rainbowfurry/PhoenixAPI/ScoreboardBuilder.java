package net.rainbowfurry.PhoenixAPI;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScoreboardBuilder {

    private final ScoreboardManager manager = Bukkit.getScoreboardManager();
    private Scoreboard scoreboard;
    private Objective objective;

    public ScoreboardBuilder createScoreBoard(String name, String displayName){
        assert manager != null;
        scoreboard = manager.getNewScoreboard();
        // Create an objective
        objective = scoreboard.registerNewObjective(
                name, // Internal name
                Criteria.DUMMY,     // Type
                displayName // Display name
        );
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        return this;
    }

    public ScoreboardBuilder addObject(String content, int index){
        objective.getScore(content).setScore(index);
        return this;
    }

    public Scoreboard build(){
        return scoreboard;
    }

    public ScoreboardBuilder updateObject(Player player, String title, String old, String content, int index){
        Scoreboard playerScore = player.getScoreboard();
        Objective objective = playerScore.getObjective(title);
        playerScore.resetScores(old);
        //playerScore.resetScores(objective.getScore(old).getEntry());
        assert objective != null;
        objective.getScore(content).setScore(index);
        return this;
    }

}
