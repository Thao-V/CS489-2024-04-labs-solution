package cs489.lab.ads.exception;

public class DuplicateUserException extends Exception{
    public DuplicateUserException(String message){
        super(message);
    }
}
