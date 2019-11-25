package reflect.test1;

public class SonClass extends FatherClass {

    private String SonName;
    protected int SonAge;
    public String SonBirthday;


    public void printSonMsg(){
        System.out.println("Son Msg - name : "
                + SonName + "; age : " + SonAge);
    }

    private void setSonName(String name){
        SonName = name;
    }

    private void setSonAge(int age){
        SonAge = age;
    }

    private int getSonAge(){
        return SonAge;
    }

    private String getSonName(){
        return SonName;
    }
}