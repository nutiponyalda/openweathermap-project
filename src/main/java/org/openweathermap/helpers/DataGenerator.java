package org.openweathermap.helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataGenerator {

    private final String USERNAMES_FILE = "/Users/yagnyukvladislav/IdeaProjects/openweathermap-project/src/files/usernames.txt";
    private final String EMAILS_FILE = "/Users/yagnyukvladislav/IdeaProjects/openweathermap-project/src/files/emails.txt";
    private final String PASSWORD_CHARACTERS = "[A-Za-z0-9]*$";
    private final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_CHARACTERS);
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> emails = new ArrayList<>();

    public String getUsername() {
        loadData(USERNAMES_FILE, usernames);
        Random random = new Random();
        String username = usernames.get(random.nextInt(usernames.size()));
        return username;
    }

    public String getEmail() {
        loadData(EMAILS_FILE, emails);
        Random random = new Random();
        String email = emails.get(random.nextInt(emails.size()));
        return email;
    }


    private void loadData(String filename, ArrayList<String> list) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error loading words from " + filename);
            e.printStackTrace();
        }
    }

    public String getPassword() {
        SecureRandom random = new SecureRandom();
        Matcher matcher;

        do {
            StringBuilder password = new StringBuilder(10);

            for (int i = 0; i < 10; i++) {
                int randomIndex = random.nextInt(PASSWORD_CHARACTERS.length());
                char randomChar = PASSWORD_CHARACTERS.charAt(randomIndex);
                password.append(randomChar);
            }

            matcher = PASSWORD_PATTERN.matcher(password.toString());
        } while (!matcher.matches());

        return matcher.group();
    }

}

