//para definir una funcion
    //nominales
        //funtion(parametros){}  
    // flecha


//nominales
function realizarCalculo(op1, op2){
    console.log(`La suma de los dos parametros es ${op1 + op2}`);
}

function realizarCalculoRetorno(op1, op2){
    return op1+op2
}
realizarCalculo(3,6);



function realizarCalculDefecto(op1, op2=7){
    return op1+op2
}
console.log(realizarCalculDefecto(5)); //12


function realizarCalculoFantasma(op1, op2=7){
    return op1+op2
}


function realizarCalculoFantasma(op1){
    console.log("Calculo fantasma");
    console.log(op1 + "es parametro requerido");
    //arguments -> argumentos fantasma que son pasados adicionalmente. []
    console.log(`El numero de argumentos fantasma es de ${arguments.length}`);
    


    let suma = 0;
    arguments.array.forEach(element => {
        suma += element;
    });
}
