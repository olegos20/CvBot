package com.oleh.model;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.ArrayList;
import java.util.List;
import static com.oleh.model.HibernateUtil.*;
import static java.lang.Math.toIntExact;

public class Bot extends TelegramLongPollingBot  {
    private  int first_start = 0;
    private static String text;
    private static String lang;
    private static String command;
    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
    List<List<InlineKeyboardButton>> rowsInline1 = new ArrayList<>();
    List<List<InlineKeyboardButton>> rowsInline2 = new ArrayList<>();
    List<List<InlineKeyboardButton>> rowsInline3 = new ArrayList<>();
    List<List<InlineKeyboardButton>> rowsInline4 = new ArrayList<>();
    List<List<InlineKeyboardButton>> rowsInline5 = new ArrayList<>();
    List<List<InlineKeyboardButton>> rowsInline6 = new ArrayList<>();
    List<InlineKeyboardButton> rowInline = new ArrayList<>();
    List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
    List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
    List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
    List<InlineKeyboardButton> rowInline4 = new ArrayList<>();
    List<InlineKeyboardButton> rowInline5 = new ArrayList<>();
    List<InlineKeyboardButton> rowInline6 = new ArrayList<>();
    private void printContactUA(){
        HibernateUtil.contactUa();
        text=out;
    }
    private void createStartMenu(){
        rowInline.add(new InlineKeyboardButton().setText("Ua").setCallbackData("/ua"));
        rowInline.add(new InlineKeyboardButton().setText("Rus").setCallbackData("/rus"));
        rowInline.add(new InlineKeyboardButton().setText("Eng").setCallbackData("/eng"));
        rowsInline.add(rowInline);
    }
    private void  createRusMenu(){
        rowInline2.add(new InlineKeyboardButton().setText("Информация").setCallbackData("/rus_info"));
        rowInline2.add(new InlineKeyboardButton().setText("Контакт").setCallbackData("/rus_contact"));
        rowInline2.add(new InlineKeyboardButton().setText("Резюме").setCallbackData("/rusCV"));
        rowInline2.add(new InlineKeyboardButton().setText("Назад").setCallbackData("/back"));
        rowsInline2.add(rowInline2);
    }
    private  void createUaMenu(){
        rowInline1.add(new InlineKeyboardButton().setText("Інформація").setCallbackData("/ua_info"));
        rowInline1.add(new InlineKeyboardButton().setText("Контакт").setCallbackData("/ua_contact"));
        rowInline1.add(new InlineKeyboardButton().setText("Резюме").setCallbackData("/uaCV"));
        rowInline1.add(new InlineKeyboardButton().setText("Назад").setCallbackData("/back"));
        rowsInline1.add(rowInline1);
    }
    private void createEnMenu(){
        rowInline3.add(new InlineKeyboardButton().setText("Info").setCallbackData("/en_info"));
        rowInline3.add(new InlineKeyboardButton().setText("Contact").setCallbackData("/en_contact"));
        rowInline3.add(new InlineKeyboardButton().setText("CV").setCallbackData("/enCV"));
        rowInline3.add(new InlineKeyboardButton().setText("Back").setCallbackData("/back"));
        rowsInline3.add(rowInline3);
    }
    private void createUaBack(){
        rowInline4.add(new InlineKeyboardButton().setText("Назад").setCallbackData("/ua"));
        rowsInline4.add(rowInline4);
    }
    private void  createRusBack(){
        rowInline5.add(new InlineKeyboardButton().setText("Назад").setCallbackData("/rus"));
        rowsInline5.add(rowInline5);
    }
    private void  createEnBack(){
        rowInline6.add(new InlineKeyboardButton().setText("Back").setCallbackData("/eng"));
        rowsInline6.add(rowInline6);
    }
    private  void  printContactEN(){
        HibernateUtil.contactEn();
        text=out;
    }
    private void printContactRus(){
        HibernateUtil.contactRus();
        text=out;
    }
    private void printInfoUa(){
        HibernateUtil.infoUa();
        text=out;
    }
    private void printInfoEn(){
        HibernateUtil.infoEn();
        text=out;
    }
    private void printInfoRus(){
        HibernateUtil.infoRus();
        text=out;
    }
    private void printua(){
        HibernateUtil.CVua();
        text= out;
    }
    private void  printen(){
        HibernateUtil.CVen();
        text=out;
    }
    private  void printrus(){
        HibernateUtil.CVrus();
        text= out;
    }
    public static void main(String args[]){
        ApiContextInitializer.init();
        TelegramBotsApi telegramBot = new TelegramBotsApi();
        try{telegramBot.registerBot( new Bot());
        }
        catch(TelegramApiException e){
            e.printStackTrace();
        }
    }
    public void sendMsg(Message message, String s){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(s);
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();
        markupInline.setKeyboard(rowsInline);
    }
    public void onUpdateReceived(Update update)  {
        if (first_start == 0){createStartMenu();
            createEnMenu();
            createRusMenu();
            createUaMenu();
            createEnBack();
            createRusBack();
            createUaBack();
            first_start++;}
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            if (update.getMessage().getText().equals("/start")) {
                SendMessage message = new SendMessage()
                        .setChatId(chat_id)
                        .setText("Привіт! Вибери свою мову! Для повторного входу в меню введи /start  \nПривет! Выбери свой язык! Для возврата в меню введи /start" +
                                "\nHello! Chose you languege! For return to menu type /start \n");
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {
            }
        } else if (update.hasCallbackQuery()) {
            String call_data = update.getCallbackQuery().getData();
            long message_id = update.getCallbackQuery().getMessage().getMessageId();
            long chat_id = update.getCallbackQuery().getMessage().getChatId();
            if (call_data.equals("/ua")) {
                String answer = "Меню:";
                EditMessageText new_message = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText(answer);
                markupInline.setKeyboard(rowsInline1);
                new_message.setReplyMarkup(markupInline);
                try {
                    execute(new_message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (call_data.equals(("/rus"))){
                {
                    String answer = "Меню:";
                    EditMessageText new_message = new EditMessageText()
                            .setChatId(chat_id)
                            .setMessageId(toIntExact(message_id))
                            .setText(answer);
                    markupInline.setKeyboard(rowsInline2);
                    new_message.setReplyMarkup(markupInline);
                    try {
                        execute(new_message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
            else if (call_data.equals(("/eng"))){
                {
                    String answer = "Menu: ";
                    EditMessageText new_message = new EditMessageText()
                            .setChatId(chat_id)
                            .setMessageId(toIntExact(message_id))
                            .setText(answer);
                    markupInline.setKeyboard(rowsInline3);
                    new_message.setReplyMarkup(markupInline);
                    try {
                        execute(new_message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
            else if (call_data.equals(("/uaCV"))) {
                printua();
                EditMessageText new_message = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText(text);
                markupInline.setKeyboard(rowsInline4);
                new_message.setReplyMarkup(markupInline);
                try {
                    execute(new_message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
               else if (call_data.equals(("/enCV"))){
                    printen();
                    EditMessageText new_message1 = new EditMessageText()
                            .setChatId(chat_id)
                            .setMessageId(toIntExact(message_id))
                            .setText(text);
                markupInline.setKeyboard(rowsInline5);
                new_message1.setReplyMarkup(markupInline);
                    try {
                        execute(new_message1);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    }
                else if (call_data.equals(("/rusCV"))) {
                printrus();
                EditMessageText new_message2 = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText(text);
                markupInline.setKeyboard(rowsInline5);
                new_message2.setReplyMarkup(markupInline);
                try {
                    execute(new_message2);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (call_data.equals(("/ua_info"))) {
                printInfoUa();
                EditMessageText new_message3 = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText(text);
                markupInline.setKeyboard(rowsInline4);
                new_message3.setReplyMarkup(markupInline);
                try {
                    execute(new_message3);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (call_data.equals(("/rus_info"))) {
                printInfoRus();
                EditMessageText new_message4 = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText(text);
                markupInline.setKeyboard(rowsInline5);
                new_message4.setReplyMarkup(markupInline);
                try {
                    execute(new_message4);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (call_data.equals(("/en_info"))) {
                printInfoEn();
                EditMessageText new_message5 = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText(text);
                markupInline.setKeyboard(rowsInline6);
                new_message5.setReplyMarkup(markupInline);
                try {
                    execute(new_message5);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (call_data.equals(("/en_contact"))) {
                printContactEN();
                EditMessageText new_message6 = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText(text);
                markupInline.setKeyboard(rowsInline6);
                new_message6.setReplyMarkup(markupInline);
                try {
                    execute(new_message6);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (call_data.equals(("/rus_contact"))) {
                printContactRus();
                EditMessageText new_message7 = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText(text);
                markupInline.setKeyboard(rowsInline5);
                new_message7.setReplyMarkup(markupInline);
                try {
                    execute(new_message7);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (call_data.equals(("/ua_contact"))) {
                printContactUA();
                EditMessageText new_message8 = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText(text);
                markupInline.setKeyboard(rowsInline4);
                new_message8.setReplyMarkup(markupInline);
                try {

                    execute(new_message8);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }else if (call_data.equals(("/back"))) {
                EditMessageText new_message9 = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText("Меню:");
                markupInline.setKeyboard(rowsInline);
                new_message9.setReplyMarkup(markupInline);
                try {
                    execute(new_message9);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            }
        }
    public String getBotUsername() {
        return "Oleh CV Bot";
    }
    public String getBotToken() {
        return "627176177:AAFh3oDKML_HzmILOgV43xu8Y2odhgFe75w";
    }
}
