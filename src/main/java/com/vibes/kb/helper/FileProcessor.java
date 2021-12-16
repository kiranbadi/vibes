package com.vibes.kb.helper;

import com.vibes.kb.model.MesageModel;
import com.vibes.kb.model.PushModel;
import com.vibes.kb.model.SMSModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class FileProcessor {

    // we can use memory byte buffer for large files if required
    public List<MesageModel> readFile(String FILE_PATH) throws FileNotFoundException {
        List<MesageModel> counts = getUsersModel();
        List<String> smsReceiverList ;
        List<String> pushReceiverList;
        //    System.out.println("counts : \n" + counts);
        Scanner scanner = new Scanner(new File(FILE_PATH));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // process the line
            //    System.out.println(line);
            // check if the line is for sms or push message
            if (line.startsWith("sms-sender")) {
                SMSModel smsModel = new SMSModel();
                SMSHelper smsHelper = new SMSHelper();
                smsModel = smsHelper.getSMSInformation(line);
                String smsSender = smsModel.getSmsSender();
                smsReceiverList = smsModel.getSmsRecipient();
                int s = smsReceiverList.size();
                for (MesageModel count : counts) {
                    // check all objects for mobile and increment accordingly 3 parameters in the object
                    String userMobile = count.getMobile();
                    if (userMobile.equals(smsSender)) {
                        int smsSend = count.getSmsSend();
                        smsSend = smsSend + 1;
                        count.setSmsSend(smsSend);
                    }

                    for(int k =0 ; k < s; k++)
                    {
                       if (smsReceiverList.get(k).equals(userMobile)) {
                            int smsReceived = count.getSmsReceived();
                            smsReceived = smsReceived + 1;
                            count.setSmsReceived(smsReceived);
                        }
                    }

                }

            } else {
                PushModel pushModel = new PushModel();
                PushHelper pushHelper = new PushHelper();
                pushModel = pushHelper.getPushInformation(line);
                pushReceiverList = pushModel.getPushRecipient();
                int p = pushReceiverList.size();
                for (MesageModel count : counts) {
                    // check all objects for mobile and increment accordingly 3 parameters in the object
                    String userMobile = count.getMobile();
                    for(int k =0 ; k < p; k++)
                    {
                        if (pushReceiverList.get(k).equals(userMobile)) {
                            int pushReceived = count.getPushReceived();
                            pushReceived = pushReceived + 1;
                            count.setPushReceived(pushReceived);
                        }
                    }

                }
            }


        }
        return counts;
    }

    public void printMessages(List<MesageModel> countList)
    {
     //   countList.forEach(System.out::println);
        List<MesageModel> DupsList = new ArrayList<>();
        List<MesageModel> NonDupsList = new ArrayList<>();
        List<MesageModel> MergedList = new ArrayList<>();
        MesageModel uniqueModel = new MesageModel();
        NonDupsList = countList.stream().distinct().collect(Collectors.toList());
        DupsList = countList.stream()
                .collect(Collectors.groupingBy(MesageModel -> MesageModel.getUser(),Collectors.toList()))
                        .values()
                                .stream()
                                        .filter(i->i.size() > 1)
                                                .flatMap(j ->j.stream())
                                                        .collect(Collectors.toList());
        String user = DupsList.stream().map(x->x.getUser()).distinct().collect(Collectors.joining(", "));
        uniqueModel.setUser(user);
        List<String> mobile = DupsList.stream().map(x->x.getMobile()).collect(Collectors.toList());
        uniqueModel.setMobile(mobile.toString());
        Integer smsReceived = DupsList.stream().map(x-> x.getSmsReceived()).reduce(0,ArthimaticProp::add);
        uniqueModel.setSmsReceived(smsReceived);
        Integer smsSend = DupsList.stream().map(x-> x.getSmsSend()).reduce(0,ArthimaticProp::add);
        uniqueModel.setSmsSend(smsSend);
        Integer pushRecevied = DupsList.stream().map(x-> x.getPushReceived()).reduce(0,ArthimaticProp::add);
        uniqueModel.setPushReceived(pushRecevied);
     //   System.out.println("user : " + user + "mobile : " + mobile + " smsReceived -" + smsReceived + " smsSend -" + smsSend + " pushRecevied - " + pushRecevied);
        MergedList.add(uniqueModel);
        for(int i =0; i < NonDupsList.size(); i++)
        {

            if(!NonDupsList.get(i).getUser().contains(user))
            {
                MergedList.add(NonDupsList.get(i));
            }

        }
       // System.out.println(MergedList);

        PrintStatusMessagesForUser(MergedList);

    }

    static void PrintStatusMessagesForUser(List<MesageModel>  finalList)
    {
        for(int i = 0; i < finalList.size(); i++)
        {
            System.out.println(finalList.get(i).getUser() + " sent " + finalList.get(i).getSmsSend() + " SMS Messages " + " , received " +  finalList.get(i).getSmsReceived() + " SMS Messages" + " , and received " +  finalList.get(i).getPushReceived() + " push messages");

        }

    }

    // can be abstracted away in the from main method
    public static List<MesageModel> getDuplicates(List<MesageModel> countList)

    {
        List<MesageModel> DupsList = null;
        DupsList = countList.stream()
                .collect(Collectors.groupingBy(MesageModel -> MesageModel.getUser(),Collectors.toList()))
                .values()
                .stream()
                .filter(i->i.size() > 1)
                .flatMap(j ->j.stream())
                .collect(Collectors.toList());

        return DupsList;
    }


    // we can get user info from file and this is more for testng purpose
    public static List<MesageModel> getUsersModel() {
        List<MesageModel> m = new ArrayList<>();
        MesageModel mo = null;
        HashMap<String, String> users = new HashMap<>();
        users.put("15105550101", "Jessie");
        users.put("15105550102", "Marion");
        users.put("15105550103", "Jackie");
        users.put("15105550104", "Jackie");
        for (Map.Entry<String, String> us : users.entrySet()) {
            mo = new MesageModel();
            mo.setMobile(us.getKey());
            mo.setUser(us.getValue());
            mo.setSmsReceived(0);
            mo.setSmsSend(0);
            mo.setPushReceived(0);
            m.add(mo);
        }

        return m;
    }
}
