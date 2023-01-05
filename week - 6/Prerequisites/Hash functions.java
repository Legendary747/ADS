package weblab;

class ETHHash extends HashTable {

    public ETHHash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        if (item == null) return 0;
        int b = 1;
        int s = getCapacity();
        int n = item.length();
        for (int i = 0; i < n; i++) {
            b = ((b % 257) + 1) * item.charAt(i);
        }
        return b % s;
    }
}

class GNUCPPHash extends HashTable {

    public GNUCPPHash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        if (item == null) return 0;
        int b = 0;
        int n = item.length();
        int s = getCapacity();
        for (int i = 0; i < n; i++) {
            b = 4 * b + item.charAt(i);
        }
        b = b % (Integer.MAX_VALUE / 2);
        b = b % s;
        return b;
    }
}

class GNUCC1Hash extends HashTable {

    public GNUCC1Hash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        if (item == null) return 0;
        int n = item.length();
        int b = n;
        int s = getCapacity();
        for (int i = 0; i < n; i++) {
            b = 613 * b + item.charAt(i);
            b = b % s;
        }
        return b % (Integer.MAX_VALUE / 4);
    }
}

class HashCodeHash extends HashTable {

    public HashCodeHash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        if (item == null) return 0;
        int b = item.hashCode();
        int s = getCapacity();
        return Math.abs(b) % s;
    }
}
