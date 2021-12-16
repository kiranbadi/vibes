package com.vibes.kb.model;


import java.util.List;
import java.util.Objects;

// sms-sender:+15105550102, sms-recipient:+15105550101,+15105550104, body: I'm outside
public class SMSModel {

    private String smsSender;
    private List<String> smsRecipient;
    private String smsBody;


    public String getSmsSender() {
        return smsSender;
    }

    public void setSmsSender(String smsSender) {
        this.smsSender = smsSender;
    }

    public List<String> getSmsRecipient() {
        return smsRecipient;
    }

    public void setSmsRecipient(List<String> smsRecipient) {
        this.smsRecipient = smsRecipient;
    }

    public String getSmsBody() {
        return smsBody;
    }

    public void setSmsBody(String smsBody) {
        this.smsBody = smsBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SMSModel)) return false;
        SMSModel smsModel = (SMSModel) o;
        return smsSender.equals(smsModel.smsSender) && smsRecipient.equals(smsModel.smsRecipient) && smsBody.equals(smsModel.smsBody);
    }

    @Override
    public int hashCode() {
        return Objects.hash(smsSender, smsRecipient, smsBody);
    }

    @Override
    public String toString() {
        return "SMSModel{" +
                "smsSender='" + smsSender + '\'' +
                ", smsRecipient=" + smsRecipient +
                ", smsBody='" + smsBody + '\'' +
                '}';
    }
}
