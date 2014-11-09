<%--// ------------------------------------------- --%>
<%--//                                             --%>
<%--//            SimpleTextNote component           --%>
<%--//                                             --%>
<%--// ------------------------------------------- --%>
<%--// root element --%>
.z-simpletextnote {
    <%--// be the anchor of absolute positioned children --%>
    position: relative;
    overflow: hidden;
}
<%--// the mask that cover whole element --%>
<%--// no background-color and opacity specified --%>
<%--// since we specified them in widget class --%>
.z-simpletextnote-cover {
    <%--// absoluted positioned --%>
    position: absolute;
    <%--// align the left-top corner of parent (root) element --%>
    left: 0px;
    top: 0px;
    <%--// cover whole root element --%>
    height: 100%;
    width: 100%;
    <%--// make it the top most element under root element --%>
    z-index: 99999;
}

.z-simpletextnote .z-simpletextnote-noteblock {
    <%--// absoluted positioned --%>
    position: absolute;
    <%--// in front of mask --%>
    z-index: 999999;
}