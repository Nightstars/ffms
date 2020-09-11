package com.christ.ffms.service;

public class IdCheck {
    public static boolean idCheck(String id){
        boolean isCorrect=false;
        if (id.length()!=18) isCorrect=false;
        int sum=0;
        String  [] test={"1","0","x","9","8","7","6","5","4","3","2"};
        int []test1={0,1,2,3,4,5,6,7,8,9,10};
        String valid = null;
        for(int i=0;i<17;i++){
            sum+=Integer.parseInt(String.valueOf(id.charAt(i)))*Math.pow(2,17-i);
        }
        for(int i=0;i<test.length;i++){
            if(test1[i]==sum%11)  valid=test[i];
        }
        if(valid.equals(String.valueOf(id.charAt(17)))) isCorrect=true;
        return isCorrect;
    }

    public static void main(String[] args) {
        String id="360732199612076113";
        System.out.println(idCheck(id));
    }
}
