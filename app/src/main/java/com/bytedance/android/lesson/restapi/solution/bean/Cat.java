package com.bytedance.android.lesson.restapi.solution.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * @author Xavier.S
 * @date 2019.01.17 18:08
 */
public class Cat {

    // TODO-C1 (1) Implement your Cat Bean here according to the response json
    @SerializedName("breeds")
    private ArrayList<String> list;
    @SerializedName("id")
    private String id;
    @SerializedName("url")
    private  String url;

    public Cat() {
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
