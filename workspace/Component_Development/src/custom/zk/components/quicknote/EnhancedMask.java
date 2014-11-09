package custom.zk.components.quicknote;

import java.io.IOException;

import org.zkoss.zk.ui.sys.ContentRenderer;
import org.zkoss.zul.impl.XulElement;

public class EnhancedMask extends XulElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int _opacity = 35;
	private String _maskColor = "#ccc";

	public void setOpacity(int opacity) {
		// no negative
		if (opacity < 0) {
			opacity = 0;
		}
		// cannot larger than 100
		if (opacity > 100) {
			opacity = 100;
		}
		// update if value is changed
		if (_opacity != opacity) {
			_opacity = opacity;
			smartUpdate("opacity", _opacity);
		}
	}

	public int getOpacity() {
		return _opacity;
	}

	public void setMaskColor(String maskColor) {
		// update if there is a different value
		if (maskColor != null && !maskColor.isEmpty()
				&& !maskColor.equals(_maskColor)) {
			_maskColor = maskColor;
			smartUpdate("maskColor", _maskColor);
		}
	}

	public String getMaskColor() {
		return _maskColor;
	}

	/**
	 * ComponentCtrl the renderProperties method is a part of component life
	 * cycle it will be called by ZK framework automatically, remember to render
	 * super's properties first
	 */
	@Override
	protected void renderProperties(ContentRenderer renderer)
			throws IOException {
		super.renderProperties(renderer);
		if (_opacity != 35) {
			// this will call setOpacity in widget class
			render(renderer, "opacity", _opacity);
		}
		if (!"#ccc".equals(_maskColor)) {
			// this will call setMaskColor (maskColor) in widget class at the
			// client side
			render(renderer, "maskColor", _maskColor);
		}
	}
}
