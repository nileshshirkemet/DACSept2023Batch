class Transformer {

    public static void encode(byte[] data, int count) {
        for(int i = 0; i < count; ++i){
            data[i] = (byte)(data[i] ^ '#');
        }
    }

    public static void reverse(byte[] data) {
        for(int i = 0, j = data.length - 1; i < j; ++i, --j){
            byte ib = data[i];
            byte jb = data[j];
            data[i] = jb;
            data[j] = ib;
        }
    }
}
