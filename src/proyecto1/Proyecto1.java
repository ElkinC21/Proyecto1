/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1;

import java.util.Scanner;

/**
 *
 * @author elkin
 */
public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner lea = new Scanner(System.in);

        String decision, linea;
        boolean opciones = false, ingefectivo = true, facturacion;
        boolean compra;
        double volventas=0, volcompras=0, caja=0;
        int ventas = 0, compras = 0;
        double precio=0;
        String detallesfactura = "", proveedor, tipocliente;
        double aumentocaja;
        String producto = "";
        double cantidad_producto = 0;
        double Azucar_cantidad = 0;
        double Avena_cantidad = 0;
        double Trigo_cantidad = 0;
        double Maiz_cantidad = 0;
        double cantidad = 0;
        int codigoproducto = 0;
        double cantidadkilogramo = 0;
        double sumasubtotales = 0;
        double descuento;
        double descuentoaplicado = 0;
        int porcentaje = 0;
        double impuesto;
        double total;
        int opcion = 0;
        double precioavena;
        double gasto, promediocompras, promedioventas;
        String prodstar;
        double mayorventa=0;
        double mayorcompra=0, depositar;
        int ventasazucar = 0;
        int ventastrigo = 0;
        int ventasmaiz = 0;
        int ventasavena = 0;
        int masvendido = 0;
        double depositodisponible;
        int canproducto=0;
        double totalinventario;
        

