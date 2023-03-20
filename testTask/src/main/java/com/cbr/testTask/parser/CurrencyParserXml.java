package com.cbr.testTask.parser;

import com.cbr.testTask.dtos.CurrencyDto;
import com.cbr.testTask.exceptions.CurrencyParsingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CurrencyParserXml implements CurrencyParser {
    @Override
    public List<CurrencyDto> parse(String ratesAsString, LocalDate date) {
        List rates = new ArrayList<CurrencyDto>();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            try (StringReader reader = new StringReader(ratesAsString)) {
                Document doc = dbf.newDocumentBuilder().parse(new InputSource(reader));
                doc.getDocumentElement().normalize();

                NodeList list = doc.getElementsByTagName("Valute");

                for (int i = 0; i < list.getLength(); i++) {
                    Node node = list.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;

                        CurrencyDto rate = CurrencyDto.builder()
                                .currency(element.getElementsByTagName("CharCode").item(0).getTextContent())
                                .dateOfRequest(date)
                                .exchangeRates( DecimalFormat.getNumberInstance().parse(element.getElementsByTagName("Value").item(0).getTextContent()).doubleValue())
                                .build();
                        rates.add(rate);
                    }
                }
            }
        }
        catch (Exception exception) {
            throw new CurrencyParsingException(exception);
        }
        return rates;
    }
}
