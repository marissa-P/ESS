package edu.txstate.ess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Instruction extends AppCompatActivity {
;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring_record);
        TextView instructions = findViewById(R.id.txtInstructions);

        instructions.setText("Validating Entry #:\n" +
                "1.\tEnter TEAM JUDGE # and enter ENTRY#.\n" +
                "2.\tClick on the ENTER button.\n" +
                "3.\tIf ENTRY # is valid, the following fields: DIVISION, CLASS NAME, CLASS NUMBER, PROJECT NAME, and SCHOOL will auto-populate. \n" +
                "\n" +
                "Scoring Entry Requirements:\n" +
                " *Cannot enter over the maximum value of points in criteria boxes.\n" +
                "*Cannot leave ANY column blank. Must enter at least a 0. \n" +
                "*The SUBMIT TO SUMMARY SHEET button will add scores to the Class Summary Sheet.\n" +
                "\n" +
                "Rules for Selecting Ribbon Type:\n" +
                "*To be given a BLUE ribbon, the project should score AT LEAST 90% (27 points) in the WORKMANSHIP criteria.\n" +
                "*To be given a RED ribbon, the project should score LESS THAN 90% (27 points) in the WORKMANSHIP criteria. \n" );
    }
}
