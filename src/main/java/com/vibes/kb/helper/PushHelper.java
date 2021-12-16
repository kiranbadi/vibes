package com.vibes.kb.helper;


import com.vibes.kb.model.PushModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//push-recipient:+15105550101,+15105550102, body: open our app to see our new updates
public class PushHelper {

    private PushModel pushModel;

    public PushModel getPushInformation(String pushMessage)
    {
        pushMessage = pushMessage.replace("+","");
        pushModel = new PushModel();
        String[] pushArray = pushMessage.split(", "); // TODO: ugly way to do it need to figure some other way
    //    System.out.println("PushArray: " + Arrays.toString(pushArray));
        int len = pushArray.length;
        String[] pushReceiverList = pushArray[0].split((":|\\,"));
      //      System.out.println("pushReceiverList: " + Arrays.toString(pushReceiverList));
            List<String> pushReceiver = Stream.of(pushReceiverList).collect(Collectors.toCollection(ArrayList::new));
            pushReceiver.remove(0);
            pushModel.setPushRecipient(pushReceiver);
            String[] pushBodyArray = pushArray[1].split(":");
      //      System.out.println("pushBodyArray: " + Arrays.toString(pushBodyArray));
            String pushBody = pushBodyArray[1];
            pushModel.setPushBody(pushBody);
        return pushModel;
    }
}
