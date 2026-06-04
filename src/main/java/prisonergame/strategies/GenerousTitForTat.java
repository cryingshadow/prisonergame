package prisonergame.strategies;

import java.util.*;

import prisonergame.*;

public class GenerousTitForTat implements PrisonerStrategy {

    private final Random random = new Random();

    @Override
    public String getName() {
        return "GenerousTitForTat";
    }

    @Override
    public PrisonerDecision takeDecision(final PrisonerInformation information) {
        if (
            information.opponentDecisions().isEmpty()
            || information.opponentDecisions().getLast() == PrisonerDecision.COMPLY
            || this.random.nextInt(20) == 0
        ) {
            return PrisonerDecision.COMPLY;
        }
        return PrisonerDecision.DEFECT;
    }

}
