public class dataValidation extends Main{
    String nameAddress;
    String regNoPincode;
    String nameadds = "^[A-Za-z][A-Za-z0-9_$\\- ]*[A-Za-z]$";
    String regPin = "^[0-9]{6}$";
    dataValidation(){
        this.nameAddress=null;
        this.regNoPincode=null;
    }
    dataValidation(long regnoPincode){
        String z=String.valueOf(regnoPincode);
        this.regNoPincode=z;
    }
    dataValidation(String nameAdd){
        this.nameAddress=nameAdd;
    }
    boolean nameAddvali(){
        return nameAddress.matches(nameadds);
    }
    boolean regPinVali(){
        return regNoPincode.matches(regPin);
    }
}
