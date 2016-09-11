package com.vdthai.wendlercalcvd;

import android.view.View;

/**
 * Created by vdthai on 2016-09-07.
 */
public class Presenter {

    Calculator calculator;
    View view;

    /**
     * Presenter Constructor.
     * @param view reference to the view.
     */
    public Presenter( View view ){
        this.view = view;
        calculator = new Calculator();
    }

    /**
     * calcWeights
     * @param trainingMax the training max for the cycle.
     * @return list of exact training weights for the cycle.
     */
    public double[] calcWeights( double trainingMax ){
        return calculator.calculateTrainingWeigths( trainingMax );
    }

    /**
     * calcRoundedWeights: rounds the weights based on the kg-plates;
     * 1,25 kg, 2,5 kg, 5,0 kg, 10,0 kg, 20,0 kg
     * @param trainingMax the training max for the cycle.
     * @return list of rounded training weights for the cycle.
     */
    public double[] calcRoundedWeights( double trainingMax ){
        return calculator.roundCalculatedWeights( calculator.calculateTrainingWeigths( trainingMax ) );
    }

    /**
     * Makes this an interface for the View to implement.
     */
    public interface View {

    }
}
