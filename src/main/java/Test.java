import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {


    public static void main(String[] args) {

        List<String> str = Arrays.asList("alt", "valt", "khalt");

        test(str.toArray(new String[0]));
    }


    static void test(String ... a){
        System.out.println(a[3]);
    }
}
