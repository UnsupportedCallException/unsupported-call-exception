public class UnsupportedCallException extends RuntimeException {

    public UnsupportedCallException() { super(buildMessage()); }

    public UnsupportedCallException(String message) {
        super(message);
    }

    private static String buildMessage() {
        return StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
            .walk(stream -> stream
                    .dropWhile(f -> f.getDeclaringClass() == UnsupportedCallException.class)
                    .findFirst()
                    .map(f -> f.getClassName() + "." + f.getMethodName() + "() must not be called.")
                    .orElse("Unknown method must not be called."));
    }
}
