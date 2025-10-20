public static class Aufgabe3{

    public int[] summe(int[] num1, int[] num2){
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

}
void main() {
    Aufgabe3 aufgabe3 = new Aufgabe3();
    int[] num1 = {1,3,0,0,0,0,0,0,0}, num2 = {7,7,0,0,0,0,0,0,0};


    int[] sum = aufgabe3.summe(num1, num2);

    for(int i = 0; i < sum.length; i++){
        System.out.print(sum[i]);
        System.out.print(' ');
    }

}
