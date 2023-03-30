import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class showData {
    void DataShow(Connection connection){
        try{
            String q=String.format("select * from student;");
            PreparedStatement statement=connection.prepareStatement(q);
            ResultSet result=statement.executeQuery();
            while(result.next()){
                String name = result.getString("name");
                int regNo = result.getInt("regNo");
                int pincode = result.getInt("pincode");
                String address = result.getString("address");
                System.out.println("\t\tName: " + name + " regNo: "+regNo+" "+"pincode: "+pincode+" "+"address: "+address);
            }
            System.out.print("\t\tDo You Want To Go Back Main Menu ? Y or N ?: ");
                Scanner sc=new Scanner(System.in);
                char choice =sc.next().charAt(0);
                if(choice=='Y' || choice=='y'){
                    System.out.print("\033[H\033[2J"); 
                    Main.menu();
                }else{
                    System.exit(0);
                }
                sc.close();
            
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
/*
table name student
    IMPORTANT ENTITY
    regNo int PRIMARY KEY,
    pincode int,
    name varchar(255),
    address varchar(255)

 */