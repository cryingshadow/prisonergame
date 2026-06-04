package prisonergame.strategies;

import prisonergame.*;

public class ScepticalTitForTat implements PrisonerStrategy {

    @Override
    public String getName() {
        return "ScepticalTitForTat";
    }

    @Override
    public PrisonerDecision takeDecision(final PrisonerInformation information) {
        if (information.opponentDecisions().isEmpty()) {
            return PrisonerDecision.DEFECT;
        }
        return information.opponentDecisions().getLast();
    }

}
