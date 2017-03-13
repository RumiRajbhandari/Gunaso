package com.example.root.gunaso;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by user on 10/4/2016.
 */
public class ContratorModel implements Serializable {
    @SerializedName("Contract Name")
    public String title;
    @SerializedName("Awarded To")

    public String awarded;
    @SerializedName("Contract Date")

    public String contract_date;
    @SerializedName("Completion Date")

    public String completion_date;
    @SerializedName("Contract Amount")

    public  String contract_amount;


    public ContratorModel(String title, String awarded, String contract_date, String completion_date, String contract_amount) {
        this.title = title;
        this.awarded = awarded;
        this.contract_date = contract_date;
        this.completion_date = completion_date;
        this.contract_amount = contract_amount;
    }

    public String getContract_date() {
        return contract_date;
    }

    public void setContract_date(String contract_date) {
        this.contract_date = contract_date;
    }

    public String getAwarded() {
        return awarded;
    }

    public void setAwarded(String awarded) {
        this.awarded = awarded;
    }

    public String getCompletion_date() {
        return completion_date;
    }

    public void setCompletion_date(String completion_date) {
        this.completion_date = completion_date;
    }

    public String getContract_amount() {
        return contract_amount;
    }

    public void setContract_amount(String contract_amount) {
        this.contract_amount = contract_amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
