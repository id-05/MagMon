import java.util.ArrayList;

public class MagMonRec {
    String Name;
    String IP;
    String Port;
    String Login;
    String Pass;
    String HePress;
    String HeLevel;
    String WaterFlow1;
    String WaterTemp1;
    String WaterFlow2;
    String WaterTemp2;
    String Status;
    ArrayList<String> Errors;
    String LastTime;

    public String getLastTime() {
        return LastTime;
    }

    public void setLastTime(String lastTime) {
        LastTime = lastTime;
    }

    public String getHePress() {
        return HePress;
    }

    public void setHePress(String hePress) {
        HePress = hePress;
    }

    public String getHeLevel() {
        return HeLevel;
    }

    public void setHeLevel(String heLevel) {
        HeLevel = heLevel;
    }

    public String getWaterFlow1() {
        return WaterFlow1;
    }

    public void setWaterFlow1(String waterFlow1) {
        WaterFlow1 = waterFlow1;
    }

    public String getWaterTemp1() {
        return WaterTemp1;
    }

    public void setWaterTemp1(String waterTemp1) {
        WaterTemp1 = waterTemp1;
    }

    public String getWaterFlow2() {
        return WaterFlow2;
    }

    public void setWaterFlow2(String waterFlow2) {
        WaterFlow2 = waterFlow2;
    }

    public String getWaterTemp2() {
        return WaterTemp2;
    }

    public void setWaterTemp2(String waterTemp2) {
        WaterTemp2 = waterTemp2;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public ArrayList<String> getErrors() {
        return Errors;
    }

    public void setErrors(ArrayList<String> errors) {
        Errors = errors;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getPort() {
        return Port;
    }

    public void setPort(String port) {
        Port = port;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }
}
