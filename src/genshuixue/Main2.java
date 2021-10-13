package genshuixue;



public class Main2 {
    int num = 5;
    int k;
    boolean find;
    int logo[] = new int[num];
    int stamp[] = { 0, 1, 4, 12, 21 };
    int M = 5;// 表示stamp数组的长度


    private boolean check(int n, int Value) {
        if (n >= 0 && Value == 0) {
            find = true;
            int sum = 0;
            for (int i = 0; i < num && logo[i] != 0; i++) {
                sum += stamp[logo[i]];
            }
        } else
            for (int i = 1; i < M && !find && n > 0; i++)
                if (Value - stamp[i] >= 0) {
                    logo[k++] = i;
                    check(n - 1, Value - stamp[i]);
                    logo[--k] = 0;
                }
        return find;
    }


    public int getResult() {
        int i;
        for (i = 1; check(num, i); i++, find = false);
        return i - 1;
    }


    public static void main(String[] args) {
        // 时间测试
        long start = System.currentTimeMillis();
        Main2 program = new Main2();
        System.out.println(program.getResult());
        long end = System.currentTimeMillis();
        System.out.println("ProgramInbook time lasts " + (end - start) + "ms");
    }
}