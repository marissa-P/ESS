package edu.txstate.ess;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class TeamAdapterTwo extends BaseAdapter {


    public ArrayList<Team> teamArrayList;
    Activity activity;

    public TeamAdapterTwo(Activity activity, ArrayList<Team> teamArrayList) {
        super();
        this.activity = activity;
        this.teamArrayList = teamArrayList;
    }

    @Override
    public int getCount() {
        return teamArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return teamArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {

        CheckBox cbFinal;
        TextView sEntry;
        TextView sWorkmanship;
        TextView sDesign;
        TextView sDocumentation;
        TextView sPresenation;
        TextView sDifficulty;
        TextView sSafety;
        TextView sTotal;
        TextView sRibbon;
        TextView sTeamJudge;
        TextView sProjectName;
        TextView sNotes;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final TeamAdapterTwo.ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_row, null);
            holder = new TeamAdapterTwo.ViewHolder();
            holder.cbFinal = convertView.findViewById(R.id.cbFinalCSS);
            holder.sNotes = convertView.findViewById(R.id.notes);
            holder.sEntry = convertView.findViewById(R.id.entry);
            holder.sProjectName = convertView.findViewById(R.id.project);
            holder.sWorkmanship = convertView.findViewById(R.id.workmanship);
            holder.sDesign = convertView.findViewById(R.id.design);
            holder.sDocumentation = convertView.findViewById(R.id.documentation);
            holder.sPresenation = convertView.findViewById(R.id.presenation);
            holder.sDifficulty = convertView.findViewById(R.id.difficulty);
            holder.sSafety = convertView.findViewById(R.id.safety);
            holder.sTotal = convertView.findViewById(R.id.total);
            holder.sRibbon = convertView.findViewById(R.id.ribbon);
            holder.sTeamJudge = convertView.findViewById(R.id.teamJudge);
            convertView.setTag(holder);
        } else {
            holder = (TeamAdapterTwo.ViewHolder) convertView.getTag();
        }

        final Team team = teamArrayList.get(position);
        holder.sEntry.setText(team.getEntryNumber());
        holder.sProjectName.setText(team.getProjectName());
        holder.sWorkmanship.setText(Integer.toString(team.getWorkmanship()));
        holder.sDesign.setText(Integer.toString(team.getDesign()));
        holder.sDocumentation.setText(Integer.toString(team.getDocumnetation()));
        holder.sPresenation.setText(Integer.toString(team.getPresentation()));
        holder.sDifficulty.setText(Integer.toString(team.getDifficulty()));
        holder.sSafety.setText(Integer.toString(team.getSafety()));
        holder.sTotal.setText(Integer.toString(team.getTotalPoints()));
        holder.sRibbon.setText(team.getRibbon());
        holder.sTeamJudge.setText(team.getTeamJudgeNumber());
        holder.sNotes.setText(team.getNotes());

        if (team.getTeamJudgeNumber().equals("1")) {
            convertView.setBackgroundColor(Color.RED);
        }

        if (team.isChecked()) {
            holder.cbFinal.setChecked(true);
        } else {
            holder.cbFinal.setChecked(false);
        }

        if (team.getTeamJudgeNumber().equals("2")) {

        }
        return convertView;
    }

    public ArrayList<Team> getTeamArrayList() {
        return teamArrayList;
    }

    public void setCheckBox(int position) {
        Team team = teamArrayList.get(position);
        team.setChecked(!team.isChecked());
        notifyDataSetChanged();
    }
}