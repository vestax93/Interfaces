package exercise4;

import java.lang.reflect.Method;
import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(sc.nextLine());
        Map<Person, List<Buyer>> buyers = new LinkedHashMap<>();
        while(numberOfPeople-- > 0){
            String[] data = sc.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            Person person;
            Buyer buyer;
            if(data.length == 4){ //ako niz ima 4 clana u pitanju je Citizen (jer on ima 4 polja)
                String id = data[2];
                String birthDate = data[3];
                person = new Citizen(name,age,id,birthDate);
                buyer = new Citizen(name,age,id,birthDate);
            } else { //ako je u pitanju niz sa 3 clana to je Rebel jer on ima 3 polja
                String group = data[2];
                person = new Rebel(name,age,group);
                buyer = new Rebel(name,age,group);
            }
            buyers.putIfAbsent(person, new ArrayList<>());
            buyers.get(person).add(buyer);
        }
        String line;
        while(!(line = sc.nextLine()).equals("End")){
            final String name = line;
            buyers.entrySet().stream()
                    .filter(e -> e.getKey().getName().equals(name))
                    .forEach(e -> e.getValue().forEach(Buyer::buyFood));
        }
        int sum = 0;
        for(Map.Entry<Person, List<Buyer>> personListEntry : buyers.entrySet()){
            sum += personListEntry.getValue().stream()
                    .map(Buyer::getFood)
                    .mapToInt(Integer::intValue)
                    .sum();
        }
        System.out.println(sum);

        }


}
