package edu.txstate.ess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FinalCSS extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_c_s_s);



            String entry = getIntent().getStringExtra("KeyEntry");
            String judge=getIntent().getStringExtra("KeyJudge");
            String projectName = getIntent().getStringExtra("KeyProjectName");
            TextView entryText = findViewById(R.id.txtEntryNumberFinal);
            TextView placing = findViewById(R.id.txtPlacingFinalCSS);
            TextView judgeText = findViewById(R.id.txtJudgeFinal);
            TextView projectNameText = findViewById(R.id.txtProjectNameFinal);
            judgeText.setText("JUDGE #"+ "\n"+judge+ "\n");
            projectNameText.setText("PROJECT DESCRIPTION"+ "\n"+projectName+ "\n");
            entryText.setText("ENTRY NUMBER"+ "\n"+entry+ "\n");
            placing.setText("Placing"+ "\n"
                             + "\n"+
                            "1" + "\n"+
                            "2"+ "\n"+
                            "3"+ "\n"+
                            "4" + "\n"+
                            "5"+ "\n"+
                             "6");






        }
    }