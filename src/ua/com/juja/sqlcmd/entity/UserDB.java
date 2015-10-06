package ua.com.juja.sqlcmd.entity;


public class UserDB {

    private String databaseName;
    private String userName;
    private String password;

    public UserDB() {
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDB userDB = (UserDB) o;

        if (databaseName != null ? !databaseName.equals(userDB.databaseName) : userDB.databaseName != null)
            return false;
        if (userName != null ? !userName.equals(userDB.userName) : userDB.userName != null) return false;
        return !(password != null ? !password.equals(userDB.password) : userDB.password != null);

    }

    @Override
    public int hashCode() {
        int result = databaseName != null ? databaseName.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserDB{" +
                "databaseName='" + databaseName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
