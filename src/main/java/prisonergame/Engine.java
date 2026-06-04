package prisonergame;

import java.math.*;
import java.util.*;

public class Engine {

    private final PrisonerPayoffFunction payoff;

    private final int rounds;

    private final PrisonerStrategy[] strategies;

    public Engine(
        final PrisonerPayoffFunction payoff,
        final Collection<PrisonerStrategy> strategies,
        final int rounds
    ) {
        this.payoff = payoff;
        this.strategies = strategies.toArray(new PrisonerStrategy[strategies.size()]);
        this.rounds = rounds;
    }

    public BigInteger[] runExperiment() {
        final BigInteger[] results = new BigInteger[this.strategies.length];
        Arrays.fill(results, BigInteger.ZERO);
        for (int firstPlayer = 0; firstPlayer < this.strategies.length; firstPlayer++) {
            for (int secondPlayer = firstPlayer + 1; secondPlayer < this.strategies.length; secondPlayer++) {
                this.runGame(firstPlayer, secondPlayer, results);
            }
        }
        return results;
    }

    private void runGame(final int firstPlayer, final int secondPlayer, final BigInteger[] results) {
        final PrisonerInformation firstPlayerInformation =
            new PrisonerInformation(new ArrayList<PrisonerDecision>(), new ArrayList<PrisonerDecision>(), this.payoff);
        final PrisonerInformation secondPlayerInformation =
            new PrisonerInformation(new ArrayList<PrisonerDecision>(), new ArrayList<PrisonerDecision>(), this.payoff);
        for (int i = 0; i < this.rounds; i++) {
            this.runRound(firstPlayer, secondPlayer, firstPlayerInformation, secondPlayerInformation, results);
        }
    }

    private void runRound(
        final int firstPlayer,
        final int secondPlayer,
        final PrisonerInformation firstPlayerInformation,
        final PrisonerInformation secondPlayerInformation,
        final BigInteger[] results
    ) {
        final PrisonerStrategy firstPlayerStrategy = this.strategies[firstPlayer];
        final PrisonerStrategy secondPlayerStrategy = this.strategies[secondPlayer];
        final PrisonerDecision firstPlayerDecision = firstPlayerStrategy.takeDecision(firstPlayerInformation);
        final PrisonerDecision secondPlayerDecision = secondPlayerStrategy.takeDecision(secondPlayerInformation);
        final PrisonerPayoff result = this.payoff.apply(firstPlayerDecision, secondPlayerDecision);
        firstPlayerInformation.ownDecisions().add(firstPlayerDecision);
        firstPlayerInformation.opponentDecisions().add(secondPlayerDecision);
        secondPlayerInformation.ownDecisions().add(secondPlayerDecision);
        secondPlayerInformation.opponentDecisions().add(firstPlayerDecision);
        results[firstPlayer] = results[firstPlayer].add(result.payoffFirstPlayer());
        results[secondPlayer] = results[secondPlayer].add(result.payoffSecondPlayer());
    }

}
