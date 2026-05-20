package utils;

/**
 * Centralized counters for game statistics.
 */
public final class GameStats {

    private static int wordleStarted;
    private static int wordleAttempts;
    private static int wordleLosses;
    private static int wordleWins;

    private static int basketballStarted;

    private static int game2048Started;
    private static int game2048Wins;
    private static int game2048Exits;

    private GameStats() {
    }

    /**
     * Registers a new Wordle session.
     */
    public static void registerWordleStart() {
        wordleStarted++;
    }

    /**
     * Registers a Wordle attempt.
     */
    public static void registerWordleAttempt() {
        wordleAttempts++;
    }

    /**
     * Registers a Wordle loss.
     */
    public static void registerWordleLoss() {
        wordleLosses++;
    }

    /**
     * Registers a Wordle win.
     */
    public static void registerWordleWin() {
        wordleWins++;
    }

    /**
     * Registers a Basketball session.
     */
    public static void registerBasketballStart() {
        basketballStarted++;
    }

    /**
     * Registers a 2048 session.
     */
    public static void register2048Start() {
        game2048Started++;
    }

    /**
     * Registers a 2048 victory.
     */
    public static void register2048Win() {
        game2048Wins++;
    }

    /**
     * Registers a 2048 exit without finishing.
     */
    public static void register2048Exit() {
        game2048Exits++;
    }

    /**
     * @return Wordle sessions started
     */
    public static int getWordleStarted() {
        return wordleStarted;
    }

    /**
     * @return Wordle attempts
     */
    public static int getWordleAttempts() {
        return wordleAttempts;
    }

    /**
     * @return Wordle losses
     */
    public static int getWordleLosses() {
        return wordleLosses;
    }

    /**
     * @return Wordle wins
     */
    public static int getWordleWins() {
        return wordleWins;
    }

    /**
     * @return Basketball sessions started
     */
    public static int getBasketballStarted() {
        return basketballStarted;
    }

    /**
     * @return 2048 sessions started
     */
    public static int get2048Started() {
        return game2048Started;
    }

    /**
     * @return 2048 victories
     */
    public static int get2048Wins() {
        return game2048Wins;
    }

    /**
     * @return 2048 exits without finishing
     */
    public static int get2048Exits() {
        return game2048Exits;
    }
}
