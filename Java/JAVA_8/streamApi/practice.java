package java8.streamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class practice {
    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(1,2,3,4,5,8,78,9,7,5,9,56,4,9,78,4);
        List<Integer> ans = arr.
                stream()
        .filter(x->x%2==0)
                .sorted((a,b)->b-a)
                .distinct()
                .limit(3)
                .skip(1)
                .collect(Collectors.toList());
        System.out.println(ans);
    }

}
