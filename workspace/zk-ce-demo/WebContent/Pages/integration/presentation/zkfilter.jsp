<?xml version="1.0"?>
<!DOCTYPE html>
<html xmlns="xhtml" xmlns:zul="zul" xmlns:zk="zk">
<head>
<title>ZHTML Demo</title>
</head>
<body>
	<input id="btn1" type="button" value="Add Item" zk:onClick="addItem()" />
</body>
	<zk:zscript>
		<![CDATA[
	void addItem() {
		System.out.println("click on button");
	}
]]></zk:zscript>
</html>