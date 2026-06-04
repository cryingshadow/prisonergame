package prisonergame;

import java.math.*;

public class DefaultPayoffFunction implements PrisonerPayoffFunction {

    private final BigInteger cc;

    private final BigInteger cd;

    private final BigInteger dc;

    private final BigInteger dd;

    public DefaultPayoffFunction() {
        this(BigInteger.valueOf(8), BigInteger.ZERO, BigInteger.valueOf(10), BigInteger.TWO);
    }

    public DefaultPayoffFunction(final BigInteger cc, final BigInteger cd, final BigInteger dc, final BigInteger dd) {
        this.cc = cc;
        this.cd = cd;
        this.dc = dc;
        this.dd = dd;
    }

    @Override
    public PrisonerPayoff apply(final PrisonerDecision first, final PrisonerDecision second) {
        if (first == PrisonerDecision.COMPLY) {
            if (second == PrisonerDecision.COMPLY) {
                return new PrisonerPayoff(this.cc, this.cc);
            } else {
                return new PrisonerPayoff(this.cd, this.dc);
            }
        } else if (second == PrisonerDecision.COMPLY) {
            return new PrisonerPayoff(this.dc, this.cd);
        } else {
            return new PrisonerPayoff(this.dd, this.dd);
        }
    }

}
