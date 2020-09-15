package edu.txstate.ess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CSS extends AppCompatActivity {
    public ListView listView, listViewTwo;
    ArrayList<Team> teams;
    TeamAdapterTwo adapterTwo;
    Button workmanshipOne, totalOne, knowOne, docOne, finalButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_s_s);

        listView = findViewById(R.id.listViewOne);


        finalButton = findViewById(R.id.txtFinalCSS);
        workmanshipOne = findViewById(R.id.btnWorkmanshipSortOne);
        totalOne = findViewById(R.id.btnTotalSortOne);
        knowOne = findViewById(R.id.btnKnowledgeSortOne);
        docOne = findViewById(R.id.btnDocumentationSortOne);


        teams = new ArrayList<>();
        SetListView();



        totalOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(teams, new Comparator<Team>() {
                    @Override
                    public int compare(Team t1, Team t2) {
                        return t2.getTotalPoints() - t1.getTotalPoints();
                    }
                });
                adapterTwo.notifyDataSetChanged();
            }
        });
        workmanshipOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(teams, new Comparator<Team>() {
                    @Override
                    public int compare(Team t1, Team t2) {
                        return t2.getWorkmanship() - t1.getWorkmanship();
                    }
                });
                adapterTwo.notifyDataSetChanged();
            }
        });
        knowOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(teams, new Comparator<Team>() {
                    @Override
                    public int compare(Team t1, Team t2) {
                        return t2.getPresentation() - t1.getPresentation();
                    }
                });
                adapterTwo.notifyDataSetChanged();
            }
        });
        docOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(teams, new Comparator<Team>() {
                    @Override
                    public int compare(Team t1, Team t2) {
                        return t2.getDocumnetation() - t1.getDocumnetation();
                    }
                });
                adapterTwo.notifyDataSetChanged();
            }
        });

    }

    public void SetListView() {
        Team t1 = null;
        t1 = new Team("2", "10010", 100, 10, 5, 10, 10, 5, 1, "Blue", false, "Tool Box", "");
        teams.add(t1);
        Team t2 = null;
        t2 = null;
        t2 = new Team("2", "10003", 97, 12, 2, 3, 4, 5, 1, "Blue", false, "Rear and Front Bumper", "");
        teams.add(t2);
        Team t3 = null;
        t3 = new Team("2", "11000", 87, 20, 3, 2, 12, 1, 1, "Blue", false, "Tool Box", "");

        teams.add(t3);
        Team t4 = null;
        t4 = null;
        t4 = new Team("2", "12000", 47, 2, 15, 1, 1, 1, 1, "Blue", false, "Reverse Hitch Carrier", "");
        teams.add(t4);

        Team t5 = null;
        t5 = new Team("1", "10010", 17, 19, 5, 10, 10, 1, 1, "Blue", false, "Truck Flatbed", "");
        teams.add(t5);
        Team t6 = null;
        t6 = null;
        t6 = new Team("1", "10003", 25, 19, 2, 3, 4, 5, 1, "Blue", false, "Headache Rack", "");
        teams.add(t6);

        Team t7 = null;
        t7 = new Team("1", "11000", 35, 27, 23, 2, 12, 1, 1, "Blue", false, "Rear Bumper", "");
        teams.add(t7);
        Team t8 = null;
        t8 = null;
        t8 = new Team("1", "12000", 32, 30, 15, 1000, 1, 1, 1, "Blue", false, "Chevy Truck", "");
        teams.add(t8);


        adapterTwo = new TeamAdapterTwo(CSS.this, teams);
        listView.setAdapter(adapterTwo);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapterTwo.setCheckBox(position);
            }
        });


        finalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String entry = "";
                String judge = "";
                String projectName = "";
                String work = "";
                String design = "";
                String doc = "";
                String pres = "";
                String diff = "";
                String saf = "";
                String total = "";
                for (Team hold : adapterTwo.getTeamArrayList()) {
                    if (hold.isChecked()) {
                        entry += "\n" + hold.getEntryNumber();
                        judge += "\n" + hold.getTeamJudgeNumber();
                        projectName += "\n" + hold.getProjectName();
                        work += "\n" + hold.getWorkmanship().toString();
                        design += "\n" + hold.getDesign().toString();
                        doc += "\n" + hold.getDocumnetation().toString();
                        pres += "\n" + hold.getPresentation().toString();
                        diff += "\n" + hold.getDifficulty().toString();
                        saf += "\n" + hold.getSafety().toString();
                        total += "\n" + hold.getTotalPoints().toString();

                    }
                }
                Intent intent = new Intent(CSS.this, FinalCSS.class);
                intent.putExtra("KeyEntry", entry);
                intent.putExtra("KeyJudge", judge);
                intent.putExtra("KeyProjectName", projectName);
                intent.putExtra("KeyWork", work);
                intent.putExtra("KeyDesign", design);
                intent.putExtra("KeyDoc", doc);
                intent.putExtra("KeyPres", pres);
                intent.putExtra("KeyDiff", diff);
                intent.putExtra("KeySaf", saf);
                intent.putExtra("KeyTotal", total);
                startActivity(intent);
            }
        });


    }

}


