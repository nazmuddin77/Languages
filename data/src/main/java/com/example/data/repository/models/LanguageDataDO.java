
package com.example.data.repository.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LanguageDataDO {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("authenticated")
    @Expose
    private Boolean authenticated;
    @SerializedName("response")
    @Expose
    private LanguageResponseDO response;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    public LanguageResponseDO getResponse() {
        return response;
    }

    public void setResponse(LanguageResponseDO response) {
        this.response = response;
    }

}
