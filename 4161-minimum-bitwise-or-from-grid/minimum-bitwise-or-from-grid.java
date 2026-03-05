public class Solution {

    public int minimumOR(int[][] g) {

        int a = (1 << 17) - 1;
        int b = 16;

        while (b >= 0) {

            int c = a & ~(1 << b);
            boolean f = true;

            int i = 0;

            while (i < g.length && f) {

                boolean k = false;
                int j = 0;

                while (j < g[i].length) {

                    int x = g[i][j];

                    if ((x | c) == c) {
                        k = true;
                        break;
                    }

                    j++;
                }

                if (!k) {
                    f = false;
                }

                i++;
            }

            if (f) {
                a = c;
            }

            b--;
        }

        return a;
    }
}