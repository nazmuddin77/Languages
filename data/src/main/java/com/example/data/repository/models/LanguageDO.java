
package com.example.data.repository.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LanguageDO {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("icon")
    @Expose
    private String icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}
