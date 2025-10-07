package model


class Ejercicios(var descripcion: String = "Estos son los ejercicios ") {
    fun ejercicio1() {
        //Crea un array de Strings con los nombres de 5 compañeros.
        // A continuación, recorre el array y escribe el nombre de
        // cada persona en la consola.
        var nombres = arrayOf("Javi, Pablo, Dani, Jesus")
        for (i in 0..nombres.size - 1) {
            println(nombres[i])
        }
    }

    fun ejercicio2(){
        //Crea un array de enteros con la serie de Fibonacci de los
        // primeros 20 números. A continuación, recorre el array y
        // escribe cada número en la consola.
        var contador1 = 0
        var contador2 = 1
        var resultadoFibonacci = 0

        for (it in 0.. 20){
            if (it == 0){
                resultadoFibonacci = 0
                println(resultadoFibonacci)
                resultadoFibonacci = contador1
            }else if (it == 1){
                resultadoFibonacci = 1
                println(resultadoFibonacci)
                resultadoFibonacci = contador2
            }else {
                if (it % 2 == 0){
                    resultadoFibonacci = contador1 + contador2
                    println(resultadoFibonacci)
                    resultadoFibonacci = contador1
                }else{
                    resultadoFibonacci = contador1 + contador2
                    println(resultadoFibonacci)
                    resultadoFibonacci = contador2
                }
            }
        }
    }
}
