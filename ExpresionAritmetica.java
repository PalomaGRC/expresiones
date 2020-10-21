package expresiones;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpresionAritmetica {

	Stack pilaOperaciones = new Stack();
	Stack pilaFinal = new Stack();
	
	public ExpresionAritmetica() {
		separar("(6+2)*3/2^2-4"); //infija
	}

	private void separar(String operacion) {
		
		String prefijo = "(?=[-+*/^()])";
		String sufijo = "(?<=[-+*/^()])";
		String simbolos = "(?=[-+*/^()])|(?<=[-+*/^()])";

		String []arreglo = operacion.split(simbolos);
		
		SeparaExpresion(arreglo);
		
	}

	private void SeparaExpresion(String[] arreglo) {
		
		List cadena = new ArrayList();
		
		//(6+2)*3/2^2-4
		
		/*cadena
			6,2,+,3,*,2,2,^,/,4,-
		*/
		
		/*pilaOperadores
			
		*/
		
		//Recorre el arreglo que hicimos con split
		for (int i = 0; i < arreglo.length; i++) {
			
			//necesitamos saber si el String es un número
			if(isNumeric(arreglo[i])) { 
				//insertar a la pila numérica
				
				cadena.add(arreglo[i]);
				
				if (i == arreglo.length-1) {
					while(!pilaOperaciones.empty()){
						cadena.add(pilaOperaciones.peek());
						pilaOperaciones.pop();
					}
				}
				
			}else {
				//insertar a la pila Operaciones
				
				int prioridad = prioridad(arreglo[i]);
				
				switch (prioridad) {
				
				case 0:
					if(!pilaOperaciones.empty()) {
						
						int prioridadPila = prioridad((String) pilaOperaciones.peek());
					
						if(prioridadPila == prioridad) {
							cadena.add(pilaOperaciones.peek());
							
							pilaOperaciones.pop();
							
					
						}else if(prioridadPila>=prioridad) {
							while(!pilaOperaciones.empty () && !pilaOperaciones.peek().equals("(")){
								
								cadena.add(pilaOperaciones.peek());
								pilaOperaciones.pop();
							}
						}											
					}
					pilaOperaciones.push(arreglo[i]);
					
					break;
				case 1:
					
					if(!pilaOperaciones.empty()) {
						
						int prioridadPilas = prioridad((String) pilaOperaciones.peek());
					
						if(prioridadPilas == prioridad) {
							cadena.add(pilaOperaciones.peek());
							pilaOperaciones.pop();
					
                                                }}
                                        pilaOperaciones.push(arreglo[i]);
                                         break;
	
					
				case 2:
					pilaOperaciones.push(arreglo[i]);
					break;
                                
                                case 3:
					pilaOperaciones.push(arreglo[i]);
					break;
				case 4:
					while(!pilaOperaciones.empty()){
						if (pilaOperaciones.peek().equals("(")){
						pilaOperaciones.pop();
					break;}
					cadena.add(pilaOperaciones.peek());
                                        pilaOperaciones.pop();
                                        } break;
				
				}
			}
		}
		
		System.out.println(cadena);
		ResuelveOperacion(cadena);
	}
	
	private void ResuelveOperacion(List cadena) {
                
                String cadenaoperador;
		double Num2, Num1, r=0;
                
		for (int i = 0; i < cadena.size(); i++) {
			//Esta línea es para saber de qué tipo es el dato
                    if(isNumeric((String) cadena.get(i))){
                        pilaFinal.push(cadena.get(i));
                    }
                    else{
                        cadenaoperador = (String)cadena.get(i);
                        //pop saca de la pila el último dato almacenado, por eso comienzamos con el num 2
//                        Num2 = Integer.parseInt(pilaFinal.pop().toString());
                        Num2 = Double.parseDouble(pilaFinal.pop().toString());
                        Num1 = Double.parseDouble(pilaFinal.pop().toString());
                        
//                        if (cadenaoperador == "+") 
//                            { 
//                                r = Num1 + Num2;
//                                 pilaFinal.push(r);
//                                break;
//                            }  
//                        // Ejecuta cuando condicion1 es verdadero 
//                        else if (cadenaoperador == "-") 
//                                {  r = Num1 + Num2;
//                                 pilaFinal.push(r);
//                                 break;
//                                }          
//                        else if (cadenaoperador == "*") 
//                                {  r = Num1 * Num2;
//                                 pilaFinal.push(r);
//                                break;
//                                } 
//                        else if (cadenaoperador == "/") 
//                                {  r = Num1 / Num2;
//                                 pilaFinal.push(r);
//                                break;
//                                } 
//                        else if (cadenaoperador == "^") 
//                                {  r = Math.pow(Num1, Num2);
//                                 pilaFinal.push(r);
//                                break;
//                                } 
//                        else {break;}
                    switch (cadenaoperador) {
                    case "+":
                        r = Num1 + Num2;
                        pilaFinal.push(r);
                        break;
                    case "-":
                        r = Num1 - Num2;
                        pilaFinal.push(r);
                        break;
                    case "*":
                        r = Num1 * Num2;
                        pilaFinal.push(r);
                        break;
                    case "/":
                        r = Num1 / Num2;
                        pilaFinal.push(r);
                        break;
                    case "^":
                        r = Math.pow(Num1, Num2);
                        pilaFinal.push(r);
                    break;
                        
                    } 
                    }}System.out.println("El resultado es: " + pilaFinal.pop());
		
				
	}



	//Solamente prioridad de símboloes
	private int prioridad(String ope) { 
		
		if (ope.equals("+") || ope.equals("-")){
			
			return 0;
                }
		else if (ope.equals("*") || ope.equals("/")){
	
			return 1; 
                }
		else if (ope.equals("^")){
			
			return 2;
                }
		else if (ope.equals("(")){
			
			return 3;
                }
                else if (ope.equals(")")){
			
			return 4;
                }	
		return -1;
	} //Fin de la funcion prioridad
	
	private boolean isNumeric(String string) {
		
		try{  
			double d = Double.parseDouble(string);  
			return true;
		}catch(NumberFormatException nfe){  
			return false;  
		}  
	}
}
