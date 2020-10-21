
package expresiones;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paloma
 */
public class ExpresionLogicaV {

    String p[] = {"v", "v", "f", "f"};
    String q[] = {"v", "f", "v", "f"};
    String r[] = new String[4];
    
    public ExpresionLogicaV() {
      
        System.out.println("La expresion a realizar es [(p->q)^p]->q");
        Resolverexpresion();
    }
    
    
    public String[] OperacionCondicional(String[] p, String[]q){
        for(int i = 0; i < p.length; i++){
            if(p[i].equals("v") & q[i].equals("v")){
                r[i] = "v";
            }
            
            if(p[i].equals("v") & q[i].equals("f")){
                r[i] = "f";
            }
            
            if(p[i].equals("f") & q[i].equals("v")){
                r[i] = "v";
            }
            
            if(p[i].equals("f") & q[i].equals("f")){
                r[i] = "v";
                    }
            } return r;
    }
    public String[] OperacionConjuncion(String[] p, String[]q){
        for(int i = 0; i < p.length; i++){
            if(p[i].equals("v") & q[i].equals("v")){
                r[i] = "v";
            }
            
            if(p[i].equals("v") & q[i].equals("f")){
                r[i] = "f";
            }
            
            if(p[i].equals("f") & q[i].equals("v")){
                r[i] = "f";
            }
            
            if(p[i].equals("f") & q[i].equals("f")){
                r[i] = "f";
                    }
            } return r;
    }
    
    public String[] OperacionNegacion(String[] aux){
        for(int i = 0; i < p.length; i++){
            if(aux[i].equals("v")){
                r[i] = "f";
            }
            
            if(p[i].equals("f")){
                r[i] = "v";
            }
            
           
                    }return r;
            } 
    
    private void Resolverexpresion(){
        String aux[];
        
        
        aux=OperacionCondicional(p,q);
       
        
        aux=OperacionConjuncion(aux,p);
        p=OperacionNegacion(p);
        
        
        aux= OperacionCondicional(aux,q);
        for(int i=0;i<aux.length;i++){
            System.out.println("Solución: "+aux[i]);
        }

    }
    }

