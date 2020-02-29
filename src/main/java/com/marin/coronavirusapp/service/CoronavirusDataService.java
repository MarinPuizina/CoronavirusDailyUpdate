package com.marin.coronavirusapp.service;

import com.marin.coronavirusapp.model.CoronavirusData;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronavirusDataService {

    @Autowired
    Environment environment;

    @PostConstruct
    @Scheduled(cron = "* * 12 * * *") // Execute every 12 hours
    public void getCoronavirusData() throws IOException, InterruptedException {

        List<CoronavirusData> newData = new ArrayList<>();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(environment.getProperty("coronavirus.data.csv")))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        StringReader stringReader = new StringReader(response.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);
        for (CSVRecord record : records) {

            CoronavirusData coronavirusData = new CoronavirusData();
            coronavirusData.setState(record.get(environment.getProperty("coronavirus.data.state")));
            coronavirusData.setCountry(record.get(environment.getProperty("coronavirus.data.country")));
            coronavirusData.setNumberOfCases( Integer.parseInt( record.get( record.size() - 1 ) ) );

            newData.add(coronavirusData);

        }

        CoronavirusData.virusData = newData;

    }

}
