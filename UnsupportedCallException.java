public class UnsupportedCallException extends RuntimeException {

    public UnsupportedCallException() { super(buildMessage()); }

    public UnsupportedCallException(String message) {
        super(message);
    }

    private static String buildMessage() {
    return StackWalker.getInstance()
            .walk(s -> s.skip(2) 
                        .findFirst()
                        .map(f -> f.getClassName() + "." + f.getMethodName() + "() must not be called.")
                        .orElse("Unknown method must not be called."));
    }
}
