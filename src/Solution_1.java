import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstCoordinates;
        List<Integer> secondCoordinates;

        String[] firstString = scanner.nextLine().split(" ");
        String[] secondString = scanner.nextLine().split(" ");

        /*
            Another solution
        List<Integer> intString = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
         */

        firstCoordinates = getCoordinate(firstString);
        secondCoordinates = getCoordinate(secondString);

        int res = getMaxLayer(firstCoordinates, secondCoordinates);
        System.out.println(res);
    }

    private static int getMaxLayer(List<Integer> firstCoordinates, List<Integer> secondCoordinates) {
        int minOx = Integer.min(firstCoordinates.get(0), secondCoordinates.get(0));
        int minOy = Integer.min(firstCoordinates.get(1), secondCoordinates.get(1));
        int maxOx = Integer.max(firstCoordinates.get(2), secondCoordinates.get(2));
        int maxOy = Integer.max(firstCoordinates.get(3), secondCoordinates.get(3));

        int coordLayX = maxOx - minOx;
        int coordLayY = maxOy - minOy;

        int res = Integer.max(coordLayX, coordLayY);

        return res * res;
    }

    public static List<Integer> getCoordinate(String[] str) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            newList.add(Integer.parseInt(str[i]));
        }
        return newList;
    }
}