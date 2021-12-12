package AirlineFlightSearch1;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;


public class AirlineFlightSearch{
    public static Scanner scn=new Scanner(System.in);
    public static boolean flag=true;
    public static AVLTreeComparable Informations=new AVLTreeComparable();
    public static boolean is=false;

    public static void main(String[] args) throws IOException {
        String select=null;


        File file=new File("Airlineflights.txt");
        Information info1=new Information(LocalDateTime.of(2020,11,15,12,30),"Ankara","Istanbul","THY",235.0);
        Information info2=new Information(LocalDateTime.of(2020,4,15,10,35),"Ankara","Istanbul","THY",235.0);
        Information info3=new Information(LocalDateTime.of(2020,7,20,12,40),"Istanbul","Ankara","THY",235.0);
        Information info4=new Information(LocalDateTime.of(2020,12,15,12,30),"Istanbul","Ankara","THY",235.0);
        Information info5=new Information(LocalDateTime.of(2020,8,15,12,30),"Istanbul","Ankara","THY",120.0);
        Information info6=new Information(LocalDateTime.of(2020,6,15,12,30),"Izmir","Antalya","Pegasus",200.0);
        Informations.put(info1.code,info1);
        Informations.put(info2.code,info2);
        Informations.put(info3.code,info3);
        Informations.put(info4.code,info4);
        Informations.put(info5.code,info5);
        Informations.put(info6.code,info6);


        try{

            FileWriter writer; writer=new FileWriter(file);
            writer.write(info1+"\n");
            writer.write(info2+"\n");
            writer.write(info3+"\n");
            writer.write(info4+"\n");
            writer.write(info5+"\n");
            writer.write(info6+"\n");
            writer.close();

        }catch(FileNotFoundException e){e.printStackTrace();}

        while(flag){
            System.out.println("*************************  FLIGHT INFORMATION *************************");
            Informations.traverseLevelOrder(Informations.root);
            System.out.println();
            System.out.println("Please select one of the menu options... ");
            System.out.println("0. Insert flight information \n"  +
                    "1. Remove flight information\n" +
                    "2. Search for flights by date\n" +
                    "3. Search for flights by from city \n"  +
                    "4. Search for flights with both from city and date. \n"+
                    "5. Search for flights between two dates. \n" +
                    "6. Search for flights less than a given price in a given date\n" +
                    "e. Exit: quits the app.\n");

            select=scn.next();

            switch(select){

                case "0" :insertFlight(); break;
                case "1" : System.out.println("Enter code which flight  you want to remove");
                    int code = scn.nextInt();
                    Informations.delete(code);
                    break;
                case "2" : System.out.println("Enter Flight Month : (01, 02, 09, 11, etc..)");
                    int month=scn.nextInt();
                    System.out.println("Enter Flight Day : (Must be between 1 and 31)");
                    int day=scn.nextInt();
                    System.out.println("Enter Flight Hour : (01, 12, 18, 00, etc..)");
                    int hour=scn.nextInt();
                    System.out.println("Enter minute : (Must be between 0 and 59)");
                    int minute=scn.nextInt();
                    LocalDateTime date=LocalDateTime.of(2020,month,day,hour,minute);
                    System.out.println("Here : ");
                    is=false;
                    searchDate(Informations.root,date);
                    if (!is){
                        AVLNodeComparable diffkey=Informations.root;
                        findClosestDate(Informations.root,date);
                     }

                    break;
                            
                case "3" : System.out.println("Enter city ");
                    String fromcity=scn.next();
                    System.out.println("Here : ");
                    is=false;
                    searchFromCity(Informations.root,fromcity);
                    if(!is){
                        System.out.println("there is no flight");
                    }
                    break;
                case "4" :
                    System.out.println("Enter city");
                    fromcity=scn.next();
                    System.out.println("Enter flight Month : (01, 02, 09, 11, etc..)");
                    month=scn.nextInt();
                    System.out.println("Enter Flight Day : (Must be between 1 and 31)");
                    day=scn.nextInt();
                    System.out.println("Enter Flight Hour : (01, 12, 18, 00, etc..)");
                    hour=scn.nextInt();
                    System.out.println("Enter minute : (Must be between 0 and 59)");
                    minute=scn.nextInt();
                    date=LocalDateTime.of(2020,month,day,hour,minute);
                    System.out.println("Here : ");
                    is=false;
                    searchFromCityAndDate(Informations.root,fromcity,date);
                    if(!is){
                        System.out.println("There is no flight");
                    }
                    break;
                case "5" :  System.out.println("Enter first date's month");
                    int month1=scn.nextInt();
                    System.out.println("Enter first date's day");
                    int day1=scn.nextInt();
                    System.out.println("Enter first date's hour");
                    int hour1=scn.nextInt();
                    System.out.println("Enter first date's minute");
                    int minute1=scn.nextInt();
                    LocalDateTime date1=LocalDateTime.of(2020,month1,day1,hour1,minute1);
                    System.out.println("Enter second date's month");
                    int month2=scn.nextInt();
                    System.out.println("Enter second date's day");
                    int day2=scn.nextInt();
                    System.out.println("Enter second date's hour");
                    int hour2=scn.nextInt();
                    System.out.println("Enter second date's minute");
                    int minute2=scn.nextInt();
                    LocalDateTime date2=LocalDateTime.of(2020,month2,day2,hour2,minute2);
                    is=false;
                    BetweenTwoDates(Informations.root,date1,date2);
                    if(!is){
                        System.out.println("There is no flight");
                    }
                    break;
                case "6" :  System.out.println("Enter The Flight Price : ");
                    Double price=scn.nextDouble();
                    System.out.println("Enter flight Month : (01, 02, 09, 11, etc..)");
                    month=scn.nextInt();
                    System.out.println("Enter Flight Day : (Must be between 1 and 31)");
                    day=scn.nextInt();
                    System.out.println("Enter Flight Hour : (01, 12, 18, 00, etc..)");
                    hour=scn.nextInt();
                    System.out.println("Enter minute : (Must be between 0 and 59)");
                    minute=scn.nextInt();
                    date=LocalDateTime.of(2020,month,day,hour,minute);
                    is=false;
                    searchPriceAndDate(Informations.root,price,date);
                    if(!is){
                        System.out.println("There is no flight");
                    }
                    break;
                case "e" : Exit();break;
                default  : System.out.println("Please enter correct option sign ");
                    break;
            }

        }
    }

