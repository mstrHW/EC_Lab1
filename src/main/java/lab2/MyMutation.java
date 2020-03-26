package lab2;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.List;
import java.util.Random;

public class MyMutation implements EvolutionaryOperator<double[]> {

    private float mutatePopulationRate;
    private float mutateGeneRate;
    private double minX;
    private double maxX;

    public MyMutation(float mutatePopulationRate, float mutateGeneRate, double minX, double maxX) {
        this.mutatePopulationRate = mutatePopulationRate;
        this.mutateGeneRate = mutateGeneRate;
        this.minX = minX;
        this.maxX = maxX;
    }

    public List<double[]> apply(List<double[]> population, Random random) {
        for(int i = 0; i < population.size(); i++) {
            population.set(i, mutated(population.get(i), random));
        }

        return population;

    }

    private double[] mutated(double[] individ, Random random) {
        if (random.nextDouble() > mutatePopulationRate) {
            for(int i = 0; i < individ.length; i++) {
                individ[i] = generateValue(individ[i], random);
            }
        }
        return individ;
    }

    private double generateValue(double oldValue, Random random) {
        double result = oldValue;
        if (random.nextDouble() > mutateGeneRate) {
            result += random.nextGaussian();
            result = clipInRange(result);
        }
        return result;
    }

    private double clipInRange(double value) {
        return Math.min(Math.max(value, minX), maxX);
    }
}
