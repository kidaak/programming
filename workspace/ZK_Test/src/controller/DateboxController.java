package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.metainfo.ComponentInfo;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.SimpleDateConstraint;

public class DateboxController extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4902911740117673597L;
	
	@Wire
	private Datebox dbFormat1, dbFormat2;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	@Override
	public ComponentInfo doBeforeCompose(Page page, Component parent,
			ComponentInfo compInfo) {
		return super.doBeforeCompose(page, parent, compInfo);
	}

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}



	public SimpleDateConstraint getBeforeConstraint() {
		SimpleDateConstraint sdc = new SimpleDateConstraint("before " + sdf.format(dbFormat1.getValue()));
		return sdc;
	}
	
//	public SimpleDateConstraint getFormatDateConstraint() {
//		SimpleDateConstraint sdc = new SimpleDateConstraint("before ");
//	}

}
