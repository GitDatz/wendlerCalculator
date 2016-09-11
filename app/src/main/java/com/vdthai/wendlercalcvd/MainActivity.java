package com.vdthai.wendlercalcvd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Presenter.View {

    Presenter presenter;

    public void updateFields( double[] trainingWeights ){
        // Week 1
        TextView w1Set1Text = (TextView) findViewById(R.id.w1Set1Field);
        w1Set1Text.setText( String.valueOf( "65% 5 x " + trainingWeights[0] ) );
        TextView w1Set2Text = (TextView) findViewById(R.id.w1Set2Field);
        w1Set2Text.setText( String.valueOf( "75% 5 x " + trainingWeights[1] ) );
        TextView w1Set3Text = (TextView) findViewById(R.id.w1Set3Field);
        w1Set3Text.setText( String.valueOf( "85% 5 x " + trainingWeights[2] ) );
        // Week 2
        TextView w2Set1Text = (TextView) findViewById(R.id.w2Set1Field);
        w2Set1Text.setText( String.valueOf( "70% 3 x " + trainingWeights[3] ) );
        TextView w2Set2Text = (TextView) findViewById(R.id.w2Set2Field);
        w2Set2Text.setText( String.valueOf( "80% 3 x " + trainingWeights[4] ) );
        TextView w2Set3Text = (TextView) findViewById(R.id.w2Set3Field);
        w2Set3Text.setText( String.valueOf( "90% 3 x " + trainingWeights[5] ) );
        // Week 3
        TextView w3Set1Text = (TextView) findViewById(R.id.w3Set1Field);
        w3Set1Text.setText( String.valueOf( "75% 5 x " + trainingWeights[6] ) );
        TextView w3Set2Text = (TextView) findViewById(R.id.w3Set2Field);
        w3Set2Text.setText( String.valueOf( "85% 3 x " + trainingWeights[7] ) );
        TextView w3Set3Text = (TextView) findViewById(R.id.w3Set3Field);
        w3Set3Text.setText( String.valueOf( "95% 1 x " + trainingWeights[8] ) );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter(this);

        final EditText trainingMaxVal = (EditText)findViewById(R.id.weightInputField);
        Button calcButton = (Button)findViewById(R.id.calcButton);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get value of trainingMax-EditText, check if empty.
                if( !trainingMaxVal.getText().toString().isEmpty() ){
                    // If checkBox is marked, roundWeights
                    CheckBox calcRounded = (CheckBox)findViewById(R.id.checkBox);
                    if( calcRounded.isChecked() ){
                        updateFields( presenter.calcRoundedWeights( Double.parseDouble( trainingMaxVal.getText().toString() ) ) );
                    } else {
                        updateFields( presenter.calcWeights( Double.parseDouble( trainingMaxVal.getText().toString() ) ) );
                    }
                }
            }
        });
    }
}
