package main.dosw.semana_3patrones;

// Clase abstracta que define el proceso general del reporte
abstract class Reporte {

    // Template Method
    public final void generarReporte() {

        obtenerDatos();
        procesarDatos();
        aplicarFormato();
        exportarArchivo();

    }

    public void obtenerDatos() {
        System.out.println("Obteniendo datos...");
    }

    public void procesarDatos() {
        System.out.println("Procesando datos...");
    }

    public abstract void aplicarFormato();

    public abstract void exportarArchivo();

}

// Reporte PDF
class PdfReport extends Reporte {

    @Override
    public void aplicarFormato() {
        System.out.println("Aplicando formato PDF");
    }

    @Override
    public void exportarArchivo() {
        System.out.println("Exportando archivo PDF");
    }

}

// Reporte Excel
class ExcelReport extends Reporte {

    @Override
    public void aplicarFormato() {
        System.out.println("Aplicando formato Excel");
    }

    @Override
    public void exportarArchivo() {
        System.out.println("Exportando archivo Excel");
    }

}

// Reporte CSV
class CsvReport extends Reporte {

    @Override
    public void aplicarFormato() {
        System.out.println("Aplicando formato CSV");
    }

    @Override
    public void exportarArchivo() {
        System.out.println("Exportando archivo CSV");
    }

}

// Factory Method
class ReportFactory {

    public Reporte crearReporte(String tipo) {

        if (tipo.equalsIgnoreCase("PDF")) {
            return new PdfReport();
        }

        if (tipo.equalsIgnoreCase("EXCEL")) {
            return new ExcelReport();
        }

        if (tipo.equalsIgnoreCase("CSV")) {
            return new CsvReport();
        }

        return null;
    }

}

// Main

