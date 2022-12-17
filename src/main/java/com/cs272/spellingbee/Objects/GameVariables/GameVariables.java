// Programmer: Guido Asbun

package com.cs272.spellingbee.Objects.GameVariables;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GameVariables {
    private final String letters;
    private final String centerWord;
    private Long totalCorrectWords;
    private final StringChainHashSet wordList = new StringChainHashSet();

    public GameVariables() throws ParseException {
        StringBuilder gameVariablesData =  new StringBuilder();
        Object objectToParse;
        try {
            URL url = new URL("https://freebee.fun/cgi-bin/today");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            // Check to see if connection is made
            int responseCode = connection.getResponseCode();

            // code 200 is good
            if(responseCode != 200) {
                throw  new RuntimeException("Connection was not made. HttpResponseCode: " + responseCode);
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
        this.totalCorrectWords = (Long) jsonObject.get("words");
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

    public Long getTotalCorrectWords() {
        return this.totalCorrectWords;
    }

    public Boolean checkWord(String word) {
        return wordList.contains(word);
    }

}
