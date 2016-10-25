/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class GestionarServicios{
    GestorJDBC gestorJDBC;
    MesaDAO mesaDAO;
    PlatoDAO platoDAO;
    PedidoDAO pedidoDAO;
    GeneralDAO generalDAO;
    VentaDAO ventaDAO;
    UsuarioDAO usuarioDAO;
    PersonaDAO personaDAO;
    PermisoDAO permisoDAO;
    public GestionarServicios() {
        this.gestorJDBC = new ConexionPostgreSQL();
        this.mesaDAO = new MesaDAO(gestorJDBC);
        this.platoDAO = new PlatoDAO(gestorJDBC);
        this.pedidoDAO = new PedidoDAO(gestorJDBC);
        this.generalDAO = new GeneralDAO(gestorJDBC);
        this.ventaDAO = new VentaDAO(gestorJDBC);
        this.usuarioDAO = new UsuarioDAO(gestorJDBC);
        this.personaDAO = new PersonaDAO(gestorJDBC);
        this.permisoDAO = new PermisoDAO(gestorJDBC);
    }
    public List<Mesa> buscarMesas() throws Exception{              
        List<Mesa> listaMesas;
        gestorJDBC.abrirConexion(); 
        try {            
            listaMesas = mesaDAO.buscar();
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();  
            throw e;
        }                      
        gestorJDBC.cerrarConexion();  
        return listaMesas;
    }
    
    public Mesa buscarMesa(int mesaid) throws Exception{     
        Mesa mesa;
        gestorJDBC.abrirConexion();        
        try {
            mesa = mesaDAO.buscar(mesaid);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();  
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return mesa;
    }
    public void crearMesa(Mesa mesa)throws Exception{
        try {
            gestorJDBC.abrirConexion();
            mesaDAO.ingresar(mesa);
            gestorJDBC.cerrarConexion();
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }
    public void eliminarMesa(Mesa mesa)throws Exception{
        try {
            gestorJDBC.abrirConexion();
            mesaDAO.eliminar(mesa);
            gestorJDBC.cerrarConexion();
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }
    public List<Plato> buscarPlatos(String nombre) throws Exception{     
        List<Plato> listaPlatos;
        gestorJDBC.abrirConexion();        
        try {
            listaPlatos = platoDAO.buscar(nombre);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();  
            throw e;
        }        
        gestorJDBC.cerrarConexion();
        return listaPlatos;
    }
    
    public Plato buscarPlato(int platoid) throws Exception{     
        Plato plato;
        gestorJDBC.abrirConexion();        
        try {
            plato = platoDAO.buscar(platoid);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();  
            throw e;
        }        
        gestorJDBC.cerrarConexion();
        return plato;
    }
    
    public void guardarPedido(Pedido pedido) throws Exception{     
        pedido.validarPedido();
        gestorJDBC.abrirConexion();
        gestorJDBC.iniciarTransaccion();
        try {
            if(pedido.getPedidoid() == 0){ // si es un pedido nuevo
                pedidoDAO.ingresar(pedido);
                mesaDAO.modificarMesaPedido(pedido.getMesa());
            }
            else{ // si es un pedido existente
                pedidoDAO.modificar(pedido);
            }            
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
        }
        gestorJDBC.terminarTransaccion();
    }
    
    public Pedido buscarPedido(Mesa mesa) throws Exception{
        Pedido pedido;
        gestorJDBC.abrirConexion();        
        try {
            pedido = pedidoDAO.buscar(mesa);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();  
            throw e;
        }        
        gestorJDBC.cerrarConexion();
        return pedido;
    }
    
    public void crearPlato(Plato plato) throws Exception{
       gestorJDBC.abrirConexion();
       plato.validarPrecio();
       platoDAO.ingresar(plato);
       gestorJDBC.cerrarConexion();
    }

    public void modificarPlato(Plato plato) throws Exception{
        gestorJDBC.abrirConexion();        
        plato.validarPrecio();
        platoDAO.modificar(plato);
        gestorJDBC.cerrarConexion();
    }
    
    public void eliminarPlato(Plato plato) throws Exception{
        gestorJDBC.abrirConexion();        
        platoDAO.eliminar(plato);
        gestorJDBC.cerrarConexion();
    }
    public List<Interface> NAZCASOFT_ADM_ObtenerModuloPorUsuario(int codigoUsuario)throws Exception{
        gestorJDBC.abrirConexion();
        List<Interface>listaInterfaces;
        listaInterfaces = generalDAO.NAZCASOFT_ADM_ObtenerModuloPorUsuario(codigoUsuario);
        gestorJDBC.cerrarConexion();
        return listaInterfaces;
    }
    public Persona NAZCASOFT_ADM_LoginUsuario(String cuenta, String password) throws Exception{
        gestorJDBC.abrirConexion();
        Persona persona;
        persona = generalDAO.NAZCASOFT_ADM_LoginUsuario(cuenta, password);
        gestorJDBC.cerrarConexion();
        return persona;
    }
    
    public void guardarVenta(Venta venta)throws Exception{
        try {
            gestorJDBC.abrirConexion();
            gestorJDBC.iniciarTransaccion();
            ventaDAO.generarVenta(venta);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
        }
    }
    
    public void crearCliente(Usuario usuario)throws Exception{
        try {
            gestorJDBC.abrirConexion();
            gestorJDBC.iniciarTransaccion();
            Persona persona = usuario.getPersona();
            persona.setCodigo(personaDAO.crearCliente(persona));
            usuario.setPersona(persona);
            usuarioDAO.crearUsuario(usuario);
            Permiso permiso = new Permiso();
            permiso.setUsuario(usuario);
            for(int i=0; i<Permiso.DEFAULT_CLIENTE.length; i++){
                Interface intFace = new Interface();
                intFace.setCodigoInterface(Permiso.DEFAULT_CLIENTE[i]);
                permiso.agregarInterface(intFace);
            }
            permisoDAO.agregarPermisos(permiso);
            gestorJDBC.terminarTransaccion();
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }
    
    public List<Persona> buscarClientes(String nombres)throws Exception{
        try {
            gestorJDBC.abrirConexion();
            List<Persona> listaPersona = personaDAO.buscarPersonaCliente(nombres);
            gestorJDBC.cerrarConexion();
          return listaPersona;
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }
 
 
}
