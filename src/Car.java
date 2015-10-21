/**
 * Created by Bharath on 10/15/15.
 */

     class Vehicle{
        void getName(){
            System.out.println("Vehicle");
        }
    }

     class Car extends Vehicle{
        void getName(){
            System.out.println("Car");

        }
        void hasWheels(){
            System.out.println("Yes Four ");
        }
        public static void main(String[] args){
            Vehicle v  = new Car();
            v.getName();
            Car c = (Car) v;

            c.hasWheels();
            c.getName();
            //(Car)v.getName();

            //v.hasWheels();
        }
    }



