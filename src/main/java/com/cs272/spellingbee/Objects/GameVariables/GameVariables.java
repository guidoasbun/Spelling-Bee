package com.cs272.spellingbee.Objects.GameVariables;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GameVariables {
    private final String letters;
    private final String centerWord;
    private StringChainHashSet wordList = new StringChainHashSet();

    public GameVariables() throws ParseException, IOException {
        StringBuilder gameVariablesData =  new StringBuilder();
        int responseCode = 0;
        Object objectToParse;
        try {
            URL url = new URL("https://freebee.fun/cgi-bin/today");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            // Check to see if connection is made
            responseCode = connection.getResponseCode();

            // code 200 is good
            if(responseCode != 200) {
                throw  new RuntimeException("Connection was not made. Using local variables. HttpResponseCode: " + responseCode);
            } else {
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    gameVariablesData.append(scanner.nextLine());
                }

                scanner.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONParser jsonParser = new JSONParser();

        objectToParse = jsonParser.parse(gameVariablesData.toString());
        JSONObject jsonObject = (JSONObject) objectToParse;


        this.letters = (String) jsonObject.get("letters");
        this.centerWord = (String) jsonObject.get("center");
        JSONArray array = (JSONArray) jsonObject.get("wordlist");
        for (Object word : array) {
            wordList.add((String) word);
        }
    }

    public  String getLetters() {
        return this.letters;
    }

    public  String getCenterWord() {
        return this.centerWord;
    }

    public Boolean checkWord(String word) {
        return wordList.contains(word);
    }

}
