public class EntradaSwitch {
    public static void main(String[] args) {
        int numero = 6;
        switch (numero){
            case 0:
                System.out.println("El valor es 0");
                break;
            case 5:
                System.out.println("El valor es 5");
                break;
            case 10:
                System.out.println("El valor es 10");
                break;
            default:
                System.out.println("El valor no esta contemplado");
        }
        System.out.println("Terminando bloque");
    }
}
