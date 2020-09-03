
public class TennisGame2 {

    private final Player player1;
    private final Player player2;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (player1.named(playerName)) {
            player1.bumpScore();
        } else {
            player2.bumpScore();
        }
    }

    public String getScore() {
        return isWinable() ? winableScore() : nonWinScore();
    }

    private boolean isWinable() {
        return (player1.canWin() || player2.canWin());
    }

    private String winableScore() {
        return player1.buildWinnableScore(player2);
    }

    private String nonWinScore() {
        return player1.buildNonWinScore(player2);
    }
}