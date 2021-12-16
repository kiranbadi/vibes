package com.vibes.kb.model;

import java.util.List;
import java.util.Objects;

public class PushModel {

    private List<String> pushRecipient;

    private String pushBody;

    public List<String> getPushRecipient() {
        return pushRecipient;
    }

    public void setPushRecipient(List<String> pushRecipient) {
        this.pushRecipient = pushRecipient;
    }

    public String getPushBody() {
        return pushBody;
    }

    public void setPushBody(String pushBody) {
        this.pushBody = pushBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PushModel)) return false;
        PushModel pushModel = (PushModel) o;
        return pushRecipient.equals(pushModel.pushRecipient) && pushBody.equals(pushModel.pushBody);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pushRecipient, pushBody);
    }

    @Override
    public String toString() {
        return "PushModel{" +
                "pushRecipient=" + pushRecipient +
                ", pushBody='" + pushBody + '\'' +
                '}';
    }
}
