package Model;

public class ProfesorInterno extends Profesor{
    double complementoFijoMensual;

    public ProfesorInterno(String nombre, String dni, double salarioBaseAnual, double complementoFijoMensual) {
        super(nombre, dni, salarioBaseAnual);
        this.complementoFijoMensual = complementoFijoMensual;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("complementoFijoMensual = " + complementoFijoMensual);
    }

    public void calcularSalario(){
        double SalarioTotal = salarioBaseAnual + complementoFijoMensual;
    }

}