    public static void insertFlight()   {

        System.out.println("Enter flight Month : (01, 02, 09, 11, etc..)");
        int month=scn.nextInt();
        System.out.println("Enter Flight Day : (Must be between 1 and 31)");
        int day=scn.nextInt();
        System.out.println("Enter Flight Hour : (01, 12, 18, 00, etc..)");
        int hour= scn.nextInt();
        while(hour < 0 || hour >23){
            hour= scn.nextInt();
        }
        System.out.println("Enter minute : (Must be between 0 and 59)");
        int minute=scn.nextInt();
        System.out.println("From?");
        String fromcity=scn.next();
        System.out.println("To Where?");
        String to=scn.next();
        System.out.println("Enter The Flight Price : ");
        Double price=scn.nextDouble();
        System.out.println("Enter Carrier Of The Flight : ");
        String car=scn.next();
        LocalDateTime date=LocalDateTime.of(2020,month,day,hour,minute);
        Information info=new Information(date,fromcity,to,car,price);
        Informations.put(info.code,info);


    }

    public static void searchFromCity(AVLNodeComparable focus,String fromcity){
        if (focus == null) {
            throw new NoSuchElementException("");
        }
        if(((Information)focus.val).fromcity.toLowerCase().equals(fromcity.toLowerCase())){
            is=true;
            System.out.println(focus.val.toString());
        }

        if (focus.left!=null ){
            searchFromCity(focus.left,fromcity);
        }

        if (focus.right!=null ){
            searchFromCity(focus.right,fromcity);
        }

    }
    public static void findClosestDate(AVLNodeComparable focus,LocalDateTime date){
        AVLNodeComparable a = focus;
        if((((Information)a.val).date.getYear() == date.getYear()) && (((Information)a.val).date.getMonth()== date.getMonth()) ){
            System.out.println("The Closest Flights : ");
             System.out.println(a.val.toString());
        }

         if(focus.left!=null){
             findClosestDate(focus.left,date);
         }
         if(focus.right!=null){
             findClosestDate(focus.right,date);
         }
    }
    public static void searchFromCityAndDate(AVLNodeComparable focus,String fromcity,LocalDateTime date){
        if (focus == null) {
            throw new NoSuchElementException("");
        }
        if(((Information)focus.val).fromcity.toLowerCase().equals(fromcity.toLowerCase()) && ((Information)focus.val).date.equals(date) ){
            is=true;
            System.out.println(focus.val.toString());
        }

        if (focus.left!=null ){
            searchFromCityAndDate(focus.left,fromcity,date);
        }

        if (focus.right!=null ){
            searchFromCityAndDate(focus.right,fromcity,date);
        }


    }
    public static void searchPriceAndDate(AVLNodeComparable focus,Double price,LocalDateTime date){
        if (focus == null) {
            throw new NoSuchElementException("");
        }

        if(((Information)focus.val).price<price && ((Information)focus.val).date.equals(date) ){
            is=true;
            System.out.println(focus.val.toString());
        }

        if (focus.left!=null ){
            searchPriceAndDate(focus.left,price,date);
        }

        if (focus.right!=null ){
            searchPriceAndDate(focus.right,price,date);
        }

    }

    public static void searchDate(AVLNodeComparable focus, LocalDateTime date) {
        if (focus == null) {
            throw new NoSuchElementException("");
        }

        if( ((Information)focus.val).date.equals(date) ){
            is=true;
            System.out.println(focus.val.toString());
        }


        if (focus.left!=null ){
            searchDate(focus.left,date);
        }

        if (focus.right!=null ){
            searchDate(focus.right,date);
        }
    }


    public static void BetweenTwoDates(AVLNodeComparable focus, LocalDateTime date1,LocalDateTime date2) {
        if (focus == null) {
            throw new NoSuchElementException("");
        }
        if (((((Information)focus.val).date).isAfter(date1) && (((Information)focus.val).date).isBefore(date2))|| ((((Information)focus.val).date).isAfter(date2) && (((Information)focus.val).date).isBefore(date1) )) {
            is=true;
            System.out.println(focus.val.toString());
        }
        if (focus.left!=null ){
            BetweenTwoDates(focus.left,date1,date2);
        }

        if (focus.right!=null ){
            BetweenTwoDates(focus.right,date1,date2);
        }
    }


    public static void  Exit(){
        System.out.println("bye");
        flag=false;
    }
}