package be.vdab.servlets;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.repositories.SausRepository;

@WebServlet("/sauzen/metingredient.htm")
public class SauzenMetIngredient extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/sauzenmetingredient.jsp";
    private final SausRepository sausRepository = new SausRepository();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
//	if (request.getQueryString() != null) {
//	    Map<String, String> fouten = new HashMap<>();
//	    String ingredient = null;
//	    try {
//		ingredient = request.getParameter("ingredient");
//	    } catch (Exception e) {
//		fouten.put("ingredient", "tik een ingredient");
//	    }
//	    if (fouten.isEmpty()) {
//		request.setAttribute("sauzen", sausRepository.findByIngredient(ingredient));
//	    } else {
//		request.setAttribute("fouten", fouten);
//	    }
//	}
	
	String ingredient = request.getParameter("ingredient");
	if (ingredient != null) {
	    if (ingredient.isEmpty()) {
		request.setAttribute("fouten", Collections.singletonMap("ingredient", "verplicht"));
	    } else {
		request.setAttribute("sauzen", sausRepository.findByIngredient(ingredient));
	    }
	}
	request.getRequestDispatcher(VIEW).forward(request, response);
    }

}
