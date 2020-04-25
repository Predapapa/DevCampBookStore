sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/m/MessageToast",
	"sap/ui/model/json/JSONModel"
], function (Controller, MessageToast, JSONModel) {
	"use strict";

	return Controller.extend("BWATC.BookstoreWebAppTC.controller.MainView", {
		onInit: function () {
			
		},

		onListItemPress: function (oEvent) {
			var listItem = oEvent.getParameter("listItem");
			  var getTitle = listItem.getTitle();
			  
		}	});
});