package prisonergame;

import java.math.*;
import java.util.*;
import java.util.stream.*;

import prisonergame.strategies.*;

public class Main {

    public static void main(final String[] args) {
        final int replicas = 1;
        final int rounds = 200;
        final Map<PrisonerStrategy, Integer> strategyReplicas =
            Map.of(
                new TitForTat(), replicas,
                new Defect(), replicas,
                new Comply(), replicas,
                new RandomStrategy(), replicas,
                new ComplyMore(), replicas,
                new DefectMore(), replicas,
                new GenerousTitForTat(), replicas,
                new ScepticalTitForTat(), replicas,
                new FirstTrust(), replicas
            );
        final List<PrisonerStrategy> strategies =
            strategyReplicas
            .entrySet()
            .stream()
            .flatMap(entry ->
                (Stream<PrisonerStrategy>)Stream.generate(() -> entry.getKey()).limit(entry.getValue())
            ).toList();
        final BigInteger[] results =
            new Engine(
                new DefaultPayoffFunction(),
                strategies,
                rounds
            ).runExperiment();
        int index = 0;
        final TreeMap<BigDecimal, Set<String>> averages = new TreeMap<BigDecimal, Set<String>>();
        for (final Map.Entry<PrisonerStrategy, Integer> entry : strategyReplicas.entrySet()) {
            BigInteger sum = results[index++];
            for (int i = 1; i < entry.getValue(); i++) {
                sum = sum.add(results[index++]);
            }
            averages.merge(
                new BigDecimal(sum).divide(new BigDecimal(entry.getValue())),
                Set.of(entry.getKey().getName()),
                (set1, set2) -> Stream.concat(set1.stream(), set2.stream()).collect(Collectors.toSet())
            );
        }
        for (final Map.Entry<BigDecimal, Set<String>> entry : averages.descendingMap().entrySet()) {
            System.out.println(String.format("%s: %s", entry.getValue(), entry.getKey()));
        }
    }

}
