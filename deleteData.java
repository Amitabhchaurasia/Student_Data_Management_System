import java.util.*;
import java.sql.Connection;
import java.sql.Statement;
public class deleteData {
    void delete(Connection connection){
        Statement statement;
        try{
            System.out.println("\t\t\t***DELTING THE RECORD***");
            System.out.print("\t\t\t Enter The RegNo:");
            Scanner sc=new Scanner(System.in);
            long reg=sc.nextLong();
            String q=String.format("DELETE FROM student WHERE regNo = %s;",reg);
            statement=connection.createStatement();
            statement.executeUpdate(q);
            
            System.out.print("\033[H\033[2J"); 
            System.out.println("\t\t\t Data is Deleted !");
            System.out.println("\t\t\t--------------------------");
            System.out.print("\t\t Do You Want To Exit? Y or N ?: ");
            char choice =sc.next().charAt(0);
            if(choice=='N' || choice=='n'){
                System.out.print("\033[H\033[2J"); 
                Main.menu();
            }else{
                System.out.print("\033[H\033[2J"); 
                System.exit(0);
            }
            
            sc.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
