class UndergroundSystem {
    //here i am gonna define two hashmaps, one for checkin check out and 
    //another one for average:
    private final HashMap<Integer, Customer> map;
    private final HashMap<String, double[]> average;

    public class Customer {
        Integer id;
        Integer checkIn;
        String startStation;
        String endStation;
        Integer checkOut;
        Integer duration;

        public Customer (int id, String stationName, int time) {
            this.id = id;
            this.checkIn = time;
            this.startStation = stationName;
            this.endStation = null;
            this.checkOut = null;
            this.duration = null;
        }
    }

    public UndergroundSystem() {
        this.map = new HashMap<>();
        this.average = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        //check for duplicate:
        if (map.containsKey(id)) {
            return;
        }

        Customer customer = new Customer(id, stationName, t);
        map.put(id, customer);
    }

    public void checkOut(int id, String stationName, int t) {
        //get the customer:
        Customer customer = map.getOrDefault(id, null);

        //if the customer is null then just return:
        if (customer == null) {
            return;
        }

        //calculate duration and assign checkout, duration and endstation name
        //to object fields:
        int duration = t - customer.checkIn;
        customer.checkOut = t;
        customer.duration = duration;
        customer.endStation = stationName;

        //update the map by removing the customer:
        map.remove(id);

        //now create a key for start and end station name and add the average:
        //now add entry or update entry of average map:
        String key = customer.startStation + "|" + customer.endStation;
        double[] stationAverage = average.getOrDefault(key, new double[2]);

        double count = stationAverage[0];
        double oldAverage = stationAverage[1];
        double newAverage = ((oldAverage * count) + duration) / (count + 1);

        stationAverage[0] = count + 1;
        stationAverage[1] = newAverage;

        //update the average map:
        average.put(key, stationAverage);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "|" + endStation;
        double[] time = average.getOrDefault(key, new double[2]);

        if (time[0] == 0.0) {
            return -1;
        }

        return time[1];
    }
}
