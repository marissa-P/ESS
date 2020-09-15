package edu.txstate.ess;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;




import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.text.DecimalFormat;




public class MainActivity extends AppCompatActivity {
    Double total;
    Double percentTotal;
    CountDownTimer countDownTimer;
    TextView timer;
    Button retrieveInformationFirebase;

    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button instruction = findViewById(R.id.btnInstruction);
        final EditText workmanship = findViewById(R.id.txt_Workmanship);
        final EditText design = findViewById(R.id.txt_Design);
        final EditText documentation = findViewById(R.id.txt_Doc);
        final EditText presentation = findViewById(R.id.txt_Presentation);
        final EditText difficulty = findViewById(R.id.txt_Difficulty);
        final EditText safety = findViewById(R.id.txt_Safety);
        final TextView totalV = findViewById(R.id.txtTotal);
        final TextView percentWorkmanship = findViewById(R.id.txtPerWorkmanship);
        final TextView percentDesign = findViewById(R.id.txtPerDesign);
        final TextView percentDoc = findViewById(R.id.txtPerDoc);
        final TextView percentPresentation = findViewById(R.id.txtPerPresentation);
        final TextView percentDifficulty = findViewById(R.id.txtPerDifficulty);
        final TextView percentSafety = findViewById(R.id.txtPerSafety);
        Button calculate = findViewById(R.id.btnCalculate);
        final DecimalFormat tenth = new DecimalFormat("#%");
        RadioButton blue = findViewById(R.id.rdbBlue);
        RadioButton white = findViewById(R.id.rdbWhite);
        RadioButton red = findViewById(R.id.rdbRed);
        Button classSummary = findViewById(R.id.btnClassSummary);
        retrieveInformationFirebase  = findViewById(R.id.btnRetrieve);
        timer = findViewById(R.id.txtTime);

        final TextView division = findViewById(R.id.txtDivision);
        final TextView className = findViewById(R.id.txtClassName);
        final TextView classNumber = findViewById(R.id.txtClassNumber);
        final TextView projectName = findViewById(R.id.txtProjectName);
        final TextView schoolName= findViewById(R.id.txtSchool);
        final EditText teamJudge= findViewById(R.id.txtTeamJudge);
        final EditText entryMainActivity = findViewById(R.id.txtEntryMain);


