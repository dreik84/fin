package org.example;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.HashMap;
import java.util.Map;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Valute {
    private Map<String, String> attributes = new HashMap<>();
    private int numCode;
    private String charCode;
    private int nominal;
    private String name;
    private double value;
    private double vunitRate;
}
