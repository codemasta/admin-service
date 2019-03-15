/*  ==========================================================================
    Table of Content for Data Tables:

    === Function ===
	- runDataTable

    --------------------------
    === Function Calls ===

    ========================================================================== */


/*  ==========================================================================
    Functions
    ========================================================================== */

/*
    runDataTable
    ========================================================================== */
function runDataTable(dataTableId){

	 // $(dataTableId).dataTable();
    $(dataTableId).dataTable({
        "order": []
    });

    // $(dataTableId).dataTable({
    //     "aaSorting": []
    // });
}


/*  ==========================================================================
    Function Calls
   	========================================================================== */

$(function(){

    // Variables
    var dataTableId = "#dataTableId";

    // === Checkers ===

    // === Setters ===

    // === Executions ===

    runDataTable(dataTableId);



});