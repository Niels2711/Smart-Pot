
package com.example.plantname.modelsPexels;

import com.example.plantname.modelsTrefle.data;

import java.util.List;

public class Photos {
    private int total_results;
    private int page;
    private int per_page;
    private List<Photo> photos;
    private String next_page;
    public void setTotal_results(int total_results){
        this.total_results = total_results;
    }
    public int getTotal_results(){
        return this.total_results;
    }
    public void setPage(int page){
        this.page = page;
    }
    public int getPage(){
        return this.page;
    }
    public void setPer_page(int per_page){
        this.per_page = per_page;
    }
    public int getPer_page(){
        return this.per_page;
    }
    public void setPhotos(List<Photo> photos){
        this.photos = photos;
    }
    public List<Photo> getPhotos(){
        return this.photos;
    }
    public void setNext_page(String next_page){
        this.next_page = next_page;
    }
    public String getNext_page(){
        return this.next_page;
    }
}
