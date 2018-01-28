package Probability;

/**
 * Given a random generator random5(), the return value of random5() is 0 - 4 with equal probability. Use random5() to implement random1000()
 */
public class Random1000UsingRandom5 {
    public static int random1000() {
        int random = Random.random5() * 5 * 5 * 5 * 5 + Random.random5() * 5 * 5 * 5 + Random.random5() * 5 * 5
                + Random.random5() * 5 + Random.random5();
        while (random > 3000) {
            random = Random.random5() * 5 * 5 * 5 * 5 + Random.random5() * 5 * 5 * 5 + Random.random5() * 5 * 5
                    + Random.random5() * 5 + Random.random5();
        }
        return random % 1000;
    }
}
