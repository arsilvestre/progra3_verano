class Main {
    public static void main(String[] args) {
        int [][] matriz = {{4,5,6},{7,8,9},{5,6,7}};
        int j;
        int suma=0;
        int contador=0;
        //for(int i=0;i<=2;i++)
        for(int i=0;i<matriz.length;i++)
            {
                //for(j=0;j<=2;j++)
                for(j=0;j<matriz[i].length;j++)
                    {
                        suma+= matriz[i][j];
                        contador++;
                        System.out.println(matriz[i][j]);
                    }
                
            }
        System.out.println("Resultado: " + suma/contador);
    }
}