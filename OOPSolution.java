import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// [!] How do you imagine your code will obtain laundry requests, and from where will they originate?
//      I imagine my code will obtain laundry requests from some frontend via a REST API which then calls my code.
// [!] How do you imagine your code will present computed information (revenue, net income), or how will it send this information to a presentation system?
//      In progress
// [!] How do you plan to deploy your program as a service accessible to other business systems?

// [!] Let's say we put all these things into production, what's the worst that could happen?

public class OOPSolution {
    public static void main(String[] args) {
    }

    public static class LaundryCorporation {
        private Map<String, Store> franchises = new HashMap<>();

        public String getHighestRevenueFranchise() {
            String highestRevenueFranchise = franchises.keySet().iterator().next();
            for (Entry<String, Store> entry : franchises.entrySet()) {
                if (entry.getValue().getRevenue() > franchises.get(highestRevenueFranchise).getRevenue()) {
                    highestRevenueFranchise = entry.getKey();
                }
            }
            return highestRevenueFranchise;
        }
    }

    public static class Store {
        private int revenue = 0;
        private List<LaundryVan> vans = new ArrayList<LaundryVan>();

        public void handlePickup(String address, LaundryBag bag) {
            for (LaundryVan van : vans) {
                if (van.canFit(bag)) {
                    van.addPickup(bag);
                    revenue += bag.getPrice();
                    return;
                }
            }
        }

        public int getRevenue() {
            return revenue;
        }

        public double getNetIncome() {
            double totalGasCost = 0;
            for (LaundryVan van : vans) {
                totalGasCost += van.getGasCost();
            }
            return revenue - totalGasCost;
        }
    }

    public class LaundryVan {
        private int id;
        private int capacity;
        private int capacityUsed = 0;
        private int numberOfPickups = 0;

        public LaundryVan(int id, int capacity) {
            this.id = id;
            this.capacity = capacity;
        }

        public int getId() {
            return id;
        }

        public boolean canFit(LaundryBag bag) {
            return capacityUsed + bag.getSize() <= capacity;
        }

        public void addPickup(LaundryBag bag) {
            capacityUsed += bag.getSize();
            numberOfPickups++;
        }

        public double getGasCost() {
            double gasUsed = 0.1 * numberOfPickups * (this.capacityUsed + this.capacity);
            return 4 * gasUsed;
        }
    }

    public static enum LaundryBag {
        SMALL(5, 0.25),
        MEDIUM(10, 0.5),
        LARGE(15, 1);

        private int price;
        private double size;

        private LaundryBag(int price, double size) {
            this.price = price;
            this.size = size;
        }

        public int getPrice() {
            return price;
        }

        public double getSize() {
            return size;
        }
    }
}
