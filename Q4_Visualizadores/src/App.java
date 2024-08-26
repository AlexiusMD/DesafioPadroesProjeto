import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var dados = new FonteDeDados();
        var cm = new VisualizadorDeMedia(dados.getValores());
        dados.registerObserver(cm);
        var cs = new VisualizadorDeSomatorio(dados.getValores());
        dados.registerObserver(cs);
        var mv = new VisualizadorDeMaior(dados.getValores());
        dados.registerObserver(mv);

        Scanner s = new Scanner(System.in);
        int valor = 0;
        while(true){
            System.out.println("\nEntre um valor positivo maior que zero (0=fim):");
            valor = Integer.parseInt(s.nextLine());
            if (valor == 0){
                break;
            }
            cm.toggle();
            cs.toggle();
            mv.toggle();
            
            dados.add(valor);
        }
        System.out.println("Fim");
    }
}
