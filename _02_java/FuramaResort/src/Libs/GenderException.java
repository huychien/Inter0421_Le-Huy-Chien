package Libs;

public class GenderException extends Exception{
    public GenderException() {
        super("Bắt buộc phải nhập vào Male, Female hoặc Unknow !!!");
    }
}
