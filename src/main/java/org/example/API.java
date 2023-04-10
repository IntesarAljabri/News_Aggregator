package org.example;

public class API {
    String apiUrl = "https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=yY0PdPrB7EvhGB2kiMT8dP9PbAAyWiuN";
        try {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        StringBuilder json = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            json.append(line);
        }

        conn.disconnect();

        Gson gson = new Gson();
        Countries[] countriesArr = gson.fromJson(json.toString(), Countries[].class);

        // Do something with the countries array

    } catch (RuntimeException ex) {
        ex.printStackTrace();
    }
}

