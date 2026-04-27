import java.util.*;

class Student {
   private int id;
   private String name;
   private  String course;
   private int fee;
   void setId(int id) {
   this.id = id;
   }
   void setName(String name) {
   this.name = name;
   }
   void setCourse(String course) {
   this.course = course;
   }
   void setFee(int fee) {
   this.fee = fee;
   }
   int getId() {
   return id;
   } 
   String getName() {
      return name;
   }
   String getCourse() {
      return course;
   }
   int getFee() {
      return fee;
   }
   void display(){
      System.out.println("Student Id is: "+id);
      System.out.println("Student name is: "+name);
      System.out.println("Course taken is: "+course);
      System.out.println("Course fee is: "+fee);

   }
}
class Main {
   public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      ArrayList<Student> students =  new ArrayList<>();


       int choice;
       do {  
              System.out.println("\n--- Student Management System ---");
              System.out.println("1. Add Student");
              System.out.println("2. View Student");
              System.out.println("3. Search Student");
              System.out.println("4. Update Student");
              System.out.println("5. Delete Student");
              System.out.println("6. Exit From Database");
              System.out.print("Enter Your Choice: ");
              choice = sc.nextInt();
              sc.nextLine();
              switch(choice) {
               case 1 :
                  System.out.print("Create Student Id:");
                  int id = sc.nextInt();
                  if(id < 0) {
                     System.out.println("Can't Enter Negative Values: ");
                  } else {
                  sc.nextLine();
                  boolean flag = false;
                  for(Student s : students) {
                  if(s.getId() == id) {
                     System.out.println("Id already exist.");
                     flag = true;
                     break;
                  }
                  }
                  if(!flag) {

                     System.out.print("Enter Student Name:");
                     String name = sc.nextLine();

                     System.out.print("Enter Student Course:");
                     String course = sc.nextLine();

                     System.out.print("Enter Student Fee:");
                     int fee = sc.nextInt();
                     sc.nextLine();

                     Student s1 = new Student();
                     s1.setId(id);
                     s1.setName(name);
                     s1.setCourse(course);
                     s1.setFee(fee);
                     students.add(s1);
                  }
                  }
                  break;
                  case 2 : 
                  if(students.isEmpty()) {
                     System.out.println("No Student Found.");
                  } else {
                     for(Student s : students) {
                       s.display();  
                     }
                  }
                  break;
                  case 3 :
                     System.out.println("Enter Student Id: ");
                     int searchid = sc.nextInt();
                     sc.nextLine();
                     boolean found = false;
                     for(Student s : students){
                      if(s.getId() == searchid) {
                        System.out.println("Student Details Are: ");
                        s.display();
                        found =true;
                        break;
                      }
                     }
                      if(!found) {
                        System.out.println("Student Not Found.");
                      }
                      break;
                     case 4 :
                        System.out.println("Enter Student Id: ");
                        int id1 = sc.nextInt();
                        sc.nextLine();
                        boolean isfound = false;
                        for(Student s : students) {
                           if(s.getId() == id1) {
                               System.out.println("What you want to update");
                        int change;
                        do {
                           System.out.println("1. Change Name");
                           System.out.println("2. Change Course");
                           System.out.println("3. Change Fee");
                           System.out.println("4. Want to Exit From Updation");
                           System.out.println("Enter Your Choice: ");
                           change = sc.nextInt();
                           sc.nextLine();
                           switch(change) {
                              case 1: 
                              System.out.print("Enter Name: ");
                              String nname = sc.nextLine();
                              s.setName(nname);
                              s.display();
                              break;
                              case 2 :
                                 System.out.print("Enter Course Taken: ");
                                 String ncourse = sc.nextLine();
                                 s.setCourse(ncourse);
                                 break;
                                 case 3 :
                                    System.out.println("Enter Fee: ");
                                    int nfee = sc.nextInt();
                                    sc.nextLine();
                                    s.setFee(nfee);
                                    break;
                                    case 4 :
                                       System.out.println("Exiting From Updating Student...");
                              break;
                              default : System.out.println("Invalid Input");
                           }
                        } while(change!=4);
                          isfound = true;
                        break; }
                        }
                         if(!isfound) {
                           System.out.println("Student Not Found.");
                          }
                          break;
                          default : System.out.println("Invalid Input");
                  }
                         
       } while(choice !=6);
       sc.close();
      }
   }
