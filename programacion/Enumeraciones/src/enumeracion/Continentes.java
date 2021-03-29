
package enumeracion;


public enum Continentes {
    AMERICA(34,343244),
    ASIA(44,34234324),
    AFRICA (53,23432434),
    EUROPA(46,34324),
    OCEANIA(14,32424342);
    
    private final int paises;
    private final int habitantes;
    
    Continentes(int paises, int habitantes){
        this.paises=paises;
        this.habitantes=habitantes;
    }
    
    public int getPaises(){
        return this.paises;
    }
    public int getHabitantes(){
        return this.habitantes;
    }
}
