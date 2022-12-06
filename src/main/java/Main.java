class MyThread implements Runnable {
    Thread thrd;

    MyThread(String name) {
        thrd = new Thread(this, name);
    }

    public static MyThread createAndStart(String name) {
        MyThread myThrd = new MyThread(name);
        myThrd.thrd.start();
        return myThrd;
    }

    public void run() {
        System.out.println(thrd.getName() + " - starting.");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("B " + thrd.getName() + ", count : " + count);
            }
        } catch (InterruptedException ехс) {
            System.out.println(thrd.getName() + " - Interrupting.") ;
        }
        System.out.println(thrd.getName() + " - Stopping.") ;
    }
}

class Main {
    public static void main(String args[]) {
        System.out.println("Starting main thread.");

        MyThread mtl = MyThread.createAndStart("Child thread #1");
        MyThread mt2 = MyThread.createAndStart("Child thread #2");
        MyThread mt3 = MyThread.createAndStart("Child thread #3");
        MyThread mt4 = MyThread.createAndStart("Child thread #4");
        MyThread mt5 = MyThread.createAndStart("Child thread #5");
        MyThread mt6 = MyThread.createAndStart("Child thread #6");
        MyThread mt7 = MyThread.createAndStart("Child thread #7");
        MyThread mt8 = MyThread.createAndStart("Child thread #8");
        MyThread mt9 = MyThread.createAndStart("Child thread #9");
        MyThread mt10 = MyThread.createAndStart("Child thread #10");

        for (int i = 0; i < 50; i++) {
            System.out.println(".");
            try {
                Thread.sleep(100) ;
            } catch (InterruptedException ехс) {
                System. out .println ( "Interrupting main thread . " ) ;
            }
        }

        System.out.println("Stopping main thread.") ;

    }
}
