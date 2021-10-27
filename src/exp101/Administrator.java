package exp101;

public class Administrator {

    private String name;
    private String passWord;

    public String getName() {
        return name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    Administrator(){

    }
    Administrator(String name,String passWord){
        this.name=name;
        this.passWord=passWord;
    }
public void show(){
    System.out.println("姓名："+this.name+"密码："+this.passWord);
}



}
