package softwareengineweek1;

import java.util.Scanner;

//Jeffrey Xiong
//10/27/2019
//Create a petDatabase that adds,store,removes,pets. Release 2
public class PetDataBase_Release2 {
    
    //Create Pet Class to store new pet objects
    public static class Pet {
        String name;
        int age;

        public Pet(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            this.name = name;
            return name;
        }

        public int getAge() {
            this.age = age;
            return age;
        }

        public void setName(String newName) {
            this.name = newName;

        }

        public void setAge(int newAge) {
            this.age = newAge;

        }
    }
    
    // Public Variables
    public static Scanner s = new Scanner(System.in);
    public static Pet[] Petarray = new Pet[100];//Create petArray to store new created pet class ojects
    public static int petcount = 0;//Keep track of the amount of objects inside the list
    
    //Methods
    public static int getUserChoice(){
        System.out.println("");
        System.out.println("What would you like to do?");
        System.out.println("1) View all pets");
        System.out.println("2) Add more pets");
        System.out.println("5) Search pets by name ");
        System.out.println("6) Search pets by age");
        System.out.println("7) Exit program");
        System.out.print("Your choice: ");
        int userChoice = s.nextInt();
        return userChoice;
    }
    
     public static void addPets(){
        int count = 0;
        System.out.println("Enter 'done' to exit");
        for(;;){
        System.out.print("add pet (name, age): ");
        String name = s.next();
        if(name.equalsIgnoreCase("done")) break;
        int age = s.nextInt();
        Pet newPet = new Pet(name,age); //Create new pet object
        Petarray[petcount] = newPet; //Save new created object into list
        petcount++;  //increse the list
        count++;
        }
        System.out.println(count + " pets added.");
    }
    
    public static void showAllPets(){
        System.out.printf("%-4s %-10s %s ","ID","NAME","AGE");
        System.out.println("");
        for(int count = 0;count<petcount;count++){
            System.out.printf("%-4d %-10s %d ",count,Petarray[count].getName(),Petarray[count].getAge());
            System.out.println("");
        } 
        System.out.println(petcount + " rows in set");
    }
    
    public static void nameSearch(){ //Search for name using, name and index number
        System.out.print("Enter Pet name : ");
        String name = s.next();
        for(int count = 0;count<petcount;count++){
            if(name.equals(Petarray[count].getName())){
                System.out.printf("%-4d %-10s %d ",count,Petarray[count].getName(),Petarray[count].getAge());
                System.out.println("");
             }
        }
    }
    
    public static void ageSearch(){ //Search for age using, age and index number
        System.out.print("Enter Pet Age : ");
        int age = s.nextInt();
        for(int count = 0;count<petcount;count++){
            if(age == Petarray[count].getAge()){
                System.out.printf("%-4d %-10s %d ",count,Petarray[count].getName(),Petarray[count].getAge());
                System.out.println("");
             }
        }
    }
    
    //Main
    public static void main(String[] args){
        Boolean mainon = true;
        System.out.println("Begin of Program");
        for(;mainon == true;){
            switch(getUserChoice()){
                case 1: showAllPets(); break;
                case 2: addPets(); break;
                case 5: nameSearch(); break;
                case 6: ageSearch(); break;
                case 7: mainon = false; System.out.println("End of program, goodbye");  break;
                default: break;
                }
            }
        }
    
}
