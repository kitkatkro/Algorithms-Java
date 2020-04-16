public class KnapsackProblem {
    private int capacity;
    private KnapsackItem[] items;
    private static int itemsCount = -1;

    public KnapsackProblem(int knapsackCapacity, int amountItems) {
        capacity = knapsackCapacity;
        items = new KnapsackItem[amountItems];
    }

    public void put(int weightItem, int costItem) {
        if (isFull()) {
            throw new StackOverflowError("Заданное количество вещей превышено");
        } else {
            items[++itemsCount] = new KnapsackItem(weightItem, costItem);
        }
    }

    public void solve() {
        sortItemsWithUnitCosts();
        int[] X  = new int[items.length];
        X = putItemToKnapsack(0,0,items,0, X);
        printAllInformationAboutKnapsackProblem(X);

    }

    private void printAllInformationAboutKnapsackProblem(int[] X) {
        int maxCost = 0;
        int maxWeight = 0;
        System.out.printf("Вместимость рюкзака - %d. Количество вещей - %d.\n", capacity, items.length);
        System.out.print("Ценность вещей:\t");
        for (int i=0; i < items.length; i++) {
            System.out.print(items[i].cost + "\t");
            if (X[i] == 1) {
                maxCost += items[i].cost;
                maxWeight += items[i].weight;
            }
        }
        System.out.print("\nВес вещей:\t\t");
        for (int i=0; i < items.length; i++) {
            System.out.print(items[i].weight + "\t");
        }
        System.out.print("\nВектор X:\t\t");
        for (int i=0; i < X.length; i++) {
            System.out.print(X[i] + "\t");
        }

        System.out.println("\nМаксимальная стоимость: " + maxCost);
        System.out.printf("Занятый объем в рюкзаке: %d из %d", maxWeight, capacity);

    }

    private int[] putItemToKnapsack(int maxWeight, int maxCost, KnapsackItem[] items, int indexOfItem, int[] X) {
        if (maxWeight > capacity || indexOfItem == items.length) {
            if (indexOfItem < items.length) {
                X[indexOfItem] = 0;
            }
            return X;
        } else {
            maxWeight += items[indexOfItem].weight;
            maxCost += items[indexOfItem].cost;
            X[indexOfItem] = 1;
            indexOfItem += 1;
            return putItemToKnapsack(maxWeight, maxCost, items, indexOfItem, X);
        }
    }

    private boolean isFull() {
        return itemsCount == items.length - 1;
    }

    private void sortItemsWithUnitCosts() {
        double unitCosts[] = new double[items.length];
        for (int i=0; i < unitCosts.length; i++) {
            unitCosts[i] = items[i].cost * 1.0 / items[i].weight;
        }

        for (int k=0; k < unitCosts.length; k++) {
            for (int i = 0; i < unitCosts.length-1; i++) {
                if (unitCosts[i+1] == unitCosts[i]) {
                    if (items[i+1].weight < items[i].weight) {
                        KnapsackItem temp = items[i+1];
                        items[i+1] = items[i];
                        items[i] = temp;

                        double tempUnitCost = unitCosts[i+1];
                        unitCosts[i+1] = unitCosts[i];
                        unitCosts[i] = tempUnitCost;
                    }
                }
                if (unitCosts[i+1] > unitCosts[i]) {
                    KnapsackItem temp = items[i+1];
                    items[i+1] = items[i];
                    items[i] = temp;

                    double tempUnitCost = unitCosts[i+1];
                    unitCosts[i+1] = unitCosts[i];
                    unitCosts[i] = tempUnitCost;
                }
            }
        }
    }

    class KnapsackItem {
        private int weight;
        private int cost;

        public KnapsackItem(int weight, int cost) {
            if (weight <= 0 || cost <= 0) {
                throw new NumberFormatException ("Неверное значение веса/стоимости груза. Значение должно быть положительным числом");
            } else {
                this.weight = weight;
                this.cost = cost;
            }
        }

    }

    public static void main(String[] args) {
        KnapsackProblem problem = new KnapsackProblem(10, 5);
        problem.put(1,1);
        problem.put(1,1);
        problem.put(1,1);
        problem.put(1,4);
        problem.put(6,10);
        problem.solve();
    }
}
