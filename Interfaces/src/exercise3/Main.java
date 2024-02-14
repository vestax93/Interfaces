package exercise3;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Birthable> list = new ArrayList<>();

        String line = sc.nextLine();
        while(!line.equals("End")){
            String[] tokens = line.split("\\s+");
            switch (tokens[0]){
                case "Citizen":
                    String name = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    String id = tokens[3];
                    String birthDate = tokens[4];
                    Citizen citizen = new Citizen(name,age,id,birthDate);
                    list.add(citizen);
                    break;
                case "Pet":
                    String namePet = tokens[1];
                    String birthDatePet = tokens[2];
                    Pet pet = new Pet(namePet,birthDatePet);
                    list.add(pet);
                    break;
                case "Robot":
                    String nameRobot = tokens[1];
                    String idRobot = tokens[2];
                    Robot robot = new Robot(nameRobot,idRobot);
                    break;
            }
            line = sc.nextLine();
        }
        String givenDate = sc.nextLine();
        System.out.println(list.stream().map(Birthable::getBirthDate)
                .filter(p -> p.endsWith(givenDate))
                .collect(Collectors.toList()).size() == 0 ?
                "<no output>" : String.format("%s",
                list.stream().map(Birthable::getBirthDate)
                .filter(p -> p.endsWith(givenDate))
                        .map(String::valueOf)
                        .collect(Collectors.joining(System.lineSeparator()))
                )
        );
    }


}
