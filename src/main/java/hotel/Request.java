package hotel;

public class Request extends Thread{

    static Hotel hotel;

    static void setHotel(Hotel hotel){
        Request.hotel = hotel;
    }

    String surname;
    int time;

    Request(String surname, int time){
        this.surname = surname;
        this.time = time;
    }

    // для красивого вывода постоянно уменьшаем time, а не делаем просто sleep(time)
    public void run(){
        while(time > 0){
            time--;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hotel.kicksOut(this);
    }

    public boolean hasSurname(String surname){
        return this.surname.equals(surname);
    }

    @Override
    public String toString() {
        return "Request{" +
                "surname='" + surname + '\'' +
                ", time=" + time +
                '}';
    }
}
