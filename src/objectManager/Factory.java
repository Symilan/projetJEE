package objectManager;

public class Factory {
    private static class FactoryHolder {
        private static final Factory factory = new Factory();
    }
}
