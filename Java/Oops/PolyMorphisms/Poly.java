package Java.Oops.PolyMorphisms;


class Engine {

    private int mileage;
    private int price;

    Engine(int mileage, int price){
        if(mileage < 0 || price < 0){
            throw new IllegalArgumentException("Mileage and Price cannot be negative");
        }
        
        this.mileage = mileage;
        this.price = price;
    }

    public void start(){
        System.out.println("Engine is starting");
    }

    void getMileageAndPrice(){
        System.out.println("Mileage: " + mileage + " Price: " + price);
    }

    void service(){
        System.out.println("General Service");
    }

    void service(String serviceType){
        System.out.println(serviceType + " Service");
    }

    void service(String serviceType, int cost){
        System.out.println(serviceType + " Service Cost: " + cost);
    }
}
class Car extends Engine{

    Car(int mileage, int price){
        super(mileage, price);
    }
    public void start(){
        System.out.println("Car is starting");
    }
}
class Bike extends Engine{
    Bike(int mileage, int price){
        super(mileage, price);
    }
    public void start(){
        System.out.println("Bike is starting");
    }
}

class Truck extends Engine{
    Truck(int mileage, int price){
        super(mileage, price);
    }
    public void start(){
        System.out.println("Truck is starting");
    }
}

class Poly {
    public static void main(String[] args) {

        Engine e1 = new Car(10, 100000);
        Engine e2 = new Bike(20, 50000);
        Engine e3 = new Truck(5, 200000);

                
        e1.service();
        e1.service("Oil Change");
        e1.service("Full Service", 5000); 
        e1.start();
        e1.getMileageAndPrice();
        e2.start();
        e2.getMileageAndPrice();
        e3.start();
        e3.getMileageAndPrice();
    }
}
