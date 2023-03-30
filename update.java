import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class update {
    public void updateData(){
        Scanner sc =new Scanner(System.in);
        Connection connection;
        System.out.print("\t\t\tEnter The Reg:No , Whose Data You Want To Upadate::");
        long regNo=sc.nextLong();

        String q2=String.format("select * from student where regNo='%s';",regNo);
        try{
        Server s2=new Server();
        connection=s2.connection_o("postgres", "postgres", "Sql1234@");
        PreparedStatement statement=connection.prepareStatement(q2);
        ResultSet result=statement.executeQuery();
        //System.out.println(result.getString("name"));
        if(result.next()==true){
            while(result.next()){
                String name = result.getString("name");
                    int regN = result.getInt("regNo");
                    int pincode = result.getInt("pincode");
                    String address = result.getString("address");
                    System.out.println("\t\tName: " + name + " regNo: "+regN+" "+"pincode: "+pincode+" "+"address: "+address);
                    
            } 
            }else{
            System.out.println("Data Not Present !");
                System.out.println("Do You Want To Go Main Menu ? ,i:e:- Y,N");
                char ch =sc.next().charAt(0);
                if(ch=='Y' ||ch=='y'){
                    System.out.print("\033[H\033[2J"); 
                    Main.menu();
                }
                else{
                    System.exit(0);
                }
                
            }

        }catch(Exception e){
            System.out.println(e);
        }

        System.out.println("\t\t\t\t What You Want To Upadte ?");
        System.out.println("\t\t\t\t 1:Name  2:Address  3:Pincode   4:Reg:NO");
        int choice=sc.nextInt();

        switch(choice){
            case 1: System.out.println("Enter New Name !");
                    String name=sc.next();
                    Server s=new Server();
                    connection=s.connection_o("postgres", "postgres", "Sql1234@");
                    try{
                      String q=String.format("UPDATE student SET name='%s' WHERE regNo='%s';",name,regNo); 
                       PreparedStatement stmt=connection.prepareStatement(q);
                       stmt.executeUpdate();
                        System.out.println("Name Updated!");
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    break;
            case 2:
                    System.out.println("\t\t\t Enter The New Address ");
                    String address=sc.next();
                    Server s3=new Server();
                    connection=s3.connection_o("postgres", "postgres", "Sql1234@");
                    try{
                        String q=String.format("UPDATE student SET address='%s' WHERE regNo='%s';",address,regNo); 
                         PreparedStatement stmt=connection.prepareStatement(q);
                         stmt.executeUpdate();
                          System.out.println("Address Updated!");
                      }catch(Exception e){
                          System.out.println(e);
                      }
                      break; 
            case 3:
                    System.out.println("\t\t\t Enter New Pincode");
                    int pincode=sc.nextInt();
                    Server s4=new Server();
                    connection=s4.connection_o("postgres", "postgres", "Sql1234@");
                    try{
                        String q=String.format("UPDATE student SET pincode='%s' WHERE regNo='%s';",pincode,regNo); 
                         PreparedStatement stmt=connection.prepareStatement(q);
                         stmt.executeUpdate();
                          System.out.println("PinCode Updated!");
                      }catch(Exception e){
                          System.out.println(e);
                      }
                      
                      break;
            case 4: 
                    System.out.println("\t\t\t Enter New Reg:No");
                    int reg=sc.nextInt();
                    Server s5=new Server();
                    connection=s5.connection_o("postgres", "postgres", "Sql1234@");
                    try{
                        String q=String.format("UPDATE student SET regNo='%s' WHERE regNo='%s';",reg,regNo); 
                        PreparedStatement stmt=connection.prepareStatement(q);
                        stmt.executeUpdate();
                        System.out.println("Reg:No Updated!");
                      }catch(Exception e){
                          System.out.println(e);
                      }
                      break; 
                      default:
                System.out.print("\033[H\033[2J"); 
                System.out.println("\t\t\t--------------------------");
                System.out.println("\t\t\t Enter Right Option:");
                System.out.println("\t\t\t--------------------------");
                updateData();                                   
        }
        
        sc.close();
    }
}