import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

public class Bot extends TelegramLongPollingBot {
    private static final String botUserName = "@PasswordGeneratorBot_bot:";
    private static final String token = "1187477046:AAH_XIotZRwDUMOuKIq7-4iKvW78nDYlDSE";
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    PasswordGenerator passwordGenerator = new PasswordGenerator(20);
    long chat_id;

    @Override
    public void onUpdateReceived(Update update) {
//        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
//
//        // приимаем текст входящего сообщения
//        String text = update.getMessage().getText();
//        sendMessage.setText((String) input(update.getMessage().getText()));
//
//        try{
//            execute(sendMessage);
//        }catch (TelegramApiException e){
//            e.printStackTrace();
//        }
        chat_id = update.getMessage().getChatId();

        SendMessage sendMessage = new SendMessage()
                .setChatId(chat_id)
                .setText(getMessage(update.getMessage().getText()));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

//    public Object input(String msg){
//        if(msg.contains("Create a password")){
//            return getPassword();
//        }
//        return msg;
//    }

    public String getPassword() {
        return passwordGenerator.passwordGenerator();
    }

    public String getMessage(String msg) {
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        if(msg.equals("Привет") || msg.equals("Меню") || msg.equals("/start")){
            //keyboard.clear();
            keyboardFirstRow.add("Create");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выберите пункт меню";
        }
        if (msg.equals("Create")) {
            try {
                return getPassword();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "Something wrong";
    }


    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
