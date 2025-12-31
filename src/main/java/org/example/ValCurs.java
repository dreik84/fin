package org.example;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ValCurs {
    private Map<String, String> attributes = new HashMap<>();
    private List<Valute> valutes;
}
