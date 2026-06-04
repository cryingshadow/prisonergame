package prisonergame.strategies;

import prisonergame.*;

public class FirstTrust implements PrisonerStrategy {

    private boolean trust = true;

    @Override
    public String getName() {
        return "FirstTrust";
    }

    @Override
    public PrisonerDecision takeDecision(final PrisonerInformation information) {
        if (
            this.trust
            && (
                information.opponentDecisions().isEmpty()
                || information.opponentDecisions().getLast() == PrisonerDecision.COMPLY
            )
        ) {
            return PrisonerDecision.COMPLY;
        }
        this.trust = false;
        return PrisonerDecision.DEFECT;
    }

}
