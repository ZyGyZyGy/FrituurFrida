package be.vdab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Saus;

@WebServlet("/sauzen.htm")
public class SauzenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "WEB-INF/JSP/sauzen.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	List<Saus> sauzenLijst = new ArrayList<>();

	sauzenLijst.add(new Saus(5L, "cocktail", new String[] {
		"room", "ketchup", "paprikapoeder", "sherry", "cognac",
		"gembersiroop", "citroensap", "peper", "zout" }
	));
	sauzenLijst.add(new Saus(12L, "mayonaise", new String[] {
		"olie", "eidooiers", "azijn", "citroensap", "mosterd" }
	));
	sauzenLijst.add(new Saus(18L, "mosterd", new String[] {
		"mosterdzaden", "azijn", "water", "zout", "suiker",
		"peper", "mierikswortel", "rozemarijn", "lavendel" }
	));
	sauzenLijst.add(new Saus(23L, "tartare", new String[] {
		"ei", "peterselie", "gehakte", "uitjes", "sjalotjes",
		"augurk", "kappertjes", "bieslook" }
	));
	sauzenLijst.add(new Saus(31L, "vinaigrette", new String[] {
		"olijfolie", "wijnazijn", "zout", "peper", "tuinkruiden", "moster", "knoflook" }
	));
	request.setAttribute("sauzen", sauzenLijst);
	request.getRequestDispatcher(VIEW).forward(request, response);
    }

}
