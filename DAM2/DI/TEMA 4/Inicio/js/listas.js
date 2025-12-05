const lista = ["Palabra1","Palabra2","Palabra3"]
lista.push("Palabra4", "Palabra5") //Agrega un elemento final a la lista
lista.unshift("Palabra6","Palabra7") //Agrega un elemento al inicio de la lista
//lista[2] = "Palabra8" //Añade un elemento en x posicion en la lista
//lista[100] "Palabra 100" //Agrega un elemento en la posicion 100, si no existe lo crea

lista.pop() //Elimina el ultimo elemento de la lista
lista.shift() //Elimina el primer elemento de la lista
console.log(lista)

//filtrar elementos de una lista
lista.filter((item, index) => { //item es el elemento actual, index es la posicion del elemento
    return item != "Palabra3"
})
console.log(lista)




console.log(lista)

