package controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.metainfo.ComponentInfo;
import org.zkoss.zk.ui.select.SelectorComposer;

public class TreeComposer extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3043418944149662028L;

	@Override
	public ComponentInfo doBeforeCompose(Page page, Component parent,
			ComponentInfo compInfo) {
		return super.doBeforeCompose(page, parent, compInfo);
	}

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
}
