
package com.example.plantname.modelsTrefle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("data")
    @Expose
    private List<Plants> data;
    @SerializedName("links")
    @Expose
    private Links_ links;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    public List<Plants> getData() {
        return data;
    }

    public void setData(List<Plants> data) {
        this.data = data;
    }

    public Links_ getLinks() {
        return links;
    }

    public void setLinks(Links_ links) {
        this.links = links;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
