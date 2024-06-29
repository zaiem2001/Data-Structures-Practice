package Java.Problems;

public class Main {

    public static void main(String[] args) {
        QfromStacks<Integer> q = new QfromStacks<>();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(4);
        q.enqueue(5);

        System.out.println(q.peek());
        System.out.println(q.dequeue());
        System.out.println(q.peek());
        System.out.println(q.dequeue());
    }

}