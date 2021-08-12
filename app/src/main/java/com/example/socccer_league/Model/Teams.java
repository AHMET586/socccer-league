package com.example.socccer_league.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "teams", indices = @Index(value = {"id"},unique = true))
public class Teams {

    @PrimaryKey(autoGenerate = true)
    private int teamId;

    @SerializedName("id")
    @ColumnInfo(name = "id")
    private int id;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String name;

    @SerializedName("short_code")
    @ColumnInfo(name = "short_code")
    private String shortCode;

    @SerializedName("founded")
    @ColumnInfo(name = "founded")
    private int founded;

    @SerializedName("logo_path")
    @ColumnInfo(name = "logo_path")
    private String logo;

    @SerializedName("department_name")
    @ColumnInfo(name = "department_name")
    private String departmentName;

    public Teams(int id, String name, String shortCode, int founded, String logo, String departmentName) {
        this.id = id;
        this.name = name;
        this.shortCode = shortCode;
        this.founded = founded;
        this.logo = logo;
        this.departmentName = departmentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "Teams{" +
                "teamId=" + teamId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", shortCode='" + shortCode + '\'' +
                ", founded=" + founded +
                ", logo='" + logo + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
