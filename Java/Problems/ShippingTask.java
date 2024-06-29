package Java.Problems;

public class ShippingTask {

    public static long minimalNumberOfPackages(long items, long availableLargePackages, long availableSmallPackages) {
        final long LARGE_PACKAGE_SIZE = 5;
        long maxWeight = (LARGE_PACKAGE_SIZE * availableLargePackages) + availableSmallPackages;
        long totalBoxes = 0;

        if (maxWeight < items)
            return -1;

        while (availableLargePackages != 0) {
            if (items < LARGE_PACKAGE_SIZE) {
                totalBoxes++;
                availableLargePackages--;
                items = 0;
            }
            if (items == 0)
                break;

            items -= LARGE_PACKAGE_SIZE;
            totalBoxes++;
            availableLargePackages--;
        }

        return totalBoxes + items;
    }

    public static void main(String[] args) {
        System.out.println(minimalNumberOfPackages(16, 3, 10)); // Output should be 4
    }
}
