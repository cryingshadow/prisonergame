package prisonergame;

public interface PrisonerStrategy {

    String getName();

    PrisonerDecision takeDecision(PrisonerInformation information);

}
