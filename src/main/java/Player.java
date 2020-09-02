public class Player {
    public static final int WINPOSSIBLETHRESHOLD = 4;

    public final String name;
    public Integer points = 0;

    public Player(String playerName) {
        name = playerName;
    }

    public void bumpScore() {
        points += 1;
    }

    boolean isTied(Player opponent) {
        return points.equals(opponent.points);
    }

    static String[] scoreNames = {"Love", "Fifteen", "Thirty", "Forty"};
    String buildNonWinScore(Player opponent) {
        return (isTied(opponent)) ? buildTiedScore() :  buildNonTiedScore(opponent);
    }

    private String buildNonTiedScore(Player opponent) {
        return scoreNames[points] + "-" + scoreNames[opponent.points];
    }

    private String buildTiedScore() { 
        return (cannotWin()) ? scoreNames[points] + "-All" : "Deuce";
    }

    String buildWinnableScore(Player opponent) {
        if (isTied(opponent)) return "Deuce";
        return isAdvantage(opponent)
                ? "Advantage " + winningPlayName(opponent)
                : "Win for " + winningPlayName(opponent);
    }

    private boolean isAdvantage(Player opponent) {
        return Math.abs(points - opponent.points) == 1;
    }

    String winningPlayName(Player opponent) {
        return (points > opponent.points) ? name : opponent.name;
    }

    boolean named(String playerName) {
        return playerName.equals(name);
    }
    
    boolean cannotWin() {
        return ! canWin(); }

    boolean canWin() {
        return points >= WINPOSSIBLETHRESHOLD;
    }
}
