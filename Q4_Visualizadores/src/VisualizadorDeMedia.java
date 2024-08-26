import java.util.List;

public class VisualizadorDeMedia implements Observer {
    private List<Integer> valores;
    private boolean active = false;

    public VisualizadorDeMedia(List<Integer> valores){
        this.valores = valores;
    }

    public void defineValores(List<Integer> valores){
        this.valores = valores;
    }

    public void acrescentaValor(Integer valor){
        this.valores.add(valor);
    }

    public void exibeMedia(){
        double media = valores.stream()
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0.0);
        System.out.println("Media: "+media+", quantidade de elementos analisados: "+valores.size());
    }

    public void notifica(List<Integer> valores){
        this.valores = valores;
        if (active) exibeMedia();
    }

    public void toggle() {
        active = !active;
    }
}
