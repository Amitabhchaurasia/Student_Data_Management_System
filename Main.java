import java.util.*;
import java.sql.Connection;

public class Main {

    static void insert(Connection connection){
        Scanner sc = new Scanner(System.in) ;
            long regNo,pincode;
            String name,address;

            System.out.print("\t\t\t Enter Name: ");
            name=sc.nextLine();
            dataValidation nameData=new dataValidation(name);
            boolean result=nameData.nameAddvali();
                while(true){
                    if(result==true){
                        break;
                    }
                    else{
                        System.out.println("\t\t\t--------------------------");
                        System.out.print("\t\t\t Enter the Correct Name: ");
                        name=sc.nextLine();
                        dataValidation nameD=new dataValidation(name);
                        result=nameD.nameAddvali();
                    }
                }
            System.out.print("\t\t\t Enter Address: ");
            address=sc.nextLine();
            dataValidation addressData=new dataValidation(address);
            result=addressData.nameAddvali();
                while(true){
                    if(result==true){
                    break;
                    }else{
                        System.out.println("\t\t\t--------------------------");
                        System.out.print("\t\t\t Enter the Correct Adrees Fromate : ");
                        address=sc.nextLine();
                        dataValidation addressD=new dataValidation(address);
                        result=addressD.nameAddvali();
                    }
                }
              System.out.print("\t\t\t Enter PinCode: ");
              pincode=sc.nextLong();
              dataValidation pinData=new dataValidation(pincode);
              result=pinData.regPinVali();
              while(true){
                if(result==true){
                    break;
                }else{
                    System.out.println("\t\t\t--------------------------");
                        System.out.print("\t\t\t Enter the Correct PinCode Fromate i.e:- only num min and max 6 : ");
                        pincode=sc.nextLong();
                        dataValidation pinD=new dataValidation(pincode);
                        result=pinD.regPinVali();
                }
              }
              System.out.print("\t\t\t Enter Registration Number: ");
              regNo=sc.nextLong();
        sc.close();
        dataInsert db=new dataInsert(regNo,pincode,name,address);
        db.insertData(connection);

    }


    public static void main(String[] args) throws Exception {
        menu();
    }




    static void menu(){
        Connection connection=null;
        try (Scanner sc = new Scanner(System.in)) {
            
            System.out.println("\t\t\t 1.Cheeck The Connection");
            System.out.println("\t\t\t 2.ENTER THE NEW RECORD");
            System.out.println("\t\t\t 3.DISPLAY RECORED");
            System.out.println("\t\t\t 4.MODIFY RECORD");
            System.out.println("\t\t\t 5.SEARCH RECORED");
            System.out.println("\t\t\t 6.DELETE RECOREDS");
            System.out.println("\t\t\t 7.EXITS");
            System.out.print("\t\t\t CHOOSE OPTION [1 TO 6]: ");
            int option=sc.nextInt();
            switch (option) {
                case 1:
                    Server s=new Server();
                    connection=s.connection_to_db("postgres", "postgres", "Sql1234@");
                    break;
                case 2:
                    Server s1=new Server();
                    connection=s1.connection_o("postgres", "postgres", "Sql1234@");
                    insert(connection);
                    break;
                case 3:
                    System.out.print("\033[H\033[2J"); 
                    System.out.println("\t\t\t\t ***RECORDS***");
                    Server s2=new Server();
                    connection=s2.connection_o("postgres", "postgres", "Sql1234@");
                    showData sd=new showData();
                    sd.DataShow(connection);
                    break;
                case 4:
                System.out.print("\033[H\033[2J");
                    update up=new update();
                    up.updateData();
                    break;    
                case 6:
                    Server s3=new Server();
                    connection=s3.connection_o("postgres", "postgres", "Sql1234@"); 
                    deleteData dd=new deleteData();
                    dd.delete(connection);
                    break;   
                case 7:
                    System.out.print("\033[H\033[2J"); 
                    System.exit(0);         
                default:
                System.out.print("\033[H\033[2J"); 
                System.out.println("\t\t\t--------------------------");
                System.out.println("\t\t\t Enter Right Option:");
                System.out.println("\t\t\t--------------------------");
                    menu();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
