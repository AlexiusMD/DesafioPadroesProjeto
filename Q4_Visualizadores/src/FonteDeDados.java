import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FonteDeDados{
    private List<Integer> lst;
    private List<Observer> observers;

    public FonteDeDados(){
        lst = new LinkedList<>();
        observers = new LinkedList<>();
    }

    public void add(Integer value){
        if (value < 0) throw new IllegalArgumentException("Valor invalido");
        lst.add(value);
        notifyObservers();
    }

    public int quantidade(){
        return lst.size();
    }

    public List<Integer> getValores(){
        return new ArrayList<>(lst);
    }

    public void registerObserver(Observer obs){
        observers.add(obs);
    }

    private void notifyObservers(){
        for (Observer obs : observers) {
            obs.notifica(lst);
        }
    }
}