//CICLO BASE O PRINCIPAL DEL PROGRAMA
        while (opcion != 6) {
            System.out.println("----------------CAJA REGISTRADORA---------------");
            System.out.println("");
            System.out.println("Menu inicial");
            System.out.println("");
            System.out.println("1.Abrir Caja");
            System.out.println("2.Ventas");
            System.out.println("3.Compras");
            System.out.println("4.Reportes");
            System.out.println("5.Cierre de caja");
            System.out.println("6.Salir del sistema");
            System.out.print("Seleccione una opcion: ");

            // VALIDACION QUE LA OPCION SEA UN NUMERO 
            if (!lea.hasNextInt()) {
                lea.next();
                System.out.println("Porfavor ingrese una opcion valida");

                continue;
            }
            opcion = lea.nextInt();
            lea.nextLine();
            totalinventario= Azucar_cantidad+Maiz_cantidad+Trigo_cantidad+Avena_cantidad;
            switch (opcion) {
                // SWITCH PARA LAS DISTINTAS OPCIONES DEL MENU
                
                case 1:
                    //CAJA

                    opciones = true;
                    System.out.println("");
                    System.out.println("----------------CAJA---------------");
                    System.out.println("");
                    if (ingefectivo == true) {
                        System.out.print("Ingrese cantidad de efectivo que desea depositar a la caja LPS: ");
                        linea = lea.nextLine();

                        Scanner vali = new Scanner(linea);

                        if (vali.hasNextDouble()) {
                            aumentocaja = vali.nextDouble();
                            if (aumentocaja > 0) {
                                System.out.println("Su deposito se ha realizado exitosamente");
                                System.out.println();
                                caja += aumentocaja;
                            } else {
                                System.out.println("ERROR......VALOR INVALIDO");
                                continue;
                            }
                        } else {
                            System.out.println("ERROR......VALOR INVALIDO");
                            continue;
                        }
                    }
                    System.out.println("Caja actual: " + String.format("%.2f",caja) + " Lps");
                    System.out.println();
                    ingefectivo = true;
                    break;

                case 2:
                    //OPCION VENTAS
                    if (opciones == false) {
                        System.out.println(""); 
                        System.out.println("DEBE ABRIR CAJA ANTES DE REALIZAR VENTAS");
                        System.out.println("");
                        continue;
                    }
                    if(totalinventario<=0){
                        System.out.println("");
                        System.out.println("INVENTARIO VACIO.........SE RECOMIENDA COMPRAR MAS PRODUCTO");
                        System.out.println("");
                        continue;
                    }
                    facturacion = true;
                    System.out.println("");
                    System.out.println("----------------VENTAS---------------");
                    System.out.println("");
                    System.out.println("Tipos de cliente ");
                    System.out.println(" A        B       C ");
                    System.out.print("Ingrese tipo de cliente: ");
                    tipocliente = lea.nextLine();

                    tipocliente = tipocliente.toUpperCase();
                    if (!tipocliente.equals("A") && !"B".equals(tipocliente) && !"C".equals(tipocliente)) {
                        System.out.println("Opcion no valida......Regresando al menu principal");
                        System.out.println("");
                        break;
                    }
                    System.out.println("");
                    while (true) {
                        facturacion = true;
                        System.out.println("----------------------Tabla de Productos-------------------");
                        System.out.println("Codigo del producto         Descripcion             Precio");
                        System.out.println("        1                     Azucar                LPS 30.0");
                        System.out.println("        2                     Avena                 LPS 25.0");
                        System.out.println("        3                     Trigo                 LPS 32.0");
                        System.out.println("        4                     Maiz                  LPS 20.0");
                        System.out.print("Ingrese codigo del producto: ");

                        if (!lea.hasNextInt()) {
                            lea.next();
                            System.out.println("Error...........Porfavor ingrese una opcion valida\n");
                            System.out.println("");
                            System.out.println("");
                            continue;
                        }

                        codigoproducto = lea.nextInt();
                        // VALIDACION PRODUCTO
                        if (codigoproducto != 1 && codigoproducto != 2 && codigoproducto != 3 && codigoproducto != 4) {
                            System.out.println("Opcion no valida.....PORFAVOR INGRESE UNA OPCION VALIDA");
                            System.out.println("");
                            facturacion=false;
                            continue;
                        } else {
                        
                        }
                        boolean venta = true;
                        switch (tipocliente) {
                            // CONDICIONAL CLIENTE Y PRODUCTO
                            case "A":
                                if (codigoproducto == 1) {
                                    producto = "Azucar";
                                    precio = 30;
                                    cantidad_producto = Azucar_cantidad;
                                } else if (codigoproducto == 2) {
                                    producto = "Avena";
                                    precio = 25;
                                    cantidad_producto = Avena_cantidad;
                                } else if (codigoproducto == 3) {
                                    producto = "Trigo";
                                    precio = 32;
                                    cantidad_producto = Trigo_cantidad;
                                } else if (codigoproducto == 4) {
                                    producto = "Maiz";
                                    precio = 20;
                                    cantidad_producto = Maiz_cantidad;
                                }
                                break;
                            case "B":

                                if (codigoproducto == 1) {
                                    producto = "Azucar";
                                    precio = 30;
                                    cantidad_producto = Azucar_cantidad;
                                } else if (codigoproducto == 2) {
                                    producto = "Avena";
                                    precio = 25;
                                    cantidad_producto = Avena_cantidad;
                                } else if (codigoproducto == 3) {
                                    producto = "Trigo";
                                    precio = 32;
                                    cantidad_producto = Trigo_cantidad;
                                } else if (codigoproducto == 4) {
                                    venta = false;
                                }
                                break;
                            case "C":
                                if (codigoproducto == 4) {
                                    producto = "Maiz";
                                    precio = 20;
                                    cantidad_producto = Maiz_cantidad;
                                } else {
                                    venta = false;
                                }
                                break;
                        }

                        // COMPROBAR QUE LA VENTA SEA VALIDA  
                        if (venta == false) {
                            System.out.println("NO PUEDE COMPRAR ESTE PRODUCTO");
                            facturacion = false;

                        } else {
                            while (true) {
                                System.out.print("Ingrese la cantidad en kilogramos que vendera: ");
                                // DEBE SER NUMERO Y MAYOR QUE CERO      
                                if (lea.hasNextDouble()) {
                                    cantidadkilogramo = lea.nextDouble();
                                    lea.nextLine();
                                    if (cantidadkilogramo > 0) {
                                        break;
                                    } else {
                                        System.out.println("ERROR......porfavor ingrese un valor valido");
                                    }
                                } else {
                                    lea.next();
                                    System.out.println("ERROR......porfavor ingrese un valor valido");
                                }
                            }
                            if (cantidadkilogramo > cantidad_producto) {
                                System.out.println("NO HAY SUFICIENTE PRODUCTO.......SE RECOMIENDA ADQUIRIR MAS");
                                facturacion = false;
                            } else {
                                // CONCATENACION/ADICION DE LA FACTURA MEDIANTE EL CICLO       
                                canproducto++;
                                double subtotal = precio * cantidadkilogramo;
                                detallesfactura += "\n"
                                        + "Producto # " + canproducto + ":            " + producto + "\n"
                                        + "Cantidad:                " + cantidadkilogramo + " Kg\n"
                                        + "Precio Unitario:         " + String.format("%.2f",precio) + " LPS\n"
                                        + "Total Parcial:           " + String.format("%.2f",subtotal)+ " LPS\n"          ;
                                
                                sumasubtotales += subtotal;

                                System.out.println("El producto a sido vendido exitosamente");
                                ventas++;

                                //PERDIDA DE PRODUCTO SI SE VENDE          
                                if (producto.equals("Azucar")) {
                                    Azucar_cantidad -= cantidadkilogramo;
                                    ventasazucar++;
                                } else if (producto.equals("Avena")) {
                                    Avena_cantidad -= cantidadkilogramo;
                                    ventasavena++;
                                } else if (producto.equals("Trigo")) {
                                    Trigo_cantidad -= cantidadkilogramo;
                                    ventastrigo++;
                                } else if (producto.equals("Maiz")) {
                                    Maiz_cantidad -= cantidadkilogramo;
                                    ventasmaiz++;
                                }
                           
                            }
                        }

// PREGUNTAR SI DESEA OTRO PRODUCTO  
                        while (true) {
                            System.out.println("Desea comprar otro producto?");
                            System.out.print("SI/NO: ");
                            decision = lea.nextLine();
                            decision = decision.toUpperCase();
                            if (!decision.equals("NO") && !decision.equals("SI")) {
                                System.out.println("ERROR.....Ingrese una opcion valida");
                                System.out.println("");
                            } else {
                                break;
                            }
                        }

                        if (decision.equals("NO")) {
                            break;
                        }
                    }
                    if (sumasubtotales > 5000) {
                        porcentaje = 10;
                        descuento = sumasubtotales * 0.1;

                    } else if (sumasubtotales >= 1000) {
                        porcentaje = 5;
                        descuento = sumasubtotales * 0.05;

                    } else {
                        porcentaje=0;
                        descuento = 0;

                    }

                    // CALCULOS E IMPRESION DE LA FACTURA    
                    impuesto = sumasubtotales * 0.07;
                    total = (sumasubtotales + impuesto) - descuento;
                    if (facturacion == true) {
                        System.out.println("");
                        System.out.print("-----------------Facturacion------------");
                        System.out.println(detallesfactura);
                        System.out.println("          RESUMEN DE PAGO       ");
                        System.out.println("Subtotal:                " + String.format("%.2f",sumasubtotales) + " LPS");
                        System.out.println("Descuento " + porcentaje + "%:            " + String.format("%.2f", descuento) + " LPS");
                        System.out.println("Impuesto 7%:             " + String.format("%.2f", impuesto) + " LPS");
                        System.out.println("Total a pagar:           " + String.format("%.2f", total) + " LPS");
                        System.out.println("");
                        caja += total;
                        volventas += total;
                        canproducto = 0;
                        if (total > mayorventa) {
                            mayorventa = total;
                        }

                        detallesfactura = "";
                        sumasubtotales = 0;

                    }
                    break;

                // COMPRAS
                case 3:
                    precioavena = 20;
                    if (opciones == false) {
                        System.out.println("");
                        System.out.println("DEBE ABRIR CAJA ANTES DE REALIZAR COMPRAS");
                        System.out.println("");
                        continue;
                    }
                    compra = true;
                    // ELECCION DE PROVEEDOR      
                    System.out.println("----------------COMPRAS---------------");
                    System.out.println("");
                    System.out.println("Tipos de proveedor");
                    System.out.println(" A        B       C ");
                    System.out.print("Ingrese tipo de proveedor: ");
                    proveedor = lea.next();
                    proveedor = proveedor.toUpperCase();
                    System.out.println("");
                    if (!proveedor.equals("A") && !proveedor.equals("B") && !proveedor.equals("C")) {
                        System.out.println("Opcion no valida........Regresando al menu principal");
                        break;
                    }
                    if (proveedor.equals("C")) {
                        precioavena = 22;

                    }
                    // SELECCION DE PRODUCTO        
                   while(true) {
                    System.out.println("----------------------Tabla de Productos-------------------");
                    System.out.println("Codigo del producto         Descripcion             Precio");
                    System.out.println("        1                     Azucar                LPS 25.0");
                    System.out.println("        2                     Avena                 LPS " + precioavena);
                    System.out.println("        3                     Trigo                 LPS 30.0");
                    System.out.println("        4                     Maiz                  LPS 18.0");
                    System.out.print("Ingrese codigo del producto: ");
                    if (!lea.hasNextInt()) {
                        lea.next();
                        System.out.println("");
                        System.out.println("Error...........PORFAVOR INGRESE UNA OPCION VALIDA\n");
                        System.out.println("");
                        System.out.println("");
                        continue;
                    }

                    codigoproducto = lea.nextInt();
                    lea.nextLine();
                    if(codigoproducto!=1&&codigoproducto!=2&&codigoproducto!=3&&codigoproducto!=4){
                        System.out.println("");
                        System.out.println("ERROR.....PORFAVOR INGRESE UNA OPCION VALIDA\n");
                        System.out.println("");
                    }else{
                    break;
                    }
                   }
                    switch (proveedor) {

                        // CONDICIONAL. TIPO PROVEEDOR CON CODIGO DE PRODUCTO    
                        case "A":
                            if (codigoproducto == 1) {
                                producto = "Azucar";
                                precio = 25;

                            } else if (codigoproducto == 2) {
                                compra = false;

                            } else if (codigoproducto == 3) {
                                compra = false;
                            } else if (codigoproducto == 4) {
                                producto = "Maiz";
                                precio = 18;

                            }
                            
                            break;
                        case "B":

                            if (codigoproducto == 1) {
                                producto = "Azucar";
                                compra = false;
                            } else if (codigoproducto == 2) {
                                producto = "Avena";
                                precio = 20;

                            } else if (codigoproducto == 3) {
                                producto = "Trigo";
                                precio = 30;
                            } else if (codigoproducto == 4) {
                                producto = "Maiz";
                                compra = false;
                            }
                            break;
                        case "C":
                            if (codigoproducto == 1) {
                                producto = "Azucar";

                                compra = false;
                            }
                            if (codigoproducto == 2) {
                                producto = "Avena";
                                precio = 22;

                            }
                            if (codigoproducto == 3) {
                                producto = "Trigo";

                                compra = false;
                            }
                            if (codigoproducto == 4) {
                                producto = "Maiz";

                                compra = false;
                            }
                            break;
                    }

                    // VALIDACION SI SE PUEDE REALIZAR LA COMPRA  
                    if (compra == false) {
                        System.out.println("Proveedor no vende " + producto);
                    } else {
                        while (true) {
                            // NO INGRESAR ALGO ! A NUMERO POSITIVOS Y MAYOR QUE CERO   
                            System.out.print("Ingrese la cantidad en kilogramos que desea comprar: ");
                            linea = lea.nextLine();

                            Scanner num = new Scanner(linea);

                            if (num.hasNextDouble()) {
                                cantidadkilogramo = num.nextDouble();

                                if (cantidadkilogramo > 0) {
                                    break;
                                } else {
                                    System.out.println("ERROR......porfavor ingrese un valor valido");
                                
                                }
                            } else {

                                System.out.println("ERROR......porfavor ingrese un valor valido");
                            }
                        }
                        // VERIFICACION QUE SE PUEDA REALIZAR LA COMPRA  

                        gasto = precio * cantidadkilogramo;
                        if (gasto > caja) {
                            System.out.println("NO SE HA REALIZADO LA COMPRA..... SALDO INSUFICIENTE");
                            break;
                        } else {
                            System.out.println("El producto a sido comprado exitosamente\n");
                            System.out.println("Monto gastado: "+ String.format("%.2f",gasto));
                            compras++;
                            caja = caja - gasto;
                            volcompras += gasto;
                            if (gasto > mayorcompra) {
                                mayorcompra = gasto;
                            }
                            // AUMENTO DE INVENTARIO SI SE COMPRA DICHO PRODUCTO 
                            if (producto.equals("Azucar")) {
                                Azucar_cantidad += cantidadkilogramo;
                            } else if (producto.equals("Avena")) {
                                Avena_cantidad += cantidadkilogramo;
                            } else if (producto.equals("Trigo")) {
                                Trigo_cantidad += cantidadkilogramo;
                            } else if (producto.equals("Maiz")) {
                                Maiz_cantidad += cantidadkilogramo;
                            }
                                
                        }
                             
                    }
                    break;

//REPORTES
                case 4:
                if (opciones == false) {
                        System.out.println("");
                        System.out.println("DEBE ABRIR CAJA ANTES DE SOLICITAR UN REPORTE");
                        System.out.println("");
                        continue;
                    }

//CALCULOS DE REPORTES  
                    promediocompras = (compras > 0 ? volcompras / compras : 0);
                    promedioventas = (ventas > 0 ? volventas / ventas : 0);
                    prodstar = (ventas <= 0 ? "SIN RESULTADOS POR AHORA" : "");
                    if (ventasazucar > masvendido) {
                        prodstar = "Azucar";
                        masvendido = ventasazucar;
                    }
                    if (ventasmaiz > masvendido) {
                        prodstar = "Maiz";
                        masvendido = ventasmaiz;
                    }
                    if (ventastrigo > masvendido) {
                        prodstar = "Trigo";
                        masvendido = ventastrigo;
                    }
                    if (ventasavena > masvendido) {
                        prodstar = "Avena";
                        masvendido = ventasavena;
                    }

                    System.out.println("\n----------------REPORTES---------------");
                    System.out.println("");
                    System.out.println("| ESTADO DE CAJA |       ");
                    System.out.println("Caja actualmente LPS: " + String.format("%.2f",caja));
                    System.out.println("");
                    System.out.println("| RESUMEN DE MOVIMIENTOS |    ");
                    System.out.println("Numero de compras: " + compras);
                    System.out.println("Numero de ventas: " + ventas);

                    System.out.println("");
                    System.out.println("| VOLUMEN DE TRANSACCIONES |      ");
                    System.out.println("Volumen total de compras: " + String.format("%.2f",volcompras));
                    System.out.println("Volumen total de ventas: " + String.format("%.2f",volventas));
                    System.out.println("Ganancias: " + String.format("%.2f",(volventas - volcompras)));
                    System.out.println("");
                    System.out.println("| VALORES MEDIOS |            ");
                    System.out.println("Promedio de compras: " + String.format("%.2f",promediocompras));
                    System.out.println("Promedio de ventas: " + String.format("%.2f",promedioventas));
                    System.out.println("");
                    System.out.println("| TOP VENTAS Y COMPRAS |      ");
                    System.out.println("Mayor venta: " + String.format("%.2f",mayorventa));
                    System.out.println("Mayor compra: " + String.format("%.2f",mayorcompra));
                    System.out.println("");
                    System.out.println("| PRODUCTO DESTACADO |    ");
                    System.out.println("PRODUCTO ESTRELLA DEL DIA: " + prodstar);
                    System.out.println("");
                    break;
                // CIERRE DE CAJA
                case 5:
                    if (opciones == false) {
                        System.out.println("");
                        System.out.println("DEBE ABRIR CAJA ANTES DE CERRAR CAJA");
                        System.out.println("");
                        continue;
                    }
                    depositodisponible = caja * 0.6;
                    System.out.println("-----------CIERRE DE CAJA-----------");
                    System.out.println("");
                    System.out.println("   | GANANCIA | ");
                    System.out.println("");
                    System.out.println("Efectivo en caja actual: " + String.format("%.2f",caja) + " LPS");
                    System.out.println("Ganancia del dia: " + String.format("%.2f",(volventas - volcompras)) + " LPS");
                    System.out.println("Cantidad disponible a depositar: " + String.format("%.2f",depositodisponible) + " LPS");
                    
// VERIFICAR QUE SOLO SE PUEDA DEPOSITAR EL 60%  
                    while (true) {
                        System.out.print("Ingrese monto a depositar: ");
                        linea = lea.nextLine();
                        Scanner valid2 = new Scanner(linea);
                        if (valid2.hasNextDouble()) {
                            depositar = valid2.nextDouble();
                            if (depositar <= depositodisponible) {
                                System.out.println("Su deposito se ha realizado exitosamente");
                                caja -= depositar;
                                break;
                            } else {
                                System.out.println("ERROR... monto ingresado es mayor al permitido");
                            }
                        } else {
                            System.out.println("ERROR... ingrese un número válido");
                        }
                    }
                    opciones = false;
                    ingefectivo = false;
                    volcompras = 0;
                    volventas = 0;
                    compras = 0;
                    ventas = 0;
                    promediocompras = 0;
                    promedioventas = 0;
                    mayorventa = 0;
                    mayorcompra = 0;
                    prodstar = "";
                    break;
                //SALIR DEL SISTEMA
                case 6:
                    System.out.println("Saliendo del sistema.......");
                    break;
                default:
                    System.out.println("ERROR........Ingrese una opcion valida");
                    System.out.println("");

            }

        }
    }
}
