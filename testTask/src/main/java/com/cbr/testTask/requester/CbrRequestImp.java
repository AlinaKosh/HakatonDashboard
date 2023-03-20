package com.cbr.testTask.requester;

import com.cbr.testTask.exceptions.RequesterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
public class CbrRequestImp implements CbrRequest {

    @Override
    public String getRatesAsXml(String url) {
        try {
            return HttpClient.newHttpClient().send(HttpRequest.newBuilder().uri(URI.create(url)).build(), HttpResponse.BodyHandlers.ofString()).body();
        }
        catch (Exception ex) {
            throw new RequesterException(ex);
        }
    }
}
