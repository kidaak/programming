package viewmodel.international;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.lang.Library;
import org.zkoss.util.Locales;
import org.zkoss.web.Attributes;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.WebApp;
import org.zkoss.zk.ui.util.Clients;

public class LocaleVM {
	private Session session;

	@Init
	public void init(@ContextParam(ContextType.SESSION) Session session,
			@ContextParam(ContextType.APPLICATION) WebApp application) {
		this.session = session;

		System.out.println(session.getAttribute(Attributes.PREFERRED_LOCALE));
		System.out.println(application
				.getAttribute(Attributes.PREFERRED_LOCALE));
		System.out.println(Library.getProperty(Attributes.PREFERRED_LOCALE));
		HttpServletRequest request = (HttpServletRequest) Executions
				.getCurrent().getNativeRequest();
		System.out.println(request.getAttribute(Attributes.PREFERRED_LOCALE));
		System.out.println(request.getLocale());
	}

	@Command
	public void changeLocaleWithReloading() {
		session.setAttribute(Attributes.PREFERRED_LOCALE, new Locale("de"));
		Executions.sendRedirect(null);
	}

	@Command
	public void changeLocaleWithoutReloading() {
		Locale locale = new Locale("de");
		session.setAttribute(Attributes.PREFERRED_LOCALE, locale);
		try {
			Clients.reloadMessages(locale);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Locales.setThreadLocal(locale);
	}
}
