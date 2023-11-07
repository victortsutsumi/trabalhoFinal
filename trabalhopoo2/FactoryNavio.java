package trabalhopoo2;

public class FactoryNavio {

    public Submarino constroiNavio(String modelo) {
        if (modelo.equals("submarino")) {
            return new Submarino();
        }
        return null;
    }

}
