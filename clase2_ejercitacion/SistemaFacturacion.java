import java.util.*;
class Factura {
    int idFactura;
    int idCliente;
    double importe;
    
    public Factura(int idFactura, int idCliente, double importe) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.importe = importe;
    }
}

class Cliente {
    int idCliente;
    String nombre;
    
    public Cliente(int idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
    }
}

public class SistemaFacturacion {
    
    // sin Maps
    public static List<String> generarReporteSinMap(List<Factura> facturas, List<Cliente> clientes) {
        List<String> reporte = new ArrayList<>();
        for (Cliente cliente : clientes) {
            double suma = 0;
            for (Factura factura : facturas) {
                if (factura.idCliente == cliente.idCliente) {
                    suma += factura.importe;
                }
            }
            reporte.add(cliente.idCliente + ", " + cliente.nombre + ", " + suma);
        }
        return reporte;
    }
    
    //con Maps
    public static List<String> generarReporteConMap(List<Factura> facturas, List<Cliente> clientes) {
        Map<Integer, Double> sumaImportes = new HashMap<>();
        for (Factura factura : facturas) {
            sumaImportes.put(factura.idCliente, sumaImportes.getOrDefault(factura.idCliente, 0.0) + factura.importe);
        }
        
        List<String> reporte = new ArrayList<>();
        for (Cliente cliente : clientes) {
            double suma = sumaImportes.getOrDefault(cliente.idCliente, 0.0);
            reporte.add(cliente.idCliente + ", " + cliente.nombre + ", " + suma);
        }
        return reporte;
    }
    
    public static void main(String[] args) {
        List<Factura> facturas = Arrays.asList(
            new Factura(1, 101, 200.0),
            new Factura(2, 102, 150.0),
            new Factura(3, 101, 300.0),
            new Factura(4, 103, 400.0)
        );
        
        List<Cliente> clientes = Arrays.asList(
            new Cliente(101, "Ariel"),
            new Cliente(102, "German"),
            new Cliente(103, "Hector")
        );
        
        System.out.println("Salida sin Map:");
        System.out.println(generarReporteSinMap(facturas, clientes));
        
        System.out.println("Salida con Map:");
        System.out.println(generarReporteConMap(facturas, clientes));
    }
}
  