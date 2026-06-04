package prisonergame;

import java.math.*;
import java.util.*;
import java.util.stream.*;

import prisonergame.strategies.*;

public class Main {

    public static void main(final String[] args) {
        final int replicas = 4;
        final Map<PrisonerStrategy, Integer> strategyReplicas =
            Map.of(
                new TitForTat(), replicas,
                new Defect(), replicas,
                new Comply(), replicas,
                new RandomStrategy(), replicas
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
                400
            ).runExperiment();
        int index = 0;
        for (final Map.Entry<PrisonerStrategy, Integer> entry : strategyReplicas.entrySet()) {
            BigInteger sum = results[index++];
            for (int i = 1; i < entry.getValue(); i++) {
                sum = sum.add(results[index++]);
            }
            System.out.println(
                String.format(
                    "%s: %s",
                    entry.getKey().getName(),
                    new BigDecimal(sum).divide(new BigDecimal(entry.getValue())).toPlainString()
                )
            );
        }
        System.out.println();
        System.out.println(strategies.stream().map(PrisonerStrategy::getName).toList());
        System.out.println(Arrays.toString(results));
    }

}
