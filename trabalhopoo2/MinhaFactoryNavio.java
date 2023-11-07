package trabalhopoo2;

public class MinhaFactoryNavio implements FactoryNavio{

    @Override
    public Navio constroiNavio(String modelo) {
        if (modelo.equals("submarino")) {
            return new Submarino();
        }
        // Adicione lógica para outros tipos de navios, se necessário.
        return null;
    }
}
