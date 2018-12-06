package sample;

public class Fuerza_bruta {

    private int [][]dp;
    private int n;
    private int Altura;

    public Fuerza_bruta(int n, int altura) {
        dp = new int[n + 1][n + 1];
        this.n = n;
        Altura = altura;
    }

    public int [] addBox(int largo, int ancho, int altura, int tipo){
        //      if (tipo == 1){
        return colocar(largo, ancho, altura);
//  }
/*
    boolean ans = false;
    if (tipo == 2){
    if (colocar(largo, ancho, altura) == true)
                ans = true;
            if (colocar(ancho, largo, altura) == true)
                ans = true;
            return ans;
        }

        if (colocar(largo, ancho, altura) == true)
            ans = true;
        if (colocar(largo, altura, ancho) == true)
            ans = true;
        if (colocar(ancho, altura, largo) == true)
            ans = true;
        if (colocar(ancho, largo, altura) == true)
            ans = true;
        if (colocar(altura, ancho, largo) == true)
            ans = true;
        if (colocar(altura, largo, ancho) == true)
            ans = true;
        return ans;
  */
        }

    public int[] colocar(int largo, int ancho, int altura){

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                if( i + largo >= n || j + ancho >= n)
                    continue;
                int m = comprobar(largo, ancho, i, j);
                if (m + altura <= Altura) {
                    llenar(largo, ancho, altura, i, j, m);
                    int P[] = {i, j, m};
                    return P;
                }
            }
        }

        int P1[] = {-1,-1,-1};
        return P1;
    }

    public void llenar(int largo, int ancho, int altura, int a, int b, int m){

        for (int i = a ; i < largo + a ; i++){
            for (int j = b ; j < ancho + b ; j++){
                dp[i][j] = altura + m;
            }
        }
    }

    public int comprobar(int largo, int ancho, int a , int b){

        int ans = 0;
        for (int i = a ; i < largo + a ; i++){
            for (int j = b ; j < ancho + b ; j++){
                if (ans < dp[i][j])
                    ans = dp[i][j];
            }
        }
        return ans;
    }
}