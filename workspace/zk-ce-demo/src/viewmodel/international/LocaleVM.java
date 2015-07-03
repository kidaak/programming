package viewmodel.international;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.lang.Library;
import org.zkoss.util.Locales;
import org.zkoss.web.Attributes;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.WebApp;
import org.zkoss.zk.ui.util.Clients;

public class LocaleVM {
	private Session session;
	private WebApp webApp;
	private Library library;
	private HttpServletRequest request;

	@Init
	public void init(@ContextParam(ContextType.SESSION) Session session,
			@ContextParam(ContextType.APPLICATION) WebApp application) {
		this.session = session;
	}

	@Command
	public void changeLocaleWithReloading(
			@BindingParam("locale") String localeName) {
		session.setAttribute(Attributes.PREFERRED_LOCALE,
				new Locale(localeName));
		Executions.sendRedirect(null);
	}

	@Command
	@NotifyChange("*")
	public void changeLocaleWithoutReloading(
			@BindingParam("locale") String localeName) {
		Locale locale = new Locale(localeName);
		session.setAttribute(Attributes.PREFERRED_LOCALE, locale);
		try {
			Clients.reloadMessages(locale);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Locales.setThreadLocal(locale);
	}

	public Session getSession() {
		return session;
	}

	public WebApp getWebApp() {
		return webApp;
	}

	public Library getLibrary() {
		return library;
	}

	public HttpServletRequest getRequest() {
		return request;
	}
}
