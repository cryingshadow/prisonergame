package prisonergame.strategies;

import prisonergame.*;

public class TitForTat implements PrisonerStrategy {

    @Override
    public String getName() {
        return "TitForTat";
    }

    @Override
    public PrisonerDecision takeDecision(final PrisonerInformation information) {
        if (information.opponentDecisions().isEmpty()) {
            return PrisonerDecision.COMPLY;
        }
        return information.opponentDecisions().getLast();
    }

}
