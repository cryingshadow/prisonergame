package prisonergame.strategies;

import prisonergame.*;

public class Defect implements PrisonerStrategy {

    @Override
    public String getName() {
        return "Defect";
    }

    @Override
    public PrisonerDecision takeDecision(final PrisonerInformation information) {
        return PrisonerDecision.DEFECT;
    }

}
