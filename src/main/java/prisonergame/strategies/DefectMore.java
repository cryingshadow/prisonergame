package prisonergame.strategies;

import java.util.*;

import prisonergame.*;

public class DefectMore implements PrisonerStrategy {

    private final Random random = new Random();

    @Override
    public String getName() {
        return "DefectMore";
    }

    @Override
    public PrisonerDecision takeDecision(final PrisonerInformation information) {
        return this.random.nextInt(3) == 0 ? PrisonerDecision.COMPLY : PrisonerDecision.DEFECT;
    }

}
