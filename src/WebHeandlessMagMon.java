import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WebHeandlessMagMon {

    public static Boolean autorise(Integer NumberMagMonList, JTextArea LogOut) throws IOException {
        Boolean result = false;
        try {
            MagMonRec MagMon = MainForm.MagMonList.get(NumberMagMonList);
            final WebClient webClient = new WebClient();
            //Загружаем нужную страницу
            final HtmlPage page1 = webClient.getPage("http://" + MagMon.IP + ":" + MagMon.Port);
            // Выбираем нужную форму,
            // находим кнопку отправки и поле, которое нужно заполнить.
            final HtmlForm form = page1.getFormByName("login");
            final HtmlTextInput textLogin = form.getInputByName("UserName");
            final HtmlPasswordInput textPass = form.getInputByName("PassWord");
            final HtmlSubmitInput button = form.getInputByValue("Submit");

            // Записывает в найденное поле нужное значение.
            textLogin.setValueAttribute(MagMon.Login);
            textPass.setValueAttribute(MagMon.Pass);
            // Теперь «кликаем» на кнопку и переходим на новую страницу.
            final HtmlPage page2 = button.click();
            webClient.close();
            result = true;
        }catch (Exception e){
            result = false;
        }
        return result;
    }

    public static Boolean getData(Integer NumberMagMonList, JTextArea LogOut) throws IOException {
        Boolean result = false;
        MagMonRec MagMon = MainForm.MagMonList.get(NumberMagMonList);
        final WebClient webClient = new WebClient();
        HtmlPage page3 = webClient.getPage("http://"+MagMon.IP+":"+MagMon.Port+"/coldhead.html");
        HtmlForm form2 = page3.getFormByName("curVal");
        HtmlTextInput textBUF = form2.getInputByName("Ch15");
        MainForm.MagMonList.get(NumberMagMonList).setHePress(textBUF.getText());
        MainForm.MagMonList.get(NumberMagMonList).setStatus("ok");
        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("HH:mm");

        MainForm.MagMonList.get(NumberMagMonList).setLastTime(formatForDateNow.format(date));

        textBUF = form2.getInputByName("Ch1");
        MainForm.MagMonList.get(NumberMagMonList).setHeLevel(textBUF.getText());

        page3 = webClient.getPage("http://"+MagMon.IP+":"+MagMon.Port+"/cur_a_vals.html");
        form2 = page3.getFormByName("curVal");

        textBUF = form2.getInputByName("Ch16");
        MainForm.MagMonList.get(NumberMagMonList).setWaterFlow1(textBUF.getText());

        textBUF = form2.getInputByName("Ch17");
        MainForm.MagMonList.get(NumberMagMonList).setWaterTemp1(textBUF.getText());

        textBUF = form2.getInputByName("Ch25");
        MainForm.MagMonList.get(NumberMagMonList).setWaterFlow2(textBUF.getText());

        textBUF = form2.getInputByName("Ch26");
        MainForm.MagMonList.get(NumberMagMonList).setWaterTemp2(textBUF.getText());

        textBUF = form2.getInputByName("Ch3");
        MainForm.MagMonList.get(NumberMagMonList).setHeLevelTopCurrent(textBUF.getText());

        textBUF = form2.getInputByName("Ch4");
        MainForm.MagMonList.get(NumberMagMonList).setHeLevelTop(textBUF.getText());

        textBUF = form2.getInputByName("Ch5");
        MainForm.MagMonList.get(NumberMagMonList).setReconRuOCurrent(textBUF.getText());

        textBUF = form2.getInputByName("Ch6");
        MainForm.MagMonList.get(NumberMagMonList).setReconRuO(textBUF.getText());

        textBUF = form2.getInputByName("Ch7");
        MainForm.MagMonList.get(NumberMagMonList).setSpareScanRoom1A(textBUF.getText());

        textBUF = form2.getInputByName("Ch8");
        MainForm.MagMonList.get(NumberMagMonList).setShieldTempCurrent(textBUF.getText());

        textBUF = form2.getInputByName("Ch9");
        MainForm.MagMonList.get(NumberMagMonList).setShieldTemp(textBUF.getText());

        textBUF = form2.getInputByName("Ch10");
        MainForm.MagMonList.get(NumberMagMonList).setReconSi410Current(textBUF.getText());

        textBUF = form2.getInputByName("Ch11");
        MainForm.MagMonList.get(NumberMagMonList).setReconSi410(textBUF.getText());

        textBUF = form2.getInputByName("Ch12");
        MainForm.MagMonList.get(NumberMagMonList).setSpareScanRoom1B(textBUF.getText());

        textBUF = form2.getInputByName("Ch13");
        MainForm.MagMonList.get(NumberMagMonList).setColdheadRuOCurrent(textBUF.getText());

        textBUF = form2.getInputByName("Ch18");
        MainForm.MagMonList.get(NumberMagMonList).setSCPressure(textBUF.getText());

        textBUF = form2.getInputByName("Ch19");
        MainForm.MagMonList.get(NumberMagMonList).setSpareCmp1b(textBUF.getText());

        textBUF = form2.getInputByName("Ch20");
        MainForm.MagMonList.get(NumberMagMonList).setSpareCmp1c(textBUF.getText());

        textBUF = form2.getInputByName("Ch21");
        MainForm.MagMonList.get(NumberMagMonList).setReconSi4102a(textBUF.getText());

        textBUF = form2.getInputByName("Ch22");
        MainForm.MagMonList.get(NumberMagMonList).setReconSi4102aCurrent(textBUF.getText());

        textBUF = form2.getInputByName("Ch23");
        MainForm.MagMonList.get(NumberMagMonList).setReconSi4102b(textBUF.getText());

        textBUF = form2.getInputByName("Ch24");
        MainForm.MagMonList.get(NumberMagMonList).setReconSi4102bCurrent(textBUF.getText());

        textBUF = form2.getInputByName("Ch27");
        MainForm.MagMonList.get(NumberMagMonList).setVoltsPlusExternal(textBUF.getText());

        textBUF = form2.getInputByName("Ch28");
        MainForm.MagMonList.get(NumberMagMonList).setVoltsPlus(textBUF.getText());

        textBUF = form2.getInputByName("Ch29");
        MainForm.MagMonList.get(NumberMagMonList).setVoltsMinus(textBUF.getText());

        textBUF = form2.getInputByName("Ch30");
        MainForm.MagMonList.get(NumberMagMonList).setVoltsMinusExternal(textBUF.getText());

        textBUF = form2.getInputByName("Ch31");
        MainForm.MagMonList.get(NumberMagMonList).setHFOBottomShield(textBUF.getText());

        textBUF = form2.getInputByName("Ch32");
        MainForm.MagMonList.get(NumberMagMonList).setMagmonCaseTemp(textBUF.getText());



        page3 = webClient.getPage("http://"+MagMon.IP+":"+MagMon.Port+"/alarms.html");
        WebResponse response = page3.getWebResponse();
        String content = response.getContentAsString();
        Document doc = (Document) Jsoup.parseBodyFragment(content);
        Elements fullHtml = doc.getElementsByTag("pre");

        ArrayList<String> bufList = ErrParse(fullHtml.toString());
        String buf;
        if(bufList.size()<1){
            buf = "OK";
        }
        else{
            buf = bufList.size()+" Error";
        }
        MainForm.MagMonList.get(NumberMagMonList).setStatus(buf);
        MainForm.MagMonList.get(NumberMagMonList).setErrors(bufList);

        webClient.close();
        return result;
    }

    public static ArrayList<String> ErrParse(String sourcetext){
        ArrayList<String> result = null;
        ArrayList<String> ListStr = new ArrayList<String>();
        ArrayList<String> ListBuf = new ArrayList<String>();
        for (String retval : sourcetext.split("\\n")) {
            ListStr.add(retval);
        }
        for(int i=0; i<=ListStr.size()-1;i++){
            if(ListStr.get(i).contains("<")|(ListStr.get(i).length()<2)|(ListStr.get(i).contains("-"))){

            }
            else {
                ListBuf.add(ListStr.get(i));
            }
        }
        return ListBuf;
    }
}
