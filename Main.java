import java.util.InputMismatchException;
import java.util.Scanner;

    public class Main {
        public static void main(String[] args)  {
            Scanner vvod = new Scanner(System.in);
            System.out.println("Привет. Это простой калькулятор");
            System.out.println("Он умеет складывать, вычитать, умножать, делить  арабские и римские цифры в диазоне от 1 до 10");
            System.out.println("Введи выражение");
            String vurazheniz = vvod.nextLine();
            System.out.println(kalkulytor(vurazheniz));
        }

        public static String kalkulytor(String input) {
            String probel = input.replaceAll("[-+/*^]"," $0 ").replace("  ", " ").trim();
            String[] massive = probel.split(" ");
            try{ String mas1 = massive[0];
                String mas2 = massive[1];
                String mas3 = massive[2];
                if (massive.length>3) {
                    System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    return "";
                } else {
                    try {
                        if(podschet(mas1, mas3, mas2)<-10000){return "";}
                        else{
                            String result = Integer.toString(podschet(mas1, mas3, mas2));
                            return result;}
                    } catch (NumberFormatException nfe) {
                        if(perevodVPUM(mas1.toUpperCase()) > 0 && perevodVPUM(mas3.toUpperCase()) > 0) {
                            int x = perevodVPUM(mas1.toUpperCase());
                            int y = perevodVPUM(mas3.toUpperCase());
                            String a = Integer.toString(x);
                            String b = Integer.toString(y);
                            if (podschet(a, b, mas2) < -10000) {
                                return "";
                            } else if (podschet(a, b, mas2) < 0){return "throws Exception // т.к.в римской системе нет отрицательных чисел";}
                            else {
                                String resultRoman = perevodVPum(podschet(a, b, mas2));
                                return resultRoman;
                            }
                        }
                        else if ((perevodVPUM(mas1.toUpperCase()) < 0 && perevodVPUM(mas3.toUpperCase()) > 0) || (perevodVPUM(mas1.toUpperCase()) > 0 && perevodVPUM(mas3.toUpperCase()) < 0)){
                            System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
                            return "";
                        }
                        else {
                            System.out.println("throws Exception //т.к. Неверно введено число");
                            return "";
                        }
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("строка не является математической операцией");
                return "";
            }
        }

        private static String perevodVPum (int numArabian) {
            String[] rimskie = {"null", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                    "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                    "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
            final String s = rimskie[numArabian];
            return s;
        }
/*    public int vstakaArabskihCHisel(char pum){
        if('I' == pum) return 1;
        else if('V' == pum) return 5;
        else if('X' == pum) return 10;
        else if('L' == pum) return 50;
        else if('C' == pum) return 100;
        else if('D' == pum) return 500;
        else if('M' == pum) return 1000;
        return 0;

    }
    public int perevodVpum(String s) {



        int end = s.length()-1;
        char[] arr = s.toCharArray();
        int arab;
        int result = vstakaArabskihCHisel(arr[end]);
        for (int i = end-1; i >=0; i--) {
            arab = vstakaArabskihCHisel(arr[i]);

            if (arab < vstakaArabskihCHisel(arr[i + 1])) {
                result -= arab;
            } else {
                result += arab;
            }


        }
        return result;

    }
*/
        private static int perevodVPUM (String rumskie) {
            try {

                if (rumskie.equals("I")) {
                    return 1;
                } else if (rumskie.equals("II")) {
                    return 2;
                } else if (rumskie.equals("III")) {
                    return 3;
                } else if (rumskie.equals("IV")) {
                    return 4;
                } else if (rumskie.equals("V")) {
                    return 5;
                } else if (rumskie.equals("VI")) {
                    return 6;
                } else if (rumskie.equals("VII")) {
                    return 7;
                } else if (rumskie.equals("VIII")) {
                    return 8;
                } else if (rumskie.equals("IX")) {
                    return 9;
                } else if (rumskie.equals("X")) {
                    return 10;
                }
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Неверный формат данных");
            }
            return -1;
        }

        private static int podschet (String str1, String str2, String symvol){
            int x = Integer.parseInt(str1.trim());
            int y = Integer.parseInt(str2.trim());
            if (x < 1 || x > 10 || y < 0 || y > 10) {
                System.out.println("Число вне диапазона");
                return -11000;
            }
            if (symvol.equals("*")) {
                int s = x * y;
                return s;
            } else if (symvol.equals("/")) {
                try {
                    int s = x / y;
                    return s;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Делить на 0 нельзя");
                    return -11000;
                }
            } else if (symvol.equals("+")) {
                int s = x + y;
                return s;
            } else if (symvol.equals("-")) {
                int s = x - y;
                return s;
            } else {
                System.out.println("Неверная операция");
                return -11000;}
        }
    }

