/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knowledge_ass;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.opencsv.*;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author fatinhalim
 */
public class Knowledge_ass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         String choice;
        int answer;
        Scanner in = new Scanner (System.in);

        //Load Smartphone
        CSVReader smartRead = new CSVReader(new FileReader("src/smart.csv"), ',', '"', 1);
        List<Smartphone> smartphones = new ArrayList<Smartphone>();
        List<String> brandSmart = new ArrayList<>();
        List<Integer> priceSmart = new ArrayList<>();
        String[] record = null;
        int count = 0;
        while ((record = smartRead.readNext()) != null) {
            Smartphone smartphone = new Smartphone();
            smartphone.setName(record[0]);
            smartphone.setBrand(record[1]);
            brandSmart.add(record[1]);
            smartphone.setScreen(record[2]);
            smartphone.setCamera(record[3]);
            smartphone.setPrice(record[4]);
            priceSmart.add(Integer.parseInt(record[4]));
            smartphone.setRam(record[5]);
            smartphone.setNetwork(record[6]);
            smartphones.add(smartphone);
            count++;
        }


        System.out.println("Total number of smartphones entered into the system: " + count + ".");
        smartRead.close();

        //Load Feature Phone
        CSVReader featureRead = new CSVReader(new FileReader("src/feature.csv"), ',', '"', 1);
        List<Featurephone> featurephones = new ArrayList<Featurephone>();
        List<Integer> pricelistFeature = new ArrayList<>();
        record = null;
        int countFeature = 0;

        while ((record = featureRead.readNext()) != null) {

            Featurephone featurephone = new Featurephone();
            //Iphone7Plus,Apple,5.5,12MP,3400,3GB,4g
            featurephone.setName(record[1]);
            featurephone.setBrand(record[0]);
            featurephone.setPrice(record[2]);
            pricelistFeature.add(Integer.parseInt(record[2]));
            featurephones.add(featurephone);
            countFeature++;
        }
        System.out.println("Total number of featurephone(s) entered into the system: " + countFeature + ".\n\n");

        featureRead.close();


        while(true) {
        System.out.println("Welcome to Phone Selection Arena! We're here to help you to choose the phone you want!* ");
        System.out.println("Here are the available settings:");
        System.out.println("1. Featurephone");
        System.out.println("2. Smartphone");
        System.out.println("3. Exit");
        System.out.print("Please enter your selection: ");
        choice = in.nextLine();

        answer = Integer.parseInt(choice);
            if (answer == 1) {

                System.out.println("Feature phone is basic phone that has limited capabilities. Therefore, when choosing Feature phone, enduser care only about the price.");
                System.out.println("This system also will take that into consideration as well and show you a list of phone you can buy!");
                System.out.print("Please enter the amount you're willing to pay to get a feature phone (Range: 50 - 400): ");
                choice = in.nextLine();
                answer = Integer.parseInt(choice);
                while (answer < 50 || answer > 400) {
                    System.out.println("Sorry, the range you've entered is invalid! If your budget is higher than 400, it's better to get a smartphone!");
                    choice = in.nextLine();
                    answer = Integer.parseInt(choice);

                }
                int moreFifty = answer + 50;
                int lessFifty = answer - 50;
                System.out.println("Please wait!");
                System.out.println(".\n.\n.\n.\n.\n.\n.");
                System.out.println("The suitable phone(s) are as below:");
                for (int i = 0; i < pricelistFeature.size(); i++) {
                    if (pricelistFeature.get(i) <= moreFifty && pricelistFeature.get(i) >= lessFifty ) {
                        System.out.println(featurephones.get(i));
                        System.out.println();
                    }

                }

                System.out.println("\n\n\n");

            } else if (answer == 2) {
                while (true) {
                    System.out.println("1. Select based on brand.");
                    System.out.println("2. Select based on price.");
                    System.out.println("3. Pick Smart!");
                    System.out.println("4. Exit to main menu.");
                    System.out.print("Please enter your selection: ");
                    choice = in.nextLine();
                    answer = Integer.parseInt(choice);
                    if (answer == 1) {
                        System.out.println("Please enter the the brand you're looking for (For example: Apple, Huawei, Sony and etc.)");
                        String brand = in.nextLine();
                        System.out.println("Please wait!");
                        System.out.println(".\n.\n.\n.\n.\n.\n.");
                        System.out.println("The suitable phone(s) are as below:");
                        for (int i = 0; i < brandSmart.size(); i++){
                            if ((brandSmart.get(i)).equalsIgnoreCase(brand)){
                                System.out.println(smartphones.get(i));
                                System.out.println();
                            }
                        }
                    }
                    else if (answer == 3){
                        int lowBracket, highBracket;
                        System.out.println("It's extremely hard to buy a Smartphone nowadays, therefore the easiest way would be using the amount of cash you're willing to pay!");
                        System.out.print("It also teaches us to manage our finance as well! Please enter your monthly saving: ");
                        choice = in.nextLine();
                        answer = Integer.parseInt(choice);
                        if (answer < 50) {
                            System.out.println("The system seriously think you shouldn't waste too much money on phone, you can't even save up to RM 50 a month! Get a feature phone is a better choice!");
                        }
                        else if (answer >=50 && answer < 500) {
                            System.out.println("Your total saving in three months are " + answer * 3 + ". Please rethink again whether you really need the phone!");
                        }
                        else if (answer >= 500 ){
                            System.out.println("Your total saving in three months are " + answer*3 + ". The phone(s) you can afford are: ");
                            lowBracket = answer * 3 - 200;
                            highBracket = answer * 3;
                            for (int i = 0; i < priceSmart.size(); i++){
                                if (priceSmart.get(i) > lowBracket){
                                    System.out.println(smartphones.get(i));
                                    System.out.println();
                                }
                            }
                        }
                    }
                    //smartphone
                    else if (answer == 2){
                        System.out.print("Please enter the amount you're willing to pay to get a smart phone (Range: 500 - 4000): ");
                        choice = in.nextLine();
                        answer = Integer.parseInt(choice);
                        while (answer < 500 || answer > 4000) {
                            System.out.println("Sorry, the range you've entered is invalid! If your budget is lower than 500, it's better to get a featurephone!");
                            choice = in.nextLine();
                            answer = Integer.parseInt(choice);
                        }
                        int moreFifty = answer + 50;
                        int lessFifty = answer - 50;
                        System.out.println("Please wait!");
                        System.out.println(".\n.\n.\n.\n.\n.\n.");
                        System.out.println("The suitable phone(s) are as below:");
                        for (int i = 0; i < smartphones.size(); i++) {
                            if (priceSmart.get(i) <= moreFifty && priceSmart.get(i) >= lessFifty ) {
                                System.out.println(smartphones.get(i));
                                System.out.println();
                            }

                        }

                        System.out.println("\n\n\n");
                    }

                    else if (answer == 4){
                        break;
                    }

                    else{
                        System.out.println("Wrong input received. Please try again!");
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");                    }
                }
            } else if (answer == 3) {
                break;
            } else {
                System.out.println("Wrong input received. Please try again!");
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            }

        }
    }
    
}
