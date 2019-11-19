package menu.commands.littletasks.regexp.regexp.validator.alex;

import menu.commands.littletasks.regexp.regexp.validator.Validator;

import java.util.regex.Pattern;

public class AlexRegExpValidator implements Validator {
    @Override
    public Enum getValidatorTypes(int validatorIndex) {
       return AlexValidatorType.values()[validatorIndex];
    }

    @Override
    public boolean isEmailValid(String email) {
        return Pattern.matches(AlexValidatorType.EMAIL.getRegExp(), email);
    }

    @Override
    public boolean isPhoneValid(String phone) {
        return Pattern.matches(AlexValidatorType.PHONE.getRegExp(), phone);
    }

    @Override
    public boolean isCarNumberValid(String carNumber) {
        return Pattern.matches(AlexValidatorType.CAR_NUMBER.getRegExp(), carNumber);
    }

    @Override
    public boolean isIpAddressValid(String ip) {
        return Pattern.matches(AlexValidatorType.IP_ADDRESS.getRegExp(), ip);
    }
}
