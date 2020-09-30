package hotel;

import java.util.*;

public class Main {

    static final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

    static final Random random = new java.util.Random();

    static public String randomSurname() {
        StringBuilder builder = new StringBuilder();
        int length = random.nextInt(5)+5;
        for(int i = 0; i < length; i++) {
            builder.append(lexicon.charAt(random.nextInt(lexicon.length())));
        }
        return builder.toString();
    }

    public static void main(String[] args) {

        Hotel hotel = new Hotel(3);

        Queue<Request> waiting = new LinkedList<Request>();

        Request.setHotel(hotel);

        while (true){

            Request request = new Request(randomSurname(), random.nextInt(5000));
            waiting.add(request);

            do{

                request = waiting.poll();
                if(request == null)
                    break;

            } while (hotel.accepts(request));

            if(request != null)
                waiting.add(request);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(hotel);
            System.out.println("waiting : " + waiting.size());

        }

    }

}
