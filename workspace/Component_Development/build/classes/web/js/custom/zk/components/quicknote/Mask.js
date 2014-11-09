/**
 * 
 */
custom.zk.components.quicknote.Mask = zk.$extends(zul.Widget, {
	getZClass:function(){
		var zcls = this._zclass;
		return zcls ? zcls : 'z-mask';
	}
});