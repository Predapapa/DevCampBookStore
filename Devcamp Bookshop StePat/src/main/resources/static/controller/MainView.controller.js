sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/m/MessageToast",
	"sap/ui/model/json/JSONModel"
], function (Controller, MessageToast, JSONModel) {
	"use strict";

	return Controller.extend("BWATC.BookstoreWebAppTC.controller.MainView", {
		onInit: function () {
			var oViewModel = new JSONModel();
			this.getView().setModel(oViewModel, "view");
		},
		
		onPress: function(oEvent){
			console.log("onPress working :)");
		}
	

		

});
	
});