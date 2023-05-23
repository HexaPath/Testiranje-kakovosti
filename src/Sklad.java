
import java.util.ArrayList;
import java.util.List; 


class Element<Tip> {

    public Tip vrednost;
    public Element<Tip> vezava;

    public Element(Tip e) {
        this.vrednost = e;
    }
}

public class Sklad<Tip> implements Seznam<Tip> {

    private Element<Tip> vrh;
    private List<Tip> listaSklada;

    public Sklad() {
        listaSklada = new ArrayList<>();
    } 

    public void push(Tip e) {
        Element<Tip> novVrh = new Element<>(e);
        novVrh.vezava = vrh;
        vrh = novVrh;
    }

    public Tip pop() {
        if (vrh == null) {
            throw new java.util.NoSuchElementException();
        }
        Tip e = vrh.vrednost;
        vrh = vrh.vezava;
        return e;
    }

    @Override
    public boolean isEmpty() {
        return (vrh == null);
    }

    public Tip top() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return vrh.vrednost;
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        }

        int stElementov = 0;
        Element<Tip> tmp = vrh;
        while (tmp != null) {
            stElementov++;
            tmp = tmp.vezava;
        }
        return stElementov;
    }

    public boolean isTop(Tip e) {
        if (vrh == null) {
            throw new java.util.NoSuchElementException();
        }
        return vrh.vrednost.equals(e);
    }

    public int search(Tip e) {
        Element<Tip> tmp = vrh;
        int i = 0;
        while (null != tmp) {
            if (tmp.vrednost.equals(e)) {
                return i;
            }
            i++;
            tmp = tmp.vezava;
        }
        return -1;
    }

    @Override
    public void add(Tip e) {
        this.push(e);
    }

    @Override
    public Tip removeFirst() {
        return this.pop();
    }

    @Override
    public Tip getFirst() {
        return top();
    }

    @Override
    public int depth() {
        return this.size();
    }

    @Override
    public Tip remove(Tip e) {
        // TODO:
        throw new java.util.NoSuchElementException("To funckijo morate implementirati");
    }

    @Override
    public boolean exists(Tip e) {
        //TODO: 
        throw new java.util.NoSuchElementException("To funckijo morate implementirati");
    }

    
    
    
    
    
    
    @Override
    public List<Tip> asList() {
        listaSklada.clear();
        Element<Tip> elt = vrh;
        Element<Tip> tmp = elt;
        int i = 0;
        while (null != elt) {
            if (i > 0) {
                tmp = elt;
            }
            listaSklada.add(tmp.vrednost);
            elt = elt.vezava;
            i++;
        }
        return listaSklada;
    }
    

}
