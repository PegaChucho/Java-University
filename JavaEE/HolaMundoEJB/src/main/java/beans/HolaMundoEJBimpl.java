
package beans;

import javax.ejb.Stateless;

@Stateless
public class HolaMundoEJBimpl implements HolaMundoEJBRemote{

    @Override
    public int sumar(int a, int b) {
        System.out.println("Ejecutando método suma en el servidor");
        return a+b;
    }
    
}
