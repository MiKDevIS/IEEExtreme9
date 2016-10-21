import java.util.Scanner;

public class ZoomIn {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = stringToInt(input.nextLine());
        int len = stringToInt(input.nextLine());
        int size = stringToInt(input.nextLine());
        Conv[] mc = new Conv[size];
        for (int i = 0; i < mc.length; i++) {
            mc[i] = new Conv(len);
            mc[i].ref = input.nextLine();
            int j = 0;
            while (j < mc[i].Ref.length) {
                mc[i].Ref[j] = input.nextLine();
                j++;
            }
        }
        int num = stringToInt(input.nextLine());
        String[] dc = new String[num];
        for (int i = 0; i < dc.length; i++) {
            dc[i] = input.nextLine();
            print(dc[i], mc);

        }
    }

    private static int stringToInt(String str) {
        char[] temp = str.toCharArray();
        int value = 0;
        for (int i = 0; i < temp.length; i++) {
            int tempIdPart = (int) temp[i] - 48;
            value = value + tempIdPart * (int) (Math.pow(10, temp.length - i - 1));
        }
        return value;
    }

    public static void print(String str, Conv[] cv) {
        char[] cStr = str.toCharArray();
        String[] strings = new String[cv[0].Ref.length];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = new String("");
        }
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < cv.length; j++) {
                if (cStr[i] == cv[j].ref.charAt(0)) {
                    for (int k = 0; k < cv[j].Ref.length; k++) {
                        strings[k] += cv[j].Ref[k];
                    }
                }
            }
        }
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }
}

class Conv {
    String ref = "";
    String[] Ref;

    public Conv(int len) {
        Ref = new String[len];
    }
}