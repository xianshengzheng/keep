package quene;

/**
 * @author Eric
 * @Title: LoopQuene
 * @date 2019/8/27 14:47
 * @Description: TODO
 */
public class LoopArrayQuene {
    String[] a;
    int head = 0;
    int tail = 0;
    int capacity;

    public LoopArrayQuene(int capacity){
        a = new String[capacity];
        this.capacity  = capacity;
    }

    public boolean enquene(String item){
        //队列满了
        if((tail +1) % capacity == head) return false;

        a[tail] = item;
        tail = (tail +1 ) % capacity;
        return true;
    }

    public String dequene(){
        if(tail == head){
            return null;
        }
        String result = a[head];

        head = (head +1 ) % capacity;
        return result;
    }

    public static void main(String args[]){
        LoopArrayQuene quene = new LoopArrayQuene(4);
        System.out.println(quene.enquene("1"));
        System.out.println(quene.enquene("2"));
        System.out.println(quene.enquene("3"));
        System.out.println(quene.enquene("4"));


        System.out.println(quene.dequene());
        System.out.println(quene.enquene("a"));
        System.out.println(quene.dequene());
        System.out.println(quene.dequene());
        System.out.println(quene.dequene());
        System.out.println(quene.dequene());
    }

}
