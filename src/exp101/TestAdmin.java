package exp101;

public class TestAdmin {

    public static void main(String[] args) {
        Administrator adm1=new Administrator("admin1","111111");
        Administrator adm2=new Administrator();
        adm2.setName("admin2");
        adm2.setPassWord("222222");
        adm1.show();
        adm2.show();
    }

}
