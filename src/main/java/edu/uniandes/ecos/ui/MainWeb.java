package edu.uniandes.ecos.ui;

import edu.uniandes.ecos.biz.DesviationBiz;
import edu.uniandes.ecos.util.FileUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

public class MainWeb extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
      process("test1.txt",resp);
      process("test2.txt",resp);
  }
  
  private void process(String file, HttpServletResponse resp) throws IOException{

      System.out.println("Calculo de Desviacion Estadar y Medidas de Estimacion\n");
        
        try {
            resp.getWriter().print("\nArchivo de prueba " + file + "\n\n");
            
            DesviationBiz biz = new DesviationBiz(FileUtil.getListNumbers(file));
            
            resp.getWriter().print("Desviacion Estandar: " + biz.getSd()+"\n\n");
            resp.getWriter().print("VS: " + biz.getVs()+"\n");
            resp.getWriter().print("S: " + biz.getS()+"\n");
            resp.getWriter().print("M: " + biz.getM()+"\n");
            resp.getWriter().print("L: " + biz.getL()+"\n");
            resp.getWriter().print("VL: " + biz.getVl()+"\n\n");


        } catch (FileNotFoundException ex) {
            resp.getWriter().print("No se encuentra el archivo especificado, se debe ubicar en la carpeta /src/test/resources/\n");
        } catch (IOException ex) {
            resp.getWriter().print("Error al leer el archivo especificado\n");
        } catch (NumberFormatException ex) {
            resp.getWriter().print("Existen lineas que no son numeros\n");
        }
        resp.getWriter().print("\nFin de la aplicacion\n");
  }

  public static void main(String[] args) throws Exception {
    Server server = new Server(Integer.valueOf(System.getenv("PORT")));
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");
    server.setHandler(context);
    context.addServlet(new ServletHolder(new MainWeb()),"/*");
    server.start();
    server.join();
  }
}
