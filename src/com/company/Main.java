package com.company;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {


     String data =new String(Files.readAllBytes(Paths.get("Info.json")));
     JSONArray jsonArray =new JSONArray(data);
        MotorDepot [] motorDepots =new MotorDepot[jsonArray.length()];

        for (int i = 0; i < motorDepots.length ; i++) {
            motorDepots[i] = new MotorDepot();
            String str = jsonArray.get(i).toString();
            JSONObject object = new JSONObject(str);
            motorDepots[i].setId(object.getInt("id"));
            motorDepots[i].setName(object.getString("name"));
            motorDepots[i].setDriver(object.getString("driver"));
            motorDepots[i].setState(object.getString("state"));


        }
        System.out.println("#  |    Bus          |  Driver  |  State ");
        System.out.println("———+—————————————————+——————————+—————————");

        for (int i = 0; i < 3; i++) {
            System.out.printf("%-3s|",motorDepots[i].getId());
            System.out.printf("%-17s|",motorDepots[i].getName());
            System.out.printf("%-10s|",motorDepots[i].getDriver());
            System.out.printf("%-8s|",motorDepots[i].getState());
            System.out.println();
        }


    }
}
