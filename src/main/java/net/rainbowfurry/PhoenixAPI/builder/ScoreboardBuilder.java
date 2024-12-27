package net.rainbowfurry.PhoenixAPI.builder;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScoreboardBuilder {

    private final ScoreboardManager manager = Bukkit.getScoreboardManager();
    private Scoreboard scoreboard;
    private Objective objective;

    //ToDo: Name mit speichern? falls ja aber nicht multiscore möglich außer seperater aufruf

    private int placeholderIndex = 1;

    /**
     * Create a new ScoreBoard
     * @param name Score Name
     * @param displayName Score DisplayName
     * @return base class
     */
    public ScoreboardBuilder createScoreBoard(String name, String displayName){
        assert manager != null;
        scoreboard = manager.getNewScoreboard();
        objective = scoreboard.registerNewObjective(
                name,
                Criteria.DUMMY,
                displayName
        );
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        return this;
    }

    /**
     * Add new Line
     * @param content Content
     * @param index Index
     * @return base Class
     */
    public ScoreboardBuilder addObject(String content, int index){
        objective.getScore(content).setScore(index);
        return this;
    }

    /**
     * Add empty Line as PlaceHolder
     * @param index Line Index
     * @return base Class
     */
    public ScoreboardBuilder addPlaceholder(int index){
        String placeholder = "";
        for(int i = 0; i < placeholderIndex; i++)
            placeholder = placeholder + " ";
        objective.getScore(placeholder).setScore(index);
        placeholderIndex++;
        return this;
    }

    /**
     * Build the ScoreBoard
     * @return ScoreBoard
     */
    public Scoreboard build(){
        return scoreboard;
    }

    /**
     * Update Score without flicker
     * @param player Player
     * @param title Score Title
     * @param old Old Content
     * @param content New Content
     * @param index Index
     * @return base Class
     */
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
