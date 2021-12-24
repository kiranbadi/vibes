package com.vibes.kb.helper;


import com.vibes.kb.model.SMSModel;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
sms-sender:+15105550102, sms-recipient:+15105550101,+15105550104, body: I'm outside
 */

public class SMSHelper {

    private SMSModel smsModel;

    List<String> smsReceiver = null;

    public SMSModel getSMSInformation(String smsMessage)
    {

        smsMessage = smsMessage.replace("+","");
        smsModel = new SMSModel();
        String[] smsArray = smsMessage.split(", ");
        // populate the smspojo
        String[] smsSenderArray = smsArray[0].split(":");
        String smsSender = smsSenderArray[1];
        smsModel.setSmsSender(smsSender);
        String[] smsReceiverList = smsArray[1].split(":|\\,");
        smsReceiver = Arrays.stream(smsReceiverList, 1, smsReceiverList.length).collect(Collectors.toList());
        smsModel.setSmsRecipient(smsReceiver);
        String[] smsBodyArray = smsArray[2].split(":");
        String smsBody = smsBodyArray[1].trim();
        smsModel.setSmsBody(smsBody);
     return smsModel;
    }

}
