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

    public double[] calcWeights( double trainingMax ){
        return calculator.calculateTrainingWeigths( trainingMax );
    }

    public double[] calcRoundedWeights( double trainingMax ){
        return calculator.roundCalculatedWeights( calculator.calculateTrainingWeigths( trainingMax ) );
    }

    /**
     * Makes this an interface for the View to implement.
     */
    public interface View {

    }
}
