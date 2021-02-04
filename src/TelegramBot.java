import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class TelegramBot extends TelegramLongPollingBot {

    String Token;
    String UserName = "mri_dkb_bot";

    public TelegramBot(String Token){
         this.Token = Token;
         this.Token = Token;
    }


    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {

            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println("Error send");
        }
    }


    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()){
            if(update.getMessage().hasText()){
                if(update.getMessage().getText().equals("/start")){
                    try {
                        execute(sendInlineKeyBoardMessage(update.getMessage().getChatId()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else if(update.hasCallbackQuery()){
            String firstTeg = "";
            String secondTeg = "";
            JsonObject jsonObject = JsonParser.parseString(update.getCallbackQuery().getData()).getAsJsonObject();
            if (jsonObject.has("name")) {
                firstTeg = jsonObject.get("name").getAsString();
                System.out.println("firstTeg :"+firstTeg);
            }
            if (jsonObject.has("data")) {
                secondTeg = jsonObject.get("data").getAsString();
                System.out.println("secondTeg :"+secondTeg);
            }

            if(firstTeg.equals("list")){
                ListMenu(update);
            }

            if(firstTeg.equals("device")){
                DeviceMenu(update,secondTeg,"");
            }

            if(firstTeg.equals("settings")){
                if(secondTeg.equals("settings")) {
                    SettingsMenu(update);
                }
                if(secondTeg.equals("time")) {
                    ChangeParamMenu(update,"Time to update: "+MainForm.timeToMagMonUpdate,secondTeg);
                }
                if(secondTeg.equals("webport")) {
                    ChangeParamMenu(update,"Web Port: "+MainForm.WebPort,secondTeg);
                }
                if(secondTeg.equals("botmode")) {
                    MainForm.BotMode = !MainForm.BotMode;
                    MainForm.userPrefs.putBoolean("TelegramBotMode", MainForm.BotMode);
                    SettingsMenu(update);
                }
                if(secondTeg.equals("reload")) {
                    MainForm.reloadTimeAndWeb();
                }
                if(secondTeg.equals("time-")) {
                    if(MainForm.timeToMagMonUpdate!=1) {
                        MainForm.timeToMagMonUpdate = MainForm.timeToMagMonUpdate - 1;
                        MainForm.userPrefs.putInt("TimeToUpdate",MainForm.timeToMagMonUpdate);
                        ChangeParamMenu(update, "Time to update: " + MainForm.timeToMagMonUpdate, "time");
                    }
                }
                if(secondTeg.equals("time+")) {
                    if(MainForm.timeToMagMonUpdate!=44) {
                        MainForm.timeToMagMonUpdate = MainForm.timeToMagMonUpdate + 1;
                        MainForm.userPrefs.putInt("TimeToUpdate",MainForm.timeToMagMonUpdate);
                        ChangeParamMenu(update, "Time to update: " + MainForm.timeToMagMonUpdate, "time");
                    }
                }
                if(secondTeg.equals("webport-")) {
                    if(MainForm.WebPort!=1) {
                        MainForm.WebPort = MainForm.WebPort - 1;
                        MainForm.userPrefs.putInt("WebPort",MainForm.WebPort);
                        ChangeParamMenu(update,"Web Port: "+MainForm.WebPort,"webport");
                    }
                }
                if(secondTeg.equals("webport+")) {
                    if(MainForm.WebPort<=32000) {
                        MainForm.WebPort = MainForm.WebPort + 1;
                        MainForm.userPrefs.putInt("WebPort",MainForm.WebPort);
                        ChangeParamMenu(update,"Web Port: "+MainForm.WebPort,"webport");
                    }
                }
            }

            if(firstTeg.equals("short")){
                Integer i = Integer.valueOf(secondTeg);
                String buf = "\n HePress: "+MainForm.MagMonList.get(i).getHePress()+
                        "\n HeLevel: "+MainForm.MagMonList.get(i).getHeLevel()+
                        "\n WaterTemp1: "+MainForm.MagMonList.get(i).getWaterTemp1()+
                        "\n WaterFlow1: "+MainForm.MagMonList.get(i).getWaterFlow1()+
                        "\n Status: "+MainForm.MagMonList.get(i).getStatus();
                DeviceMenu(update,secondTeg,buf);
                //CustomEditMessage(update,buf);
            }

            if(firstTeg.equals("full")){
                Integer i = Integer.valueOf(secondTeg);
                String buf = "\n HePress: "+MainForm.MagMonList.get(i).getHePress()+
                        "\n HeLevel: "+MainForm.MagMonList.get(i).getHeLevel()+
                        "\n WaterTemp1: "+MainForm.MagMonList.get(i).getWaterTemp1()+
                        "\n WaterFlow1: "+MainForm.MagMonList.get(i).getWaterFlow1()+
                        "\n WaterTemp2: "+MainForm.MagMonList.get(i).getWaterTemp2()+
                        "\n WaterFlow2: "+MainForm.MagMonList.get(i).getWaterFlow2()+
                        "\n HeLevelCurrent: "+MainForm.MagMonList.get(i).getHeLevelCurrent()+
                        "\n HeLevelTopCurrent: "+MainForm.MagMonList.get(i).getHeLevelTopCurrent()+
                        "\n HeLevelTop: "+MainForm.MagMonList.get(i).getHeLevelTop()+
                        "\n ReconRuOCurrent: "+MainForm.MagMonList.get(i).getReconRuOCurrent()+
                        "\n ReconRuO: "+MainForm.MagMonList.get(i).getReconRuO()+
                        "\n SpareScanRoom1A: "+MainForm.MagMonList.get(i).getSpareScanRoom1A()+
                        "\n ShieldTempCurrent: "+MainForm.MagMonList.get(i).getShieldTempCurrent()+
                        "\n ShieldTemp: "+MainForm.MagMonList.get(i).getShieldTemp()+
                        "\n ReconSi410Current: "+MainForm.MagMonList.get(i).getReconSi410Current()+
                        "\n ReconSi410: "+MainForm.MagMonList.get(i).getReconSi410()+
                        "\n SpareScanRoom1B: "+MainForm.MagMonList.get(i).getSpareScanRoom1B()+
                        "\n ColdheadRuOCurrent: "+MainForm.MagMonList.get(i).getColdheadRuOCurrent()+
                        "\n ColdheadTemp: "+MainForm.MagMonList.get(i).getColdheadTemp()+
                        "\n SCPressure: "+MainForm.MagMonList.get(i).getSCPressure()+
                        "\n SpareCmp1b: "+MainForm.MagMonList.get(i).getSpareCmp1b()+
                        "\n SpareCmp1c: "+MainForm.MagMonList.get(i).getSpareCmp1c()+
                        "\n ReconSi4102a: "+MainForm.MagMonList.get(i).getReconSi4102a()+
                        "\n ReconSi4102aCurrent: "+MainForm.MagMonList.get(i).getReconSi4102aCurrent()+
                        "\n ReconSi4102b: "+MainForm.MagMonList.get(i).getReconSi4102b()+
                        "\n ReconSi4102bCurrent: "+MainForm.MagMonList.get(i).getReconSi4102bCurrent()+
                        "\n VoltsPlusExternal: "+MainForm.MagMonList.get(i).getVoltsPlusExternal()+
                        "\n VoltsPlus: "+MainForm.MagMonList.get(i).getVoltsPlus()+
                        "\n VoltsMinus: "+MainForm.MagMonList.get(i).getVoltsMinus()+
                        "\n VoltsMinusExternal: "+MainForm.MagMonList.get(i).getVoltsMinusExternal()+
                        "\n HFOBottomShield: "+MainForm.MagMonList.get(i).getHFOBottomShield()+
                        "\n MagmonCaseTemp: "+MainForm.MagMonList.get(i).getMagmonCaseTemp()+
                        "\n Status: "+MainForm.MagMonList.get(i).getStatus();
                DeviceMenu(update,secondTeg,buf);
            }

            if(firstTeg.equals("error")){
                Integer i = Integer.valueOf(secondTeg);
                String errors = "";
                if(MainForm.MagMonList.get(i).getErrors().size()>0){
                    ArrayList<String> bufList = MainForm.MagMonList.get(i).getErrors();
                    for (int j = 0; j <= bufList.size() - 1; j++) {
                        errors = errors + bufList.get(j) + "\n";
                    }
                }
                String buf = "\n Errors: \n"+errors;
                DeviceMenu(update,secondTeg,buf);
            }

            if(firstTeg.equals("back")){
                if(secondTeg.equals("main")){
                    MainMenu(update);
                }
                if(secondTeg.equals("list")){
                    ListMenu(update);
                }
                if(secondTeg.equals("settings")){
                    SettingsMenu(update);
                }
            }
        }
    }

    public void CustomEditMessage(Update update, String text){
        EditMessageText editMessage = new EditMessageText();
        editMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        editMessage.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
        editMessage.setText(text);
        try {
            execute(editMessage);
        } catch (TelegramApiException ex){
            System.out.println(ex.toString());
        }
    }

    public void ChangeParamMenu(Update update, String texttomes, String NameParam){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("-");
        inlineKeyboardButton1.setCallbackData(JsonEdit.GetJsonForBotMenu("settings",NameParam+"-"));
        inlineKeyboardButton2.setText("+");
        inlineKeyboardButton2.setCallbackData(JsonEdit.GetJsonForBotMenu("settings",NameParam+"+"));
        keyboardButtonsRow.add(inlineKeyboardButton1);
        keyboardButtonsRow.add(inlineKeyboardButton2);
        rowList.add(keyboardButtonsRow);
        rowList.add(SetOneRowButton("Back",JsonEdit.GetJsonForBotMenu("back","settings")));
        inlineKeyboardMarkup.setKeyboard(rowList);

        EditMessageText editMessage = new EditMessageText();
        editMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        editMessage.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
        editMessage.setText(texttomes);
        editMessage.setReplyMarkup(inlineKeyboardMarkup);
        try {
            execute(editMessage);
        } catch (TelegramApiException ex){
            System.out.println(ex.toString());
        }
    }

    public void DeviceMenu(Update update, String secondTeg, String info){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(SetOneRowButton("Short info",JsonEdit.GetJsonForBotMenu("short",secondTeg)));
        rowList.add(SetOneRowButton("Full info",JsonEdit.GetJsonForBotMenu("full",secondTeg)));
        rowList.add(SetOneRowButton("Error info",JsonEdit.GetJsonForBotMenu("error",secondTeg)));
        rowList.add(SetOneRowButton("Back",JsonEdit.GetJsonForBotMenu("back","list")));
        inlineKeyboardMarkup.setKeyboard(rowList);

        EditMessageText editMessage = new EditMessageText();
        editMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        editMessage.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
        editMessage.setText(MainForm.MagMonList.get(Integer.parseInt(secondTeg)).getName()+" \n"+info);
        editMessage.setReplyMarkup(inlineKeyboardMarkup);
        try {
            execute(editMessage);
        } catch (TelegramApiException ex){
            System.out.println(ex.toString());
        }
    }

    public List<InlineKeyboardButton> SetOneRowButton(String NameButton, String Data){
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        inlineKeyboardButton.setText(NameButton);
        inlineKeyboardButton.setCallbackData(Data);
        keyboardButtonsRow.add(inlineKeyboardButton);
        return keyboardButtonsRow;
    }

    public void SettingsMenu(Update update){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(SetOneRowButton("Time to update: "+MainForm.timeToMagMonUpdate,JsonEdit.GetJsonForBotMenu("settings","time")));
        rowList.add(SetOneRowButton("Web Port: "+MainForm.WebPort,JsonEdit.GetJsonForBotMenu("settings","webport")));
        String buf ="";
        if(MainForm.BotMode){
            buf = "Send Full Log";
        }else{
            buf = "Send Only Event";
        }
        rowList.add(SetOneRowButton("Bot mode: "+buf,JsonEdit.GetJsonForBotMenu("settings","botmode")));
        rowList.add(SetOneRowButton("Reload Settings",JsonEdit.GetJsonForBotMenu("settings","reload")));
        rowList.add(SetOneRowButton("Back",JsonEdit.GetJsonForBotMenu("back","main")));
        inlineKeyboardMarkup.setKeyboard(rowList);

        EditMessageText editMessage = new EditMessageText();
        editMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        editMessage.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
        editMessage.setText("Settings MagMon:");
        editMessage.setReplyMarkup(inlineKeyboardMarkup);
        try {
            execute(editMessage);
        } catch (TelegramApiException ex){
            System.out.println(ex.toString());
        }
    }

    public void MainMenu(Update update){
        EditMessageText editMessage = new EditMessageText();
        editMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        editMessage.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
        editMessage.setText("Bot functions:");
        editMessage.setReplyMarkup(StartMenuInlineKeyboardMarkup());
        try {
            execute(editMessage);
        } catch (TelegramApiException ex){
            System.out.println(ex.toString());
        }
    }

    public void ListMenu(Update update){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        for(int i=0; i<=MainForm.MagMonList.size()-1;i++) {
            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
            inlineKeyboardButton.setText(MainForm.MagMonList.get(i).getName());
            inlineKeyboardButton.setCallbackData(JsonEdit.GetJsonForBotMenu("device", String.valueOf(i)));
            List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
            keyboardButtonsRow.add(inlineKeyboardButton);
            rowList.add(keyboardButtonsRow);
        }

        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Back");
        inlineKeyboardButton.setCallbackData(JsonEdit.GetJsonForBotMenu("back","main"));
        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(inlineKeyboardButton);
        rowList.add(keyboardButtonsRow);
        inlineKeyboardMarkup.setKeyboard(rowList);

        EditMessageText editMessage = new EditMessageText();
        editMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        editMessage.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
        editMessage.setText("List of devices:");
        editMessage.setReplyMarkup(inlineKeyboardMarkup);
        try {
            execute(editMessage);
        } catch (TelegramApiException ex){
            System.out.println(ex.toString());
        }
    }

    public synchronized void setButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("hello"));
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton("help"));
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    public static InlineKeyboardMarkup StartMenuInlineKeyboardMarkup(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("List of devices");
        inlineKeyboardButton1.setCallbackData(JsonEdit.GetJsonForBotMenu("list","list"));
        inlineKeyboardButton2.setText("Settings MagMon");
        inlineKeyboardButton2.setCallbackData(JsonEdit.GetJsonForBotMenu("settings","settings"));
        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow2.add(inlineKeyboardButton2);
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

    public static SendMessage sendInlineKeyBoardMessage(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText("Bot functions:");
        sendMessage.setReplyMarkup(StartMenuInlineKeyboardMarkup());
        return sendMessage;
    }


    @Override
    public String getBotUsername() {
        return UserName;
    }

    @Override
    public String getBotToken() {
        return Token;
    }
}
