import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "company.com";

    //Constructor to receive the first name and the last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
       // System.out.println("\n************************************************************");
       // System.out.println("Email Created: " +this.firstName+" " +this.lastName);
       // System.out.println("************************************************************");

        //Call a method asking for the department - return the department
        this.department = setDepartment();
       // System.out.println("\n************************************************************");
       // System.out.println("Department: "+this.department);
       // System.out.println("************************************************************");

        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("\n************************************************************");
        System.out.println("Your Password is =>" +this.password);
        System.out.println("************************************************************\n");

        //Combine elements to generate email
        email = firstName.toLowerCase() + "." +lastName.toLowerCase() + "@" +department + "." + companySuffix;
       // System.out.println("\n************************************************************");
       // System.out.println("Your Email is => " + email);
       // System.out.println("************************************************************\n");
    }

    //Ask for the department
    private String setDepartment(){
        System.out.println("New Worker => " + firstName +  ". \nDepartment Codes:\n1 => Sales\n2 => Development\n3 => Accounting\n0 => None\nEnter Department Code:");
        Scanner in = new Scanner(System.in);
       int depChoice = in.nextInt();
       if (depChoice == 1){
        return "Sales";
       } 
       else if(depChoice == 2){
        return "Development";
       }
       else if(depChoice == 3){
        return "Account";
       }
       else{
        return "";
       }

    }

    //Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#%&*";
        char[] password = new char [length];
        for (int i=0; i<length; i++){
          int rand = (int) (Math.random() * passwordSet.length());
          password[i] = passwordSet.charAt(rand);
        }
        return new String (password);
    }

    //Set the mailbox capacity 
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    //Change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity (){
        return mailboxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "\nDisplay Name => " + firstName+ " " +lastName +
                "\nCompany Email => " + email +
                "\nMailbox Capacity => " + mailboxCapacity + "Mb\n";
    }
 }
