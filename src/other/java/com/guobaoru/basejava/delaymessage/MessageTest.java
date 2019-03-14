package basejava.delaymessage;

import java.util.ArrayList;
import java.util.Set;

/**
 * @author Created by guobaoru.
 * @create on 2018/9/21.
 */
public class MessageTest {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList(3600);

        Task task = new Task(0);

        arrayList.set(10,task);

        System.out.println(arrayList.size());

    }
}
