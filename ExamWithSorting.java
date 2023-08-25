import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Person> people = loadPeople("C:\\Users\\Student\\IdeaProjects\\exam\\src\\people.txt");
        Map<String, Integer> kayaks = loadKayaks("C:\\Users\\Student\\IdeaProjects\\exam\\src\\kayaks.txt");

        List<String> assignments = assignPeopleToKayaks(people, kayaks);

        for (String assignment : assignments) {
            System.out.println(assignment);
        }
    }

    public static List<Person> loadPeople(String filename) {
        List<Person> people = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String name = parts[0].trim();
                int weight = Integer.parseInt(parts[1].trim());
                people.add(new Person(name, weight));
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла людей: " + e.getMessage());
        }

        // Сортировка людей по весу (от меньшего к большему)
        people.sort(Comparator.comparingInt(Person::getWeight));

        return people;
    }

    public static Map<String, Integer> loadKayaks(String filename) {
        Map<String, Integer> kayaks = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String number = parts[0].trim();
                int capacity = Integer.parseInt(parts[1].trim());
                kayaks.put(number, capacity);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла байдарок: " + e.getMessage());
        }

        return kayaks;
    }

    public static List<String> assignPeopleToKayaks(List<Person> people, Map<String, Integer> kayaks) {
        List<String> assignments = new ArrayList<>();

        for (String kayakNumber : kayaks.keySet()) {
            int kayakCapacity = kayaks.get(kayakNumber);
            List<String> assignedPeople = new ArrayList<>();

            for (Person person : people) {
                int personWeight = person.getWeight();

                if (personWeight <= kayakCapacity) {
                    assignedPeople.add(person.getName());
                    kayakCapacity -= personWeight;

                    if (assignedPeople.size() == 2) {
                        break;
                    }
                }
            }

            for (String person : assignedPeople) {
                assignments.add(kayakNumber + ":" + person+" "+people.get(Weight)); //TODO: вывести вес человека
                people.removeIf(p -> p.getName().equals(person));
            }
        }

        return assignments;
    }

    static class Person {
        private final String name;
        private final int weight;

        public Person(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public int getWeight() {
            return weight;
        }
    }
}

/* import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Map<String, Integer> people = loadPeople("C:\\Users\\Student\\IdeaProjects\\exam\\src\\people.txt");
        Map<String, Integer> kayaks = loadKayaks("C:\\Users\\Student\\IdeaProjects\\exam\\src\\kayaks.txt");
        List<String> assignments = assignPeopleToKayaks(people, kayaks);

    for (String assignment : assignments) {
        System.out.println(assignment);
    }
}

    public static Map<String, Integer> loadPeople(String filename) {
        Map<String, Integer> people = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String name = parts[0].trim();
                int weight = Integer.parseInt(parts[1].trim());
                people.put(name, weight);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла людей: " + e.getMessage());
        }

        return people;
    }

    public static Map<String, Integer> loadKayaks(String filename) {
        Map<String, Integer> kayaks = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String number = parts[0].trim();
                int capacity = Integer.parseInt(parts[1].trim());
                kayaks.put(number, capacity);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла байдарок: " + e.getMessage());
        }

        return kayaks;
    }

    public static List<String> assignPeopleToKayaks(Map<String, Integer> people, Map<String, Integer> kayaks) {
        List<String> assignments = new ArrayList<>();

        for (String kayakNumber : kayaks.keySet()) {
            int kayakCapacity = kayaks.get(kayakNumber);
            List<String> assignedPeople = new ArrayList<>();

            for (String personName : people.keySet()) {
                int personWeight = people.get(personName);

                if (personWeight <= kayakCapacity) {
                    assignedPeople.add(personName);
                    kayakCapacity -= personWeight;

                    if (assignedPeople.size() == 2) {
                        break;
                    }
                }
            }

            for (String person : assignedPeople) {
                assignments.add(kayakNumber + ":" + person+" "+ people.get(person));
                people.remove(person);
            }
        }

        return assignments;
    }
} */
