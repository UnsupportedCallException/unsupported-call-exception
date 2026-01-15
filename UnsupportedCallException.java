public class UnsupportedCallException extends RuntimeException {

    public UnsupportedCallException() { super(buildMessage()); }

    public UnsupportedCallException(String message) {
        super(message);
    }

    private static String buildMessage() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        StackTraceElement caller =  stackTrace[3];

        return caller.getClassName() + "." + caller.getMethodName() + " must not be called.";
    }
}
