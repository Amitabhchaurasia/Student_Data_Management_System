import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
public class Server {
    public Connection connection_to_db(String dbname,String user,String password){
        Connection connection=null;
        try{
            Class.forName("org.postgresql.Driver");
            connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,password);
            if(connection!=null){
                System.out.println("\t\t\t--------------------------");
                System.out.println("\t\t\t DataBase is Connected !");
                System.out.println("\t\t\t--------------------------");
                System.out.print("\t\t Do You Want To Exit? Y or N ?: ");
                Scanner sc=new Scanner(System.in);
                char choice =sc.next().charAt(0);
                if(choice=='N' || choice=='n'){
                    System.out.print("\033[H\033[2J"); 
                    Main.menu();
                }else{
                    System.out.print("\033[H\033[2J"); 
                    System.exit(0);
                }
                sc.close();
            }else{
                System.out.println("\t\t\t--------------------------");
                System.out.println("\t\t\t DataBase is Not Connected");
                System.out.print("\t\t\t Do You Want To Exit? Y or N ?: ");
                Scanner sc=new Scanner(System.in);
                char choice =sc.next().charAt(0);
                if(choice=='N' || choice=='n'){
                    System.out.print("\033[H\033[2J"); 
                    Main.menu();
                }else{
                    System.exit(0);
                }
                sc.close();
            }

        }catch(Exception e){
            System.out.println(e);
        }
        return connection;
    }

    public Connection connection_o(String dbname,String user,String password){
        Connection connection=null;
        try{
            Class.forName("org.postgresql.Driver");
            connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,password);
            if(connection==null){
                System.out.println("\t\t\t--------------------------");
                System.out.println("\t\t\t DataBase is Not Connected");
                System.out.println("\t\t\t--------------------------");
            }

        }catch(Exception e){
            System.out.println(e);
        }
        return connection;
    }
}
