package prisonergame;

import java.util.function.*;

public interface PrisonerPayoffFunction extends BiFunction<PrisonerDecision, PrisonerDecision, PrisonerPayoff> {

}
