import model.*
import kotlin.reflect.typeOf

fun main() {
    // var persona = Persona("Borja", "Martin","123A")
    // persona.mostrarDatos()
    // var trabajador = Trabajador("Borja","Martin","1234A",40000,12,true,91111111,"borja@gmail.com")
    val asalariado = Asalariado("Borja","Martin","1234A",40000.0,12,0.10)
    val autonomo = Autonomo("Borja","Martin","1234A",40000.0,true,10)
    val jefe = Jefe("Borja","Martin","1234A",40000.0,2)
    val directivo = Directivo("Borja","Martin","1234A",40000000,"borjamartin@ces",40 )
    val trabajadores = arrayOf<Persona>(asalariado, autonomo,jefe)
    /*
    trabajadores.forEach {
        //si eres trabajador ->calcular salario
        it.mostrarDatos()
        if(it is Trabajador){
            println("Calculando salario del trabajador: ${it.calcularSalarioNeto()}")
        }
    }

     */


    //calcular beneficio
    trabajadores.forEach {
        if (it is Sindicato){
            it.bajarSueldos(trabajadores.filter { it !is Directivo }
            as ArrayList<Trabajador>)
        }
    }

    //para poder bajar sueldos, un jefe solo bajara los sueldos
        //a los trabajadores que no son jefes
        //la cantidad de salario que puede bajar es del 10%
    //en caso de ser directivo, le podre bajar el sueldo a todos los trabajadores
        //incluido a los jefes. un 20% a los asalariados / autonomos
        //un 10% a los  jefes

    //println(asalariado.calcularSalarioNeto())
}