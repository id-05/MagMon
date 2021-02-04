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
    Boolean StatusChange;

    String HeLevelCurrent;
    String HeLevelTopCurrent;
    String HeLevelTop;
    String ReconRuOCurrent;
    String ReconRuO;
    String SpareScanRoom1A;
    String ShieldTempCurrent;
    String ShieldTemp;
    String ReconSi410Current;
    String ReconSi410;
    String SpareScanRoom1B;
    String ColdheadRuOCurrent;
    String ColdheadTemp;
    String SCPressure;
    String SpareCmp1b;
    String SpareCmp1c;
    String ReconSi4102a;
    String ReconSi4102aCurrent;
    String ReconSi4102b;
    String ReconSi4102bCurrent;
    String VoltsPlusExternal;
    String VoltsPlus;
    String VoltsMinus;
    String VoltsMinusExternal;
    String HFOBottomShield;
    String MagmonCaseTemp;


    public String getHeLevelCurrent() {
        return HeLevelCurrent;
    }

    public void setHeLevelCurrent(String heLevelCurrent) {
        HeLevelCurrent = heLevelCurrent;
    }

    public String getHeLevelTopCurrent() {
        return HeLevelTopCurrent;
    }

    public void setHeLevelTopCurrent(String heLevelTopCurrent) {
        HeLevelTopCurrent = heLevelTopCurrent;
    }

    public String getHeLevelTop() {
        return HeLevelTop;
    }

    public void setHeLevelTop(String heLevelTop) {
        HeLevelTop = heLevelTop;
    }

    public String getReconRuOCurrent() {
        return ReconRuOCurrent;
    }

    public void setReconRuOCurrent(String reconRuOCurrent) {
        ReconRuOCurrent = reconRuOCurrent;
    }

    public String getReconRuO() {
        return ReconRuO;
    }

    public void setReconRuO(String reconRuO) {
        ReconRuO = reconRuO;
    }

    public String getSpareScanRoom1A() {
        return SpareScanRoom1A;
    }

    public void setSpareScanRoom1A(String spareScanRoom1A) {
        SpareScanRoom1A = spareScanRoom1A;
    }

    public String getShieldTempCurrent() {
        return ShieldTempCurrent;
    }

    public void setShieldTempCurrent(String shieldTempCurrent) {
        ShieldTempCurrent = shieldTempCurrent;
    }

    public String getShieldTemp() {
        return ShieldTemp;
    }

    public void setShieldTemp(String shieldTemp) {
        ShieldTemp = shieldTemp;
    }

    public String getReconSi410Current() {
        return ReconSi410Current;
    }

    public void setReconSi410Current(String reconSi410Current) {
        ReconSi410Current = reconSi410Current;
    }

    public String getReconSi410() {
        return ReconSi410;
    }

    public void setReconSi410(String reconSi410) {
        ReconSi410 = reconSi410;
    }

    public String getSpareScanRoom1B() {
        return SpareScanRoom1B;
    }

    public void setSpareScanRoom1B(String spareScanRoom1B) {
        SpareScanRoom1B = spareScanRoom1B;
    }

    public String getColdheadRuOCurrent() {
        return ColdheadRuOCurrent;
    }

    public void setColdheadRuOCurrent(String coldheadRuOCurrent) {
        ColdheadRuOCurrent = coldheadRuOCurrent;
    }

    public String getColdheadTemp() {
        return ColdheadTemp;
    }

    public void setColdheadTemp(String coldheadTemp) {
        ColdheadTemp = coldheadTemp;
    }

    public String getSCPressure() {
        return SCPressure;
    }

    public void setSCPressure(String SCPressure) {
        this.SCPressure = SCPressure;
    }

    public String getSpareCmp1b() {
        return SpareCmp1b;
    }

    public void setSpareCmp1b(String spareCmp1b) {
        SpareCmp1b = spareCmp1b;
    }

    public String getSpareCmp1c() {
        return SpareCmp1c;
    }

    public void setSpareCmp1c(String spareCmp1c) {
        SpareCmp1c = spareCmp1c;
    }

    public String getReconSi4102a() {
        return ReconSi4102a;
    }

    public void setReconSi4102a(String reconSi4102a) {
        ReconSi4102a = reconSi4102a;
    }

    public String getReconSi4102aCurrent() {
        return ReconSi4102aCurrent;
    }

    public void setReconSi4102aCurrent(String reconSi4102aCurrent) {
        ReconSi4102aCurrent = reconSi4102aCurrent;
    }

    public String getReconSi4102b() {
        return ReconSi4102b;
    }

    public void setReconSi4102b(String reconSi4102b) {
        ReconSi4102b = reconSi4102b;
    }

    public String getReconSi4102bCurrent() {
        return ReconSi4102bCurrent;
    }

    public void setReconSi4102bCurrent(String reconSi4102bCurrent) {
        ReconSi4102bCurrent = reconSi4102bCurrent;
    }

    public String getVoltsPlusExternal() {
        return VoltsPlusExternal;
    }

    public void setVoltsPlusExternal(String voltsPlusExternal) {
        VoltsPlusExternal = voltsPlusExternal;
    }

    public String getVoltsPlus() {
        return VoltsPlus;
    }

    public void setVoltsPlus(String voltsPlus) {
        VoltsPlus = voltsPlus;
    }

    public String getVoltsMinus() {
        return VoltsMinus;
    }

    public void setVoltsMinus(String voltsMinus) {
        VoltsMinus = voltsMinus;
    }

    public String getVoltsMinusExternal() {
        return VoltsMinusExternal;
    }

    public void setVoltsMinusExternal(String voltsMinusExternal) {
        VoltsMinusExternal = voltsMinusExternal;
    }

    public String getHFOBottomShield() {
        return HFOBottomShield;
    }

    public void setHFOBottomShield(String HFOBottomShield) {
        this.HFOBottomShield = HFOBottomShield;
    }

    public String getMagmonCaseTemp() {
        return MagmonCaseTemp;
    }

    public void setMagmonCaseTemp(String magmonCaseTemp) {
        MagmonCaseTemp = magmonCaseTemp;
    }

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


    public Boolean getStatusChange() {
        return StatusChange;
    }

    public void setStatusChange(Boolean statusChange) {
        StatusChange = statusChange;
    }
}
