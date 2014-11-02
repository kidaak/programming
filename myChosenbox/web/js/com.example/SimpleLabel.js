/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
com.example.SimpleLabel = zk.$extends(zk.Widget, {
    _value: '',
    getValue: function () {
        return this._value;
    },
    setValue: function (value) {
        if (this._value !== value) {
            this._value = value;
            if (this.desktop) {
                this.$n().innerHTML = zUtl.encodeXML(value);
            }
        }
    },
    redraw: function (out) {
        out.push('<span', this.domAttrs_(), '>', this.getValue(), '</span>');
    }
});