        databaseReference= FirebaseDatabase.getInstance().getReference().child("PracticeESS");
        retrieveInformationFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // figure out why database is not connecting
                // that is having issues compiling, etc
                Toast.makeText(MainActivity.this, entryMainActivity.getText() + "WORKS ", Toast.LENGTH_LONG).show();

            }
        });

        // still need to add a countup timer?
        // still update or add stuff entered by the judges

        classSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // need to set it up with a list of classes
                // see if it will let you do by listview?
                Intent intent = new Intent(MainActivity.this, CSS.class);
                startActivity(intent);
            }
        });


        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strW = null;
                strW = workmanship.getText().toString();
                double dW = Double.parseDouble(strW);
                if (dW < 27 || strW != null) {
                    Toast toast = Toast.makeText(MainActivity.this, "REMINDER: The general rule is that Blue ribbons are given to those projects that score 27 points and above in the workmanship criteria.", Toast.LENGTH_LONG);
                    View toastView = toast.getView();
                    TextView toastMessage = toastView.findViewById(android.R.id.message);
                    toastMessage.setTextSize(25);
                    toastMessage.setTextColor(Color.WHITE);
                    toastMessage.layout(1, 1, 1, 1);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER, 1, 1);
                    toastMessage.setCompoundDrawablePadding(16);
                    toastView.setBackgroundColor(Color.GRAY);
                    toast.show();
                }

            }
        });
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strW = workmanship.getText().toString();
                double dW = Double.parseDouble(strW);
                if (dW > 27) {
                    Toast toast = Toast.makeText(MainActivity.this, "REMINDER: The general rule is that Red ribbons are given to those projects that score less than 27 points in the workmanship criteria.", Toast.LENGTH_LONG);
                    View toastView = toast.getView();
                    TextView toastMessage = toastView.findViewById(android.R.id.message);
                    toastMessage.setTextSize(25);
                    toastMessage.setTextColor(Color.WHITE);
                    toastMessage.layout(1, 1, 1, 1);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER, 1, 1);
                    toastMessage.setCompoundDrawablePadding(16);
                    toastView.setBackgroundColor(Color.GRAY);
                    toast.show();
                }
            }
        });

        workmanship.addTextChangedListener(new TextWatcher() {
            ;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String strWorkmanship = workmanship.getText().toString();
                double dblWorkmanship = Double.parseDouble(strWorkmanship);
                Double pWormanship = (dblWorkmanship / 30);
                String strPercentWormanship = tenth.format(pWormanship);
                percentWorkmanship.setText(strPercentWormanship);
            }

            @Override
            public void afterTextChanged(Editable s) {
                String strWorkmanship = workmanship.getText().toString();
                double dblWorkmanship = Double.parseDouble(strWorkmanship);
                if (dblWorkmanship > 30) {
                    Toast toast = Toast.makeText(MainActivity.this, "The amount entered was over the MAXIMUM AMOUNT allowed in the Workmanship criteria box.", Toast.LENGTH_LONG);
                    View toastView = toast.getView();
                    TextView toastMessage = toastView.findViewById(android.R.id.message);
                    toastMessage.setTextSize(25);
                    toastMessage.setTextColor(Color.WHITE);
                    toastMessage.layout(1, 1, 1, 1);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER, 1, 1);
                    toastMessage.setCompoundDrawablePadding(16);
                    toastView.setBackgroundColor(Color.GRAY);
                    toast.show();

                }
            }
        });

        design.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String strDesign = design.getText().toString();
                double dblDesign = Double.parseDouble(strDesign);
                double pDesign = (dblDesign / 20);
                String strPercentDesign = tenth.format(pDesign);
                percentDesign.setText(strPercentDesign);
            }

            @Override
            public void afterTextChanged(Editable s) {
                String strDesign = design.getText().toString();
                double dblDesign = Double.parseDouble(strDesign);
                if (dblDesign > 20) {
                    Toast toast = Toast.makeText(MainActivity.this, "The amount entered was over the MAXIMUM AMOUNT allowed in the DESIGN AND MATERIAL criteria box.", Toast.LENGTH_LONG);
                    View toastView = toast.getView();
                    TextView toastMessage = toastView.findViewById(android.R.id.message);
                    toastMessage.setTextSize(25);
                    toastMessage.setTextColor(Color.WHITE);
                    toastMessage.layout(1, 1, 1, 1);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER, 1, 1);
                    toastMessage.setCompoundDrawablePadding(16);
                    toastView.setBackgroundColor(Color.GRAY);
                    toast.show();
                }
            }
        });
        documentation.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String strDocumentation = documentation.getText().toString();
                double dblDocumentation = Double.parseDouble(strDocumentation);
                double pDocumentation = (dblDocumentation / 20);
                String strPercentDocumentation = tenth.format(pDocumentation);
                percentDoc.setText(strPercentDocumentation);
            }

            @Override
            public void afterTextChanged(Editable s) {
                String strDocumentation = documentation.getText().toString();
                double dblDocumentation = Double.parseDouble(strDocumentation);
                if (dblDocumentation > 20) {
                    Toast toast = Toast.makeText(MainActivity.this, "The amount entered was over the  MAXIMUM AMOUNT allowed in the DOCUMENTATION AND RESEARCH criteria box.", Toast.LENGTH_LONG);
                    View toastView = toast.getView();
                    TextView toastMessage = toastView.findViewById(android.R.id.message);
                    toastMessage.setTextSize(25);
                    toastMessage.setTextColor(Color.WHITE);
                    toastMessage.layout(1, 1, 1, 1);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER, 1, 1);
                    toastMessage.setCompoundDrawablePadding(16);
                    toastView.setBackgroundColor(Color.GRAY);
                    toast.show();
                }
            }
        });

        presentation.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String strPresentation = presentation.getText().toString();
                double dblPresentation = Double.parseDouble(strPresentation);
                double pPresentation = (dblPresentation / 20);
                String strPercentPresentation = tenth.format(pPresentation);
                percentPresentation.setText(strPercentPresentation);
            }

            @Override
            public void afterTextChanged(Editable s) {
                String strPresentation = presentation.getText().toString();
                double dblPresentation = Double.parseDouble(strPresentation);
                if (dblPresentation > 20) {
                    Toast toast = Toast.makeText(MainActivity.this, "The amount entered was over the MAXIMUM AMOUNT allowed in the PRESENTATION criteria box.", Toast.LENGTH_LONG);
                    View toastView = toast.getView();
                    TextView toastMessage = toastView.findViewById(android.R.id.message);
                    toastMessage.setTextSize(25);
                    toastMessage.setTextColor(Color.WHITE);
                    toastMessage.layout(1, 1, 1, 1);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER, 1, 1);
                    toastMessage.setCompoundDrawablePadding(16);
                    toastView.setBackgroundColor(Color.GRAY);
                    toast.show();
                }
            }
        });

        difficulty.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String strDifficulty = difficulty.getText().toString();
                double dblDifficulty = Double.parseDouble(strDifficulty);
                double pDifficulty = (dblDifficulty / 5);
                String strPercentDifficulty = tenth.format(pDifficulty);
                percentDifficulty.setText(strPercentDifficulty);
            }

            @Override
            public void afterTextChanged(Editable s) {
                String strDifficulty = difficulty.getText().toString();
                double dblDifficulty = Double.parseDouble(strDifficulty);
                if (dblDifficulty > 5) {
                    Toast toast = Toast.makeText(MainActivity.this, "The amount entered was over the MAXIMUM AMOUNT allowed in the DIFFICULTY criteria box.", Toast.LENGTH_LONG);
                    View toastView = toast.getView();
                    TextView toastMessage = toastView.findViewById(android.R.id.message);
                    toastMessage.setTextSize(25);
                    toastMessage.setTextColor(Color.WHITE);
                    toastMessage.layout(1, 1, 1, 1);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER, 1, 1);
                    toastMessage.setCompoundDrawablePadding(16);
                    toastView.setBackgroundColor(Color.GRAY);
                    toast.show();
                }
            }
        });

        safety.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String strSafety = safety.getText().toString();
                double dblSafety = Double.parseDouble(strSafety);
                double pSafety = (dblSafety / 5);
                String strPercentSafety = tenth.format(pSafety);
                percentSafety.setText(strPercentSafety);
            }

            @Override
            public void afterTextChanged(Editable s) {
                String strSafety = safety.getText().toString();
                double dblSafety = Double.parseDouble(strSafety);
                if (dblSafety > 5) {
                    Toast toast = Toast.makeText(MainActivity.this, "The amount entered was over the MAXIMUM AMOUNT allowed in the SAFETY criteria box.", Toast.LENGTH_LONG);
                    View toastView = toast.getView();
                    TextView toastMessage = toastView.findViewById(android.R.id.message);
                    toastMessage.setTextSize(25);
                    toastMessage.setTextColor(Color.WHITE);
                    toastMessage.layout(1, 1, 1, 1);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER, 1, 1);
                    toastMessage.setCompoundDrawablePadding(16);
                    toastView.setBackgroundColor(Color.GRAY);
                    toast.show();
                }
            }
        });


        instruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Instruction.class);
                startActivity(intent);
            }
        });


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String strDesign = design.getText().toString();
                String strDocumentation = documentation.getText().toString();
                String strKnowledge = presentation.getText().toString();
                String strDifficulty = difficulty.getText().toString();
                String strSafety = safety.getText().toString();
                String strWorkmanship = workmanship.getText().toString();

                double dblWorkmanship = 0.0;
                double dblDesign = 0.0;
                double dblDocumentation = 0.0;
                double dblKnowledge = 0.0;
                double dblDifficulty = 0.0;
                double dblSafety = 0.0;

                try {
                    dblWorkmanship = Double.parseDouble(strWorkmanship);
                    dblDesign = Double.parseDouble(strDesign);
                    dblDocumentation = Double.parseDouble(strDocumentation);
                    dblKnowledge = Double.parseDouble(strKnowledge);
                    dblSafety = Double.parseDouble(strSafety);
                    dblDifficulty = Double.parseDouble(strDifficulty);


                    if (dblWorkmanship <= 30 && dblDesign <= 20 && dblDocumentation <= 20 && dblKnowledge <= 20 && dblDifficulty <= 5 && dblSafety <= 5) {

                        total = dblWorkmanship + dblDesign + dblDocumentation + dblKnowledge + dblDifficulty + dblSafety;

                        Double pW = (dblWorkmanship / 30);
                        Double pD = (dblDesign / 20);
                        Double pDO = (dblDocumentation / 20);
                        Double pKP = (dblKnowledge / 20);
                        Double pDIF = (dblDifficulty / 5);
                        Double dS = (dblSafety / 5);

                        String sPW = tenth.format(pW);
                        String sPD = tenth.format(pD);
                        String sPDO = tenth.format(pDO);
                        String sPKP = tenth.format(pKP);
                        String sPDIF = tenth.format(pDIF);
                        String sDS = tenth.format(dS);


                        percentWorkmanship.setText(sPW);
                        percentDesign.setText(sPD);
                        percentDoc.setText(sPDO);
                        percentPresentation.setText(sPDO);
                        percentDifficulty.setText(sPDIF);
                        percentSafety.setText(sDS);

                        percentTotal = (pW + pD + pDO + pKP + pDIF + dS) / 6;
                        String pT = tenth.format(percentTotal);
                        totalV.setText(total.toString());
                    } else {
                        totalV.setText("");
                    }
                } catch (Exception ex) {
                    Toast toast = Toast.makeText(MainActivity.this, "Must enter at least a 0 in all criteria boxes.", Toast.LENGTH_LONG);
                    View toastView = toast.getView();
                    TextView toastMessage = toastView.findViewById(android.R.id.message);
                    toastMessage.setTextSize(25);
                    toastMessage.setTextColor(Color.WHITE);
                    toastMessage.layout(1, 1, 1, 1);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER, 1, 1);
                    toastMessage.setCompoundDrawablePadding(16);
                    toastView.setBackgroundColor(Color.GRAY);
                    toast.show();
                    totalV.setText("");
                }


            }

        });





    }
}