package top.wenjiewang.job.shiyanlou;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Jerry on 2017/5/20.
 */
public class ReverseList<T> extends ArrayList<T> {
    private static final long serialVersionUID=1L;

    public ReverseList(Collection<T> c) {
        super(c);
    }

    public Iterable<T> reversed(){
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int cur = size()-1;
                    @Override
                    public boolean hasNext() {
                        return cur>=0;
                    }

                    @Override
                    public T next() {
                        return get(cur--);
                    }
                };
            }
        };
    }
}
