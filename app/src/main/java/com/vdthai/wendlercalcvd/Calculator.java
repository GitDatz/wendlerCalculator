package com.vdthai.wendlercalcvd;

/**
 * Created by vdthai on 2016-09-07.
 */
public class Calculator {

    private double[] trainingWeights;

    public Calculator(){
        // Initialize list of training weights for the cycle
        trainingWeights = new double[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    }

    /**
     * calculateTrainingWeigths: calculates the weights.
     * @param trainingMax the training max received.
     * @return list of exact training weights for the cycle.
     */
    public double[] calculateTrainingWeigths( double trainingMax ){
        trainingWeights[0] = trainingMax * 0.65;
        trainingWeights[1] = trainingMax * 0.75;
        trainingWeights[2] = trainingMax * 0.85;
        trainingWeights[3] = trainingMax * 0.70;
        trainingWeights[4] = trainingMax * 0.80;
        trainingWeights[5] = trainingMax * 0.90;
        trainingWeights[6] = trainingMax * 0.75;
        trainingWeights[7] = trainingMax * 0.85;
        trainingWeights[8] = trainingMax * 0.95;
        return trainingWeights;
    }

    /**
     * roundCalculatedWeights: check for single digit of training weight
     * and round to nearest valid value: 0.0, 2.5, 5.0, 7.5 or 10.0
     * @param trainingList the list of exact training weights for the cycle.
     * @return list of rounded training weights for the cycle.
     */
    public double[] roundCalculatedWeights( double[] trainingList ){
        for( int i = 0; i < trainingList.length; i++ ) {
            // Find single digit of the training weight
            double valueToRound = trainingWeights[i] % 10;
            if( valueToRound < 1.3 ){
                trainingWeights[i] -= valueToRound;
            } else if( valueToRound < 3.8 ){
                trainingWeights[i] -= valueToRound;
                trainingWeights[i] += 2.5;
            } else if( valueToRound < 6.3 ){
                trainingWeights[i] -= valueToRound;
                trainingWeights[i] += 5.0;
            } else if( valueToRound < 8.8 ){
                trainingWeights[i] -= valueToRound;
                trainingWeights[i] += 7.5;
            } else {
                trainingWeights[i] -= valueToRound;
                trainingWeights[i] += 10.0;
            }
        }
        return trainingWeights;
    }
}
