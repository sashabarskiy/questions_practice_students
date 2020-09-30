package hotel;

import java.util.HashSet;
import java.util.Set;

public class Hotel {

    final int amount;
    Set<Request> requests = new HashSet<Request>();

    public Hotel(int amount) {
        this.amount = amount;
    }

    public Request findBySurname(String surname){
        for(Request request : requests)
            if(request.hasSurname(surname))
                return request;
        return null;
    }

    // TODO тут можно вывести кто именно заселился
    public boolean accepts(Request request) {
        if(requests.size() >= amount)
            return false;
        requests.add(request);
        request.start();
        return true;
    }

    // TODO тут можно вывести кто именно выселился
    public void kicksOut(Request request){
        requests.remove(request);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "amount=" + amount +
                ", living=" + requests.size() +
                ", requests=" + requests +
                '}';
    }
}
