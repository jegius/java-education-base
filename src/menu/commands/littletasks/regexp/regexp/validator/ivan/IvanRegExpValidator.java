package menu.commands.littletasks.regexp.regexp.validator.ivan;

import menu.commands.littletasks.regexp.regexp.validator.Validator;

import java.util.regex.Pattern;

public class IvanRegExpValidator implements Validator {

    public Enum getValidatorTypes(int validatorIndex) {
        return IvanValidationType.values()[validatorIndex];
    }

    public boolean isEmailValid(String email) {
        return Pattern.matches(IvanValidationType.EMAIL.getRegExp(), email);
    }

    @Override
    public boolean isPhoneValid(String phone) {
        return false;
    }

    @Override
    public boolean isCarNumberValid(String carNumber) {
        return false;
    }

    @Override
    public boolean isIpAddressValid(String ip) {
        return false;
    }
}
