package acme.features.patron.dashboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.item.ItemType;
import acme.enums.Status;
import acme.forms.Dashboard;
import acme.forms.PatronDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronDashboardShowService implements AbstractShowService<Patron, PatronDashboard> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronDashboardRepository repository;

	@Override
	public boolean authorise(final Request<PatronDashboard> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public PatronDashboard findOne(final Request<PatronDashboard> request) {
		assert request != null;
		
		final PatronDashboard result = new PatronDashboard();
		int id = request.getPrincipal().getActiveRoleId();
		
		result.setTotalNumberPatronage(this.getTotals( id));
		//result.setPatronagesBudgets(this.getPatronagesBudgets(result.getTotalscurre() ,id));
		
		
		return result;
	}

	@Override
	public void unbind(final Request<PatronDashboard> request, final PatronDashboard entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "totalNumberPatronage");
		
	
	}
	
	private Map<Status, Integer> getTotals(final  int id) {
		
		
		final Map<Status, Integer> totals = new HashMap<Status, Integer>();
		for(final Status key : Status.values()) {
			
			totals.put(key, this.repository.getPatronageTotalsByStatus(key, id));	
		}
		return totals;
	}
	
	/*
	private Map<String, Map<String, Double>> getPatronagesBudgets( List<String> totalsKeys2 , int id) {
		final Map<String, Map<String, Double>> patronageBudgets = new HashMap<String, Map<String, Double>>();
		for(final Status key : Status.values()) {
			for(final String key2 : totalsKeys2) {
				final List<Double> budgetData = this.repository.getPatronageBudgetByStatus(key);
				
				System.out.println(budgetData.toString());
				
				final Map<String, Double> bd = new HashMap<String, Double>();
				bd.put("Min", budgetData.get(0));
				bd.put("Max", budgetData.get(1));
				bd.put("Average", budgetData.get(2));
				bd.put("Deviation", budgetData.get(3));
				
				
			}
			
		}
		return patronageBudgets;
	}
	*/
	
}
