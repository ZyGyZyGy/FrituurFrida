package be.vdab.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.entities.GastenboekEntry;
import be.vdab.repositories.GastenboekRepository;

@WebServlet("/gastenboek.htm")
public class GastenboekServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/gastenboek.jsp";
    private static final GastenboekRepository gastenboekRepository = new GastenboekRepository();

    @Resource(name = GastenboekRepository.JNDI_NAME)
    public void setDataSource(DataSource dataSource) {
	gastenboekRepository.setDataSource(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	request.setAttribute("gastenboek", gastenboekRepository.findAll());
	request.getRequestDispatcher(VIEW).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	if (request.getParameter("toevoegen") != null) {
	    Map<String, String> fouten = new HashMap<>();
	    String naam = request.getParameter("naam");
	    if (!GastenboekEntry.isNaamValid(naam)) {
		fouten.put("naam", "verplicht");
	    }
	    String bericht = request.getParameter("bericht");
	    if (!GastenboekEntry.isBerichtValid(bericht)) {
		fouten.put("bericht", "verplicht");
	    }
	    if (fouten.isEmpty()) {
		gastenboekRepository.create(new GastenboekEntry(naam, bericht));
		response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
	    } else {
		request.setAttribute("fouten", fouten);
		request.getRequestDispatcher(VIEW).forward(request, response);
	    }
	}
    }

}
