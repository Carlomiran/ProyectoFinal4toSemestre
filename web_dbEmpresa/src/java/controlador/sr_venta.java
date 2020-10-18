/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Venta;

/**
 *
 * @author jarno
 */
public class sr_venta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Venta venta;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_venta</title>");            
            out.println("</head>");
            out.println("<body>");
            venta = new Venta(Integer.valueOf(request.getParameter("txt_id_venta")), Integer.valueOf(request.getParameter("txt_no_factura")), Integer.valueOf(request.getParameter("drop_cliente")), Integer.valueOf(request.getParameter("drop_empleado")), request.getParameter("txt_serie"), request.getParameter("txt_fecha_factura"), request.getParameter("txt_fecha_ingreso"));             
            if("Agregar".equals(request.getParameter("btn_agregar"))){
                if(venta.agregar() > 0){
                    response.sendRedirect("detalle_maestro_venta.jsp");
                }else{
                    out.println("<h1>Error al ingresar</h1>");
                    out.println("<a href='detalle_maestro_venta.jsp'>Regresar</a>");
                }
            }
            
            if("Modificar".equals(request.getParameter("btn_modificar"))){
                if(venta.modificar() > 0){
                    response.sendRedirect("detalle_maestro_venta.jsp");
                }else{
                    out.println("<h1>Error al modificar</h1>");
                    out.println("<a href='detalle_maestro_venta.jsp'>Regresar</a>");
                }
            }
                        
            if("Eliminar".equals(request.getParameter("btn_eliminar"))){
                if(venta.eliminar() > 0){
                    response.sendRedirect("detalle_maestro_venta.jsp");
                }else{
                    out.println("<h1>Error al eliminar</h1>");
                    out.println("<a href='detalle_maestro_venta.jsp'>Regresar</a>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}