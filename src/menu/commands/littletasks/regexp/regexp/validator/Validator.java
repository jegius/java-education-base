package menu.commands.littletasks.regexp.regexp.validator;

public interface Validator {
    int EMAIL_INDEX = 0;
    int PHONE_INDEX = 1;
    int CAR_NUMBER_INDEX = 2;
    int IP_ADDRESS_INDEX = 3;

    Enum getValidatorTypes(int validatorIndex);
    boolean isEmailValid(String email);
    boolean isPhoneValid(String phone);
    boolean isCarNumberValid(String carNumber);
    boolean isIpAddressValid(String ip);
}
