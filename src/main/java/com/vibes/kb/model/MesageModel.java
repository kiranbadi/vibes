package com.vibes.kb.model;

import java.util.Objects;

public class MesageModel {

    public String user;
    public String mobile;
    public int smsReceived;
    public int smsSend;
    public int pushReceived;

    public MesageModel() {
    }

    public MesageModel(String user, int smsReceived, int smsSend, int pushReceived) {
        this.user = user;
        this.smsReceived = smsReceived;
        this.smsSend = smsSend;
        this.pushReceived = pushReceived;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getSmsReceived() {
        return smsReceived;
    }

    public void setSmsReceived(int smsReceived) {
        this.smsReceived = smsReceived;
    }

    public int getSmsSend() {
        return smsSend;
    }

    public void setSmsSend(int smsSend) {
        this.smsSend = smsSend;
    }

    public int getPushReceived() {
        return pushReceived;
    }

    public void setPushReceived(int pushReceived) {
        this.pushReceived = pushReceived;
    }

    @Override
    public String toString() {
        return "MesageModel{" +
                "user='" + user + '\'' +
                ", mobile='" + mobile + '\'' +
                ", smsReceived=" + smsReceived +
                ", smsSend=" + smsSend +
                ", pushReceived=" + pushReceived +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MesageModel)) return false;
        MesageModel that = (MesageModel) o;
        return user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}
