package Aston.lesson13part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {
    private final Map<String, List<String>> directory = new HashMap<>();

    public void add(String surname, String phone) {
        if (surname == null || surname.isBlank())
            throw new IllegalArgumentException("Пустое имя");
        if (phone == null || phone.isBlank())
            throw new IllegalArgumentException("Номер не может быть пустым");

        List<String> phones = directory.computeIfAbsent(surname, k -> new ArrayList<>());
        phones.add(phone);
    }

    public List<String> get(String surname) {
        if (surname == null || surname.isBlank()) {
            return List.of();
        }
        return directory.getOrDefault(surname, List.of());
    }
}