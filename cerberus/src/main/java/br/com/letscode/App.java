package br.com.letscode;

import static br.com.letscode.VeiculoImpl.Marca.MERCEDES;

import br.com.letscode.VeiculoImpl.Marca;

public class App {
    public static void main(String[] args) {

        App app = new App();

        Marca m = MERCEDES;

        // System.out.println("Inverso de 98765: " + inverter(98765));
        // System.out.println("Inverso de -8674: " + inverter(-8674));
/*
        int[] array1 = { 1, 2, 5, 7 };
        int[] array2 = { 3, 4, 6, 8, 12, 15 };
        int[] arrayConsolidado = new int[array1.length + array2.length];
        juntarArrays(array1, array2, arrayConsolidado);
*/
        /* int i = app.inverter(2147483647);
        if( i == 7463847412) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }*/

        // System.out.println(Arrays.toString(somaDois(new int[]{2,4,7,8,12}, 9)));
/*
        VeiculoImpl v = new VeiculoImpl(
            "Vermelho",
            1500,
            1994,
            VeiculoImpl.TipoVeiculo.MOTA,
            VeiculoImpl.Marca.BMW,
            "Z500",
            2,
            "AA-00-AA"
        );
v.andar(2);
        VeiculoImpl.TipoVeiculo.AUTOMOVEL.getMaxRodas();
        v.ligarRadio();

        final Scanner sc = new Scanner(System.in);
        System.out.println("Insira o seu veiculo:");
        System.out.println("1 - Carro");
        System.out.println("2 - Mota");
        final int veiculo = sc.nextInt();
        Veiculo v = null;

        switch (veiculo) {
            case 1:
                v = new Carro();
                break;
            case 2:
                v = new Mota();
                break;
            default:
                System.out.println("Veiculo não válido");
        }
        if (v != null) {
            start(v);
            v.ligarRadio("Olá");
            if (v instanceof Carro) {
                ((Carro) v).parar();
            }
        }
*/
    }

    public static void start(Veiculo v) {
        v.ligarMotor();
    }

    public static int inverter(int numero) {
        String numeroStr = Integer.toString(numero);
        String invertido = "";
        boolean isNegative = false;

        // Remove o sinal negativo da String e do int, caso haja.
        if (numeroStr.startsWith("-")) {
            numeroStr = numeroStr.substring(1);
            numero = Integer.parseInt(numeroStr);
            isNegative = true;
        }
        // Extrai o último dígito a cada iteração, e armazena na string "invertido".
        for (int i = 0; i < numeroStr.length(); i++) {
            int ultimoDigito = numero % 10;
            numero /= 10;
            invertido += ultimoDigito;
        }
        // Caso o numero seja negativo, esse if reinsere o sinal, após já estar
        // invertido.
        if (isNegative) {
            invertido = "-" + invertido;
        }

        return Integer.parseInt(invertido);
    }

    public static int[] somaDois(int[] nums, int alvo) {

        int sum1;
        int sum2;
        sum1 = nums[0];
        sum2 = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (!(sum1 + sum2 == alvo)) {
                sum2 = nums[i];
                System.out.println("N1 = " + sum1);
                System.out.println("N2 = " + sum2);
                System.out.println("Num at i = " + nums[i]);
            }
        }
        return new int[]{sum1, sum2};
    }

    public static void juntarArrays(int[] array1, int[] array2,
                                    int[] arrayConsolidado) {
        // o primeiro passo é juntar um array no outro

        for (int i = 0; i < array1.length; i++) {
            arrayConsolidado[i] = array1[i];
        }

        for (int i = 0, j = array1.length; i < array2.length; i++, j++) {
            arrayConsolidado[j] = array2[i];
        }

        // agora é ordenar esse array

        for (int i = 0; i < arrayConsolidado.length; i++) {
            for (int j = i + 1; j < arrayConsolidado.length; j++) {
                if (arrayConsolidado[j] < arrayConsolidado[i]) {
                    int aux = arrayConsolidado[j];
                    arrayConsolidado[j] = arrayConsolidado[i];
                    arrayConsolidado[i] = aux;
                }
            }
            System.out.println(arrayConsolidado[i]);
        }
    }

}
