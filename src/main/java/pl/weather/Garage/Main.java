package pl.weather.Garage;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car ("Honda", 5, "ZS1112", 50);
        System.out.println(car1);
        car1.getPlate();
        car1.getSize();
        Car car2 = new Car ("Volvo", 5.5, "VGHC138",100);
        System.out.println(car2);
        car2.getPlate();
        car2.getSize();
    }

    public void park ();
}



