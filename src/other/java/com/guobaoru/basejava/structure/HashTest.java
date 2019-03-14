package basejava.structure;

import java.util.HashMap;
import java.util.Vector;

/**
 * @author Created by guobaoru.
 * @create on 2018/7/26.
 */
public class HashTest {
    public static void main(String[] args) {

        HashMap hashMap = new HashMap();
        String a = "hello";
        String b = "hello";
        StringBuffer stringBuffer = new StringBuffer();
        Vector vector = new Vector();

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

    }
}
