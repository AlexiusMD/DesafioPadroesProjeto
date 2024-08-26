import java.util.List;

public class VisualizadorDeMaior implements Observer{
    private List<Integer> valores;
    private boolean active = false;

    public VisualizadorDeMaior(List<Integer> valores){
        this.valores = valores;
    }

    public void defineValores(List<Integer> valores){
        this.valores = valores;
    }

    public void acrescentaValor(Integer valor){
        this.valores.add(valor);
    }

    public void exibeMaiorValor(){
        Integer biggestValue = 0;
        for (Integer integer : valores) {
            if(integer > biggestValue)
                biggestValue = integer;
        }

        System.out.println("Maior valor: "+biggestValue+", quantidade de elementos analisados: "+valores.size());
    }

    public void notifica(List<Integer> valores){
        this.valores = valores;
        if (active) exibeMaiorValor();
    }

    public void toggle() {
        active = !active;
    }
}
