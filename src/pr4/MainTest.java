package pr4;

import java.util.ArrayList;
import java.util.Scanner;

public class MainTest {

    public static void trapezeMethod(double k, double l){
        double a = (k - l) / 2;
        double b = k + l;
        int n = 4;
        for (n = 4; n <= 8; n+=2) {
            System.out.println("------------[N = " + n + "]------------");
            double h = (b - a) / n;
            double tmp = 0;
            ArrayList<Double> arrayList = new ArrayList<>();

            for (int i = 1; i < n; i++) {
                tmp = a + i * h;
                System.out.println("x(" + i + ") = " + String.format("%.6f", tmp));
                tmp = (tmp + l) / (tmp * tmp + tmp + k);
                System.out.println("f(x(" + i + ")) = " + String.format("%.6f", tmp));
                arrayList.add(tmp);
            }
            String str = "";
            double dres = 0;
            for (int i = 0; i < arrayList.size(); i++) {
                str += String.format("%.6f", arrayList.get(i));
                dres += arrayList.get(i);
                if (i < arrayList.size() - 1)
                    str += " + ";
            }
            double res = 0;
            res = (h / 2) * (((a + l) / (a * a + a + k)) + (2 * (dres)) + (b + l) / (b * b + b + k));
            System.out.println("I = " + h / 2 + " * (" + String.format("%.6f", (a + l) / (a * a + a + k)) + " + 2(" + str + ") + " + String.format("%.6f", (b + l) / (b * b + b + k)) + ") = " + String.format("%.6f", res));
        }
    }

    public static double getX(int i, double a, double h){
        return a + i * h;
    }

    public static double f(double x, double l, double k){
        return (x+l)/(Math.pow(x, 2) + x + k);
    }

    public static void parabolaMethod(double k, double l){
        double a = (k - l) / 2;
        double b = k + l;
        int n = 4;
        for (n = 4; n <= 8; n+=2) {
            System.out.println("------------[N = " + n + "]------------");
            double h = (b - a) / (2 * n);

            double firstSum = 0;
            double secondSum = 0;
            String firstSumStr = "(";
            String secondSumStr = "(";

            //вычисление первой суммы
            for (int i = 1; i < n; i++) {
                firstSum += f(getX(i * 2, a, h), l, k);
                System.out.println("x(" + i * 2 + ") = " + String.format("%.6f", getX(i * 2, a, h)));
                firstSumStr += String.format("%.6f", f(getX(i * 2, a, h), l, k));
                if (i < n - 1)
                    firstSumStr += " + ";
            }
            firstSumStr += ")";


            //вычисление второй суммы
            for (int i = 1; i < n + 1; i++) {
                secondSum += f(getX(i * 2 - 1, a, h), l, k);
                System.out.println("x(" + (i * 2 - 1) + ") = " + getX(i * 2 - 1, a, h));
                secondSumStr += String.format("%.6f", f(getX(i * 2 - 1, a, h), l, k));
                if (i < n)
                    secondSumStr += " + ";
            }
            secondSumStr += ")";


            double res = 0;
            res = (h / 3) * (f(a, l, k) + (2 * firstSum) + (4 * secondSum) + f(b, l, k));
            System.out.println("I = " + String.format("%.6f", h / 3)
                    + " * (" + String.format("%.6f", f(a, l, k))
                    + " + 2" + firstSumStr
                    + " + 4" + secondSumStr + " + "
                    + String.format("%.6f", f(b, l, k)) + ") = " + String.format("%.6f", res));
        }
    }

    private static double gausGetSum6(double a, double b, double l, double k){
        double res = 0;
        double []t_arr = {-0.932464, -0.661209, -0.238619, 0.238619, 0.661209, 0.932464};
        double []a_arr = {0.171324, 0.360761, 0.467913, 0.467913, 0.360761, 0.171324};
        double ai = 0;
        String resStr = "I = " + ((b-a)/2) + " * (";
        for (int i = 0; i < t_arr.length; i++){
            System.out.println("A(" + (i+1) + ") = " + a_arr[i]) ;
            ai = f((a+b)/2 + ((b-a)/2) * t_arr[i], l, k);
            System.out.println("f((a+b)/2 + ((b-a)/2) * t(" + (i+1) + ")) = " + String.format("%.6f", ai));
            resStr += a_arr[i] + " * " + String.format("%.6f", ai);
            if(i < t_arr.length - 1)
                resStr+= " + ";
            res += a_arr[i] * ai;
        }
        res *= (b-a)/2;
        resStr += ") = " + String.format("%.6f",res);
        System.out.println(resStr);
        return res;
    }

