public class Klocka extends Thread{

    public void run(){


        while (true) {

            long då = System.currentTimeMillis();

            while (System.currentTimeMillis() - då < 1000) {

            }


            /*Frame.time++;

            Frame.timePassed.setText("" + Frame.time);*/
        }


    }
}
