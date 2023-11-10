import java.util.Optional;

public class NullSafety {

    public static void main(String[] args) {
        String nullStr = getNullStr();
        String nullCaseString = Optional.ofNullable(nullStr)
                .orElse("null case string");

//        int length = nullStr.length(); // 컴파일 에러 미발생
//        System.out.println(length);

        System.out.println(getLength(null));
    }

    public static String getNullStr() {
        return null;
    }

    public static int getLength(String str) {
        return str == null ? 0 : str.length();
    }
}
