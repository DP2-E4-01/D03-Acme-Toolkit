package acme.features.patron.dashboard;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import acme.enums.Status;
import acme.forms.PatronDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronDashboardShowService implements AbstractShowService<Patron, PatronDashboard> {



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
		
		result.setTotalNumberPatronage(this.getTotals(id));
		
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
	
	private Map<Status, Integer> getTotals(final int id) {
		
		
		final Map<Status, Integer> totals = new HashMap<Status, Integer>();
		for(final Status key : Status.values()) {
			System.out.print(this.repository.getPatronageTotalsByStatus(key, id));
			System.out.print(id);
			totals.put(key, this.repository.getPatronageTotalsByStatus(key, id));	
			
			
		}
		return totals;
	}
	


	
}
