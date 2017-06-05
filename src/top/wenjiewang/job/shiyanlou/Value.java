package top.wenjiewang.job.shiyanlou;

/**
 * Created by Jerry on 2017/5/15.
 */
public class Value {
    private int i;
    private String s;

    public Value() {
    }

    public Value(int i, String s) {
        this.i = i;
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Value value = (Value) o;

        if (i != value.i) return false;
        return s != null ? s.equals(value.s) : value.s == null;
    }

    public static void main(String[] args) {
        Value v1 = new Value(1,"adsf");
        Value v2 = new Value(1,"");
        System.out.println(v2.equals(v1));
        System.out.println(v2.getClass());
    }
}
