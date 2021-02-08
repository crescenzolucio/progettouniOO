package Interfaces;

public interface UserDAO {
    public boolean findUser(String user);
    public boolean checkPassword(String user,String password);
    public boolean addUser(String user,String password,String email);
}
