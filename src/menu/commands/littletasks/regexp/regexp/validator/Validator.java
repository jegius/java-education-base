package menu.commands.littletasks.regexp.regexp.validator;

public interface Validator {
    boolean isEmailValid(String email);
    boolean isPhoneValid(String phone);
    boolean isCarNumberValid(String carNumber);
    boolean isIpAddressValid(String ip);
}
