package model;

public class Traumatologia extends Doctor{
    private Paciente paciente;
    private boolean venda;

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("paciente = " + paciente);
    }

    public void realizarVenda(){
        if (paciente == null){
            System.out.println("¿Se le aplican las vendas al cliente?");
            venda = false;
        }else {
            System.out.println("¿Se le aplican las vendas al cliente?");
            venda = true;
        }
    }
}
