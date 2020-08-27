package pl.weather.Garage;

import java.util.HashMap;
import java.util.Map;

public class GarageService {

    private static int truckSpots;
    private static int carSpots;
    private static int motorcycleSpots;

    private static final Integer TRUCK_SIZE_LIMIT = 2000;

    private Map<String, Vehicle> parkedVehiclesBook = new HashMap<>();


    private static GarageService INSTANCE;

    public GarageService(int truckSpots, int carSpots, int motorcycleSpots) {
        GarageService.truckSpots = truckSpots;
        GarageService.carSpots = carSpots;
        GarageService.motorcycleSpots = motorcycleSpots;
    }

    public static GarageService getInstance(int truck, int car, int motorcycle) {
        if (INSTANCE == null) {
            INSTANCE = new GarageService(truck, car, motorcycle);
        }
        return INSTANCE;
    }


    public boolean attemptToPark(Vehicle vehicle){
        if (freeSpot(vehicle)) {
            vehicle.pay();
            return park(vehicle);
        }
        return false;
    }

    private boolean park(Vehicle vehicle) {
        return this.parkedVehiclesBook.putIfAbsent(vehicle.getPlate(), vehicle) != null;
    }

    private static boolean freeSpot(Vehicle vehicle){
        switch (vehicle.getType()) {
            case TRUCK:
                return truckSpots > 0 && vehicle.getSize() > TRUCK_SIZE_LIMIT;
            case CAR:
                return carSpots > 0;
            case MOTORCYCLE:
                return motorcycleSpots > 0;
            default:
                return false;
        }
    }

}
