console.log("Esta ejecucion viene desde un JS externo");
/* let datos = "Página 35";
if (true) {
    var asignatura = "DI";  //variable accesible desde todo el ámbito
    const DNI = "12345678A"; //constante que guarda el ámbito
    let nombre = "Javier"; //variable que guarda el ámbito
    console.log(nombre);
    console.log(DNI);
}

console.log(datos);
console.log(asignatura); */


/* let nombre = "Pepe"; //string
let edad = 30; //number -> int
let altura = 1.75 //number -> double
let casado = false; //boolean -> true/false
let elementos = []; //object -> array -> lista de elementos
let cosa = null; //object -> null
let dato; //undefined -> variable sin definir
//NaN -> Not a Number ->isNaN() */

// console.log(`Mi nombre es ${nombre}, tengo ${edad} años, mido ${altura} metros y estoy casado: ${casado}`);

//alert(`Bienvenido ${nombre}, vamos a realizar interacciones`)

/*let respuesta = confirm("¿Estás seguro de querer continuar?");
if (respuesta) {
    alert("El usuario ha pulsado Aceptar");
}else{
    alert("El usuario ha pulsado Cancelar");
}*/

let nombre = prompt("Por favor, introduce tu nombre: ");
console.log(`El nombre introducido es: ${nombre}`);

let num1 = parseInt(prompt("Introducel el primer numero:"))
console.log(`El primer numero es ${num1}`)

let num2 = parseInt(prompt("Introduce otro numero:"))
console.log("El segundo numero es " + num2)

let operando = prompt("Introduce el operando (+,-,*,/): ")
console.log(`El operando es ${operando}`)

let resultado;

if(operando == "+"){
    console.log(`El resultado es: ${resultado = num1 + num2}`);
}else if(operando == "-"){
    console.log(`El resultado es: ${resultado = num1 - num2}`);
}else if(operando == "*"){
    console.log(`El resultado es: ${resultado = num1 * num2}`);
}else if(operando == "/"){
    if(num2 != 0){
        console.log(`El resultado es: ${resultado = num1 / num2}`);
    }else{
        console.log("Error!! No se puede dividir entre 0")
    }

}else{
    console.log("No has intrtoducido bien el operando")
}