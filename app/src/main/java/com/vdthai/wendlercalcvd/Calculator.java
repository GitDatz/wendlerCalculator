package com.vdthai.wendlercalcvd;

import android.util.Log;

/**
 * Created by vdthai on 2016-09-07.
 */
public class Calculator {

    private double trainingMax;
    private double[] trainingWeights;

    public Calculator(){
        // Initialize T.M to 0
        trainingMax = 0;
        trainingWeights = new double[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    }

    public double[] calculateTrainingWeigths( double tm ){
        trainingMax = tm;
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

    public double[] roundCalculatedWeights( double[] trainingList ){
/*        Log.d("DEBUG", "Exact value = " + trainingWeights[0] );
        double f = 0.5;
        Log.d("DEBUG", "Rounded value = " + (f*(Math.round(trainingWeights[0]/f))) );
        Log.d("DEBUG", "Decimal value = " + ( trainingWeights[0]-(int)trainingWeights[0] ) );*/
        for( int i = 0; i < trainingList.length; i++ ) {
            double f;
            double decimal = trainingWeights[0] - (int) trainingWeights[0];
            Log.d("DEBUG", "Exact value = " + trainingWeights[0]);
            if (decimal < 0.12) {
                trainingWeights[0] -= decimal;
                Log.d("DEBUG", "Rounded value = " + trainingWeights[0]);
            } else if (decimal < 0.32) {
                f = 0.25;
                trainingWeights[0] = f * (Math.round(trainingWeights[0] / f));
                Log.d("DEBUG", "Rounded value = " + trainingWeights[0]);
            } else if (decimal < 0.63) {
                f = 0.5;
                trainingWeights[0] = f * (Math.round(trainingWeights[0] / f));
                Log.d("DEBUG", "Rounded value = " + trainingWeights[0]);
            } else if (decimal < 0.87) {
                f = 0.75;
                trainingWeights[0] = f * (Math.round(trainingWeights[0] / f));
                Log.d("DEBUG", "Rounded value = " + trainingWeights[0]);
            } else {
                f = 1;
                trainingWeights[0] = f * (Math.round(trainingWeights[0] / f));
                Log.d("DEBUG", "Rounded value = " + trainingWeights[0]);
            }
        }
        return trainingWeights;
    }
}
