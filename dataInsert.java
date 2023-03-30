import java.sql.Connection;


public class dataInsert extends Main{
    long regNo,pincode;
    String name,address;
    dataInsert(){
        this.regNo=0;
        this.pincode=0;
        this.name=null;
        this.address=null;
    }
    dataInsert(long regNo,long pincode,String name,String address){
        this.regNo=regNo;
        this.pincode=pincode;
        this.name=name;
        this.address=address;
    }
    void insertData(Connection connection){
        java.sql.Statement statement;
        try{
            String q=String.format("insert into student(regNo,pincode,name,address)values('%s','%s','%s','%s');",regNo,pincode,name,address);
            statement=connection.createStatement();
            statement.executeUpdate(q);

            System.out.print("\033[H\033[2J"); 
            System.out.println("\t\t\t--------------------------");
            System.out.println("\t\t\t DATA INSERTED !!");
            System.out.println("\t\t\t--------------------------");
        
        }catch(Exception e){
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