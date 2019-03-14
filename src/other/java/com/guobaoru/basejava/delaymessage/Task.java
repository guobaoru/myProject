package basejava.delaymessage;

/**
 * @author Created by guobaoru.
 * @create on 2018/9/21.
 */
public class Task {

    private int cycleNum;

    private void fuction(int i) {
        System.out.println("任务 " + i + "执行");
    }

    public Task(int cycleNum) {
        this.cycleNum = cycleNum;
    }
}
