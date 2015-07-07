package demo.Users;

import demo.Users.Exceptions.IllegalPrivilegeLevelException;
import demo.Users.Exceptions.NotExistUserException;
import demo.Users.Exceptions.UserAlreadyExistsException;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UsersInRam implements UserStorage {
    private Map<String, User> users = new HashMap<>();
    private int lastUserId=0;

    public void addNewUser (User user) {
        if (userNameExists(user.getUserName())){
            throw new UserAlreadyExistsException("The user name already existed: " + user.getUserName());
        }

        if (user.getUserPrivilegeLevel() >=0 && user.getUserPrivilegeLevel() <= 3) {
            user.setUserId(lastUserId + 1);
            users.put(user.getUserName(), user);
            lastUserId++;
        }else {
            throw new IllegalPrivilegeLevelException("Invalid userPrivilegeLevel: " + user.getUserPrivilegeLevel() + "Expected values 0...3");
        }
    }

    @Override
    public void removeUser(int id) {
        for (Map.Entry<String, User> entry: users.entrySet()){
            if (entry.getValue().getUserId() == id)
            {
                removeUser(entry.getKey());
                break;
            }
        }
        throw new NotExistUserException("User with id: " + id + " wasn't found");
    }

    @Override
    public void removeUser(String name) {
        users.remove(name);
    }

    @Override
    public void showAllUser(PrintStream output) {
        output.println("#Id         #UserName       #UserPrivilegeLevel");
        for (String key: users.keySet()) {
            output.println(users.get(key).getUserId() + "   " + users.get(key).getUserName() + "    " + users.get(key).getUserPrivilegeLevel());
        }
    }


    @Override
    public int getUserId(String name) {
        return users.get(name).getUserId();
    }

    public User getUserByName(String name) {
        return users.get(name);
    }

    @Override
    public String getUserName(int id) {
        for (Map.Entry<String, User> entry: users.entrySet()){
            if (entry.getValue().getUserId() == id)
            {
                return entry.getValue().getUserName();
            }
        }
        throw new NotExistUserException("User with id: " + id + " wasn't found");
    }

    public int getUserPrivilegeLevel(String name) {
        return users.get(name).getUserPrivilegeLevel();
    }

    @Override
    public boolean userIdExists(int id) {
        boolean ret = false;
        for (Map.Entry<String, User> entry: users.entrySet()){
            if (entry.getValue().getUserId() == id)
            {
                ret = true;
                break;
            }
        }
        return ret;
    }

    @Override
    public boolean userNameExists(String name) {
        return (users.containsKey(name));
    }

    @Override
    public boolean validateUser(User user) {
        if (userNameExists(user.getUserName()) ){
            User userInStorage = getUserByName(user.getUserName());
            return  userInStorage.getPassword().equals(user.getPassword());
        }else{
            return false;
        }
    }
}
