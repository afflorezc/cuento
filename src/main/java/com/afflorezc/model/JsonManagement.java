package com.afflorezc.model;

import com.afflorezc.controller.LocalPaths;
import com.afflorezc.controller.Session;
import com.google.gson.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonManagement {

    /**
     * @param args the command line arguments
     */
    public static final String JSONPATH = LocalPaths.JSONPATH+"sessions.json";


    public static void addSession(Session sesion){
        Gson gson = new Gson();

        String newJson = gson.toJson(sesion);

        String jsonContent = "";

        try (BufferedReader br = new BufferedReader(new FileReader(JSONPATH))) {
            String lines = br.readLine();
            System.out.print(lines);

            while(lines != null){
                if(!lines.equals("]")){
                    if(!lines.equals("[") && !lines.equals("\n")) {
                        jsonContent += "\n";
                    }
                    jsonContent += lines;
                }
                lines = br.readLine();
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        jsonContent += "\n"+ newJson;
        jsonContent += "\n]";


        deleteJson();

        try (BufferedWriter bw2 = new BufferedWriter(new FileWriter(JSONPATH,true))) {
            bw2.write(jsonContent);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int searchUser(Session session){
        Session nullSession = new Session("","");
        Gson gson = new Gson();

        boolean continueSearch = true;

        int typeSession = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(JSONPATH))) {
            String line;
            while ((line = br.readLine()) != null && continueSearch == true) {

                if(!line.equals("[") && !line.equals("["+"\n") && !line.equals("]") &&
                        !line.equals("]"+"\n") && !line.equals("\n") && !line.equals("")){ // valida que la linea si sea un json
                    Properties currentJson = gson.fromJson(line, Properties.class);
                    typeSession = equalSession(session, currentJson.getProperty("name"), currentJson.getProperty("password"));
                    if(typeSession == 1 || typeSession == -1){
                        continueSearch = false;
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return typeSession;
    }

    private static int equalSession(Session session, String currentName, String currentPasword){
        if(session.getName().equals(currentName)){
            if(session.getPassword().equals(currentPasword)){
                return 1;   //si el nombre de usuario y la contraseña coniciden retorna 1
            }else{
                return -1;  //si el nombre de usuario conincide pero al contraseña no, returna -1
            }
        }else{
            return 0;   //si el nombre de usuario no coincide retorna 0
        }
    }


    private static void deleteJson(){
        try {
            Files.delete(Paths.get(JSONPATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


