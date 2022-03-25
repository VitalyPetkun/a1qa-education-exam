package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.ArrayList;
import java.util.List;

public class XmlConverter {

    private static XmlMapper xmlMapper;

    private XmlConverter() {
        xmlMapper = new XmlMapper();
    }

    private static XmlMapper getXmlMapper() {
        if(xmlMapper == null)
            new XmlConverter();
        return xmlMapper;
    }

    public static <T> List<T> getListXml(String xml, Class<T[]> cls) {
        SmartLogger.logInfo("Converting string to xml List");
        List<T> list = new ArrayList<>();
        T[] array = null;

        try {
            array = getXmlMapper().readValue(xml, cls);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        for (T obj:array) {
            list.add(obj);
        }

        return list;
    }
}
