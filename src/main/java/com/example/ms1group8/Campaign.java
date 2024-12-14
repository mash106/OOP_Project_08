package com.example.ms1group8;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Campaign {
    private final SimpleStringProperty campaignName;
    private final SimpleStringProperty status;
    private final SimpleStringProperty roi;


    public Campaign(String campaignName, String status, String roi) {
        this.campaignName = new SimpleStringProperty(campaignName);
        this.status = new SimpleStringProperty(status);
        this.roi = new SimpleStringProperty(roi);
    }


    public String getCampaignName() {
        return campaignName.get();
    }

    public void setCampaignName(String campaignName) {
        this.campaignName.set(campaignName);
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getRoi() {
        return roi.get();
    }

    public void setRoi(String roi) {
        this.roi.set(roi);
    }


    public SimpleStringProperty campaignNameProperty() {
        return campaignName;
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public SimpleStringProperty roiProperty() {
        return roi;
    }
}