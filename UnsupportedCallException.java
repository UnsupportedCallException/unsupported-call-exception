public class UnsupportedCallException extends RuntimeException {

    public UnsupportedCallException() { super(buildMessage()); }

    public UnsupportedCallException(String message) {
        super(message);
    }

    private static String buildMessage() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        StackTraceElement caller =  stackTrace[3];

        return caller.getClassName() + "." + caller.getMethodName() + " 메서드는 호출될 수 없습니다.";
    }
}
