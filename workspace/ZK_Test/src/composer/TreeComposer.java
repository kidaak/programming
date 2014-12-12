package composer;

import java.util.Collection;
import java.util.Iterator;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.metainfo.ComponentInfo;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treeitem;

public class TreeComposer extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3043418944149662028L;

	@Wire
	private Tree tree;

	@Override
	public ComponentInfo doBeforeCompose(Page page, Component parent,
			ComponentInfo compInfo) {
		return super.doBeforeCompose(page, parent, compInfo);
	}

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}

	@Listen("onClick = treeitem")
	public void onClickTreeitem(Event event) {
		Treeitem treeitem = (Treeitem) event.getTarget();
		System.out.println("isOpen: " + treeitem.isOpen());
//		selecteAllChildren(treeitem);
	}

	public void selecteAllChildren(Treeitem treeitem) {
		if (treeitem.isOpen()) {
			Treechildren treechildren = treeitem.getTreechildren();
			if (treechildren != null) {
				for (Treeitem child : treechildren.getItems()) {
					setSelectedTreeitem(child, treeitem.isSelected());
				}
			}

			Collection<?> com = treeitem.getChildren();
			if (com != null) {
				for (Iterator<?> iterator = com.iterator(); iterator.hasNext();) {
					setSelectedTreeitem((Component) iterator.next(),
							!treeitem.isSelected());

				}
			}
		}
	}

	public void setSelectedTreeitem(Component comp, boolean selected) {
		if (comp instanceof Treeitem) {
			Treeitem treeitem = (Treeitem) comp;
			treeitem.setSelected(selected);
			if (treeitem.isOpen()) {
				Treechildren treechildren = treeitem.getTreechildren();
				if (treechildren != null) {
					for (Treeitem child : treechildren.getItems()) {
						setSelectedTreeitem(child, selected);
					}
				}
			}
		}
	}
}