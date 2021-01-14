
package com.example.plantname.modelsPexels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photo {
    private int id;
    private int width;
    private int height;
    private String url;
    private String photographer;
    private String photographer_url;
    private int photographer_id;
    private String avg_color;
    private Src src;
    private boolean liked;
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public int getWidth(){
        return this.width;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getHeight(){
        return this.height;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return this.url;
    }
    public void setPhotographer(String photographer){
        this.photographer = photographer;
    }
    public String getPhotographer(){
        return this.photographer;
    }
    public void setPhotographer_url(String photographer_url){
        this.photographer_url = photographer_url;
    }
    public String getPhotographer_url(){
        return this.photographer_url;
    }
    public void setPhotographer_id(int photographer_id){
        this.photographer_id = photographer_id;
    }
    public int getPhotographer_id(){
        return this.photographer_id;
    }
    public void setAvg_color(String avg_color){
        this.avg_color = avg_color;
    }
    public String getAvg_color(){
        return this.avg_color;
    }
    public void setSrc(Src src){
        this.src = src;
    }
    public Src getSrc(){
        return this.src;
    }
    public void setLiked(boolean liked){
        this.liked = liked;
    }
    public boolean getLiked(){
        return this.liked;
    }
}
