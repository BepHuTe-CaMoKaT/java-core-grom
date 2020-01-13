package lesson2.Arrays;

public class n1 {
    public static void main(String[] args) {
        arr4();
    }
//сортировка двумерного массива змейкой
    public static void arr0() {
        int n = 6;
        int[][] matrix = new int[n][n];

        int row = 0;
        int col = 0;
        int dx = 1;
        int dy = 0;
        int dirChanges = 0;
        int visits = n;

        for (int i = 0; i < n * n; i++) {
            matrix[row][col] = i + 1;
            if (--visits == 0) {
                visits = n * (dirChanges % 2) +
                        n * ((dirChanges + 1) % 2) -
                        (dirChanges / 2 - 1) - 2;
                int temp = dx;
                dx = -dy;
                dy = temp;
                dirChanges++;
            }
            col += dx;
            row += dy;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }
    }
//сортировка этого же массива только из центра
    public static void arr1() {
        int n = 6;  // размер матрицы
        int[][] m = new int[n][n];
        // центр
        int i = n / 2;
        int j = n / 2;
        // задаем границы движения
        int min_i = i; int max_i = i; // влево вправо
        int min_j = j; int max_j = j; // вверх вниз
        int d = 0; // сначала пойдем влево
        for (int a = 1; a < n * n; a++) {
            m[i][j] = a;
            switch (d) {
                case 0:
                    i -= 1;  // движение влево
                    if (i < min_i) { // проверка выхода за заполненную центральную часть слева
                        d = 1; // меняем направление
                        min_i = i; // увеличиваем заполненную часть влево
                    }
                    break;
                case 1:  // движение вверх проверка сверху
                    j -= 1;
                    if (j < min_j) {
                        d = 2;
                        min_j = j;
                    }
                    break;
                case 2:  // движение вправо проверка справа
                    i += 1;
                    if (i > max_i) {
                        d = 3;
                        max_i = i;
                    }
                    break;
                case 3:  // движение вниз проверка снизу
                    j += 1;
                    if (j > max_j) {
                        d = 0;
                        max_j = j;
                    }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int v = 0; v < n; v++)
                System.out.print(m[k][v] + "\t");
            System.out.println();
        }
    }

//сортировка двумерного массива по диагонали
    public static void arr2() {
        int[][] matrix = new int[6][6];
        int x = 0;
        for (int i = 0; i < matrix.length; i++) {
            x++;
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = x++;
                if (x > matrix.length) x = 1;
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    //сортировка двумерного массива по диагонали v.2
    public static void arr3() {
        int N = 5;
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            arr[i][i] = 1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.printf("%3d",arr[i][j]);
            System.out.println();
        }
    }
//умноение 2-х двумерных массивов
    public static void arr4(){
//объявляем две матрицы
        int [][] twoDimArray1 = {{1,0,1},{1,1,1},{1,0,0}};
        int[][] twoDimArray2 = {{1,1,1},{1,1,1},{1,1,1}};

//процесс умножения матриц
        int[][]twoDimArray3 = new int [twoDimArray1.length][twoDimArray2[0].length];
        for (int i=0; i<twoDimArray3[0].length; i++)
            for (int j=0; j<twoDimArray3.length; j++)
                for (int k=0; k<twoDimArray1[0].length; k++)
                    twoDimArray3[i][j] += twoDimArray1[i][k] * twoDimArray2[k][j];

//вывод на экран
        for (int i = 0; i < twoDimArray3.length; i++) {
            for (int j = 0; j < twoDimArray3[0].length; j++) {
                System.out.print(" " + twoDimArray3[i][j] + " ");
            }
            System.out.println();
        }
    }
}

