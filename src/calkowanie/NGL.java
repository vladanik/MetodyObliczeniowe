package calkowanie;

import java.util.*;

public class NGL {
    protected List<Double> n2weight = new ArrayList<>(2);
    protected List<Double> n2absciss = new ArrayList<>(2);
    protected List<Double> n4weight = new ArrayList<>(4);
    protected List<Double> n4absciss = new ArrayList<>(4);
    protected List<Double> n6weight = new ArrayList<>(6);
    protected List<Double> n6absciss = new ArrayList<>(6);
    protected List<Double> n8weight = new ArrayList<>(8);
    protected List<Double> n8absciss = new ArrayList<>(8);
    protected List<Double> n10weight = new ArrayList<>(10);
    protected List<Double> n10absciss = new ArrayList<>(10);
    protected List<Double> n16weight = new ArrayList<>(16);
    protected List<Double> n16absciss = new ArrayList<>(16);

    public NGL(List<Double> n2weight, List<Double> n2absciss,
               List<Double> n4weight, List<Double> n4absciss,
               List<Double> n6weight, List<Double> n6absciss,
               List<Double> n8weight, List<Double> n8absciss,
               List<Double> n10weight, List<Double> n10absciss,
               List<Double> n16weight, List<Double> n16absciss) {
        n2weight.add(1.0);
        n2absciss.add(-0.57735);
        n2weight.add(1.0);
        n2absciss.add(0.57735);

        n4weight.add(0.347855);
        n4absciss.add(-0.861136);
        n4weight.add(0.652145);
        n4absciss.add(-0.339981);
        n4weight.add(0.652145);
        n4absciss.add(0.339981);
        n4weight.add(0.347855);
        n4absciss.add(0.861136);

        n6weight.add(0.171324);
        n6absciss.add(-0.932469);
        n6weight.add(0.360762);
        n6absciss.add(-0.661209);
        n6weight.add(0.467914);
        n6absciss.add(-0.238619);
        n6weight.add(0.467914);
        n6absciss.add(0.238619);
        n6weight.add(0.360762);
        n6absciss.add(0.661209);
        n6weight.add(0.171324);
        n6absciss.add(0.932469);

        n8weight.add(0.101229);
        n8absciss.add(-0.96029);
        n8weight.add(0.222381);
        n8absciss.add(-0.796667);
        n8weight.add(0.313707);
        n8absciss.add(-0.525532);
        n8weight.add(0.362684);
        n8absciss.add(-0.183435);
        n8weight.add(0.362684);
        n8absciss.add(0.183435);
        n8weight.add(0.313707);
        n8absciss.add(0.525532);
        n8weight.add(0.222381);
        n8absciss.add(0.796667);
        n8weight.add(0.101229);
        n8absciss.add(0.96029);

        n10weight.add(0.0666713);
        n10absciss.add(-0.973907);
        n10weight.add(0.149451);
        n10absciss.add(-0.865063);
        n10weight.add(0.219086);
        n10absciss.add(-0.67941);
        n10weight.add(0.269267);
        n10absciss.add(-0.433395);
        n10weight.add(0.295524);
        n10absciss.add(-0.148874);
        n10weight.add(0.295524);
        n10absciss.add(0.148874);
        n10weight.add(0.269267);
        n10absciss.add(0.433395);
        n10weight.add(0.219086);
        n10absciss.add(0.67941);
        n10weight.add(0.149451);
        n10absciss.add(0.865063);
        n10weight.add(0.0666713);
        n10absciss.add(0.973907);

        n16weight.add(0.0271525);
        n16absciss.add(-0.989401);
        n16weight.add(0.0622535);
        n16absciss.add(-0.944575);
        n16weight.add(0.0951585);
        n16absciss.add(-0.865631);
        n16weight.add(0.124629);
        n16absciss.add(-0.755404);
        n16weight.add(0.149596);
        n16absciss.add(-0.617876);
        n16weight.add(0.169157);
        n16absciss.add(-0.458017);
        n16weight.add(0.182603);
        n16absciss.add(-0.281604);
        n16weight.add(0.189451);
        n16absciss.add(-0.0950125);
        n16weight.add(0.189451);
        n16absciss.add(-0.0950125);
        n16weight.add(0.182603);
        n16absciss.add(-0.281604);
        n16weight.add(0.169157);
        n16absciss.add(-0.458017);
        n16weight.add(0.149596);
        n16absciss.add(-0.617876);
        n16weight.add(0.124629);
        n16absciss.add(-0.755404);
        n16weight.add(0.0951585);
        n16absciss.add(-0.865631);
        n16weight.add(0.0622535);
        n16absciss.add(-0.944575);
        n16weight.add(0.0271525);
        n16absciss.add(-0.989401);

        this.n2weight = n2weight;
        this.n2absciss = n2absciss;
        this.n4weight = n4weight;
        this.n4absciss = n4absciss;
        this.n6weight = n6weight;
        this.n6absciss = n6absciss;
        this.n8weight = n8weight;
        this.n8absciss = n8absciss;
        this.n10weight = n10weight;
        this.n10absciss = n10absciss;
        this.n16weight = n16weight;
        this.n16absciss = n16absciss;
    }
}
