import java.util.Stack;

public class Torre  {
    String etiqueta;
    Stack<Integer> torre;

    public Torre(String etiqueta, Stack<Integer> torre) {
        this.etiqueta = etiqueta;
        this.torre = torre;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Stack<Integer> getTorre() {
        return torre;
    }

    public void setTorre(Stack<Integer> torre) {
        this.torre = torre;
    }
}
