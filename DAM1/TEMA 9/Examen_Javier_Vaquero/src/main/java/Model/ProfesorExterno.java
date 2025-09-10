package Model;

public class ProfesorExterno extends Profesor{
    int horas;
    int precioHora;

    public ProfesorExterno(String nombre, String dni, double salarioBaseAnual, int horas, int precioHora) {
        super(nombre, dni, salarioBaseAnual);
        this.horas = horas;
        this.precioHora = precioHora;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("horas = " + horas);
        System.out.println("precioHora = " + precioHora);
    }

    public void calcularSalario(){
        int salarioHoras = horas * precioHora;
        double salarioTotal = salarioBaseAnual + salarioHoras;
    }
}
