package Libs;

public class IdCardException extends Exception {
    public IdCardException() {
        super("Id Card phải có 9 chữ số và theo định dạng XXX XXX XXX !!!");
    }
}
