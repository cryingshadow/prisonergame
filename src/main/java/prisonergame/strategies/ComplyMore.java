package prisonergame.strategies;

import java.util.*;

import prisonergame.*;

public class ComplyMore implements PrisonerStrategy {

    private final Random random = new Random();

    @Override
    public String getName() {
        return "ComplyMore";
    }

    @Override
    public PrisonerDecision takeDecision(final PrisonerInformation information) {
        return this.random.nextInt(3) == 0 ? PrisonerDecision.DEFECT : PrisonerDecision.COMPLY;
    }

}
