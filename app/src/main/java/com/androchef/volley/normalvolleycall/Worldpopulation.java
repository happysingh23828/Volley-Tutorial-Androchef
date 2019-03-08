
package com.androchef.volley.normalvolleycall;

import com.google.gson.annotations.SerializedName;

public class Worldpopulation {

    @SerializedName("country")
    private String mCountry;
    @SerializedName("flag")
    private String mFlag;
    @SerializedName("population")
    private String mPopulation;
    @SerializedName("rank")
    private Long mRank;

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getFlag() {
        return mFlag;
    }

    public void setFlag(String flag) {
        mFlag = flag;
    }

    public String getPopulation() {
        return mPopulation;
    }

    public void setPopulation(String population) {
        mPopulation = population;
    }

    public Long getRank() {
        return mRank;
    }

    public void setRank(Long rank) {
        mRank = rank;
    }

}
