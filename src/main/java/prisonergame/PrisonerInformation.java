package prisonergame;

import java.util.*;

public record PrisonerInformation(
    List<PrisonerDecision> ownDecisions,
    List<PrisonerDecision> opponentDecisions,
    PrisonerPayoffFunction payoff
) {

}
