package exercises.ex5;
import java.util.ArrayList;
import java.util.List;
public class ObjectCounter{
    private ArrayList<String> items;
    private ArrayList<Integer> counts;

    public ObjectCounter() {
        items = new ArrayList<>();
        counts = new ArrayList<>();
    }

    public void add(String value) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equalsIgnoreCase(value)) {
                counts.set(i, counts.get(i) + 1);
                return;
            }
        }
        items.add(value);
        counts.add(1);
    }

    public List<String> getTop(int howMany) {
        List<String> topList = new ArrayList<>();
        List<String> tempItems = new ArrayList<>(items);
        List<Integer> tempCounts = new ArrayList<>(counts);

        while (howMany > 0 && !tempCounts.isEmpty()) {
            int highest = tempCounts.get(0);
            int highestIndex = 0;

            for (int j = 1; j < tempCounts.size(); j++) {
                if (tempCounts.get(j) > highest) {
                    highest = tempCounts.get(j);
                    highestIndex = j;
                }
            }

            String line = tempItems.get(highestIndex) + ": " + tempCounts.get(highestIndex);
            topList.add(line);

            tempItems.remove(highestIndex);
            tempCounts.remove(highestIndex);
            howMany--;
        }

        return topList;
    }
}
