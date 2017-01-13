package be.vdab.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.repositories.SausRepository;

@WebServlet("/sauzen/verwijderen.htm")
public class SauzenVerwijderenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/sauzen.jsp";
    private static final String REDIRECT_URL = "%s/sauzen.htm";
    private final SausRepository sausRepository = new SausRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	request.getRequestDispatcher(VIEW).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	if (request.getParameterValues("id") != null) {
	    sausRepository.delete(
		    Arrays.stream(request.getParameterValues("id"))
		    .map(id -> sausRepository.read(Long.parseLong(id)))
		    .filter(optionalId -> optionalId.isPresent())
		    .map(optionalId -> optionalId.get().getNummer())
		    .collect(Collectors.toSet())
		    );
	    response.sendRedirect(String.format(REDIRECT_URL, request.getContextPath()));
	} 
    }

}
