package prisonergame.strategies;

import prisonergame.*;

public class Comply implements PrisonerStrategy {

    @Override
    public String getName() {
        return "Comply";
    }

    @Override
    public PrisonerDecision takeDecision(final PrisonerInformation information) {
        return PrisonerDecision.COMPLY;
    }

}
