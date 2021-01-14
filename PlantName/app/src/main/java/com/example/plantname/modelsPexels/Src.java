
package com.example.plantname.modelsPexels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Src {

    private String original;
    private String large2x;
    private String large;
    private String medium;
    private String small;
    private String portrait;
    private String landscape;
    private String tiny;
    public void setOriginal(String original){
        this.original = original;
    }
    public String getOriginal(){
        return this.original;
    }
    public void setLarge2x(String large2x){
        this.large2x = large2x;
    }
    public String getLarge2x(){
        return this.large2x;
    }
    public void setLarge(String large){
        this.large = large;
    }
    public String getLarge(){
        return this.large;
    }
    public void setMedium(String medium){
        this.medium = medium;
    }
    public String getMedium(){
        return this.medium;
    }
    public void setSmall(String small){
        this.small = small;
    }
    public String getSmall(){
        return this.small;
    }
    public void setPortrait(String portrait){
        this.portrait = portrait;
    }
    public String getPortrait(){
        return this.portrait;
    }
    public void setLandscape(String landscape){
        this.landscape = landscape;
    }
    public String getLandscape(){
        return this.landscape;
    }
    public void setTiny(String tiny){
        this.tiny = tiny;
    }
    public String getTiny(){
        return this.tiny;
    }

}
