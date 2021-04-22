package test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class TestUtils {
    public ArrayList<LinkedHashMap<String, String>>
    buildArrayList(int totalHashMaps) {
        ArrayList<LinkedHashMap<String, String>> arrayList = new ArrayList<>();
        for (int i = 0; i < totalHashMaps; i++) {
            LinkedHashMap hashMap = new LinkedHashMap();
            hashMap.put("Book Id", getRandomInt(0, 20));
            hashMap.put("Book Name", getRandomString(10));
            hashMap.put("Book Publisher", getRandomString(10));
            hashMap.put("Book Genre", getRandomString(10));
            hashMap.put("Published Date", getRandomInt(0, 9999));
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    public ArrayList<LinkedHashMap<String,String>> buildTestArrayList(){
        ArrayList<LinkedHashMap<String,String>> arrayList = new ArrayList<>();

        LinkedHashMap hashMapMap1 = new LinkedHashMap();
        hashMapMap1.put("Book Id","1");
        hashMapMap1.put("Book Name","pablo");
        hashMapMap1.put("Book Publisher","escabar");
        hashMapMap1.put("Published Date","2001");

        LinkedHashMap hashMapMap2 = new LinkedHashMap();
        hashMapMap2.put("Book Id","2");
        hashMapMap2.put("Book Name","laminate");
        hashMapMap2.put("Book Publisher","sijan");
        hashMapMap2.put("Published Date","1996");

        LinkedHashMap hashMapMap3 = new LinkedHashMap();
        hashMapMap3.put("Book Id","3");
        hashMapMap3.put("Book Name","see you");
        hashMapMap3.put("Book Publisher","sandesh");
        hashMapMap3.put("Published Date","2020");


        LinkedHashMap hashMapMap4 = new LinkedHashMap();
        hashMapMap4.put("Book Id","4");
        hashMapMap4.put("Book Name","lame");
        hashMapMap4.put("Book Publisher","ujjwal");
        hashMapMap4.put("Published Date","2021");

        arrayList.add(hashMapMap1);
        arrayList.add(hashMapMap2);
        arrayList.add(hashMapMap3);
        arrayList.add(hashMapMap4);

        return arrayList;

    }

    public ArrayList<LinkedHashMap<String,String>> expectedAscending(){
        ArrayList<LinkedHashMap<String,String>> arrayList = new ArrayList<>();


        LinkedHashMap hashMapMap1 = new LinkedHashMap();
        hashMapMap1.put("Book Id","1");
        hashMapMap1.put("Book Name","pablo");
        hashMapMap1.put("Book Publisher","escabar");
        hashMapMap1.put("Published Date","2001");



        LinkedHashMap hashMapMap2 = new LinkedHashMap();
        hashMapMap2.put("Book Id","2");
        hashMapMap2.put("Book Name","laminate");
        hashMapMap2.put("Book Publisher","sijan");
        hashMapMap2.put("Published Date","1996");


        LinkedHashMap hashMapMap3 = new LinkedHashMap();
        hashMapMap3.put("Book Id","3");
        hashMapMap3.put("Book Name","see you");
        hashMapMap3.put("Book Publisher","sandesh");
        hashMapMap3.put("Published Date","2020");





        LinkedHashMap hashMapMap4 = new LinkedHashMap();
        hashMapMap4.put("Book Id","4");
        hashMapMap4.put("Book Name","lame");
        hashMapMap4.put("Book Publisher","ujjwal");
        hashMapMap4.put("Published Date","2021");
        arrayList.add(hashMapMap1);
        arrayList.add(hashMapMap2);

        arrayList.add(hashMapMap3);
        arrayList.add(hashMapMap4);

        return arrayList;

    }

    public ArrayList<LinkedHashMap<String,String>> expectedDescending(){
        ArrayList<LinkedHashMap<String,String>> arrayList = new ArrayList<>();



        LinkedHashMap hashMapMap4 = new LinkedHashMap();
        hashMapMap4.put("Book Id","4");
        hashMapMap4.put("Book Name","lame");
        hashMapMap4.put("Book Publisher","ujjwal");
        hashMapMap4.put("Published Date","2021");


        LinkedHashMap hashMapMap3 = new LinkedHashMap();
        hashMapMap3.put("Book Id","3");
        hashMapMap3.put("Book Name","see you");
        hashMapMap3.put("Book Publisher","sandesh");
        hashMapMap3.put("Published Date","2020");

        LinkedHashMap hashMapMap2 = new LinkedHashMap();
        hashMapMap2.put("Book Id","2");
        hashMapMap2.put("Book Name","laminate");
        hashMapMap2.put("Book Publisher","sijan");
        hashMapMap2.put("Published Date","1996");

        LinkedHashMap hashMapMap1 = new LinkedHashMap();
        hashMapMap1.put("Book Id","1");
        hashMapMap1.put("Book Name","pablo");
        hashMapMap1.put("Book Publisher","escabar");
        hashMapMap1.put("Published Date","2001");







        arrayList.add(hashMapMap4);

        arrayList.add(hashMapMap3);
        arrayList.add(hashMapMap2);
        arrayList.add(hashMapMap1);

        return arrayList;

    }


    public ArrayList<LinkedHashMap<String,String>> expectedPublicationSearchResult(){
        ArrayList<LinkedHashMap<String,String>> arrayList = new ArrayList<>();


        LinkedHashMap hashMapMap1 = new LinkedHashMap();
        hashMapMap1.put("Book Id","1");
        hashMapMap1.put("Book Name","pablo");
        hashMapMap1.put("Book Publisher","escabar");
        hashMapMap1.put("Published Date","2001");

        LinkedHashMap hashMapMap2 = new LinkedHashMap();
        hashMapMap2.put("Book Id","2");
        hashMapMap2.put("Book Name","laminate");
        hashMapMap2.put("Book Publisher","sijan");
        hashMapMap2.put("Published Date","1996");


        LinkedHashMap hashMapMap3 = new LinkedHashMap();
        hashMapMap3.put("Book Id","3");
        hashMapMap3.put("Book Name","see you");
        hashMapMap3.put("Book Publisher","sandesh");
        hashMapMap3.put("Published Date","2020");


        LinkedHashMap hashMapMap4 = new LinkedHashMap();
        hashMapMap4.put("Book Id","4");
        hashMapMap4.put("Book Name","lame");
        hashMapMap4.put("Book Publisher","ujjwal");
        hashMapMap4.put("Published Date","2021");


        arrayList.add(hashMapMap2);



        return arrayList;
    }

    public ArrayList<LinkedHashMap<String,String>> expectedBookNameSearchResult(){
        ArrayList<LinkedHashMap<String,String>> arrayList = new ArrayList<>();


        LinkedHashMap hashMapMap1 = new LinkedHashMap();
        hashMapMap1.put("Book Id","1");
        hashMapMap1.put("Book Name","pablo");
        hashMapMap1.put("Book Publisher","escabar");
        hashMapMap1.put("Published Date","2001");



        arrayList.add(hashMapMap1);

        return arrayList;
    }

    public ArrayList<LinkedHashMap<String,String>> expectedPublishedYearSearchResult(){
        ArrayList<LinkedHashMap<String,String>> arrayList = new ArrayList<>();

        LinkedHashMap hashMapMap2 = new LinkedHashMap();
        hashMapMap2.put("Book Id","2");
        hashMapMap2.put("Book Name","laminate");
        hashMapMap2.put("Book Publisher","sijan");
        hashMapMap2.put("Published Date","1996");
        arrayList.add(hashMapMap2);


        return arrayList;
    }

    public String getRandomString(int strLength) {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(strLength);

        for (int i = 0; i < strLength; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
