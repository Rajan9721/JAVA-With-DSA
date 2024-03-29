package Thread;

class Queue1{
    int x;
    boolean temp = false;
    synchronized void put(int n){
        try{
            if(temp == true){
                wait();
            }
            else{
                x = n;
                System.out.println("I have produced a value: "+ x );
                temp = true;
                notify();
            }
            
        }
        catch(Exception e){
            System.out.println("Some Problem");
        }   
        
    }
    synchronized void get(){
        try{
            if(temp == false){
                wait();
            }
            else{
                System.out.println("I have consumed value: "+ x);
                temp = false;
                notify();
            }
        }
        catch(Exception e){
            System.out.println("Some Problem");
        }
        
    }
}

class Producer1 extends Thread
{
    Queue1 q1;

    Producer1(Queue1 a){
        q1 = a;
    }
    
    public void run(){
        int i = 1;
        while(true){
            q1.put(i++);    

        }
    }

}

class Consumer1 extends Thread{
    Queue1 q2;
    Consumer1(Queue1 b){
        q2 = b;
    }
    public void run(){
        while(true){
            q2.get();
        }

    }
}

public class ProblemSolvePC {
    public static void main(String[] args) {
        Queue1 obj1 = new Queue1();
        Producer1 p1= new Producer1(obj1);
        Consumer1 c1 = new Consumer1(obj1);

        p1.start();
        c1.start();

    }
    
}
