package main.dosw.semana_3patrones;

// State
interface DocumentState {

    void approve(Document documento);

    void reject(Document documento);

}

// Estado borrador
class DraftState implements DocumentState {

    @Override
    public void approve(Document documento) {

        System.out.println("Documento enviado a revision");

        documento.setState(new InReviewState());

    }

    @Override
    public void reject(Document documento) {

        System.out.println("Documento rechazado");

        documento.setState(new RejectedState());

    }

}

// Estado en revision
class InReviewState implements DocumentState {

    @Override
    public void approve(Document documento) {

        System.out.println("Documento aprobado");

        documento.setState(new ApprovedState());

    }

    @Override
    public void reject(Document documento) {

        System.out.println("Documento rechazado");

        documento.setState(new RejectedState());

    }

}

// Estado aprobado
class ApprovedState implements DocumentState {

    @Override
    public void approve(Document documento) {

        System.out.println("Ya esta aprobado");

    }

    @Override
    public void reject(Document documento) {

        System.out.println("No puede rechazarse");

    }

}

// Estado rechazado
class RejectedState implements DocumentState {

    @Override
    public void approve(Document documento) {

        System.out.println("No puede aprobarse");

    }

    @Override
    public void reject(Document documento) {

        System.out.println("Ya esta rechazado");

    }

}

// Documento
class Document {

    private DocumentState estado;

    public Document() {

        estado = new DraftState();

    }

    public void setState(DocumentState estado) {

        this.estado = estado;

    }

    public void approve() {

        estado.approve(this);

    }

    public void reject() {

        estado.reject(this);

    }

}

// Chain of Responsibility
abstract class DocumentHandler {

    protected DocumentHandler siguiente;

    public void setSiguiente(DocumentHandler siguiente) {

        this.siguiente = siguiente;

    }

    public abstract void handle(Document documento);

}

// Autor
class AutorHandler extends DocumentHandler {

    @Override
    public void handle(Document documento) {

        System.out.println("Revision del autor");

        documento.approve();

        if (siguiente != null) {

            siguiente.handle(documento);

        }

    }

}

// Lider
class LiderHandler extends DocumentHandler {

    @Override
    public void handle(Document documento) {

        System.out.println("Revision del lider");

        documento.approve();

        if (siguiente != null) {

            siguiente.handle(documento);

        }

    }

}

// Juridico
class JuridicoHandler extends DocumentHandler {

    @Override
    public void handle(Document documento) {

        System.out.println("Revision juridica");

        documento.approve();

    }

}

// Main
public class EJERCICIO7 {

    public static void main(String[] args) {

        Document documento = new Document();

        AutorHandler autor = new AutorHandler();
        LiderHandler lider = new LiderHandler();
        JuridicoHandler juridico = new JuridicoHandler();

        autor.setSiguiente(lider);
        lider.setSiguiente(juridico);

        autor.handle(documento);

    }

}