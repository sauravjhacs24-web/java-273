class MessageThread extends Thread{
    String msg;
    int delay;
    int i=0;

    MessageThread(String msg,int delay){
        this.msg=msg;
        this.delay=delay;
    }
    public void run(){
        while(i<5){
            try{
                System.out.println(msg);
                Thread.sleep(delay);
            }
            catch(InterruptedException e){
                System.out.println("Thread interrupted");
            }
            i++;
        }
    }
}

public class main8{
    public static void main (String[] args){
        MessageThread t1=new MessageThread ("BMS College of Engineering",10000);
        MessageThread t2=new MessageThread ("CSE",2000);
        t1.start();
        t2.start();
    }
}