package menu.commands.littletasks.regexp.regexp.validator.max;

import menu.commands.littletasks.regexp.regexp.validator.Validator;

import java.util.regex.Pattern;

public class MaxRegExpValidator implements Validator {
    @Override
    public Enum getValidatorTypes(int validatorIndex) {
        return MaxValidatorType.values()[validatorIndex];
    }

    @Override
    public boolean isEmailValid(String email) {
        return Pattern.matches(MaxValidatorType.EMAIL.getRegExp(), email);
    }

    @Override
    public boolean isPhoneValid(String phone) {
        return Pattern.matches(MaxValidatorType.PHONE.getRegExp(), phone);
    }

    @Override
    public boolean isCarNumberValid(String carNumber) {
        return Pattern.matches(MaxValidatorType.CAR_NUMBER.getRegExp(), carNumber);
    }

    @Override
    public boolean isIpAddressValid(String ip) {
        return Pattern.matches(MaxValidatorType.IP_ADDRESS.getRegExp(), ip);
    }
}
