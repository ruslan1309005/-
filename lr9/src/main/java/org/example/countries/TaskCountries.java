package org.example.countries;

import java.util.HashMap;
import java.util.Map;

public class TaskCountries {
    public static void run() {
        Map<String, Country> map = new HashMap<>();
        map.put("Беларусь", new Country("Беларусь"));
        map.put("Минск", new City("Минск"));
        map.put("Гродно", new City("Гродно"));
        map.put("Поставы", new Town("Поставы"));
        map.put("Россия", new Country("Россия"));
        map.put("Москва", new City("Москва"));
        map.put("Сочи", new City("Сочи"));

        System.out.println("\nКЛЮЧ → ЗНАЧЕНИЕ:");
        for (Map.Entry<String, Country> e : map.entrySet()) {
            System.out.printf(" • %s → %s%n",e.getKey(),e.getValue());
        }

    }
}