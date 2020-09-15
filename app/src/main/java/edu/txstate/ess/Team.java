package edu.txstate.ess;

import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;

import androidx.annotation.Nullable;

import org.json.JSONException;
import org.json.JSONObject;

public class Team implements Comparable<Team> {
    String teamJudgeNumber;
    String entryNumber;
    Integer totalPoints;
    Integer workmanship;
    Integer design;
    Integer documnetation;
    Integer presentation;
    Integer difficulty;
    Integer safety;
    String ribbon;
    Boolean finalCSS;
    String projectName;
    String notes;

    public Team(JSONObject object) {
        try {
            this.teamJudgeNumber = object.getString("TeamJudge");
            this.entryNumber = object.getString("Entry");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Team(String teamJudgeNumber, String entryNumber, Integer totalPoints, Integer workmanship, Integer design, Integer documnetation, Integer presentation, Integer difficulty, Integer safety, String ribbon, Boolean finalCSS, String projectName, String notes) {
        this.teamJudgeNumber = teamJudgeNumber;
        this.entryNumber = entryNumber;
        this.totalPoints = totalPoints;
        this.workmanship = workmanship;
        this.design = design;
        this.documnetation = documnetation;
        this.presentation = presentation;
        this.difficulty = difficulty;
        this.safety = safety;
        this.ribbon = ribbon;
        this.finalCSS = finalCSS;
        this.projectName = projectName;
        this.notes = notes;
    }


    public Team() {
    }


    public Boolean getFinalCSS() {
        return finalCSS;
    }

    public void setFinalCSS(Boolean finalCSS) {
        this.finalCSS = finalCSS;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public boolean isChecked() {
        return this.finalCSS;
    }

    public void setChecked(boolean flag) {
        this.finalCSS = flag;
    }

    @Override
    public int compareTo(Team workmanship) {
        return this.entryNumber.compareTo(workmanship.entryNumber);
    }

    public Integer getWorkmanship() {
        return workmanship;
    }

    public void setWorkmanship(Integer workmanship) {
        this.workmanship = workmanship;
    }

    public Integer getDesign() {
        return design;
    }

    public void setDesign(Integer design) {
        this.design = design;
    }

    public Integer getDocumnetation() {
        return documnetation;
    }

    public void setDocumnetation(Integer documnetation) {
        this.documnetation = documnetation;
    }

    public Integer getPresentation() {
        return presentation;
    }

    public void setPresentation(Integer presentation) {
        this.presentation = presentation;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getSafety() {
        return safety;
    }

    public void setSafety(Integer safety) {
        this.safety = safety;
    }

    public String getRibbon() {
        return ribbon;
    }

    public void setRibbon(String ribbon) {
        this.ribbon = ribbon;
    }


    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public String getTeamJudgeNumber() {
        return teamJudgeNumber;
    }

    public void setTeamJudgeNumber(String teamJudgeNumber) {
        this.teamJudgeNumber = teamJudgeNumber;
    }

    public String getEntryNumber() {
        return entryNumber;
    }

    public void setEntryNumber(String entryNumber) {
        this.entryNumber = entryNumber;
    }

    public String toString() {
        return teamJudgeNumber;
    }

}

