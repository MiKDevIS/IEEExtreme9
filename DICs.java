import java.util.Scanner;

public class DICs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int set = stringToInt(input.nextLine());
        Function[] mf = new Function[set];
        int i = 0;
        while (i < set) {
            int word = input.nextInt();
            int dic = stringToInt(input.next());
            mf[i] = new Function(dic, word, input);
            i++;
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
}

class Dic {
    public int[] dic = new int[250];

    public Dic(String string) {
        char[] cDic = string.toCharArray();
        for (int i = 0; i < string.length(); i++) {
            dic[(int) cDic[i]]++;
        }
    }

    public int Finder(Word word) {
        int counterP = 0;
        int counterN = 0;
        int counter = 0;
        for (int i = 0; i < 250; i++) {
            if (dic[i] - word.word[i] < 0) {
                counterN += (dic[i] - word.word[i]);
            } else if (dic[i] - word.word[i] > 0) {
                counterP += (dic[i] - word.word[i]);
            }
        }
        if (counterN < 0)
            counter = counterN;
        else
            counter = counterP;
        return counter;
    }

}

class Word {
    public int[] word1 = new int[250];
    public int[] word = new int[250];

    public void fill(String string) {
        char[] cWord = string.toCharArray();
        for (int i = 0; i < string.length(); i++) {
            word1[(int) cWord[i]]++;
        }
        f2();
        word1 = new int[250];
    }

    public void f2() {
        for (int i = 0; i < 250; i++) {
            if (word1[i] > word[i])
                word[i] = word1[i];
        }
    }
}

class Function {
    Dic[] dic;
    Word iWord;

    public Function(int iDic, int iword, Scanner input) {

        dic = new Dic[iDic];
        wfiller(iword, input);
        dfiller(input);
        compare();
    }

    public void compare() {
        int i = 0;
        while (i < dic.length) {
            int counter = 0;
            counter += dic[i].Finder(iWord);
            if (counter == 0) {
                System.out.println("Yes Yes");
            } else if (counter < 0) {
                System.out.println("No " + Math.abs(counter));
            } else {
                System.out.println("Yes No");
            }
            i++;
        }
    }

    public void wfiller(int iword, Scanner input) {
        iWord = new Word();
        int i = 0;
        while (i < iword) {
            String s = input.next();
            iWord.fill(s);
            i++;
        }
    }

    public void dfiller(Scanner input) {
        int i = 0;
        while (i < dic.length) {
            String s = input.next();
            dic[i] = new Dic(s);
            i++;
        }
    }
}