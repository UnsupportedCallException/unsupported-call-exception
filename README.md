# UnsupportedCallException

## usage
```java
throw new UnsupportedCallException();
throw new UnsupportedCallException("msg");
```

## when to use
A runtime exception for methods that must exist due to inheritance or interface
contracts, but must not be called directly.