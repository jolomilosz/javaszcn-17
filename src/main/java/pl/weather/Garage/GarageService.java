package pl.weather.Garage;

import java.util.HashMap;
import java.util.Map;

public class GarageService {

    private  int truckSpots;
    private  int carSpots;
    private  int motorcycleSpots;

    private static final Integer TRUCK_SIZE_LIMIT = 2000;

    private Map<String, Vehicle> parkedVehiclesBook = new HashMap<>();


    private static GarageService INSTANCE;

    public GarageService(int truckSpots, int carSpots, int motorcycleSpots) {
        this.truckSpots = truckSpots;
        this.carSpots = carSpots;
        this.motorcycleSpots = motorcycleSpots;
    }

    public static GarageService getInstance(int truck, int car, int motorcycle) {
        if (INSTANCE == null) {
            INSTANCE = new GarageService(truck, car, motorcycle);
        }
        return INSTANCE;
    }


    public boolean attemptToPark(Vehicle vehicle){
        if (freeSpot(vehicle, false)) {
            vehicle.pay();
            return park(vehicle);
        }
        return false;
    }

    private boolean park(Vehicle vehicle) {
        this.freeSpot(vehicle, true);
        vehicle.setParked(true);
        return this.parkedVehiclesBook.putIfAbsent(vehicle.getPlate(), vehicle) != null;
    }

    private boolean freeSpot(Vehicle vehicle, boolean shouldTakeSpot){
        boolean canPark;
        switch (vehicle.getType()) {
            case TRUCK:
                canPark = (truckSpots > 0 && vehicle.getSize() < TRUCK_SIZE_LIMIT);
                truckSpots = shouldTakeSpot && canPark ? truckSpots -1 : truckSpots;
                return canPark;
            case CAR:
                canPark = carSpots > 0;
                carSpots = shouldTakeSpot ? carSpots -1 : carSpots;
                return carSpots > 0;
            case MOTORCYCLE:
                canPark = motorcycleSpots > 0;
                motorcycleSpots = shouldTakeSpot ? motorcycleSpots -1 : motorcycleSpots;
                return motorcycleSpots > 0;
            default:
                return false;
        }
    }

    @Override
    public String toString() {
        return "GarageService{" +
                "truckSpots=" + truckSpots +
                ", carSpots=" + carSpots +
                ", motorcycleSpots=" + motorcycleSpots +
                ", parkedVehiclesBook=" + "\n" +  parkedVehiclesBook.values();
    }

//    private String printBook(){
//        String result = "";
//        this.parkedVehiclesBook.forEach( (i, o) -> result.concat(o.toString()));
//        return  result;
//    }
}

