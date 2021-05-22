package menu.commands.littletasks.regexp.regexp.validator.andrew;

import menu.commands.littletasks.regexp.regexp.validator.Validator;

import java.util.regex.Pattern;

public class AndrewRegExpValidator implements Validator {
    @Override
    public Enum getValidatorTypes(int validatorIndex) {
        return AndrewValidationType.values()[validatorIndex];
    }

    @Override
    public boolean isEmailValid(String email) {
        return Pattern.matches(AndrewValidationType.EMAIL.getRegExp(), email);
    }

    @Override
    public boolean isPhoneValid(String phone) {
        return Pattern.matches(AndrewValidationType.PHONE.getRegExp(), phone);
    }

    @Override
    public boolean isCarNumberValid(String carNumber) {
        return Pattern.matches(AndrewValidationType.CAR_NUMBER.getRegExp(), carNumber);
    }

    @Override
    public boolean isIpAddressValid(String ip) {
        return Pattern.matches(AndrewValidationType.IP.getRegExp(), ip);
    }
}
