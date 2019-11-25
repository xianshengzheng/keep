package innerclass;

/**
 * @author Eric
 * @Title: Test2
 * @date 2019/8/28 10:53
 * @Description: TODO
 */
public class Test2 {
    /*
        当对象作为参数传递时，传递的是对象的引用，无论你怎么改变这个新的引用的指向，原来的引用是不会改变的
        （当然如果你通过这个引用改变了对象的内容，那么改变实实在在发生了）。
        为了内部类一致性的这个原则。我们在内部类是能修改对象里的属性，并且外部类也是能感知到的。
        但是我们一但要将引用重新指向一个对象就不行了，因为这样内部外部就不一致了。为了干脆一点。设计者直接将其强制为final类型
    */
    public void outFun(int a, Man man1){
        int b = 0;
        Man man2 = new Man("Tom2");
        System.out.println(man2);
        Inner inner = new Inner() {
            {
//                b++; //编译不通过
//                a++; //编译不通过
//                man1 = new Man("inner1"); //编译不通过
//                man2 = new Man("inner2"); //编译不通过
                man1.setName("inner1");
                man2.setName("inner2");

            }
        };
        System.out.println(man2);

    }


    public static void main(String args[]){
        Test2 out = new Test2();

        Man tom1 = new Man("Tom1");
        System.out.println(tom1);
        out.outFun(3,tom1);
        System.out.println(tom1);



    }

    class Inner {
    }


}



