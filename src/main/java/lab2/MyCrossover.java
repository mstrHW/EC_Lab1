package lab2;

import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MyCrossover extends AbstractCrossover<double[]> {

    private float crossoverProbability;

    protected MyCrossover(float crossoverProbability) {
        super(1);
        this.crossoverProbability = crossoverProbability;
    }

    protected List<double[]> mate(double[] p1, double[] p2, int i, Random random) {
        return v1(p1, p2, i, random);
    }

    protected List<double[]> v1(double[] p1, double[] p2, int i, Random random) {
        List<double[]> children = new ArrayList<>();

        // your implementation:
        double[] nextP1 = p1.clone();
        double[] nextP2 = p2.clone();

        for(int idx = 0; idx < p1.length; idx++) {
            if (random.nextDouble() > crossoverProbability){
                nextP1[idx] = p2[idx];
                nextP2[idx] = p1[idx];
            }
        }

        children.add(nextP1);
        children.add(nextP2);

        return children;
    }
}
