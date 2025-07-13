import java.util.*;
import java.io.*;
class Main{
    static Scanner sc=new Scanner(System.in);
    static ArrayList <String> tasks=new ArrayList<>();
    static ArrayList <String> completedtasks=new ArrayList<>();

    static void add(){
        System.out.println("What is your task today");
        sc.nextLine();
        String task=sc.nextLine();
        tasks.add(task);
        System.out.println("Succesfully Added");
    }
    static void remove(){
        System.out.println("Please Enter a task Number before remove make sure task can't be recovered again");
        int index=sc.nextInt();
        if(index>=1 && index<=tasks.size()){
            tasks.remove(index-1);
            System.out.println("Task is removed successfully");
        }
        else{
            System.out.println("There is only "+tasks.size()+" Tasks.");
        }
        
    }
    
    static void Mark_task(){
        System.out.println("Wow!!!Are u completed the task please Enter a task number");
        int index=sc.nextInt();
        if(index>=1 && index<=tasks.size()){
            String progresstask=tasks.get(index-1);
            tasks.remove(index-1);
            completedtasks.add(progresstask);
            System.out.println("Task is removed successfully");
        }
        else{
            System.out.println("There is only "+tasks.size()+" Tasks.");
        }
        
    }
    
    static void  view_complete_task(){
        if(completedtasks.isEmpty()){
            System.out.println("No completed tasks yet.");    
        }
        else{
        for(int i=0;i<completedtasks.size();i++){
            System.out.println(i+1+" "+completedtasks.get(i));
        }    
        }
        
    }
    static void all_task(){
        for(int i=0;i<tasks.size();i++){
            System.out.println(i+1+"."+tasks.get(i));
        }
    }
    static void savetofile(){
    try{
    FileWriter pending_task=new FileWriter("Pending_tasks.txt");
    FileWriter completed_task=new FileWriter("Completed_tasks.txt");
        for(int i=0;i<tasks.size();i++)
            pending_task.write(tasks.get(i)+"\n");
        for(int i=0;i<completedtasks.size();i++)
            completed_task.write(completedtasks.get(i)+"\n");
    pending_task.close();
    completed_task.close();

        }
        catch(Exception ex){
        System.out.println("An error Occured , Try again Later");
        }
        }
    public static void main(String[] args){
    System.out.println("\n1. Add Task");
    System.out.println("2. Remove Task");
    System.out.println("3. Mark Task as Done");
    System.out.println("4. View All Tasks");
    System.out.println("5. View Completed Tasks");
    System.out.println("6. Exit");
    
    
    while(true){
        System.out.println("Enter the Choice");
        int choice=sc.nextInt();
        if(choice==1){
            add();
        }
        else if(choice==2){
            remove();
        }
        else if(choice==3){
            Mark_task();
        }
        else if(choice==4){
            all_task();
        }
        else if(choice==5){
            view_complete_task();
        }
        else if(choice==6){
            System.out.println("Before Exit, do you like to store the task as a File ? Yes or No");
            sc.nextLine();
            String userans=sc.nextLine().toLowerCase();
            if(userans.equals("yes")){
                savetofile();
                 System.out.println("Tasks saved. Thank you!");
                 return;
            }
            else if(userans.equals("no")){
               System.out.println("Thank you!!!");
               return;
            }
            else{
             System.out.println("Please choose Yes or No ?");
            }
        }
        else{
         System.out.println("Invalid Choice");
        }
    }
    }
}
