package lab2;

import org.uncommons.watchmaker.framework.factories.AbstractCandidateFactory;

import java.util.Random;

public class MyFactory extends AbstractCandidateFactory<double[]> {

    private int dimension;
    private double minX;
    private double maxX;

    public MyFactory(int dimension, double minX, double maxX) {
        this.dimension = dimension;
        this.minX = minX;
        this.maxX = maxX;
    }

    public double[] generateRandomCandidate(Random random) {
        double[] solution = new double[dimension];
        // x from -5.0 to 5.0

        for(int i = 0; i < dimension; i++)
        {
            solution[i] = minX + (maxX - minX) * random.nextDouble();
        }

        return solution;
    }
}