    private static double gausGetSum4(double a, double b, double l, double k){
        double res = 0;
        double []t_arr = {-0.861136, -0.339981, 0.339981, 0.861136};
        double []a_arr = {0.347854, 0.652145, 0.652145, 0.347854};
        double ai = 0;
        String resStr = "I = " + ((b-a)/2) + " * (";
        for (int i = 0; i < t_arr.length; i++){
            System.out.println("A(" + (i+1) + ") = " + a_arr[i]) ;
            ai = f((a+b)/2 + ((b-a)/2) * t_arr[i], l, k);
            System.out.println("f((a+b)/2 + ((b-a)/2) * t(" + (i+1) + ")) = " + String.format("%.6f", ai));
            resStr += a_arr[i] + " * " + String.format("%.6f", ai);
            if(i < t_arr.length - 1)
                resStr+= " + ";
            res += a_arr[i] * ai;
        }
        res *= (b-a)/2;
        resStr += ") = " + String.format("%.6f",res);
        System.out.println(resStr);
        return res;
    }

    private static double gausGetSum8(double a, double b, double l, double k){
        double res = 0;
        double []t_arr = {-0.960289, -0.796666, -0.525532, -0.183434, 0.183434, 0.525532, 0.796666, 0.960289};
        double []a_arr = {0.101228, 0.222381, 0.313706, 0.362683, 0.362683, 0.313706, 0.222381, 0.101228};

        double ai = 0;
        String resStr = "I = " + ((b-a)/2) + " * (";
        for (int i = 0; i < t_arr.length; i++){
            System.out.println("A(" + (i+1) + ") = " + a_arr[i]) ;
            ai = f((a+b)/2 + ((b-a)/2) * t_arr[i], l, k);
            System.out.println("f((a+b)/2 + ((b-a)/2) * t(" + (i+1) + ")) = " + String.format("%.6f", ai));
            resStr += a_arr[i] + " * " + String.format("%.6f", ai);
            if(i < t_arr.length - 1)
                resStr+= " + ";
            res += a_arr[i] * ai;
        }
        res *= (b-a)/2;
        resStr += ") = " + String.format("%.6f",res);
        System.out.println(resStr);
        return res;
    }

    public static void gaussMethod(double k, double l){
        double a = (k - l) / 2;
        double b = k + l;

        System.out.println("------------[N = 4]------------");
        gausGetSum4(a, b, l, k);
        System.out.println("------------[N = 6]------------");
        gausGetSum6(a, b, l, k);
        System.out.println("------------[N = 8]------------");
        gausGetSum8(a, b, l, k);
    }

    public static double getAccurateResult(double k, double l){
        double a = (k-l)/2;
        double b = k+l;
        double res1 = (0.5) * Math.log(Math.pow(a, 2) + a + k)
                + ((l - 0.5) / (Math.sqrt(k - 0.25)))
                * Math.atan((a + 0.5) / Math.sqrt(k - 0.25));

        double res2 = (0.5) * Math.log(Math.pow(b, 2) + b + k)
                + ((l - 0.5) / (Math.sqrt(k - 0.25)))
                * Math.atan((b + 0.5) / Math.sqrt(k - 0.25));

        return res2 - res1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter K");
        double k = in.nextDouble();
        System.out.println("Enter L");
        double l = in.nextDouble();

        System.out.println("Accurate result: " + getAccurateResult(k, l));

        System.out.println("[Trapeze method]=====================");
        trapezeMethod(k, l);
        System.out.println("[Parabola method]====================");
        parabolaMethod(k, l);
        System.out.println("[Gauss method]=======================");
        gaussMethod(k, l);
    }

}
