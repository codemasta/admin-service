/*  ==========================================================================
    Table of Content for Date and Time pickers:

    === Function ===
	- runDaterangepicker
    - runDatetimepicker
    - runClockface

    --------------------------
    === Function Calls ===

    ========================================================================== */


/*  ==========================================================================
    Functions
    ========================================================================== */

/*
    runDaterangepicker
    ========================================================================== */
function runDaterangepicker(picker, type){

    switch(type){

        case 'basic':
            $(picker).daterangepicker(null, function(start, end, label) {
                console.log(start.toISOString(), end.toISOString(), label);
            });
        break;

        case 'single':
            $(picker).daterangepicker({ singleDatePicker: true }, function(start, end, label) {
                console.log(start.toISOString(), end.toISOString(), label);
            });
        break;

        case 'increment':
            $(picker).daterangepicker({
                timePicker: true,
                timePickerIncrement: 30,
                format: 'MM/DD/YYYY h:mm A'
            }, function(start, end, label) {
                console.log(start.toISOString(), end.toISOString(), label);
            });
        break;

        case 'predefined':
            $(picker).daterangepicker(
                {
                    ranges: {
                        'Today': [moment(), moment()],
                        'Yesterday': [moment().subtract('days', 1), moment().subtract('days', 1)],
                        'Last 7 Days': [moment().subtract('days', 6), moment()],
                        'Last 30 Days': [moment().subtract('days', 29), moment()],
                        'This Month': [moment().startOf('month'), moment().endOf('month')],
                        'Last Month': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
                    },
                    startDate: moment().subtract('days', 29),
                    endDate: moment()
                },
                function(start, end) {
                    $(picker+' span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
                }
            );
        break;
    }

}


/*
    runDatetimepicker
    ========================================================================== */
function runDatetimepicker(picker, type){

    switch(type){

        case 'basic':
            $(picker).datetimepicker({
                language: 'pt-BR'
            });
        break;

        case 'us_format':
            $(picker).datetimepicker({
                language: 'en',
                pick12HourFormat: true
            });
        break;

        case 'time':
            $(picker).datetimepicker({
                pickDate: false
            });
        break;
    }

}

/*
    runClockface
    ========================================================================== */
function runClockface(picker, type){

    switch(type){

        case 'basic':
            $(picker).clockface();
        break;

        case 'component':
            $(picker).clockface({
                format: 'HH:mm',
                trigger: 'manual'
            });

            $(picker+'_btn').click(function(e){
                e.stopPropagation();
                $(picker).clockface('toggle');
            });
        break;

        case 'time':
            $(picker).datetimepicker({
                pickDate: false
            });
        break;
    }

}

/*  ==========================================================================
    Function Calls
   	========================================================================== */

$(function(){

    // Variables
    var daterangepicker_1 = '#daterangepicker_1',
        daterangepicker_2 = '#daterangepicker_2',
        daterangepicker_3 = '#daterangepicker_3',
        daterangepicker_4 = '#daterangepicker_4';


    var datetimepicker_1 = '#datetimepicker_1',
        datetimepicker_2 = '#datetimepicker_2',
        datetimepicker_3 = '#datetimepicker_3';

    var clockface_1 = '#clockface_1',
        clockface_2 = '#clockface_2';

    // === Checkers ===

    // === Setters ===

    // === Executions ===

    runDaterangepicker(daterangepicker_1,'increment');
    runDaterangepicker(daterangepicker_2,'basic');
    runDaterangepicker(daterangepicker_3,'single');
    runDaterangepicker(daterangepicker_4,'predefined');

    runDatetimepicker(datetimepicker_1,'basic');
    runDatetimepicker(datetimepicker_2,'us_format');
    runDatetimepicker(datetimepicker_3,'time');

    runClockface(clockface_1,'basic');
    runClockface(clockface_2,'component');

});