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
    PasswordGenerator passwordGeneratorWithDigitsAndPunctuation = new PasswordGenerator.PasswordGeneratorBuilder()
            .useLower(true)
            .useUpper(true)
            .useDigits(true)
            .usePunctuation(true)
            .build();
    PasswordGenerator passwordGeneratorWithoutDigitsAndPunctuation = new PasswordGenerator.PasswordGeneratorBuilder()
            .useLower(true)
            .useUpper(true)
            .useDigits(false)
            .usePunctuation(false)
            .build();
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

    public String getMessage(String msg) {
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        KeyboardRow keyboardForthRow = new KeyboardRow();
        KeyboardRow keyboardFivesRow = new KeyboardRow();
        KeyboardRow keyboardSixRow = new KeyboardRow();
        KeyboardRow keyboardSevensRow = new KeyboardRow();
        KeyboardRow keyboardEightsRow = new KeyboardRow();
        KeyboardRow keyboardNinesRow = new KeyboardRow();


        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        if(msg.equals("/start")){
            keyboardFirstRow.add("Create");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Choose";
        }
        if (msg.equals("Create")) {
            keyboard.clear();
            keyboardFirstRow.add("With Digits and Punctuation");
            keyboardSecondRow.add("Only with letters");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Select with what password";
        }
        if (msg.equals("With Digits and Punctuation")) {
            keyboard.clear();
            keyboardFirstRow.add("8 symbols");
            keyboardSecondRow.add("9 symbols");
            keyboardThirdRow.add("10 symbols");
            keyboardForthRow.add("11 symbols");
            keyboardFivesRow.add("12 symbols");
            keyboardSixRow.add("13 symbols");
            keyboardSevensRow.add("14 symbols");
            keyboardEightsRow.add("15 symbols");
            keyboardNinesRow.add("16 symbols");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            keyboard.add(keyboardThirdRow);
            keyboard.add(keyboardForthRow);
            keyboard.add(keyboardFivesRow);
            keyboard.add(keyboardSixRow);
            keyboard.add(keyboardSevensRow);
            keyboard.add(keyboardEightsRow);
            keyboard.add(keyboardNinesRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Select dimension";
        }
        switch (msg) {
            case "8 symbols":
                try {
                    return passwordGeneratorWithDigitsAndPunctuation.generate(8);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "9 symbols":
                try {
                    return passwordGeneratorWithDigitsAndPunctuation.generate(9);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "10 symbols":
                try {
                    return passwordGeneratorWithDigitsAndPunctuation.generate(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "11 symbols":
                try {
                    return passwordGeneratorWithDigitsAndPunctuation.generate(11);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "12 symbols":
                try {
                    return passwordGeneratorWithDigitsAndPunctuation.generate(12);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "13 symbols":
                try {
                    return passwordGeneratorWithDigitsAndPunctuation.generate(13);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "14 symbols":
                try {
                    return passwordGeneratorWithDigitsAndPunctuation.generate(14);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "15 symbols":
                try {
                    return passwordGeneratorWithDigitsAndPunctuation.generate(15);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "16 symbols":
                try {
                    return passwordGeneratorWithDigitsAndPunctuation.generate(16);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        if (msg.equals("Only with letters")) {
            keyboardFirstRow.add("8 symbols");
            keyboardSecondRow.add("9 symbols");
            keyboardThirdRow.add("10 symbols");
            keyboardForthRow.add("11 symbols");
            keyboardFivesRow.add("12 symbols");
            keyboardSixRow.add("13 symbols");
            keyboardSevensRow.add("14 symbols");
            keyboardEightsRow.add("15 symbols");
            keyboardNinesRow.add("16 symbols");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            keyboard.add(keyboardThirdRow);
            keyboard.add(keyboardForthRow);
            keyboard.add(keyboardFivesRow);
            keyboard.add(keyboardSixRow);
            keyboard.add(keyboardSevensRow);
            keyboard.add(keyboardEightsRow);
            keyboard.add(keyboardNinesRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Select dimension";
        }
        switch (msg) {
            case "8 symbols":
                try {
                    return passwordGeneratorWithoutDigitsAndPunctuation.generate(8);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "9 symbols":
                try {
                    return passwordGeneratorWithoutDigitsAndPunctuation.generate(9);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "10 symbols":
                try {
                    return passwordGeneratorWithoutDigitsAndPunctuation.generate(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "11 symbols":
                try {
                    return passwordGeneratorWithoutDigitsAndPunctuation.generate(11);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "12 symbols":
                try {
                    return passwordGeneratorWithoutDigitsAndPunctuation.generate(12);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "13 symbols":
                try {
                    return passwordGeneratorWithoutDigitsAndPunctuation.generate(13);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "14 symbols":
                try {
                    return passwordGeneratorWithoutDigitsAndPunctuation.generate(14);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "15 symbols":
                try {
                    return passwordGeneratorWithoutDigitsAndPunctuation.generate(15);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "16 symbols":
                try {
                    return passwordGeneratorWithoutDigitsAndPunctuation.generate(16);
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
