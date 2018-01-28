package Probability;

/**
 * Given a random generator random5(), the return value of random5() is 0 - 4 with equal probability. Use random5() to implement random7().
 */
public class Random7UsingRandom5 {
    public int random7() {
        int random = 5 * Random.random5() + Random.random5();
        while (random > 20) {
            random = 5 * Random.random5() + Random.random5();
        }
        return random % 7;
    }
}
