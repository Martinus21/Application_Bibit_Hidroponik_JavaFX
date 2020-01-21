package data;

public class UserAccount{
    private String username;
    private String password;

    public UserAccount(String usrName, String passName){
        this.username = usrName;
        this.password = passName;
    }

    // SET GET USERNAME
    public void setUserName(String acc_User){
        this.username = acc_User;
    }
    public String getUserName(){
        return username;
    }

    // SET GET PASSWORD
    public void setPassword(String acc_Password){
        this.password = acc_Password;
    }
    public String getPassword(){
        return password;
    }
}