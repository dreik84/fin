package org.example;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValCurs {

    @XmlAttribute(name = "Date")
    private String date;

    @XmlAttribute(name = "name")
    private String name;

    @XmlElementWrapper(name = "ValCurs")
    @XmlElement(name = "Valute")
    private List<Valute> valutes;
}
