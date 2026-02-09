package student;

public class Requirements {

    public boolean checkEventStringName(String name){

        String input = "[a-zA-Z ]+";
        if(!name.matches(input)){
            System.out.println(" Drīkst būt tikai anglu burti.");
            return false;
        }
        if(name.length() < 3){
            System.out.println("Burtu garums ir mazāks par 3.");
            return false;
        }
        return true;
    }

    public boolean checkEventStringEmail(String email){
        String input = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if(!email.matches(input)){
            System.out.println("E-pasta adrese nav derīga.");
            return false;
        }
        return true;
    }

    public boolean checkEventStringPersonalCode(String personalCode){
        String input = "^\\d{6}-\\d{5}$";
        if(!personalCode.matches(input)){
            System.out.println("Personas kods nepareizs. Tam jābūt 6 cipari, mīnus un tad 5 cipari");
            return false;
        }
        return true;
    }


}

