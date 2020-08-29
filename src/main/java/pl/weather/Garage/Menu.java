package pl.weather.Garage;

import java.util.Scanner;

public class Menu {

    private GarageService garageService;

    public Menu(GarageService garageService) {
        this.garageService = garageService;
    }

    public void viewMenu() {
        int option;
        Scanner scanner = new Scanner(System.in);

        do {
            getGarageInfo();
            System.out.println("1. Wyswietl liste zaparkowanych pojazdow");
            System.out.println("2. Wyszukaj pojazd po numerze rejestracyjnym");
            System.out.println("0. Wyjdz");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    getVehiclesList();
                    break;
                case 2:
                    findByPlates();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Nieznana opcja.");
                    break;
            }

        } while (option != '0');
    }

    private void getGarageInfo() {
        System.out.println("W garażu jest:");
        System.out.println(String.format("%d miejsc dla samochodow.", garageService.getGarageCapacities().get("Cars")));
        System.out.println(String.format("%d miejsc dla ciezarowek.", garageService.getGarageCapacities().get("Trucks")));
        System.out.println(String.format("%d miejsc dla motocykli.", garageService.getGarageCapacities().get("Motorcycles")));
    }

    private void getVehiclesList() {
        //TODO
        System.out.println("To implement later....");
    }

    private void findByPlates() {
        Scanner scanner = new Scanner(System.in);
        String carPlates;
        Vehicle foundVehicle = null;

        System.out.println("Podaj numer rejestracyjny:");
        carPlates = scanner.nextLine();

        //garageService.getParkedVehiclesBook().keySet().stream().filter()

        /*for(String plate : garageService.getParkedVehiclesBook().keySet()) {
            if(plate.equals(carPlates)) {
                //TODO
                foundVehicle = garageService.getParkedVehiclesBook().get(carPlates);
            }
        }*/

        foundVehicle = garageService.getParkedVehiclesBook().get(carPlates);
        if (foundVehicle != null) {
            System.out.print(String.format("Znaleziono pojazd: %s", foundVehicle.toString()));
        } else
        {
            System.out.println("Nie znaleziono pojazdu!");
        }
    }
}
