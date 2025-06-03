package HospitalManagement.Review;

interface Selector {
    boolean end();
    Object current();
    void next();
}

public class Sequence {
    private Object[] objects;  // array of Object
    private int next = 0;

    public Sequence(int size) {
        objects = new Object[size];
    }

    public void add(Object x) {
        if (next < objects.length) {
            objects[next] = x;
            next++;
        }
    }

    private class SSelector implements Selector {
        int i = 0;

        public boolean end() {
            return i == objects.length;
        }

        public Object current() {
            return objects[i];
        }

        public void next() {
            if (i < objects.length) i++;
        }
    }

    // Trả về một instance của inner class SSelector
    public Selector getSelector() {
        return new SSelector();
    }
}

