package prisonergame.strategies;

import java.util.*;

import prisonergame.*;

public class RandomStrategy implements PrisonerStrategy {

    private final Random random = new Random();

    @Override
    public String getName() {
        return "Random";
    }

    @Override
    public PrisonerDecision takeDecision(final PrisonerInformation information) {
        return this.random.nextBoolean() ? PrisonerDecision.COMPLY : PrisonerDecision.DEFECT;
    }

}
