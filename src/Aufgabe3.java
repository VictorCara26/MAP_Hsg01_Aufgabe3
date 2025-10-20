public static class Aufgabe3{

    public boolean incorrect_input_check(int[] num1){
        for (int number : num1) {
            if(number < 0) return false;
        }
        return true;
    }

    public int[] summe(int[] num1, int[] num2){

        if(incorrect_input_check(num1) || incorrect_input_check(num2))
            return new int[]{-1};


        boolean overflow = false;
        int[] sum = new int[num1.length];

        boolean sum_overflow = false;

        for(int i = num1.length - 1; i >= 0 ; i--){
            if(sum_overflow){
                sum[i]++;
                sum_overflow = false;
            }

            if(sum[i] + num1[i] + num2[i] > 9){
                sum_overflow = true;
                if(i == 0) overflow = true;
            }

            sum[i] = (sum[i] + num1[i] + num2[i]) % 10;

        }

        if(overflow){
            int[] final_sum = new int[num1.length + 1];
            final_sum[0] = 1;
            System.arraycopy(sum, 0, final_sum, 1, sum.length);
            return final_sum;
        }

        return sum;
    }

    public int[] diff(int[] num1, int[] num2){
        if(incorrect_input_check(num1) || incorrect_input_check(num2))
            return new int[]{-1};


        int[] sum = new int[num1.length];

        boolean diff_underflow = false;

        for(int i = num1.length - 1; i >= 0 ; i--){
            if(diff_underflow){
                num1[i]--;
            }

            if(num1[i] - num2[i] < 0){
                diff_underflow = true;
                sum[i] = num1[i] - num2[i] + 10;
            }
            else sum[i] = num1[i] - num2[i];

        }

        return sum;
    }

    public int[] multi(int[] num1, int num2){

        if(incorrect_input_check(num1) || num2 < 0 || num2 >9)
            return new int[]{-1};


        int  overflow = 0;
        int[] sum = new int[num1.length];


        for(int i = num1.length - 1; i >= 0 ; i--){
            if(overflow > 0){
                sum[i] += overflow;
                overflow = 0;
            }

            if(sum[i] + (num1[i] * num2) > 9){
                overflow = (sum[i] + (num1[i] * num2)) / 10;
            }

            sum[i] = (sum[i] + (num1[i] * num2)) % 10;

        }

        if(overflow > 0){
            int[] final_sum = new int[num1.length + 1];
            final_sum[0] = overflow;
            System.arraycopy(sum, 0, final_sum, 1, sum.length);
            return final_sum;
        }

        return sum;
    }

    public int[] divi(int[] num1, int num2){
        if(incorrect_input_check(num1) || num2 < 0 || num2 >9)
            return new int[]{-1};

        int  rest = 0;
        int[] sum = new int[num1.length];

        for(int i = 0; i < num1.length ; i++){
            if(rest > 0){
                sum[i] += rest;
                rest = 0;
            }

            if((sum[i] * 10 + num1[i]) % num2 != 0){
                rest = (sum[i] * 10 + num1[i]) % num2;
            }

            sum[i] = (sum[i] * 10 + num1[i]) / num2;

        }

        if(rest > 0){
            int[] final_sum = new int[num1.length + 1];
            final_sum[num1.length] = rest;

            System.arraycopy(sum, 0, final_sum, 0, sum.length);
            return final_sum;
        }

        int ct = 0;
        while(sum[ct] == 0) ct++;

        int[] final_sum = new int[num1.length - ct];
        System.arraycopy(sum, ct, final_sum, 0, final_sum.length);
        return final_sum;


    }
}
void main() {
    Aufgabe3 aufgabe3 = new Aufgabe3();
    int[] num1 = {1,3,0,0,0,0,0,0,0}, num2 = {8,7,0,0,0,0,0,0,0}, num3 = {8,3,0,0,0,0,0,0,0}, num4 = {5,4,0,0,0,0,0,0,0},
    num5 = {2,3,6,0,0,0,0,0,0};

    int[] sum = aufgabe3.summe(num1, num2);
    for (int k : sum) {
        System.out.print(k);
        System.out.print(' ');
    }

    int[] diff = aufgabe3.diff(num3, num4);
        System.out.println();
    for (int j : diff) {
        System.out.print(j);
        System.out.print(' ');
    }

    int[] multi = aufgabe3.multi(num5, 9);
    System.out.println();
    for (int j : multi) {
        System.out.print(j);
        System.out.print(' ');
    }

    int[] divi = aufgabe3.divi(num5, 2);
    System.out.println();
    for (int j : divi) {
        System.out.print(j);
        System.out.print(' ');
    }




}
