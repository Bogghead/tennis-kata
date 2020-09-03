public class TennisGame3 {

    public static final int WINNABLETHRESHOLD = 4;
    private int player1Points;
    private int player2Points;
    private final String player1Name;
    private final String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String aPlayersName) {
        if (aPlayersName.equals(player1Name))
            ++this.player1Points;
        else
            ++this.player2Points;
    }

    public String getScore() {
        if (gameIsWinnable()) {
            return (isTied())
                    ? "Deuce"
                    : sayAdvantageOrWin();
        } else {
            return isTied()
                    ? sayScore(player1Points) + "-All"
                    : sayScore(player1Points) + "-" + sayScore(player2Points);
        }
    }

    private String sayScore(int points) {
        String[] scoreNames = {"Love", "Fifteen", "Thirty", "Forty"};
        return scoreNames[points];
    }

    private String sayAdvantageOrWin() {
        return thereIsAWinner()
                ? "Win for " + whoseAhead()
                : "Advantage " +  whoseAhead();
    }

    private String whoseAhead() {
        return (player1Points > player2Points) ? player1Name : player2Name;
    }

    private boolean gameIsWinnable() {
        return player1Points >= WINNABLETHRESHOLD || player2Points >= WINNABLETHRESHOLD;
    }

    private boolean thereIsAWinner() {
        return Math.abs(player1Points-player2Points) > 1;
    }

    private boolean isTied() {
        return this.player1Points == this.player2Points;
    }

}
